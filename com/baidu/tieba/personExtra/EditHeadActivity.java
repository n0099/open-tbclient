package com.baidu.tieba.personExtra;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
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
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tbadk.data.UserGrowthTaskListData;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.g95;
import com.baidu.tieba.oy4;
import com.baidu.tieba.xi;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class EditHeadActivity extends BaseActivity<EditHeadActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static String F = "resourceid";
    public static String G = "pic_info";
    public static String H = "file_name";
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public HashMap<String, Bitmap> B;
    public HashMap<String, ImageView> C;
    public NavigationBar D;
    public TextView E;
    public float a;
    public String b;
    public EditHeadsImageView c;
    public EditHeadsImageTopLayerView d;
    public ImageView e;
    public FrameLayout f;
    public Bitmap g;
    public int h;
    public View i;
    public View j;
    public Button k;
    public Button l;
    public oy4 m;
    public k n;
    public j o;
    public RadioButton p;
    public RadioButton q;
    public LinearLayout r;
    public LinearLayout s;
    public m t;
    public TextView u;
    public Bitmap v;
    public l w;
    public boolean x;
    public boolean y;
    public int z;

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

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditHeadActivity a;

        /* loaded from: classes5.dex */
        public class a implements g95.d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = gVar;
            }

            @Override // com.baidu.tieba.g95.d
            public void a(String str, ImageUploadResult imageUploadResult) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048576, this, str, imageUploadResult) == null) {
                    this.a.a.closeLoadingDialog();
                    Intent intent = this.a.a.getIntent();
                    if (imageUploadResult != null) {
                        if (imageUploadResult.error_code != 0) {
                            this.a.a.showToast(R.string.obfuscated_res_0x7f0f152b, false);
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
                            if (EditHeadActivityConfig.FROM_MISSON_SET_COVER.equals(this.a.a.b)) {
                                this.a.a.d2(photoUrlData);
                            }
                            intent.putExtra(EditHeadActivity.F, String.valueOf(imageUploadResult.picId));
                            intent.putExtra(EditHeadActivity.G, photoUrlData);
                            if (EditHeadActivityConfig.FROM_FLUTTER_IMAGEPICKER.equals(this.a.a.b)) {
                                Intent intent2 = new Intent();
                                intent2.setAction("com.tieba.action.ImagePickerPlugin");
                                intent2.setPackage(TbadkCoreApplication.getInst().getPackageName());
                                intent2.putExtra("pic_info", photoUrlData);
                                this.a.a.sendBroadcast(intent2);
                            }
                        }
                    }
                    this.a.a.setResult(-1, intent);
                    this.a.a.finish();
                }
            }
        }

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
            String str;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.h == 4) {
                    TiebaStatic.log(new StatisticItem("c14449").param("uid", TbadkCoreApplication.getCurrentAccount()));
                }
                if (this.a.h != 0) {
                    str = TbConfig.GROUP_HEAD_FILE;
                } else if (!this.a.x) {
                    str = TbConfig.PERSON_USER_PIC_TEMP_FILE;
                } else {
                    str = TbConfig.PERSON_HEAD_FILE;
                }
                EditHeadsImageView editHeadsImageView = this.a.c;
                if (this.a.h != 0 && this.a.h != 3) {
                    z = false;
                } else {
                    z = true;
                }
                Bitmap v0 = editHeadsImageView.v0(z);
                if (v0 == null || !this.a.c2(str, v0)) {
                    return;
                }
                if (this.a.h == 0) {
                    if (this.a.x) {
                        this.a.Z1();
                        return;
                    }
                    Intent intent = this.a.getIntent();
                    intent.putExtra("upload_image_type", 2);
                    this.a.setResult(-1, intent);
                    this.a.closeActivity();
                    return;
                }
                g95 g95Var = new g95(FileHelper.getFileDireciory(str), "head");
                g95Var.j();
                g95Var.l(new a(this));
                g95Var.n(this.a.z);
                g95Var.g(false);
                EditHeadActivity editHeadActivity = this.a;
                editHeadActivity.showLoadingDialog(editHeadActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f152d));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements DialogInterface.OnCancelListener {
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

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.a.m.h(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements DragImageView.k {
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

        @Override // com.baidu.tbadk.widget.DragImageView.k
        public void a(DragImageView dragImageView, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{dragImageView, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && this.a.f != null && this.a.f.getVisibility() == 0) {
                this.a.e.setImageBitmap(this.a.c.v0(false));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements DragImageView.j {
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

        @Override // com.baidu.tbadk.widget.DragImageView.j
        public void a(DragImageView dragImageView, int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLII(1048576, this, dragImageView, i, i2) == null) && this.a.f != null && this.a.f.getVisibility() == 0) {
                this.a.e.setImageBitmap(this.a.c.v0(false));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.setResult(0);
                this.a.finish();
            }
        }
    }

    /* loaded from: classes5.dex */
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
                this.a.s.setVisibility(0);
                this.a.l.setVisibility(8);
                this.a.q.setPadding(0, this.a.q.getPaddingTop(), this.a.q.getPaddingRight(), this.a.q.getPaddingBottom());
                this.a.q.setChecked(true);
                this.a.p.setVisibility(8);
            }
        }
    }

    /* loaded from: classes5.dex */
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
                this.a.s.setVisibility(8);
                this.a.l.setVisibility(0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements CompoundButton.OnCheckedChangeListener {
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

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) && z) {
                if (compoundButton == this.a.p) {
                    this.a.r.setVisibility(8);
                } else if (compoundButton == this.a.q) {
                    this.a.r.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.m.c()) {
                return;
            }
            if ((this.a.g == null && this.a.v == null) || view2.getTag() == null) {
                return;
            }
            this.a.e2(view2.getTag().toString());
        }
    }

    /* loaded from: classes5.dex */
    public class j extends BdAsyncTask<String, Void, Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public Bitmap b;
        public Boolean c;
        public Boolean d;
        public final /* synthetic */ EditHeadActivity e;

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
                if (this.e.g == null && this.e.v == null) {
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
                    this.b = this.e.g.copy(this.e.g.getConfig(), true);
                } else if (this.e.v != null) {
                    this.b = this.e.v.copy(this.e.v.getConfig(), true);
                } else {
                    this.b = this.e.g.copy(this.e.g.getConfig(), true);
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
                this.e.m.h(false);
                this.e.j.setClickable(true);
                this.e.j.setEnabled(true);
                if (bitmap != null && !bitmap.isRecycled()) {
                    if (!this.c.booleanValue() && !this.d.booleanValue()) {
                        this.e.c.m0(bitmap);
                    } else {
                        this.e.c.setImageBitmap(bitmap);
                        if (this.e.g.getWidth() > 1800 || this.e.g.getHeight() > 1800) {
                            EditHeadActivity editHeadActivity = this.e;
                            editHeadActivity.g = BitmapHelper.resizeBitmap(editHeadActivity.g, 1800);
                        }
                        if (this.c.booleanValue()) {
                            EditHeadActivity editHeadActivity2 = this.e;
                            editHeadActivity2.g = BitmapHelper.rotateBitmap(editHeadActivity2.g, Integer.parseInt(this.a));
                        } else if (this.d.booleanValue()) {
                            EditHeadActivity editHeadActivity3 = this.e;
                            editHeadActivity3.g = BitmapHelper.reversalBitmap(editHeadActivity3.g, Integer.parseInt(this.a));
                        }
                    }
                    if (this.e.v != null && !this.e.v.isRecycled()) {
                        this.e.v.recycle();
                    }
                    this.e.v = bitmap;
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                Bitmap bitmap = this.b;
                if (bitmap != null && !bitmap.isRecycled()) {
                    Bitmap bitmap2 = this.e.v;
                    Bitmap bitmap3 = this.b;
                    if (bitmap2 != bitmap3) {
                        bitmap3.recycle();
                    }
                }
                this.b = null;
                this.e.m.h(false);
                this.e.j.setClickable(true);
                super.cancel(true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.e.m.h(true);
                this.e.j.setEnabled(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k extends BdAsyncTask<Object, Integer, Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditHeadActivity a;

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
            this.a = editHeadActivity;
        }

        public /* synthetic */ k(EditHeadActivity editHeadActivity, a aVar) {
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
                super.onPostExecute((k) bitmap);
                this.a.n = null;
                this.a.g = bitmap;
                this.a.m.h(false);
                this.a.j.setClickable(true);
                this.a.j.setEnabled(true);
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
                this.a.n = null;
                this.a.m.h(false);
                this.a.j.setClickable(true);
                this.a.j.setEnabled(true);
                super.cancel(true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.a.m.h(true);
                this.a.j.setClickable(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditHeadActivity this$0;

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
            this.this$0 = editHeadActivity;
        }

        public /* synthetic */ l(EditHeadActivity editHeadActivity, a aVar) {
            this(editHeadActivity);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                this.this$0.releaseResouce();
                if (intent.getBooleanExtra(TiebaStatic.LogFields.RESULT, false)) {
                    this.this$0.initData();
                    return;
                }
                this.this$0.showToast(intent.getStringExtra("error"));
                if (this.this$0.j != null) {
                    this.this$0.j.setEnabled(false);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;
        public final /* synthetic */ EditHeadActivity b;

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
            this.b = editHeadActivity;
            this.a = null;
        }

        public /* synthetic */ m(EditHeadActivity editHeadActivity, a aVar) {
            this(editHeadActivity);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.closeLoadingDialog();
                this.b.t = null;
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
                editHeadActivity.showLoadingDialog(editHeadActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f1529));
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
                    } else if (BdToastHelper.getBdToastData().getContent() == null) {
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
        this.g = null;
        this.h = 0;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = true;
        this.y = true;
    }

    public final void d2(PhotoUrlData photoUrlData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, photoUrlData) == null) {
            Intent intent = new Intent(EditHeadActivityConfig.ACTION_UPLOAD_SUCCESS);
            intent.putExtra(EditHeadActivityConfig.PIC_INFO, photoUrlData);
            getPageContext().getPageActivity().sendBroadcast(intent);
        }
    }

    public final void e2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            j jVar = this.o;
            if (jVar != null) {
                jVar.cancel();
            }
            j jVar2 = new j(this);
            this.o = jVar2;
            jVar2.execute(str);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            super.onChangeSkinType(i2);
            X1();
        }
    }

    public final boolean c2(String str, Bitmap bitmap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, bitmap)) == null) {
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

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048588, this, i2, keyEvent)) == null) {
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

    public static void startActivityForResult(Activity activity, int i2, int i3, Uri uri, AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65561, null, new Object[]{activity, Integer.valueOf(i2), Integer.valueOf(i3), uri, accountData}) == null) {
            startActivityForResult(activity, i2, i3, uri, accountData, 0);
        }
    }

    public static void startActivityForResult(Activity activity, int i2, int i3, Uri uri, AccountData accountData, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65562, null, new Object[]{activity, Integer.valueOf(i2), Integer.valueOf(i3), uri, accountData, Integer.valueOf(i4)}) == null) {
            Intent intent = new Intent(activity, EditHeadActivity.class);
            intent.putExtra("request", i2);
            intent.putExtra(EditHeadActivityConfig.ACCOUNTDATA, accountData);
            intent.putExtra(EditHeadActivityConfig.EDITTYPE, i4);
            intent.setData(uri);
            activity.startActivityForResult(intent, i3);
        }
    }

    public static void startActivityForResult(Activity activity, int i2, int i3, Uri uri, AccountData accountData, int i4, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65563, null, new Object[]{activity, Integer.valueOf(i2), Integer.valueOf(i3), uri, accountData, Integer.valueOf(i4), str}) == null) {
            Intent intent = new Intent(activity, EditHeadActivity.class);
            intent.putExtra("request", i2);
            intent.putExtra(EditHeadActivityConfig.ACCOUNTDATA, accountData);
            intent.putExtra(EditHeadActivityConfig.EDITTYPE, i4);
            intent.putExtra(H, str);
            intent.setData(uri);
            activity.startActivityForResult(intent, i3);
        }
    }

    public final void X1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SkinManager.setBackgroundColor(this.D, R.color.common_color_10222);
            getLayoutMode().k(this.i);
            getLayoutMode().k(this.j);
            SkinManager.setViewTextColor(this.u, R.color.CAM_X0111, 1);
            SkinManager.setNavbarIconSrc(this.D.getBackImageView(), R.drawable.icon_topbar_return_s, R.drawable.icon_topbar_return_s, 0);
            SkinManager.setViewTextColor(this.E, R.color.CAM_X0111, 1);
        }
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            k kVar = this.n;
            if (kVar != null) {
                kVar.cancel();
            }
            k kVar2 = new k(this, null);
            this.n = kVar2;
            kVar2.execute(new Object[0]);
            AccountData accountData = (AccountData) getIntent().getSerializableExtra(EditHeadActivityConfig.ACCOUNTDATA);
            if (accountData != null) {
                TbadkCoreApplication.setCurrentAccountFromRemoteProcessInUIThread(accountData, getPageContext().getPageActivity());
            }
        }
    }

    public final void Y1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.D = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f091688);
            oy4 oy4Var = new oy4(getPageContext());
            this.m = oy4Var;
            oy4Var.e(new a(this));
            this.m.h(false);
            this.d = (EditHeadsImageTopLayerView) findViewById(R.id.obfuscated_res_0x7f090ed8);
            if (EditHeadActivityConfig.FROM_FLUTTER_IMAGEPICKER.equals(this.b)) {
                float f2 = this.a;
                if (f2 != 1.0f) {
                    this.d.setmCutHeightScale(f2);
                }
            }
            this.e = (ImageView) findViewById(R.id.obfuscated_res_0x7f091aaf);
            this.f = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f091ab0);
            int[] s = xi.s(getPageContext().getPageActivity());
            this.f.setY((int) (((s[1] - s[0]) * 0.4d) + s[0] + getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702fc)));
            EditHeadsImageView editHeadsImageView = (EditHeadsImageView) findViewById(R.id.obfuscated_res_0x7f090eb7);
            this.c = editHeadsImageView;
            editHeadsImageView.setCutImageHeightScale(this.a);
            Bitmap bitmap = this.g;
            if (bitmap != null) {
                this.c.setImageBitmap(bitmap);
            }
            this.c.setOnSizeChangedListener(new b(this));
            this.c.setOnImageScrollListener(new c(this));
            this.i = this.D.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new d(this));
            Button button = (Button) findViewById(R.id.obfuscated_res_0x7f091f10);
            this.l = button;
            button.setOnClickListener(new e(this));
            Button button2 = (Button) findViewById(R.id.obfuscated_res_0x7f090d9b);
            this.k = button2;
            button2.setVisibility(0);
            this.k.setOnClickListener(new f(this));
            View addCustomView = this.D.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d03cb, (View.OnClickListener) null);
            this.j = addCustomView;
            addCustomView.setOnClickListener(new g(this));
            this.j.setEnabled(false);
            TextView textView = (TextView) this.j.findViewById(R.id.obfuscated_res_0x7f091df2);
            this.E = textView;
            textView.setText(R.string.obfuscated_res_0x7f0f050f);
            if (!EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.b)) {
                this.u = this.D.setTitleText(getPageContext().getString(R.string.obfuscated_res_0x7f0f0309));
            }
            if ("from_photo_live".equals(this.b)) {
                this.u.setText(R.string.obfuscated_res_0x7f0f03d7);
            }
            this.s = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090385);
            this.r = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091cca);
            this.p = (RadioButton) findViewById(R.id.obfuscated_res_0x7f090384);
            this.q = (RadioButton) findViewById(R.id.obfuscated_res_0x7f091ccb);
            h hVar = new h(this);
            this.p.setOnCheckedChangeListener(hVar);
            this.q.setOnCheckedChangeListener(hVar);
            this.p.setChecked(true);
            Button button3 = (Button) findViewById(R.id.obfuscated_res_0x7f091ccd);
            Button button4 = (Button) findViewById(R.id.obfuscated_res_0x7f091ccf);
            Button button5 = (Button) findViewById(R.id.obfuscated_res_0x7f091cce);
            Button button6 = (Button) findViewById(R.id.obfuscated_res_0x7f091cd0);
            button3.setTag(0);
            button4.setTag(1);
            button5.setTag(2);
            button6.setTag(3);
            i iVar = new i(this);
            button3.setOnClickListener(iVar);
            button4.setOnClickListener(iVar);
            button5.setOnClickListener(iVar);
            button6.setOnClickListener(iVar);
            if (EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.b)) {
                this.f.setVisibility(0);
                this.l.setVisibility(8);
                this.d.setLinePaintColor(getResources().getColor(R.color.white_alpha50));
                this.d.setLineWidth(2);
            }
            if (!this.y) {
                this.l.setVisibility(8);
                this.u.setText("");
            }
        }
    }

    public final void Z1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            m mVar = this.t;
            if (mVar != null) {
                mVar.cancel();
            }
            m mVar2 = new m(this, null);
            this.t = mVar2;
            mVar2.execute(new String[0]);
        }
    }

    public final void a2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.w = new l(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
            registerReceiver(this.w, intentFilter);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            k kVar = this.n;
            if (kVar != null) {
                kVar.cancel();
            }
            this.c.setImageDrawable(null);
            b2();
        }
    }

    public final void b2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            HashMap<String, ImageView> hashMap = this.C;
            if (hashMap != null) {
                for (Map.Entry<String, ImageView> entry : hashMap.entrySet()) {
                    ImageView value = entry.getValue();
                    if (value != null) {
                        value.setImageDrawable(null);
                    }
                }
                this.C.clear();
                this.C = null;
            }
            HashMap<String, Bitmap> hashMap2 = this.B;
            if (hashMap2 != null) {
                for (Map.Entry<String, Bitmap> entry2 : hashMap2.entrySet()) {
                    Bitmap value2 = entry2.getValue();
                    if (value2 != null && !value2.isRecycled()) {
                        value2.recycle();
                    }
                }
                this.B.clear();
                this.B = null;
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            releaseResouce();
            super.onDestroy();
            this.c.c0();
            Bitmap bitmap = this.g;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.g.recycle();
                this.g = null;
            }
            m mVar = this.t;
            if (mVar != null) {
                mVar.cancel();
            }
            Bitmap bitmap2 = this.v;
            if (bitmap2 != null && !bitmap2.isRecycled()) {
                this.v.recycle();
                this.v = null;
            }
            k kVar = this.n;
            if (kVar != null) {
                kVar.cancel();
                this.n = null;
            }
            this.m.h(false);
            int i2 = this.A;
            if (i2 == 12002 || i2 == 12001) {
                unregisterReceiver(this.w);
            }
            TbadkCoreApplication.getInst().delRemoteActivity(this);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            super.onCreate(bundle);
            setSwipeBackEnabled(false);
            TbadkCoreApplication.getInst().addRemoteActivity(this);
            setContentView(R.layout.obfuscated_res_0x7f0d0247);
            Intent intent = getIntent();
            this.h = intent.getIntExtra(EditHeadActivityConfig.EDITTYPE, 0);
            this.A = intent.getIntExtra("request", 0);
            this.x = intent.getBooleanExtra("need_upload", true);
            this.y = intent.getBooleanExtra(EditHeadActivityConfig.NEED_PASTE, true);
            this.z = intent.getIntExtra(EditHeadActivityConfig.WATERMARK_TYPE, 0);
            this.a = intent.getFloatExtra(EditHeadActivityConfig.CUT_IMAGE_HEIGHT_SCALE, 1.0f);
            this.b = intent.getStringExtra(EditHeadActivityConfig.FROM_WHERE);
            UserGrowthTaskListData userGrowthTaskListData = (UserGrowthTaskListData) intent.getSerializableExtra(EditHeadActivityConfig.USER_GROWTH_TASK);
            if (userGrowthTaskListData != null) {
                TbSingleton.getInstance().setUserGrowthTaskListData(userGrowthTaskListData);
            }
            String stringExtra = intent.getStringExtra(H);
            int i2 = this.A;
            if (i2 != 12002 && i2 != 12001) {
                Y1();
                initData();
                return;
            }
            Y1();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.A, intent.getData(), TbImageHelper.getInstance().getPostImageSize());
            } else {
                TiebaPrepareImageService.StartService(this.A, null, TbImageHelper.getInstance().getPostImageSize(), 0, stringExtra);
            }
            a2();
        }
    }
}
