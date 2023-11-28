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
import androidx.appcompat.app.AlertDialog;
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
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
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
import com.baidu.tieba.a65;
import com.baidu.tieba.ck5;
import com.baidu.tieba.fj5;
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
    public static String R = "resourceid";
    public static String S = "pic_info";

    /* renamed from: T  reason: collision with root package name */
    public static String f1145T = "file_name";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public int B;
    public int C;
    public HashMap<String, Bitmap> D;
    public HashMap<String, ImageView> E;
    public NavigationBar F;
    public LinearLayout G;
    public TextView H;
    public JSONObject I;
    public boolean J;
    public boolean K;
    public ck5 L;
    public LinearLayout M;
    public FrameLayout N;
    public EditHeadController O;
    public AlertDialog P;
    public View.OnClickListener Q;
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
    public p o;
    public o p;
    public RadioButton q;
    public RadioButton r;
    public LinearLayout s;
    public LinearLayout t;
    public r u;
    public TextView v;
    public TextView w;
    public Bitmap x;
    public q y;
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
    public class a implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.n.isShowing()) {
                return;
            }
            if ((this.a.h == null && this.a.x == null) || view2.getTag() == null) {
                return;
            }
            this.a.Q1(view2.getTag().toString());
        }
    }

    /* loaded from: classes7.dex */
    public class b implements fj5.d {
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

        @Override // com.baidu.tieba.fj5.d
        public void a(String str, ImageUploadResult imageUploadResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, imageUploadResult) == null) {
                this.a.closeLoadingDialog();
                Intent intent = this.a.getIntent();
                if (imageUploadResult != null) {
                    if (imageUploadResult.error_code != 0) {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f17d8, false);
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
                            this.a.G1(photoUrlData);
                        }
                        intent.putExtra(EditHeadActivity.R, String.valueOf(imageUploadResult.picId));
                        intent.putExtra(EditHeadActivity.S, photoUrlData);
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
    public class c implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.finish();
            }
        }
    }

    /* loaded from: classes7.dex */
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
                this.a.P.dismiss();
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
                this.a.P.dismiss();
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
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                boolean z = true;
                if (EditHeadActivityConfig.FROM_FORUM_BACKGROUND.equals(this.a.b)) {
                    if (this.a.K) {
                        this.a.R1(2, 2);
                    } else if (this.a.J) {
                        this.a.S1(2, 2);
                    } else {
                        this.a.S1(2, 1);
                    }
                }
                if (this.a.i == 4) {
                    TiebaStatic.log(new StatisticItem("c14449").param("uid", TbadkCoreApplication.getCurrentAccount()));
                }
                if (this.a.i != 0) {
                    str = TbConfig.GROUP_HEAD_FILE;
                } else if (!this.a.z) {
                    str = TbConfig.PERSON_USER_PIC_TEMP_FILE;
                } else {
                    str = TbConfig.PERSON_HEAD_FILE;
                }
                if (this.a.J) {
                    str = TbConfig.FORUM_BG_FILE;
                }
                EditHeadsImageView editHeadsImageView = this.a.c;
                if (this.a.i != 0 && this.a.i != 3) {
                    z = false;
                }
                Bitmap w0 = editHeadsImageView.w0(z);
                if (w0 == null || !this.a.F1(str, w0)) {
                    return;
                }
                if (this.a.i == 0 && !EditHeadActivityConfig.FROM_FORUM_BACKGROUND.equals(this.a.b)) {
                    if (this.a.z) {
                        this.a.C1();
                        return;
                    }
                    Intent intent = this.a.getIntent();
                    intent.putExtra("upload_image_type", 2);
                    this.a.setResult(-1, intent);
                    this.a.closeActivity();
                    return;
                }
                this.a.T1(str);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements DialogInterface.OnCancelListener {
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

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.a.n.setDialogVisiable(false);
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
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.R1(2, 1);
                String optString = this.a.I.optString("style");
                String optString2 = this.a.I.optString("prompt");
                String optString3 = this.a.I.optString("styleName");
                int optInt = this.a.I.optInt("forumId");
                this.a.e.setAiCreateLoadingVisible(true);
                this.a.e.setAiCreateButtonClickable(false);
                this.a.J1(false);
                this.a.O.e(optString, optString2, optString3, optInt);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements DragImageView.k {
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

        @Override // com.baidu.tbadk.widget.DragImageView.k
        public void a(DragImageView dragImageView, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{dragImageView, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && this.a.g != null && this.a.g.getVisibility() == 0) {
                this.a.f.setImageBitmap(this.a.c.w0(false));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements DragImageView.j {
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

        @Override // com.baidu.tbadk.widget.DragImageView.j
        public void a(DragImageView dragImageView, int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLII(1048576, this, dragImageView, i, i2) == null) && this.a.g != null && this.a.g.getVisibility() == 0) {
                this.a.f.setImageBitmap(this.a.c.w0(false));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.K) {
                    this.a.R1(2, 3);
                    if (this.a.e.d()) {
                        this.a.O1();
                        return;
                    }
                }
                this.a.setResult(0);
                this.a.finish();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements View.OnClickListener {
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
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditHeadActivity a;

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
    public class n implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditHeadActivity a;

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
    public class o extends BdAsyncTask<String, Void, Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public Bitmap b;
        public Boolean c;
        public Boolean d;
        public final /* synthetic */ EditHeadActivity e;

        public o(EditHeadActivity editHeadActivity) {
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
                if (this.e.h == null && this.e.x == null) {
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
                } else if (this.e.x != null) {
                    this.b = this.e.x.copy(this.e.x.getConfig(), true);
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
                        this.e.c.n0(bitmap);
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
                    if (this.e.x != null && !this.e.x.isRecycled()) {
                        this.e.x.recycle();
                    }
                    this.e.x = bitmap;
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                Bitmap bitmap = this.b;
                if (bitmap != null && !bitmap.isRecycled()) {
                    Bitmap bitmap2 = this.e.x;
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
    public class p extends BdAsyncTask<Object, Integer, Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditHeadActivity a;

        public p(EditHeadActivity editHeadActivity) {
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

        public /* synthetic */ p(EditHeadActivity editHeadActivity, f fVar) {
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

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.o = null;
                if (!this.a.K) {
                    this.a.n.setDialogVisiable(false);
                }
                this.a.k.setClickable(true);
                this.a.k.setEnabled(true);
                super.cancel(true);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bitmap) == null) {
                super.onPostExecute((p) bitmap);
                this.a.o = null;
                this.a.h = bitmap;
                this.a.n.setDialogVisiable(false);
                this.a.k.setClickable(true);
                this.a.k.setEnabled(true);
                if (bitmap != null && !bitmap.isRecycled()) {
                    if (bitmap != null) {
                        this.a.c.setImageBitmap(bitmap);
                        if (this.a.K) {
                            this.a.J1(true);
                            this.a.M1(false);
                            this.a.I1(false);
                            this.a.H1(true);
                            this.a.K1();
                            return;
                        }
                        return;
                    }
                    return;
                }
                this.a.c.setImageDrawable(null);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                if (!this.a.K) {
                    this.a.n.setDialogVisiable(true);
                }
                this.a.k.setClickable(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditHeadActivity this$0;

        public q(EditHeadActivity editHeadActivity) {
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

        public /* synthetic */ q(EditHeadActivity editHeadActivity, f fVar) {
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
    public class r extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;
        public final /* synthetic */ EditHeadActivity b;

        public r(EditHeadActivity editHeadActivity) {
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

        public /* synthetic */ r(EditHeadActivity editHeadActivity, f fVar) {
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
                editHeadActivity.showLoadingDialog(editHeadActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f17d5));
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
        this.y = null;
        this.z = true;
        this.A = true;
        this.I = new JSONObject();
        this.K = false;
        this.Q = new f(this);
    }

    public final void O1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            TBAlertConfig.OperateBtnConfig operateBtnConfig = new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f0121, TBAlertConfig.OperateBtnStyle.MAIN_BG);
            TBAlertConfig.OperateBtnConfig operateBtnConfig2 = new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f011f, TBAlertConfig.OperateBtnStyle.SECONDARY);
            this.P = new TBAlertBuilder(getActivity()).setTitle(R.string.obfuscated_res_0x7f0f0120).setDesc(R.string.obfuscated_res_0x7f0f011e).setOperateBtn(operateBtnConfig2, operateBtnConfig).setCancelable(true).show();
            operateBtnConfig.setListener(new d(this));
            operateBtnConfig2.setListener(new e(this));
        }
    }

    public final void z1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            getLayoutMode().onModeChanged(this.j);
            getLayoutMode().onModeChanged(this.k);
            SkinManager.setViewTextColor(this.v, R.color.CAM_X0111, 1);
            if (this.K) {
                SkinManager.setViewTextColor(this.w, R.color.CAM_X0101, 1);
                SkinManager.setNavbarIconSrc(this.F.getBackImageView(), R.drawable.ic_icon_pure_topbar_return40_svg, R.drawable.ic_icon_pure_topbar_return40_svg, 0);
            } else {
                SkinManager.setViewTextColor(this.w, R.color.CAM_X0111, 1);
                SkinManager.setNavbarIconSrc(this.F.getBackImageView(), R.drawable.icon_topbar_return_s, R.drawable.icon_topbar_return_s, 0);
                SkinManager.setBackgroundColor(this.F, R.color.common_color_10222);
            }
            SkinManager.setViewTextColor(this.H, R.color.CAM_X0111, 1);
        }
    }

    public final void G1(PhotoUrlData photoUrlData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, photoUrlData) == null) {
            Intent intent = new Intent(EditHeadActivityConfig.ACTION_UPLOAD_SUCCESS);
            intent.putExtra(EditHeadActivityConfig.PIC_INFO, photoUrlData);
            getPageContext().getPageActivity().sendBroadcast(intent);
        }
    }

    public void H1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.e.setAiCreateButtonClickable(z);
        }
    }

    public void I1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.e.setAiCreateLoadingVisible(z);
        }
    }

    public void J1(boolean z) {
        EditHeadsImageView editHeadsImageView;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048585, this, z) == null) && (editHeadsImageView = this.c) != null) {
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            editHeadsImageView.setVisibility(i2);
        }
    }

    public void M1(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            FrameLayout frameLayout = this.N;
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            frameLayout.setVisibility(i2);
        }
    }

    public final void Q1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            o oVar = this.p;
            if (oVar != null) {
                oVar.cancel();
            }
            o oVar2 = new o(this);
            this.p = oVar2;
            oVar2.execute(str);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            super.onChangeSkinType(i2);
            z1();
        }
    }

    public final boolean F1(String str, Bitmap bitmap) {
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

    public int A1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.C;
        }
        return invokeV.intValue;
    }

    public final void C1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            r rVar = this.u;
            if (rVar != null) {
                rVar.cancel();
            }
            r rVar2 = new r(this, null);
            this.u = rVar2;
            rVar2.execute(new String[0]);
        }
    }

    public void D1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.y = new q(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
            registerReceiver(this.y, intentFilter);
        }
    }

    public void K1() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (alertDialog = this.P) != null && alertDialog.isShowing()) {
            this.P.dismiss();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            p pVar = this.o;
            if (pVar != null) {
                pVar.cancel();
            }
            this.c.setImageDrawable(null);
            E1();
        }
    }

    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            JSONObject jSONObject = this.I;
            if (jSONObject != null) {
                return jSONObject.optString(ForumBroadcastHelper.KEY_PARMARS_FORUM_NAME);
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void B1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.F = (NavigationBar) findViewById(R.id.navigation_bar);
            this.G = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0901b3);
            this.N = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f091a61);
            this.M = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091a62);
            BlueCircleProgressDialog blueCircleProgressDialog = new BlueCircleProgressDialog(getPageContext());
            this.n = blueCircleProgressDialog;
            blueCircleProgressDialog.setCancelListener(new g(this));
            this.n.setDialogVisiable(false);
            this.d = (EditHeadsImageTopLayerView) findViewById(R.id.obfuscated_res_0x7f091121);
            this.e = (EditForumImageLayerView) findViewById(R.id.obfuscated_res_0x7f090c8e);
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
                    this.e.setData(this.I);
                    this.e.setVisibility(0);
                    this.I.optString("diyChance");
                }
            }
            if (this.K) {
                this.e.setAiCreateButtonIsVisible();
                this.e.setCutHeightScale(this.a);
                this.e.setSaveButtonOnClickListener(this.Q);
                this.e.setRefreshButtonOnClickListener(new h(this));
                this.G.setVisibility(0);
            }
            this.f = (ImageView) findViewById(R.id.obfuscated_res_0x7f091e1c);
            this.g = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f091e1d);
            int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
            this.g.setY((int) (((screenDimensions[1] - screenDimensions[0]) * 0.4d) + screenDimensions[0] + getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070416)));
            EditHeadsImageView editHeadsImageView = (EditHeadsImageView) findViewById(R.id.obfuscated_res_0x7f0910fb);
            this.c = editHeadsImageView;
            editHeadsImageView.setCutImageHeightScale(this.a);
            Bitmap bitmap = this.h;
            if (bitmap != null) {
                this.c.setImageBitmap(bitmap);
            }
            this.c.setOnSizeChangedListener(new i(this));
            this.c.setOnImageScrollListener(new j(this));
            this.j = this.F.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new k(this));
            Button button = (Button) findViewById(R.id.obfuscated_res_0x7f0922db);
            this.m = button;
            button.setOnClickListener(new l(this));
            Button button2 = (Button) findViewById(R.id.hide_button);
            this.l = button2;
            button2.setVisibility(0);
            this.l.setOnClickListener(new m(this));
            View addCustomView = this.F.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.image_activity_save_button, (View.OnClickListener) null);
            this.k = addCustomView;
            addCustomView.setOnClickListener(this.Q);
            this.k.setEnabled(false);
            TextView textView = (TextView) this.k.findViewById(R.id.obfuscated_res_0x7f0921ae);
            this.H = textView;
            textView.setText(R.string.obfuscated_res_0x7f0f05bc);
            if (!EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.b)) {
                this.v = this.F.setTitleText(getPageContext().getString(R.string.obfuscated_res_0x7f0f0353));
            }
            if ("from_photo_live".equals(this.b)) {
                this.v.setText(R.string.obfuscated_res_0x7f0f0453);
            }
            if (EditHeadActivityConfig.FROM_FORUM_BACKGROUND.equals(this.b)) {
                this.H.setText(R.string.obfuscated_res_0x7f0f13c2);
            }
            this.t = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0903fc);
            this.s = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f092083);
            this.q = (RadioButton) findViewById(R.id.beautify_btn);
            this.r = (RadioButton) findViewById(R.id.rotate_btn);
            n nVar = new n(this);
            this.q.setOnCheckedChangeListener(nVar);
            this.r.setOnCheckedChangeListener(nVar);
            this.q.setChecked(true);
            Button button3 = (Button) findViewById(R.id.rotate_left);
            Button button4 = (Button) findViewById(R.id.rotate_right);
            Button button5 = (Button) findViewById(R.id.rotate_left_right);
            Button button6 = (Button) findViewById(R.id.rotate_up_down);
            button3.setTag(0);
            button4.setTag(1);
            button5.setTag(2);
            button6.setTag(3);
            a aVar = new a(this);
            button3.setOnClickListener(aVar);
            button4.setOnClickListener(aVar);
            button5.setOnClickListener(aVar);
            button6.setOnClickListener(aVar);
            if (EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.b)) {
                this.g.setVisibility(0);
                this.m.setVisibility(8);
                this.d.setLinePaintColor(getResources().getColor(R.color.white_alpha50));
                this.d.setLineWidth(2);
            }
            if (!this.A) {
                this.m.setVisibility(8);
                this.v.setText("");
            }
            this.w = this.F.setCenterTextTitle(getPageContext().getString(R.string.obfuscated_res_0x7f0f0123));
            if (this.K) {
                this.H.setVisibility(8);
                return;
            }
            this.H.setVisibility(0);
            this.w.setText("");
        }
    }

    public final void E1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            HashMap<String, ImageView> hashMap = this.E;
            if (hashMap != null) {
                for (Map.Entry<String, ImageView> entry : hashMap.entrySet()) {
                    ImageView value = entry.getValue();
                    if (value != null) {
                        value.setImageDrawable(null);
                    }
                }
                this.E.clear();
                this.E = null;
            }
            HashMap<String, Bitmap> hashMap2 = this.D;
            if (hashMap2 != null) {
                for (Map.Entry<String, Bitmap> entry2 : hashMap2.entrySet()) {
                    Bitmap value2 = entry2.getValue();
                    if (value2 != null && !value2.isRecycled()) {
                        value2.recycle();
                    }
                }
                this.D.clear();
                this.D = null;
            }
        }
    }

    public void P1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (this.L == null) {
                this.L = new ck5(getPageContext().getContext(), new c(this));
            }
            this.L.n(getPageContext().getString(R.string.ai_create_error));
            this.L.g(getPageContext().getString(R.string.obfuscated_res_0x7f0f0314));
            this.L.i(R.drawable.new_pic_emotion_08);
            this.L.attachView(this.M, true);
            this.L.e(R.color.CAM_X0501);
            this.L.k(0);
            this.L.f(new a65());
            this.L.q();
            this.L.p(R.color.CAM_X0101);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            releaseResouce();
            super.onDestroy();
            this.c.d0();
            Bitmap bitmap = this.h;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.h.recycle();
                this.h = null;
            }
            r rVar = this.u;
            if (rVar != null) {
                rVar.cancel();
            }
            Bitmap bitmap2 = this.x;
            if (bitmap2 != null && !bitmap2.isRecycled()) {
                this.x.recycle();
                this.x = null;
            }
            p pVar = this.o;
            if (pVar != null) {
                pVar.cancel();
                this.o = null;
            }
            this.n.setDialogVisiable(false);
            if ((this.y != null && this.C == 12002) || this.C == 12001) {
                unregisterReceiver(this.y);
            }
            TbadkCoreApplication.getInst().delRemoteActivity(this);
        }
    }

    public void R1(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048591, this, i2, i3) == null) {
            StatisticItem statisticItem = new StatisticItem("c15561");
            statisticItem.param("fid", this.I.optString("forumId")).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", i2);
            if (2 == i2) {
                statisticItem.param("obj_locate", i3);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void S1(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048592, this, i2, i3) == null) {
            StatisticItem statisticItem = new StatisticItem("c15560");
            statisticItem.param("fid", this.I.optString("forumId")).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", i2).param("obj_locate", i3);
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048598, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                if (this.K) {
                    R1(2, 3);
                }
                closeLoadingDialog();
                setResult(0);
                if (this.e.d()) {
                    O1();
                    return false;
                }
                finish();
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    public final void T1(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            if (EditHeadActivityConfig.FROM_FORUM_BACKGROUND.equals(this.b)) {
                str2 = "forum_background";
            } else {
                str2 = "head";
            }
            fj5 fj5Var = new fj5(FileHelper.getFileDireciory(str), str2);
            fj5Var.j();
            fj5Var.l(new b(this));
            fj5Var.n(this.B);
            fj5Var.g(false);
            showLoadingDialog(getPageContext().getString(R.string.obfuscated_res_0x7f0f17da));
        }
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            p pVar = this.o;
            if (pVar != null) {
                pVar.cancel();
            }
            p pVar2 = new p(this, null);
            this.o = pVar2;
            pVar2.execute(new Object[0]);
            AccountData accountData = (AccountData) getIntent().getSerializableExtra(EditHeadActivityConfig.ACCOUNTDATA);
            if (accountData != null) {
                TbadkCoreApplication.setCurrentAccountFromRemoteProcessInUIThread(accountData, getPageContext().getPageActivity());
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bundle) == null) {
            super.onCreate(bundle);
            this.O = new EditHeadController(this);
            setSwipeBackEnabled(false);
            TbadkCoreApplication.getInst().addRemoteActivity(this);
            setContentView(R.layout.obfuscated_res_0x7f0d0297);
            Intent intent = getIntent();
            this.i = intent.getIntExtra(EditHeadActivityConfig.EDITTYPE, 0);
            this.C = intent.getIntExtra("request", 0);
            this.z = intent.getBooleanExtra("need_upload", true);
            this.A = intent.getBooleanExtra(EditHeadActivityConfig.NEED_PASTE, true);
            this.B = intent.getIntExtra(EditHeadActivityConfig.WATERMARK_TYPE, 0);
            this.a = intent.getFloatExtra(EditHeadActivityConfig.CUT_IMAGE_HEIGHT_SCALE, 1.0f);
            this.b = intent.getStringExtra(EditHeadActivityConfig.FROM_WHERE);
            this.J = intent.getBooleanExtra(EditHeadActivityConfig.SYSTEM_FORUM_BACKGROUND, false);
            this.K = intent.getBooleanExtra(EditHeadActivityConfig.AI_CREATE_FORUM_BACKGROUND, false);
            String stringExtra = intent.getStringExtra("forum_bg_info");
            try {
                if (!TextUtils.isEmpty(stringExtra)) {
                    this.I = new JSONObject(stringExtra);
                }
            } catch (JSONException e2) {
                BdLog.e(e2);
            }
            UserGrowthTaskListData userGrowthTaskListData = (UserGrowthTaskListData) intent.getSerializableExtra(EditHeadActivityConfig.USER_GROWTH_TASK);
            if (userGrowthTaskListData != null) {
                TbSingleton.getInstance().setUserGrowthTaskListData(userGrowthTaskListData);
            }
            if (EditHeadActivityConfig.FROM_FORUM_BACKGROUND.equals(this.b) && !this.K) {
                if (this.J) {
                    S1(1, 2);
                } else {
                    S1(1, 1);
                }
            }
            String stringExtra2 = intent.getStringExtra(f1145T);
            String stringExtra3 = intent.getStringExtra(EditHeadActivityConfig.IMAGE_URL);
            int i2 = this.C;
            if (i2 != 12002 && i2 != 12001) {
                B1();
                initData();
                return;
            }
            B1();
            if (this.K) {
                this.O.d(this.I.optString("taskId"), true);
                this.e.setAiCreateLoadingVisible(true);
                return;
            }
            if (StringUtils.isNotNull(stringExtra3)) {
                TiebaPrepareImageService.StartService(this.C, TbImageHelper.getInstance().getPostImageSize(), stringExtra3);
            } else if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.C, intent.getData(), TbImageHelper.getInstance().getPostImageSize());
            } else {
                TiebaPrepareImageService.StartService(this.C, null, TbImageHelper.getInstance().getPostImageSize(), 0, stringExtra2);
            }
            D1();
        }
    }
}
