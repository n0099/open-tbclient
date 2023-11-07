package com.baidu.tieba.personExtra;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.message.UserGrowthTaskRequestMessage;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.BdToastHelper;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ForumBroadcastHelper;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BlueCircleProgressDialog;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tbadk.data.UserGrowthTaskListData;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.yi5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class EditHeadActivity extends BaseActivity<EditHeadActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static String I = "resourceid";
    public static String J = "pic_info";
    public static String K = "file_name";
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public HashMap<String, Bitmap> C;
    public HashMap<String, ImageView> D;
    public NavigationBar E;
    public TextView F;
    public JSONObject G;
    public boolean H;
    public float a;
    public String b;
    public EditHeadsImageView c;
    public EditHeadsImageTopLayerView d;
    public EditForumImageLayerView e;
    public ImageView f;
    public FrameLayout g;
    public Bitmap h;
    public int i;
    public View j;
    public View k;
    public Button l;
    public Button m;
    public BlueCircleProgressDialog n;
    public l o;
    public k p;
    public RadioButton q;
    public RadioButton r;
    public LinearLayout s;
    public LinearLayout t;
    public n u;
    public TextView v;
    public Bitmap w;
    public m x;
    public boolean y;
    public boolean z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-122681184, "Lcom/baidu/tieba/personExtra/EditHeadActivity;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-122681184, "Lcom/baidu/tieba/personExtra/EditHeadActivity;");
        }
    }

    /* loaded from: classes7.dex */
    public class a implements yi5.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditHeadActivity a;

        public a(EditHeadActivity editHeadActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editHeadActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editHeadActivity;
        }

        @Override // com.baidu.tieba.yi5.d
        public void a(String str, ImageUploadResult imageUploadResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, imageUploadResult) == null) {
                this.a.closeLoadingDialog();
                Intent intent = this.a.getIntent();
                if (imageUploadResult != null) {
                    if (imageUploadResult.error_code != 0) {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f17c8, false);
                    } else {
                        PhotoUrlData photoUrlData = new PhotoUrlData();
                        photoUrlData.setPicId(String.valueOf(imageUploadResult.picId));
                        ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                        if (picinfo != null) {
                            ImageUploadResult.PicDetailedInfo picDetailedInfo = picinfo.bigPic;
                            if (picDetailedInfo != null) {
                                photoUrlData.setBigurl(picDetailedInfo.picUrl);
                            }
                            ImageUploadResult.PicDetailedInfo picDetailedInfo2 = imageUploadResult.picInfo.smallPic;
                            if (picDetailedInfo2 != null) {
                                photoUrlData.setSmallurl(picDetailedInfo2.picUrl);
                            }
                            ImageUploadResult.PicDetailedInfo picDetailedInfo3 = imageUploadResult.picInfo.originPic;
                            if (picDetailedInfo3 != null) {
                                photoUrlData.setOriginPic(picDetailedInfo3.picUrl);
                            }
                            if (imageUploadResult.getUploadedPicInfo() != null && !StringUtils.isNull(imageUploadResult.getUploadedPicInfo().toPostString())) {
                                photoUrlData.setToServerPhotoInfo(imageUploadResult.getUploadedPicInfo().toPostString());
                            }
                        }
                        if (EditHeadActivityConfig.FROM_MISSON_SET_COVER.equals(this.a.b)) {
                            this.a.z1(photoUrlData);
                        }
                        intent.putExtra(EditHeadActivity.I, String.valueOf(imageUploadResult.picId));
                        intent.putExtra(EditHeadActivity.J, photoUrlData);
                        if (EditHeadActivityConfig.FROM_FLUTTER_IMAGEPICKER.equals(this.a.b)) {
                            Intent intent2 = new Intent();
                            intent2.setAction("com.tieba.action.ImagePickerPlugin");
                            intent2.setPackage(TbadkCoreApplication.getInst().getPackageName());
                            intent2.putExtra("pic_info", photoUrlData);
                            this.a.sendBroadcast(intent2);
                        } else if (EditHeadActivityConfig.FROM_FORUM_BACKGROUND.equals(this.a.b)) {
                            Intent intent3 = new Intent();
                            intent3.setAction("com.tieba.action.UploadForumBackground");
                            intent3.setPackage(TbadkCoreApplication.getInst().getPackageName());
                            intent3.putExtra("pic_url", photoUrlData.getOriginPic());
                            this.a.sendBroadcast(intent3);
                            this.a.finish();
                        }
                    }
                }
                this.a.setResult(-1, intent);
                this.a.finish();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditHeadActivity a;

        public b(EditHeadActivity editHeadActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editHeadActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editHeadActivity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.a.n.setDialogVisiable(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements DragImageView.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditHeadActivity a;

        public c(EditHeadActivity editHeadActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editHeadActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editHeadActivity;
        }

        @Override // com.baidu.tbadk.widget.DragImageView.k
        public void a(DragImageView dragImageView, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{dragImageView, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && this.a.g != null && this.a.g.getVisibility() == 0) {
                this.a.f.setImageBitmap(this.a.c.v0(false));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements DragImageView.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditHeadActivity a;

        public d(EditHeadActivity editHeadActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editHeadActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editHeadActivity;
        }

        @Override // com.baidu.tbadk.widget.DragImageView.j
        public void a(DragImageView dragImageView, int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLII(1048576, this, dragImageView, i, i2) == null) && this.a.g != null && this.a.g.getVisibility() == 0) {
                this.a.f.setImageBitmap(this.a.c.v0(false));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditHeadActivity a;

        public e(EditHeadActivity editHeadActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editHeadActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editHeadActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.setResult(0);
                this.a.finish();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditHeadActivity a;

        public f(EditHeadActivity editHeadActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editHeadActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editHeadActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.t.setVisibility(0);
                this.a.m.setVisibility(8);
                this.a.r.setPadding(0, this.a.r.getPaddingTop(), this.a.r.getPaddingRight(), this.a.r.getPaddingBottom());
                this.a.r.setChecked(true);
                this.a.q.setVisibility(8);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditHeadActivity a;

        public g(EditHeadActivity editHeadActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editHeadActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editHeadActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.t.setVisibility(8);
                this.a.m.setVisibility(0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditHeadActivity a;

        public h(EditHeadActivity editHeadActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editHeadActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editHeadActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (EditHeadActivityConfig.FROM_FORUM_BACKGROUND.equals(this.a.b) && this.a.H) {
                    TiebaStatic.log(new StatisticItem("c15556").param("fid", this.a.G.optString("forumId")).param("fname", this.a.G.optString(ForumBroadcastHelper.KEY_PARMARS_FORUM_NAME)));
                }
                if (this.a.i == 4) {
                    TiebaStatic.log(new StatisticItem("c14449").param("uid", TbadkCoreApplication.getCurrentAccount()));
                }
                if (this.a.i != 0) {
                    str = TbConfig.GROUP_HEAD_FILE;
                } else if (!this.a.y) {
                    str = TbConfig.PERSON_USER_PIC_TEMP_FILE;
                } else {
                    str = TbConfig.PERSON_HEAD_FILE;
                }
                if (this.a.H) {
                    str = TbConfig.FORUM_BG_FILE;
                }
                EditHeadsImageView editHeadsImageView = this.a.c;
                if (this.a.i != 0 && this.a.i != 3) {
                    z = false;
                } else {
                    z = true;
                }
                Bitmap v0 = editHeadsImageView.v0(z);
                if (v0 == null || !this.a.y1(str, v0)) {
                    return;
                }
                if (this.a.i == 0 && !EditHeadActivityConfig.FROM_FORUM_BACKGROUND.equals(this.a.b)) {
                    if (this.a.y) {
                        this.a.v1();
                        return;
                    }
                    Intent intent = this.a.getIntent();
                    intent.putExtra("upload_image_type", 2);
                    this.a.setResult(-1, intent);
                    this.a.closeActivity();
                    return;
                }
                this.a.D1(str);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditHeadActivity a;

        public i(EditHeadActivity editHeadActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editHeadActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editHeadActivity;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) && z) {
                if (compoundButton == this.a.q) {
                    this.a.s.setVisibility(8);
                } else if (compoundButton == this.a.r) {
                    this.a.s.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditHeadActivity a;

        public j(EditHeadActivity editHeadActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editHeadActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editHeadActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.n.isShowing()) {
                return;
            }
            if ((this.a.h == null && this.a.w == null) || view2.getTag() == null) {
                return;
            }
            this.a.B1(view2.getTag().toString());
        }
    }

    /* loaded from: classes7.dex */
    public class k extends BdAsyncTask<String, Void, Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public Bitmap b;
        public Boolean c;
        public Boolean d;
        public final /* synthetic */ EditHeadActivity e;

        public k(EditHeadActivity editHeadActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editHeadActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = editHeadActivity;
            Boolean bool = Boolean.FALSE;
            this.c = bool;
            this.d = bool;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Bitmap doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                this.a = strArr[0];
                if (this.e.h == null && this.e.w == null) {
                    return null;
                }
                if (!this.a.equals("0") && !this.a.equals("1")) {
                    if (this.a.equals("2") || this.a.equals("3")) {
                        this.d = Boolean.TRUE;
                    }
                } else {
                    this.c = Boolean.TRUE;
                }
                if (!this.c.booleanValue() && !this.d.booleanValue()) {
                    this.b = this.e.h.copy(this.e.h.getConfig(), true);
                } else if (this.e.w != null) {
                    this.b = this.e.w.copy(this.e.w.getConfig(), true);
                } else {
                    this.b = this.e.h.copy(this.e.h.getConfig(), true);
                }
                if (this.c.booleanValue()) {
                    this.b = BitmapHelper.rotateBitmap(this.b, Integer.parseInt(this.a));
                } else if (this.d.booleanValue()) {
                    this.b = BitmapHelper.reversalBitmap(this.b, Integer.parseInt(this.a));
                }
                return this.b;
            }
            return (Bitmap) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bitmap) == null) {
                this.e.n.setDialogVisiable(false);
                this.e.k.setClickable(true);
                this.e.k.setEnabled(true);
                if (bitmap != null && !bitmap.isRecycled()) {
                    if (!this.c.booleanValue() && !this.d.booleanValue()) {
                        this.e.c.m0(bitmap);
                    } else {
                        this.e.c.setImageBitmap(bitmap);
                        if (this.e.h.getWidth() > 1800 || this.e.h.getHeight() > 1800) {
                            EditHeadActivity editHeadActivity = this.e;
                            editHeadActivity.h = BitmapHelper.resizeBitmap(editHeadActivity.h, 1800);
                        }
                        if (this.c.booleanValue()) {
                            EditHeadActivity editHeadActivity2 = this.e;
                            editHeadActivity2.h = BitmapHelper.rotateBitmap(editHeadActivity2.h, Integer.parseInt(this.a));
                        } else if (this.d.booleanValue()) {
                            EditHeadActivity editHeadActivity3 = this.e;
                            editHeadActivity3.h = BitmapHelper.reversalBitmap(editHeadActivity3.h, Integer.parseInt(this.a));
                        }
                    }
                    if (this.e.w != null && !this.e.w.isRecycled()) {
                        this.e.w.recycle();
                    }
                    this.e.w = bitmap;
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                Bitmap bitmap = this.b;
                if (bitmap != null && !bitmap.isRecycled()) {
                    Bitmap bitmap2 = this.e.w;
                    Bitmap bitmap3 = this.b;
                    if (bitmap2 != bitmap3) {
                        bitmap3.recycle();
                    }
                }
                this.b = null;
                this.e.n.setDialogVisiable(false);
                this.e.k.setClickable(true);
                super.cancel(true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.e.n.setDialogVisiable(true);
                this.e.k.setEnabled(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l extends BdAsyncTask<Object, Integer, Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditHeadActivity a;

        public l(EditHeadActivity editHeadActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editHeadActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editHeadActivity;
        }

        public /* synthetic */ l(EditHeadActivity editHeadActivity, b bVar) {
            this(editHeadActivity);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Bitmap doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Bitmap bitmap;
            Exception e;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                try {
                    bitmap = FileHelper.getImage(null, TbConfig.IMAGE_RESIZED_FILE);
                    try {
                        if (bitmap.getWidth() > 1800 || bitmap.getHeight() > 1800) {
                            Bitmap resizeBitmap = BitmapHelper.resizeBitmap(bitmap, 1800);
                            try {
                                bitmap.recycle();
                                bitmap = resizeBitmap;
                            } catch (Exception e2) {
                                e = e2;
                                bitmap = resizeBitmap;
                                BdLog.e(e.toString());
                                return bitmap;
                            }
                        }
                        if (isCancelled() && bitmap != null && !bitmap.isRecycled()) {
                            bitmap.recycle();
                            return null;
                        }
                    } catch (Exception e3) {
                        e = e3;
                    }
                } catch (Exception e4) {
                    bitmap = null;
                    e = e4;
                }
                return bitmap;
            }
            return (Bitmap) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bitmap) == null) {
                super.onPostExecute((l) bitmap);
                this.a.o = null;
                this.a.h = bitmap;
                this.a.n.setDialogVisiable(false);
                this.a.k.setClickable(true);
                this.a.k.setEnabled(true);
                if (bitmap != null && !bitmap.isRecycled()) {
                    if (bitmap != null) {
                        this.a.c.setImageBitmap(bitmap);
                        return;
                    }
                    return;
                }
                this.a.c.setImageDrawable(null);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.o = null;
                this.a.n.setDialogVisiable(false);
                this.a.k.setClickable(true);
                this.a.k.setEnabled(true);
                super.cancel(true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.a.n.setDialogVisiable(true);
                this.a.k.setClickable(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditHeadActivity this$0;

        public m(EditHeadActivity editHeadActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editHeadActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = editHeadActivity;
        }

        public /* synthetic */ m(EditHeadActivity editHeadActivity, b bVar) {
            this(editHeadActivity);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                this.this$0.releaseResouce();
                if (intent.getBooleanExtra("result", false)) {
                    this.this$0.initData();
                    return;
                }
                this.this$0.showToast(intent.getStringExtra("error"));
                if (this.this$0.k != null) {
                    this.this$0.k.setEnabled(false);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;
        public final /* synthetic */ EditHeadActivity b;

        public n(EditHeadActivity editHeadActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editHeadActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = editHeadActivity;
            this.a = null;
        }

        public /* synthetic */ n(EditHeadActivity editHeadActivity, b bVar) {
            this(editHeadActivity);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.closeLoadingDialog();
                this.b.u = null;
                NetWork netWork = this.a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                super.cancel(true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                EditHeadActivity editHeadActivity = this.b;
                editHeadActivity.showLoadingDialog(editHeadActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f17c5));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            Exception e;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, strArr)) == null) {
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.PROFILE_HEAD_MODIFY);
                this.a = netWork;
                try {
                    str = netWork.uploadImage(TbConfig.PERSON_HEAD_FILE);
                } catch (Exception e2) {
                    e = e2;
                    str = null;
                }
                try {
                } catch (Exception e3) {
                    e = e3;
                    BdLog.e(e.getMessage());
                    return str;
                }
                if (!this.a.getNetContext().getResponse().isRequestSuccess()) {
                    return null;
                }
                return str;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.b.closeLoadingDialog();
                if (this.a != null) {
                    if (!TbSingleton.getInstance().isUserGrowthTaskCompleted(UserGrowthTaskRequestMessage.SET_USER_AVATAR)) {
                        MessageManager.getInstance().sendMessage(new UserGrowthTaskRequestMessage(UserGrowthTaskRequestMessage.SET_USER_AVATAR));
                    }
                    if (this.a.getNetContext().getResponse().isRequestSuccess()) {
                        Intent intent = new Intent();
                        intent.putExtra("upload_image_type", 1);
                        this.b.setResult(-1, intent);
                        if (EditHeadActivityConfig.FROM_FLUTTER_IMAGEPICKER.equals(this.b.b)) {
                            Intent intent2 = new Intent();
                            intent2.setPackage(TbadkCoreApplication.getInst().getPackageName());
                            intent2.setAction("com.tieba.action.ImagePickerPlugin");
                            intent2.putExtra("isHeadImage", true);
                            this.b.sendBroadcast(intent2);
                        }
                        this.b.finish();
                    } else if (BdToastHelper.getBdToastData() == null || BdToastHelper.getBdToastData().getContent() == null) {
                        this.b.showToast(this.a.getErrorString());
                    }
                }
            }
        }
    }

    public EditHeadActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 1.0f;
        this.c = null;
        this.d = null;
        this.e = null;
        this.h = null;
        this.i = 0;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = true;
        this.z = true;
        this.G = new JSONObject();
    }

    public final void B1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            k kVar = this.p;
            if (kVar != null) {
                kVar.cancel();
            }
            k kVar2 = new k(this);
            this.p = kVar2;
            kVar2.execute(str);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            super.onChangeSkinType(i2);
            t1();
        }
    }

    public final void z1(PhotoUrlData photoUrlData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, photoUrlData) == null) {
            Intent intent = new Intent(EditHeadActivityConfig.ACTION_UPLOAD_SUCCESS);
            intent.putExtra(EditHeadActivityConfig.PIC_INFO, photoUrlData);
            getPageContext().getPageActivity().sendBroadcast(intent);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048582, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                closeLoadingDialog();
                setResult(0);
                finish();
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    public final boolean y1(String str, Bitmap bitmap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, str, bitmap)) == null) {
            try {
                FileHelper.saveBitmapByRelativelyPath(null, str, bitmap, 80);
                return true;
            } catch (Exception e2) {
                BdLog.e(e2.toString());
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public final void D1(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            if (EditHeadActivityConfig.FROM_FORUM_BACKGROUND.equals(this.b)) {
                str2 = "forum_background";
            } else {
                str2 = "head";
            }
            yi5 yi5Var = new yi5(FileHelper.getFileDireciory(str), str2);
            yi5Var.j();
            yi5Var.l(new a(this));
            yi5Var.n(this.A);
            yi5Var.g(false);
            showLoadingDialog(getPageContext().getString(R.string.obfuscated_res_0x7f0f17ca));
        }
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            l lVar = this.o;
            if (lVar != null) {
                lVar.cancel();
            }
            l lVar2 = new l(this, null);
            this.o = lVar2;
            lVar2.execute(new Object[0]);
            AccountData accountData = (AccountData) getIntent().getSerializableExtra(EditHeadActivityConfig.ACCOUNTDATA);
            if (accountData != null) {
                TbadkCoreApplication.setCurrentAccountFromRemoteProcessInUIThread(accountData, getPageContext().getPageActivity());
            }
        }
    }

    public final void t1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            SkinManager.setBackgroundColor(this.E, R.color.common_color_10222);
            getLayoutMode().onModeChanged(this.j);
            getLayoutMode().onModeChanged(this.k);
            SkinManager.setViewTextColor(this.v, R.color.CAM_X0111, 1);
            SkinManager.setNavbarIconSrc(this.E.getBackImageView(), R.drawable.icon_topbar_return_s, R.drawable.icon_topbar_return_s, 0);
            SkinManager.setViewTextColor(this.F, R.color.CAM_X0111, 1);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            setSwipeBackEnabled(false);
            TbadkCoreApplication.getInst().addRemoteActivity(this);
            setContentView(R.layout.obfuscated_res_0x7f0d0290);
            Intent intent = getIntent();
            this.i = intent.getIntExtra(EditHeadActivityConfig.EDITTYPE, 0);
            this.B = intent.getIntExtra("request", 0);
            this.y = intent.getBooleanExtra("need_upload", true);
            this.z = intent.getBooleanExtra(EditHeadActivityConfig.NEED_PASTE, true);
            this.A = intent.getIntExtra(EditHeadActivityConfig.WATERMARK_TYPE, 0);
            this.a = intent.getFloatExtra(EditHeadActivityConfig.CUT_IMAGE_HEIGHT_SCALE, 1.0f);
            this.b = intent.getStringExtra(EditHeadActivityConfig.FROM_WHERE);
            this.H = intent.getBooleanExtra(EditHeadActivityConfig.SYSTEM_FORUM_BACKGROUND, false);
            String stringExtra = intent.getStringExtra("forum_bg_info");
            try {
                if (!TextUtils.isEmpty(stringExtra)) {
                    this.G = new JSONObject(stringExtra);
                }
            } catch (JSONException e2) {
                BdLog.e(e2);
            }
            UserGrowthTaskListData userGrowthTaskListData = (UserGrowthTaskListData) intent.getSerializableExtra(EditHeadActivityConfig.USER_GROWTH_TASK);
            if (userGrowthTaskListData != null) {
                TbSingleton.getInstance().setUserGrowthTaskListData(userGrowthTaskListData);
            }
            String stringExtra2 = intent.getStringExtra(K);
            String stringExtra3 = intent.getStringExtra(EditHeadActivityConfig.IMAGE_URL);
            int i2 = this.B;
            if (i2 != 12002 && i2 != 12001) {
                u1();
                initData();
                return;
            }
            u1();
            if (StringUtils.isNotNull(stringExtra3)) {
                TiebaPrepareImageService.StartService(this.B, TbImageHelper.getInstance().getPostImageSize(), stringExtra3);
            } else if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.B, intent.getData(), TbImageHelper.getInstance().getPostImageSize());
            } else {
                TiebaPrepareImageService.StartService(this.B, null, TbImageHelper.getInstance().getPostImageSize(), 0, stringExtra2);
            }
            w1();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            releaseResouce();
            super.onDestroy();
            this.c.c0();
            Bitmap bitmap = this.h;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.h.recycle();
                this.h = null;
            }
            n nVar = this.u;
            if (nVar != null) {
                nVar.cancel();
            }
            Bitmap bitmap2 = this.w;
            if (bitmap2 != null && !bitmap2.isRecycled()) {
                this.w.recycle();
                this.w = null;
            }
            l lVar = this.o;
            if (lVar != null) {
                lVar.cancel();
                this.o = null;
            }
            this.n.setDialogVisiable(false);
            int i2 = this.B;
            if (i2 == 12002 || i2 == 12001) {
                unregisterReceiver(this.x);
            }
            TbadkCoreApplication.getInst().delRemoteActivity(this);
        }
    }

    public final void x1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            HashMap<String, ImageView> hashMap = this.D;
            if (hashMap != null) {
                for (Map.Entry<String, ImageView> entry : hashMap.entrySet()) {
                    ImageView value = entry.getValue();
                    if (value != null) {
                        value.setImageDrawable(null);
                    }
                }
                this.D.clear();
                this.D = null;
            }
            HashMap<String, Bitmap> hashMap2 = this.C;
            if (hashMap2 != null) {
                for (Map.Entry<String, Bitmap> entry2 : hashMap2.entrySet()) {
                    Bitmap value2 = entry2.getValue();
                    if (value2 != null && !value2.isRecycled()) {
                        value2.recycle();
                    }
                }
                this.C.clear();
                this.C = null;
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            l lVar = this.o;
            if (lVar != null) {
                lVar.cancel();
            }
            this.c.setImageDrawable(null);
            x1();
        }
    }

    public final void v1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            n nVar = this.u;
            if (nVar != null) {
                nVar.cancel();
            }
            n nVar2 = new n(this, null);
            this.u = nVar2;
            nVar2.execute(new String[0]);
        }
    }

    public final void w1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.x = new m(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
            registerReceiver(this.x, intentFilter);
        }
    }

    public final void u1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.E = (NavigationBar) findViewById(R.id.navigation_bar);
            BlueCircleProgressDialog blueCircleProgressDialog = new BlueCircleProgressDialog(getPageContext());
            this.n = blueCircleProgressDialog;
            blueCircleProgressDialog.setCancelListener(new b(this));
            this.n.setDialogVisiable(false);
            this.d = (EditHeadsImageTopLayerView) findViewById(R.id.obfuscated_res_0x7f0910f9);
            this.e = (EditForumImageLayerView) findViewById(R.id.obfuscated_res_0x7f090c6e);
            if (EditHeadActivityConfig.FROM_FLUTTER_IMAGEPICKER.equals(this.b)) {
                float f2 = this.a;
                if (f2 != 1.0f) {
                    this.d.setmCutHeightScale(f2);
                }
            }
            if (EditHeadActivityConfig.FROM_FORUM_BACKGROUND.equals(this.b)) {
                float f3 = this.a;
                if (f3 != 1.0f) {
                    this.d.setmCutHeightScale(f3);
                    this.d.setLinePaintHasGradientBg();
                    this.e.setData(this.G);
                    this.e.setVisibility(0);
                    this.G.optString("diyChance");
                }
            }
            this.f = (ImageView) findViewById(R.id.obfuscated_res_0x7f091da6);
            this.g = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f091da7);
            int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
            this.g.setY((int) (((screenDimensions[1] - screenDimensions[0]) * 0.4d) + screenDimensions[0] + getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070416)));
            EditHeadsImageView editHeadsImageView = (EditHeadsImageView) findViewById(R.id.obfuscated_res_0x7f0910d4);
            this.c = editHeadsImageView;
            editHeadsImageView.setCutImageHeightScale(this.a);
            Bitmap bitmap = this.h;
            if (bitmap != null) {
                this.c.setImageBitmap(bitmap);
            }
            this.c.setOnSizeChangedListener(new c(this));
            this.c.setOnImageScrollListener(new d(this));
            this.j = this.E.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new e(this));
            Button button = (Button) findViewById(R.id.obfuscated_res_0x7f092261);
            this.m = button;
            button.setOnClickListener(new f(this));
            Button button2 = (Button) findViewById(R.id.hide_button);
            this.l = button2;
            button2.setVisibility(0);
            this.l.setOnClickListener(new g(this));
            View addCustomView = this.E.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.image_activity_save_button, (View.OnClickListener) null);
            this.k = addCustomView;
            addCustomView.setOnClickListener(new h(this));
            this.k.setEnabled(false);
            TextView textView = (TextView) this.k.findViewById(R.id.obfuscated_res_0x7f092137);
            this.F = textView;
            textView.setText(R.string.obfuscated_res_0x7f0f05b4);
            if (!EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.b)) {
                this.v = this.E.setTitleText(getPageContext().getString(R.string.obfuscated_res_0x7f0f034b));
            }
            if ("from_photo_live".equals(this.b)) {
                this.v.setText(R.string.obfuscated_res_0x7f0f044b);
            }
            if (EditHeadActivityConfig.FROM_FORUM_BACKGROUND.equals(this.b)) {
                this.F.setText(R.string.obfuscated_res_0x7f0f13b2);
            }
            this.t = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0903e8);
            this.s = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09200c);
            this.q = (RadioButton) findViewById(R.id.beautify_btn);
            this.r = (RadioButton) findViewById(R.id.rotate_btn);
            i iVar = new i(this);
            this.q.setOnCheckedChangeListener(iVar);
            this.r.setOnCheckedChangeListener(iVar);
            this.q.setChecked(true);
            Button button3 = (Button) findViewById(R.id.rotate_left);
            Button button4 = (Button) findViewById(R.id.rotate_right);
            Button button5 = (Button) findViewById(R.id.rotate_left_right);
            Button button6 = (Button) findViewById(R.id.rotate_up_down);
            button3.setTag(0);
            button4.setTag(1);
            button5.setTag(2);
            button6.setTag(3);
            j jVar = new j(this);
            button3.setOnClickListener(jVar);
            button4.setOnClickListener(jVar);
            button5.setOnClickListener(jVar);
            button6.setOnClickListener(jVar);
            if (EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.b)) {
                this.g.setVisibility(0);
                this.m.setVisibility(8);
                this.d.setLinePaintColor(getResources().getColor(R.color.white_alpha50));
                this.d.setLineWidth(2);
            }
            if (!this.z) {
                this.m.setVisibility(8);
                this.v.setText("");
            }
        }
    }
}
