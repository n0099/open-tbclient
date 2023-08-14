package com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.chatmessage.IGenBosObjectUrlListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.AsyncChatTask;
import com.baidu.android.imsdk.upload.AsyncUploadTask;
import com.baidu.android.imsdk.upload.IUploadTransferListener;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.spswitch.utils.EmotionUbcHelper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PicManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.emotiontool.EmotionNoLaunchView;
import com.baidu.tbadk.editortools.sendtool.SendNoLaunchView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.al8;
import com.baidu.tieba.an8;
import com.baidu.tieba.bi;
import com.baidu.tieba.bl8;
import com.baidu.tieba.c31;
import com.baidu.tieba.cl8;
import com.baidu.tieba.dl8;
import com.baidu.tieba.dx5;
import com.baidu.tieba.fi8;
import com.baidu.tieba.gj8;
import com.baidu.tieba.h9;
import com.baidu.tieba.im.chat.AbsMsglistView;
import com.baidu.tieba.im.model.LocalPicModel;
import com.baidu.tieba.immessagecenter.chatgroup.data.AtData;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.GroupChatFragment;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ability.InputBoxHandler;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.GroupInputTool;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.GroupInputViewController;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.GroupChatRobotTopHeadView;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.data.SkillSugRequest;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.data.UserReplyInfoData;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.BotsDTO;
import com.baidu.tieba.kw5;
import com.baidu.tieba.lh5;
import com.baidu.tieba.mh5;
import com.baidu.tieba.nc5;
import com.baidu.tieba.om8;
import com.baidu.tieba.ow5;
import com.baidu.tieba.p1c;
import com.baidu.tieba.pv5;
import com.baidu.tieba.qm8;
import com.baidu.tieba.rk8;
import com.baidu.tieba.sk8;
import com.baidu.tieba.tk8;
import com.baidu.tieba.uk8;
import com.baidu.tieba.um8;
import com.baidu.tieba.vh;
import com.baidu.tieba.vk8;
import com.baidu.tieba.vn5;
import com.baidu.tieba.wk8;
import com.baidu.tieba.xh5;
import com.baidu.tieba.xk8;
import com.baidu.tieba.xl8;
import com.baidu.tieba.yh5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class GroupInputViewController implements LifecycleObserver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public al8 A;
    public sk8 B;
    public String C;
    public int D;
    public Object E;
    public fi8 F;
    public BotsDTO.BotListDTO.UserDTO G;
    public List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> H;
    public List<BotsDTO.BotListDTO.SkillDTO> I;
    public BotsDTO.BotListDTO.SkillDTO J;
    public GroupChatRobotTopHeadView K;
    public SourceType L;
    @NonNull
    public qm8 M;
    public boolean N;
    public boolean O;
    public boolean P;
    public List<AtSelectData> Q;
    public List<InputBoxHandler.BanData> R;
    public int S;
    @Nullable

    /* renamed from: T  reason: collision with root package name */
    public gj8 f1120T;
    public final CustomMessageListener U;
    public final CustomMessageListener V;
    public mh5 W;
    public tk8.m X;
    public GroupInputTool.h Y;
    public tk8.l Z;
    public int a;
    public final h9 a0;
    public ToolState b;
    public final CustomMessageListener b0;
    public Context c;
    public WriteImagesInfo d;
    public LocalPicModel e;
    public View f;
    public String g;
    public String h;
    public String i;
    public TbPageContext j;
    public EditorTools k;
    public GroupChatFragment l;
    public GroupInputTool m;
    public rk8 n;
    public tk8 o;
    public GroupInputTool p;
    public long q;
    public boolean r;
    public String s;
    public boolean t;
    public PermissionJudgePolicy u;
    public boolean v;
    @Nullable
    public xk8 w;
    public bl8 x;
    public dl8 y;
    public cl8 z;

    /* loaded from: classes6.dex */
    public interface e0 {
        void a();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65570, this) == null) {
        }
    }

    public boolean u0(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048676, this, i2, i3)) == null) ? i2 > 1 && i2 > i3 : invokeII.booleanValue;
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageFileInfo a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ GroupInputViewController d;

        /* loaded from: classes6.dex */
        public class a extends kw5<Object> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = eVar;
            }

            @Override // com.baidu.tieba.kw5
            public Object doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    e eVar = this.a;
                    eVar.d.w0(eVar.a);
                    return null;
                }
                return invokeV.objValue;
            }
        }

        /* loaded from: classes6.dex */
        public class b implements pv5<Object> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            public b(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = eVar;
            }

            @Override // com.baidu.tieba.pv5
            public void onReturnDataInUI(Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                    if (this.a.a.isGif()) {
                        this.a.d.e = new LocalPicModel(null, TbConfig.IMAGE_RESIZED_FILE, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                    } else {
                        e eVar = this.a;
                        eVar.d.e = new LocalPicModel(eVar.b, eVar.c, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                    }
                    this.a.d.e.setLoadDataCallBack(this.a.d.a0);
                    this.a.d.e.getData();
                }
            }
        }

        public e(GroupInputViewController groupInputViewController, ImageFileInfo imageFileInfo, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController, imageFileInfo, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = groupInputViewController;
            this.a = imageFileInfo;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageFileInfo imageFileInfo;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (imageFileInfo = this.a) != null && imageFileInfo.getFilePath() != null) {
                ow5.b(new a(this), new b(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements bl8.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        /* loaded from: classes6.dex */
        public class a implements bl8.d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ h a;

            public a(h hVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = hVar;
            }

            @Override // com.baidu.tieba.bl8.d
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.L1(SourceType.ONE, false, false);
                }
            }
        }

        public h(GroupInputViewController groupInputViewController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupInputViewController;
        }

        @Override // com.baidu.tieba.bl8.f
        public void a(BotsDTO.BotListDTO.UserDTO userDTO, BotsDTO.BotListDTO.SkillDTO skillDTO) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, userDTO, skillDTO) == null) && userDTO != null && skillDTO != null) {
                this.a.T1(userDTO, skillDTO);
                this.a.g0();
                if (this.a.w != null) {
                    if (skillDTO.isFuncJump() && skillDTO.getAbilityItem() != null) {
                        this.a.w.m(skillDTO.getAbilityItem());
                        this.a.Z0();
                        return;
                    } else if (skillDTO.isFuncSendMsg() && !TextUtils.isEmpty(userDTO.getUk())) {
                        this.a.w.j(userDTO.getUk(), skillDTO.getType());
                        this.a.M0().t(null);
                        this.a.Z0();
                        return;
                    }
                }
                this.a.y0();
                this.a.F1(true);
                if (this.a.M0() != null) {
                    this.a.M0().t(new a(this));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements IGenBosObjectUrlListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wk8 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ GroupInputViewController c;

        /* loaded from: classes6.dex */
        public class a implements IUploadTransferListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ l b;

            public a(l lVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = lVar;
                this.a = str;
            }

            @Override // com.baidu.android.imsdk.upload.IUploadTransferListener
            public void onFailed(int i, int i2, String str) {
                wk8 wk8Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, str) == null) && (wk8Var = this.b.a) != null) {
                    wk8Var.a(i, i2, str);
                }
            }

            @Override // com.baidu.android.imsdk.upload.IUploadTransferListener
            public void onFinished(int i, String str) {
                wk8 wk8Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) && (wk8Var = this.b.a) != null) {
                    wk8Var.c(i, str, this.a);
                }
            }

            @Override // com.baidu.android.imsdk.upload.IUploadTransferListener
            public void onProgress(int i) {
                wk8 wk8Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (wk8Var = this.b.a) != null) {
                    wk8Var.b(i);
                }
            }
        }

        public l(GroupInputViewController groupInputViewController, wk8 wk8Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController, wk8Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = groupInputViewController;
            this.a = wk8Var;
            this.b = str;
        }

        @Override // com.baidu.android.imsdk.chatmessage.IGenBosObjectUrlListener
        public void onGenBosObjectUrlListener(int i, String str, String str2, String str3, Map<String, String> map) {
            String str4;
            String str5;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, str2, str3, map}) == null) {
                if (i == 0) {
                    String str6 = null;
                    if (map == null) {
                        str4 = "";
                        str5 = str4;
                    } else {
                        String str7 = map.get(AsyncChatTask.PUT_URL);
                        str5 = map.get(AsyncChatTask.GET_URL);
                        str4 = str7;
                        str6 = map.get("thumb_url");
                    }
                    if (bi.isEmpty(str4) || bi.isEmpty(str5) || bi.isEmpty(str6)) {
                        wk8 wk8Var = this.a;
                        if (wk8Var != null) {
                            wk8Var.a(i, 1, this.b);
                            return;
                        }
                        return;
                    }
                    this.c.g2(1, str4, str5, this.b, "image/jpeg", str2, str3, new a(this, str6));
                    return;
                }
                this.a.a(i, 1, this.b);
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class SourceType {
        public static final /* synthetic */ SourceType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final SourceType DIRECT_CHAT;
        public static final SourceType ONE;
        public static final SourceType TWO;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1239199703, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/inputtool/GroupInputViewController$SourceType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1239199703, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/inputtool/GroupInputViewController$SourceType;");
                    return;
                }
            }
            ONE = new SourceType("ONE", 0);
            TWO = new SourceType("TWO", 1);
            SourceType sourceType = new SourceType("DIRECT_CHAT", 2);
            DIRECT_CHAT = sourceType;
            $VALUES = new SourceType[]{ONE, TWO, sourceType};
        }

        public SourceType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static SourceType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (SourceType) Enum.valueOf(SourceType.class, str);
            }
            return (SourceType) invokeL.objValue;
        }

        public static SourceType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (SourceType[]) $VALUES.clone();
            }
            return (SourceType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class a implements tk8.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        public a(GroupInputViewController groupInputViewController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupInputViewController;
        }

        @Override // com.baidu.tieba.tk8.l
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
                this.a.l.G2();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a0 implements e0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserReplyInfoData a;
        public final /* synthetic */ GroupInputViewController b;

        public a0(GroupInputViewController groupInputViewController, UserReplyInfoData userReplyInfoData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController, userReplyInfoData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = groupInputViewController;
            this.a = userReplyInfoData;
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.GroupInputViewController.e0
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.y.l(null, this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends h9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        public b(GroupInputViewController groupInputViewController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupInputViewController;
        }

        @Override // com.baidu.tieba.h9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (obj instanceof LocalPicModel.ResponseData) {
                    LocalPicModel.ResponseData responseData = (LocalPicModel.ResponseData) obj;
                    String str = responseData.getBitmap().getWidth() + "," + responseData.getBitmap().getHeight();
                    String sPathGen = responseData.getSPathGen();
                    if (this.a.m1() && this.a.o != null && !StringUtils.isNull(sPathGen)) {
                        this.a.o.P(sPathGen, str);
                        return;
                    } else if (responseData.getExtraMap() != null) {
                        this.a.w.c(responseData.getSPathGen(), str, responseData.getExtraMap());
                        return;
                    } else {
                        this.a.w.k(responseData.getSPathGen(), str);
                        return;
                    }
                }
                this.a.l.showToast(TbadkCoreApplication.getInst().getString(R.string.pic_parser_error));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b0 implements bl8.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ GroupInputViewController b;

        public b0(GroupInputViewController groupInputViewController, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = groupInputViewController;
            this.a = str;
        }

        @Override // com.baidu.tieba.bl8.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.z.l(null, this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends kw5<Map<String, Object>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nc5 a;
        public final /* synthetic */ GroupInputViewController b;

        public c(GroupInputViewController groupInputViewController, nc5 nc5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController, nc5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = groupInputViewController;
            this.a = nc5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kw5
        /* renamed from: a */
        public Map<String, Object> doInBackground() {
            InterceptResult invokeV;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                String d = vn5.b.d(this.a.d(), true);
                boolean exists = new File(d).exists();
                if (!exists) {
                    d = d.replace(".gif", ".jpg");
                }
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setFilePath(d);
                imageFileInfo.setIsGif(exists);
                this.b.w0(imageFileInfo);
                String b = vn5.b.b(this.a.d());
                int i = w.a[this.a.getType().ordinal()];
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            str = "-1";
                        } else {
                            str = "3";
                        }
                    } else {
                        str = "2";
                    }
                } else {
                    str = "1";
                }
                HashMap hashMap = new HashMap();
                hashMap.put(EmotionUbcHelper.MEME_ID, b);
                hashMap.put("meme_type", str);
                return hashMap;
            }
            return (Map) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c0 implements e0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ GroupInputViewController b;

        public c0(GroupInputViewController groupInputViewController, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = groupInputViewController;
            this.a = str;
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.GroupInputViewController.e0
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.z.l(null, this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements pv5<Map<String, Object>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        public d(GroupInputViewController groupInputViewController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupInputViewController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pv5
        /* renamed from: a */
        public void onReturnDataInUI(Map<String, Object> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, map) == null) {
                this.a.e = new LocalPicModel(null, TbConfig.IMAGE_RESIZED_FILE, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                this.a.e.setExtraMap(map);
                this.a.e.setLoadDataCallBack(this.a.a0);
                this.a.e.getData();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d0 implements GroupInputTool.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.GroupInputTool.h
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        public d0(GroupInputViewController groupInputViewController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupInputViewController;
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.GroupInputTool.h
        public void b(VoiceData.VoiceModel voiceModel) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voiceModel) == null) && voiceModel != null && !StringUtils.isNull(voiceModel.getVoiceId()) && this.a.w != null) {
                this.a.w.d(voiceModel.getVoiceId(), voiceModel.getDuration());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        public f(GroupInputViewController groupInputViewController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupInputViewController;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.m.e0(false);
                this.a.v = true;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(GroupInputViewController groupInputViewController, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupInputViewController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (booleanValue && this.a.v) {
                    this.a.v = false;
                    if (!this.a.m0()) {
                        this.a.t0(true, 1);
                    }
                }
                if (!booleanValue && this.a.A != null) {
                    this.a.A.k();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements dl8.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        public i(GroupInputViewController groupInputViewController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupInputViewController;
        }

        @Override // com.baidu.tieba.dl8.e
        public void a(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) != null) || this.a.m == null) {
                return;
            }
            if (this.a.l != null) {
                this.a.l.B2();
            }
            GroupInputViewController groupInputViewController = this.a;
            groupInputViewController.J1(groupInputViewController.j.getString(R.string.im_msg_input_hint));
            this.a.K1(false);
            this.a.m.w(i, i2, j, animatorListenerAdapter, z);
        }

        @Override // com.baidu.tieba.dl8.e
        public void b(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) != null) || this.a.m == null) {
                return;
            }
            GroupInputViewController groupInputViewController = this.a;
            groupInputViewController.J1(groupInputViewController.C);
            this.a.K1(true);
            this.a.m.v(i, i2, j, animatorListenerAdapter, z);
        }

        @Override // com.baidu.tieba.dl8.e
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.p0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements cl8.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        public j(GroupInputViewController groupInputViewController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupInputViewController;
        }

        @Override // com.baidu.tieba.cl8.e
        public void a(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) != null) || this.a.m == null) {
                return;
            }
            if (this.a.l != null) {
                this.a.l.B2();
            }
            this.a.K1(false);
            this.a.m.w(i, i2, j, animatorListenerAdapter, z);
        }

        @Override // com.baidu.tieba.cl8.e
        public void b(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) != null) || this.a.m == null) {
                return;
            }
            GroupInputViewController groupInputViewController = this.a;
            groupInputViewController.J1(groupInputViewController.C);
            this.a.K1(true);
            this.a.m.v(i, i2, j, animatorListenerAdapter, z);
        }

        @Override // com.baidu.tieba.cl8.e
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.o0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(GroupInputViewController groupInputViewController, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupInputViewController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ToolState toolState;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (booleanValue) {
                    toolState = ToolState.VOICE;
                } else {
                    toolState = ToolState.TEXT;
                }
                if (this.a.b == toolState) {
                    return;
                }
                this.a.b = toolState;
                if (this.a.n != null) {
                    this.a.n.I(this.a.b);
                }
                this.a.i2(booleanValue);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m implements GroupChatRobotTopHeadView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        public m(GroupInputViewController groupInputViewController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupInputViewController;
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.GroupChatRobotTopHeadView.b
        public void onCloseEvent() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.r1(null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n implements dl8.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SourceType a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ GroupInputViewController d;

        public n(GroupInputViewController groupInputViewController, SourceType sourceType, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController, sourceType, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = groupInputViewController;
            this.a = sourceType;
            this.b = z;
            this.c = z2;
        }

        @Override // com.baidu.tieba.dl8.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.d.b2(this.a, this.b, this.c);
        }
    }

    /* loaded from: classes6.dex */
    public class o implements cl8.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SourceType a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ GroupInputViewController d;

        public o(GroupInputViewController groupInputViewController, SourceType sourceType, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController, sourceType, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = groupInputViewController;
            this.a = sourceType;
            this.b = z;
            this.c = z2;
        }

        @Override // com.baidu.tieba.cl8.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.d.b2(this.a, this.b, this.c);
        }
    }

    /* loaded from: classes6.dex */
    public class p implements e0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ GroupInputViewController b;

        public p(GroupInputViewController groupInputViewController, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = groupInputViewController;
            this.a = z;
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.GroupInputViewController.e0
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                GroupInputViewController groupInputViewController = this.b;
                groupInputViewController.a2(groupInputViewController.J, false, this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q implements bl8.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ GroupInputViewController b;

        public q(GroupInputViewController groupInputViewController, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = groupInputViewController;
            this.a = z;
        }

        @Override // com.baidu.tieba.bl8.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                GroupInputViewController groupInputViewController = this.b;
                groupInputViewController.a2(groupInputViewController.J, false, this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        public r(GroupInputViewController groupInputViewController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupInputViewController;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.o != null) {
                if (this.a.o.M()) {
                    this.a.o.D();
                    return;
                }
                this.a.a1(false);
                this.a.y0();
                this.a.h2();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class s implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        public s(GroupInputViewController groupInputViewController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupInputViewController;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.o != null && this.a.o.M()) {
                    this.a.o.D();
                    return;
                }
                this.a.b1(true, false, null);
                this.a.h2();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class t implements tk8.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        public t(GroupInputViewController groupInputViewController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupInputViewController;
        }

        @Override // com.baidu.tieba.tk8.k
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.y1();
                if (this.a.P) {
                    return;
                }
                this.a.b1(true, true, null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class u extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ e0 c;
        public final /* synthetic */ GroupInputViewController d;

        public u(GroupInputViewController groupInputViewController, boolean z, boolean z2, e0 e0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController, Boolean.valueOf(z), Boolean.valueOf(z2), e0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = groupInputViewController;
            this.a = z;
            this.b = z2;
            this.c = e0Var;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, animator) != null) {
                return;
            }
            this.d.v1(this.a, this.b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) != null) {
                return;
            }
            this.d.v1(this.a, this.b);
            e0 e0Var = this.c;
            if (e0Var != null) {
                e0Var.a();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class v extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(GroupInputViewController groupInputViewController, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupInputViewController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                this.a.O = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static /* synthetic */ class w {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1108333537, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/inputtool/GroupInputViewController$w;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1108333537, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/inputtool/GroupInputViewController$w;");
                    return;
                }
            }
            int[] iArr = new int[EmotionGroupType.values().length];
            a = iArr;
            try {
                iArr[EmotionGroupType.BIG_EMOTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[EmotionGroupType.USER_COLLECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[EmotionGroupType.USER_DIY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class x implements mh5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        public x(GroupInputViewController groupInputViewController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupInputViewController;
        }

        @Override // com.baidu.tieba.mh5
        public void B(lh5 lh5Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, lh5Var) != null) || lh5Var == null) {
                return;
            }
            int i = lh5Var.a;
            if (i == 24) {
                Object obj = lh5Var.c;
                if (obj instanceof nc5) {
                    nc5 nc5Var = (nc5) obj;
                    if (nc5Var.getType() != EmotionGroupType.LOCAL) {
                        this.a.x1(nc5Var);
                    }
                }
            } else if (i == 8) {
                this.a.y1();
                if (this.a.P) {
                    return;
                }
                this.a.a1(true);
            } else if (i == 4) {
                Object obj2 = lh5Var.c;
                if (obj2 instanceof String) {
                    this.a.g = (String) obj2;
                    this.a.t0(false, 1);
                    this.a.A.m(100L);
                }
            } else if (i == 14) {
                this.a.s1();
            } else if (i != 17) {
                if (i == 62) {
                    boolean booleanValue = ((Boolean) lh5Var.c).booleanValue();
                    if (this.a.m == null) {
                        return;
                    }
                    if (booleanValue) {
                        this.a.q0();
                    } else {
                        this.a.t0(true, 1);
                    }
                    if (!this.a.m.Z() || this.a.L0() != ToolState.TEXT) {
                        return;
                    }
                    this.a.Q1(false);
                    this.a.E1(false);
                } else if (i != 63 || this.a.m == null) {
                } else {
                    this.a.m.e0(false);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class y implements tk8.m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        public y(GroupInputViewController groupInputViewController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupInputViewController;
        }

        @Override // com.baidu.tieba.tk8.m
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZ(1048576, this, z) != null) {
                return;
            }
            this.a.W1(z);
        }
    }

    /* loaded from: classes6.dex */
    public class z implements bl8.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserReplyInfoData a;
        public final /* synthetic */ GroupInputViewController b;

        public z(GroupInputViewController groupInputViewController, UserReplyInfoData userReplyInfoData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController, userReplyInfoData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = groupInputViewController;
            this.a = userReplyInfoData;
        }

        @Override // com.baidu.tieba.bl8.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.y.l(null, this.a);
            }
        }
    }

    public GroupInputViewController(GroupChatFragment groupChatFragment, long j2, gj8 gj8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {groupChatFragment, Long.valueOf(j2), gj8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = ToolState.TEXT;
        this.d = new WriteImagesInfo(1);
        this.e = null;
        this.k = null;
        this.t = true;
        this.C = null;
        this.F = new fi8();
        this.H = new ArrayList();
        this.K = null;
        this.O = false;
        this.P = false;
        this.Q = new ArrayList();
        this.R = new ArrayList();
        this.S = 0;
        this.U = new k(this, 2921790);
        this.V = new v(this, 2921800);
        this.W = new x(this);
        this.X = new y(this);
        this.Y = new d0(this);
        this.Z = new a(this);
        this.a0 = new b(this);
        this.b0 = new g(this, 2921785);
        this.q = j2;
        this.l = groupChatFragment;
        this.j = groupChatFragment.getPageContext();
        this.c = groupChatFragment.getContext();
        this.f1120T = gj8Var;
        this.p = new GroupInputTool(this.l);
        sk8 sk8Var = new sk8(this.l);
        this.B = sk8Var;
        sk8Var.o(this.W);
        this.M = new om8(this);
        this.A = new al8(this.l, new p1c() { // from class: com.baidu.tieba.qk8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.p1c
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? GroupInputViewController.this.o1() : invokeV.objValue;
            }
        }, gj8Var);
        c1();
        G1(this.p);
        d1();
        MessageManager.getInstance().registerListener(this.U);
        MessageManager.getInstance().registerListener(this.V);
        tk8 tk8Var = this.o;
        if (tk8Var != null) {
            tk8Var.a0(this.Z);
        }
    }

    public void A1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.C = str;
        }
    }

    public void D1(List<InputBoxHandler.BanData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.R = list;
        }
    }

    public final void F1(boolean z2) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048587, this, z2) != null) || (groupInputTool = this.m) == null) {
            return;
        }
        if (z2) {
            groupInputTool.h0(1);
        } else {
            groupInputTool.h0(0);
        }
    }

    public void H1(String str) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, str) == null) && (editorTools = this.k) != null) {
            editorTools.D(new lh5(75, 3, str));
        }
    }

    public void I1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.g = str;
            if (!TextUtils.isEmpty(str)) {
                this.i = str;
            }
            EditorTools editorTools = this.k;
            if (editorTools != null) {
                editorTools.D(new lh5(6, 3, str));
            }
        }
    }

    public void J1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.s = str;
            EditorTools editorTools = this.k;
            if (editorTools != null) {
                editorTools.D(new lh5(71, 3, StringHelper.cutChineseAndEnglishWithEmoji(str, 28, "...")));
            }
        }
    }

    public void K1(boolean z2) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048597, this, z2) == null) && (groupInputTool = this.m) != null) {
            groupInputTool.i0(z2);
        }
    }

    public void N1(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048603, this, z2) == null) && this.k.o(6) != null) {
            if (!z2) {
                this.k.o(6).hide();
            } else {
                this.k.o(6).display();
            }
        }
    }

    public void O1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            this.S = i2;
        }
    }

    public void P1(GroupInputTool.f fVar) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048607, this, fVar) == null) && (groupInputTool = this.m) != null) {
            groupInputTool.m0(fVar);
        }
    }

    public void R1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, view2) == null) {
            this.f = view2;
        }
    }

    public void V1(@Nullable xk8 xk8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, xk8Var) == null) {
            this.w = xk8Var;
        }
    }

    public void Y0(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, str) == null) {
            y0();
            r0(str);
        }
    }

    public void Y1(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, editorTools) == null) {
            this.k = editorTools;
        }
    }

    public final void a1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048628, this, z2) == null) {
            b1(false, z2, null);
        }
    }

    @Nullable
    public final fi8 j0(@NonNull boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048651, this, z2)) == null) {
            fi8 fi8Var = this.F;
            if (fi8Var != null) {
                fi8Var.a = this.G;
                fi8Var.b = this.J;
                fi8Var.c = this.H;
                fi8Var.e(z2);
            }
            return this.F;
        }
        return (fi8) invokeZ.objValue;
    }

    @NonNull
    public final SkillSugRequest k0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048654, this, i2)) == null) {
            return new SkillSugRequest(i2, this.G.getUk(), this.l.j2(), this.l.l2());
        }
        return (SkillSugRequest) invokeI.objValue;
    }

    public boolean k1(@NonNull List<Integer> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048655, this, list)) == null) {
            if (list.isEmpty()) {
                return false;
            }
            return this.M.a(list);
        }
        return invokeL.booleanValue;
    }

    public final void l0(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048657, this, z2) == null) && M0() != null) {
            M0().t(new q(this, z2));
        }
    }

    public void onChangeSkinType(int i2) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048665, this, i2) == null) && (groupInputTool = this.p) != null) {
            groupInputTool.onChangeSkinType(i2);
        }
    }

    public void q1(@NonNull Bundle bundle) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048669, this, bundle) == null) && (groupInputTool = this.p) != null) {
            groupInputTool.c0(bundle);
        }
    }

    public final void w1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048681, this, z2) == null) {
            this.N = true;
            b1(true, false, new p(this, z2));
        }
    }

    public final void x0(@NonNull List<BotsDTO.BotListDTO.SkillDTO> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048682, this, list) == null) {
            for (BotsDTO.BotListDTO.SkillDTO skillDTO : list) {
                if (skillDTO != null && skillDTO.getType() == this.D) {
                    this.J = skillDTO;
                    return;
                }
            }
        }
    }

    public void z1(BotsDTO botsDTO) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048687, this, botsDTO) == null) && (groupInputTool = this.m) != null) {
            groupInputTool.d0(botsDTO);
        }
    }

    public void T1(BotsDTO.BotListDTO.UserDTO userDTO, BotsDTO.BotListDTO.SkillDTO skillDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048615, this, userDTO, skillDTO) == null) {
            this.G = userDTO;
            this.J = skillDTO;
        }
    }

    public void k2(@NonNull String str, @NonNull uk8 uk8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048656, this, str, uk8Var) == null) {
            vk8 vk8Var = new vk8(this.c, str, "audio/amr");
            vk8Var.b(uk8Var);
            BIMManager.audioTrans(this.c, str, "audio/amr", "amr", 12, vk8Var);
        }
    }

    public void t1(@NonNull UserReplyInfoData userReplyInfoData, @NonNull Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048675, this, userReplyInfoData, obj) == null) {
            this.E = obj;
            y0();
            s0(userReplyInfoData);
            f0(userReplyInfoData);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65571, this) == null) {
            sk8 sk8Var = this.B;
            if (sk8Var != null) {
                sk8Var.z0().setIsUseMediaPlayer(false);
                this.B.l();
            }
            rk8 rk8Var = this.n;
            if (rk8Var != null) {
                rk8Var.A();
            }
            tk8 tk8Var = this.o;
            if (tk8Var != null) {
                tk8Var.Q();
            }
            al8 al8Var = this.A;
            if (al8Var != null) {
                al8Var.o();
            }
            VoiceManager.setIsNeedBlackScreen(true);
            MessageManager.getInstance().unRegisterListener(this.b0);
            MessageManager.getInstance().unRegisterListener(this.U);
            MessageManager.getInstance().unRegisterListener(this.V);
        }
    }

    public String G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            EditorTools editorTools = this.k;
            if (editorTools == null) {
                return "";
            }
            xh5 p2 = editorTools.p(3);
            String str = TbEnum.ChatInputStatus.INPUT_STATUS_TEXT;
            if (p2 != null) {
                yh5 yh5Var = p2.m;
                if ((yh5Var instanceof View) && ((View) yh5Var).getVisibility() != 0) {
                    str = TbEnum.ChatInputStatus.INPUT_STATUS_VOICE;
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put(TbEnum.ChatInputStatus.INPUT_DRAFT_KEY, this.g);
            hashMap.put(TbEnum.ChatInputStatus.INPUT_STATUS_KEY, str);
            return OrmObject.jsonStrWithObject((AbsMsglistView.DraftContent) OrmObject.objectWithMap(hashMap, AbsMsglistView.DraftContent.class));
        }
        return (String) invokeV.objValue;
    }

    public final void g0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048642, this) == null) && this.G != null && this.J != null) {
            um8.f().h(um8.f().c(this.G.getUk(), this.J.getType(), this.G.getNameShow(), this.J.getName(), this.G.getPortrait(), this.J.getDesc(), this.J.getFuncType()));
        }
    }

    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048645, this) == null) {
            y0();
            if (l1()) {
                p0();
            }
            if (j1()) {
                o0();
            }
            v0();
            tk8 tk8Var = this.o;
            if (tk8Var != null && tk8Var.L()) {
                a1(true);
            }
            U1(2, true);
            M1(true);
            N1(true);
            this.Q.clear();
            this.P = false;
        }
    }

    public final void s1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048673, this) != null) || !i1()) {
            return;
        }
        EditorTools editorTools = this.k;
        if (editorTools != null) {
            editorTools.r();
        }
        this.d.mIsFromIm = true;
        AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.c, this.d.toJsonString(), true, false);
        albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
        albumFloatActivityConfig.setResourceType(1);
        albumFloatActivityConfig.setCanEditImage(false);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65572, this) == null) {
            this.r = false;
            sk8 sk8Var = this.B;
            if (sk8Var != null) {
                sk8Var.m();
                this.B.p(this.r);
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65573, this) == null) {
            this.r = true;
            sk8 sk8Var = this.B;
            if (sk8Var != null) {
                sk8Var.n();
                this.B.p(this.r);
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65574, this) == null) {
            if (K0() != null && K0().O()) {
                return;
            }
            TbSingleton.getInstance().setRoomDraft(Long.valueOf(this.q), G0());
        }
    }

    public void B0() {
        BotsDTO.BotListDTO.SkillDTO skillDTO;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (skillDTO = this.J) != null && skillDTO.getItems() != null) {
            this.H.addAll(this.J.getItems());
        }
    }

    public rk8 C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.n;
        }
        return (rk8) invokeV.objValue;
    }

    public GroupInputTool F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.p;
        }
        return (GroupInputTool) invokeV.objValue;
    }

    public List<InputBoxHandler.BanData> H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.R;
        }
        return (List) invokeV.objValue;
    }

    @NonNull
    public String I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (TextUtils.isEmpty(this.g)) {
                return "";
            }
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    public String J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    public GroupInputTool K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.m;
        }
        return (GroupInputTool) invokeV.objValue;
    }

    public ToolState L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.b;
        }
        return (ToolState) invokeV.objValue;
    }

    public bl8 M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.x;
        }
        return (bl8) invokeV.objValue;
    }

    public BotsDTO.BotListDTO.UserDTO N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.G;
        }
        return (BotsDTO.BotListDTO.UserDTO) invokeV.objValue;
    }

    @Nullable
    public BotsDTO.BotListDTO.SkillDTO O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.J;
        }
        return (BotsDTO.BotListDTO.SkillDTO) invokeV.objValue;
    }

    public final int P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            SourceType sourceType = this.L;
            if (sourceType == SourceType.DIRECT_CHAT) {
                return 6;
            }
            if (sourceType == SourceType.ONE) {
                return 1;
            }
            return 2;
        }
        return invokeV.intValue;
    }

    public tk8 Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.o;
        }
        return (tk8) invokeV.objValue;
    }

    public String R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            if (TextUtils.isEmpty(this.i)) {
                if (TextUtils.isEmpty(this.h)) {
                    return "";
                }
                return this.h;
            }
            return this.i;
        }
        return (String) invokeV.objValue;
    }

    public cl8 S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.z;
        }
        return (cl8) invokeV.objValue;
    }

    public void S1() {
        tk8 tk8Var;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048613, this) == null) && (tk8Var = this.o) != null && tk8Var.L() && (arrayList = (ArrayList) this.o.C()) != null) {
            this.H = arrayList;
        }
    }

    public dl8 T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.y;
        }
        return (dl8) invokeV.objValue;
    }

    @NonNull
    public qm8 U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.M;
        }
        return (qm8) invokeV.objValue;
    }

    @Nullable
    public VoiceManager V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            sk8 sk8Var = this.B;
            if (sk8Var != null) {
                return sk8Var.z0();
            }
            return null;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public SourceType W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return this.L;
        }
        return (SourceType) invokeV.objValue;
    }

    public void Z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            al8 al8Var = this.A;
            if (al8Var != null) {
                al8Var.k();
            }
            GroupInputTool groupInputTool = this.m;
            if (groupInputTool != null) {
                groupInputTool.V();
            }
        }
    }

    public final void c1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048632, this) == null) && this.n == null) {
            this.n = new rk8(this.c, this.l);
        }
    }

    public final void d1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            sk8 sk8Var = this.B;
            if (sk8Var != null) {
                sk8Var.i();
            }
            GroupInputTool groupInputTool = this.m;
            if (groupInputTool != null) {
                groupInputTool.n0(this.Y);
            }
        }
    }

    public final void e1() {
        bl8 bl8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048637, this) == null) && (bl8Var = this.x) != null) {
            bl8Var.s(new h(this));
        }
    }

    public final GroupChatRobotTopHeadView f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            GroupInputTool groupInputTool = this.m;
            if (groupInputTool == null) {
                return null;
            }
            GroupChatRobotTopHeadView R = groupInputTool.R();
            this.K = R;
            R.setEventCallback(new m(this));
            return this.K;
        }
        return (GroupChatRobotTopHeadView) invokeV.objValue;
    }

    public final void g1() {
        cl8 cl8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048643, this) == null) && (cl8Var = this.z) != null) {
            cl8Var.i(new j(this));
        }
    }

    public final void h1() {
        dl8 dl8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048646, this) == null) && (dl8Var = this.y) != null) {
            dl8Var.i(new i(this));
        }
    }

    public boolean i1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            if (FileHelper.checkSD()) {
                return true;
            }
            BdUtilHelper.showToast(this.c, TbadkCoreApplication.getInst().getString(R.string.voice_error_sdcard));
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            cl8 cl8Var = this.z;
            if (cl8Var != null && cl8Var.e()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            dl8 dl8Var = this.y;
            if (dl8Var != null && dl8Var.e()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean m1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            GroupInputTool groupInputTool = this.m;
            if (groupInputTool != null && groupInputTool.O() && this.O) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) {
            GroupInputTool groupInputTool = this.m;
            if (groupInputTool != null) {
                return groupInputTool.B();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void o0() {
        cl8 cl8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048663, this) == null) && (cl8Var = this.z) != null) {
            cl8Var.k(null);
        }
    }

    public /* synthetic */ CharSequence o1() {
        return this.g;
    }

    public void p0() {
        dl8 dl8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048666, this) == null) && (dl8Var = this.y) != null) {
            dl8Var.j(null);
        }
    }

    public final void q0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048668, this) == null) && M0() != null) {
            M0().t(null);
        }
    }

    public void u1() {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048677, this) == null) && (groupInputTool = this.m) != null) {
            groupInputTool.f0(false);
        }
    }

    public final void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048678, this) == null) {
            this.F.a();
            this.H.clear();
            this.G = null;
            this.J = null;
            this.E = null;
        }
    }

    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048684, this) == null) {
            this.g = null;
            EditorTools editorTools = this.k;
            if (editorTools != null) {
                editorTools.D(new lh5(9, -1, Boolean.TRUE));
            }
        }
    }

    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048686, this) == null) {
            try {
                y1();
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    public void A0() {
        BotsDTO.BotListDTO.SkillDTO skillDTO;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (skillDTO = this.J) != null && skillDTO.isCanKeyboardInput()) {
            if (!TextUtils.isEmpty(this.J.getKeyboardContent())) {
                I1(this.J.getKeyboardContent());
            } else {
                I1("");
            }
        }
    }

    @NonNull
    public xl8 E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            xl8 xl8Var = new xl8();
            xl8Var.g(this.l.l2());
            xl8Var.h(this.l.p2());
            xl8Var.e(this.l.j2());
            xl8Var.f(this.l.k2());
            return xl8Var;
        }
        return (xl8) invokeV.objValue;
    }

    public String e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            if (this.S == 0) {
                return f2() + this.g;
            }
            return this.g + f2();
        }
        return (String) invokeV.objValue;
    }

    public final String f2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            StringBuilder sb = new StringBuilder();
            for (AtSelectData atSelectData : this.Q) {
                sb.append("@");
                sb.append(atSelectData.getNameShow());
                sb.append(" ");
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public final boolean m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
            rk8 rk8Var = this.n;
            if (rk8Var == null || c31.h(rk8Var.v()) != 1 || !this.n.v().get(0).isRobot()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void B1(@Nullable Object obj, @Nullable BotsDTO.BotListDTO.UserDTO userDTO, @Nullable BotsDTO.BotListDTO.SkillDTO skillDTO, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{obj, userDTO, skillDTO, Boolean.valueOf(z2)}) == null) {
            this.E = obj;
            this.G = userDTO;
            this.J = skillDTO;
            fi8 fi8Var = this.F;
            if (fi8Var != null) {
                fi8Var.d(z2);
            }
        }
    }

    public final int D0(String str, AtSelectData atSelectData, Map<String, Integer> map, int i2) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048582, this, str, atSelectData, map, i2)) == null) {
            if (!map.containsValue(Integer.valueOf(i2))) {
                return i2;
            }
            return D0(str, atSelectData, map, str.indexOf("@" + atSelectData.getNameShow(), i2 + 1));
        }
        return invokeLLLI.intValue;
    }

    public void C1(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString(TbEnum.ChatInputStatus.INPUT_DRAFT_KEY);
            if (this.k != null) {
                this.k.D(new lh5(6, 3, optString));
            }
            this.g = optString;
            if (TextUtils.equals(jSONObject.optString(TbEnum.ChatInputStatus.INPUT_STATUS_KEY), TbEnum.ChatInputStatus.INPUT_STATUS_VOICE) && this.k != null) {
                this.k.D(new lh5(1, 6, null));
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void M1(boolean z2) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048601, this, z2) == null) && (groupInputTool = this.m) != null && groupInputTool.H() != null && (this.m.H().m instanceof EmotionNoLaunchView)) {
            ((EmotionNoLaunchView) this.m.H().m).setNeedHideForever(z2);
            if (!z2) {
                this.m.H().m.hide();
            } else {
                this.m.H().m.display();
            }
        }
    }

    public final void i2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048650, this, z2) == null) {
            if (z2) {
                q0();
                Q1(true);
                E1(true);
                if (this.l.L2() && !K0().b0()) {
                    this.l.F2(true);
                    return;
                } else {
                    this.l.F2(false);
                    return;
                }
            }
            t0(true, 1);
            int i2 = this.a;
            if (i2 == 0) {
                Q1(false);
            } else if (i2 == 1) {
                E1(false);
            }
        }
    }

    public final void r0(@NonNull String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048670, this, str) != null) || this.z == null) {
            return;
        }
        bl8 bl8Var = this.x;
        if (bl8Var != null && bl8Var.k()) {
            this.x.t(new b0(this, str));
        } else if (this.m.O()) {
            r1(new c0(this, str));
        } else {
            this.z.l(null, str);
            this.l.E2(true);
            if (l1()) {
                this.y.k(false);
                this.a = 0;
            }
        }
    }

    public final void s0(@NonNull UserReplyInfoData userReplyInfoData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048672, this, userReplyInfoData) != null) || this.y == null) {
            return;
        }
        bl8 bl8Var = this.x;
        if (bl8Var != null && bl8Var.k()) {
            this.x.t(new z(this, userReplyInfoData));
        } else if (this.m.O()) {
            r1(new a0(this, userReplyInfoData));
        } else {
            this.y.l(null, userReplyInfoData);
            this.l.E2(true);
            if (j1()) {
                this.z.j(false);
                this.a = 1;
            }
        }
    }

    public final void w0(ImageFileInfo imageFileInfo) {
        Bitmap resizeBitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048680, this, imageFileInfo) == null) {
            try {
                if (imageFileInfo.isGif()) {
                    FileHelper.saveGifByRelativePath(imageFileInfo.getFilePath(), null, TbConfig.IMAGE_RESIZED_FILE);
                    FileHelper.saveGifByRelativePath(imageFileInfo.getFilePath(), null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                    return;
                }
                Bitmap c2 = dx5.c(0, this.c, null, imageFileInfo.getFilePath(), TbImageHelper.getInstance().getPostImageSize());
                if (c2 != null && FileHelper.saveBitmapByRelativelyPath(null, TbConfig.IMAGE_RESIZED_FILE, c2, 85) != null && (resizeBitmap = BitmapHelper.resizeBitmap(c2, 100)) != null) {
                    FileHelper.saveBitmapByRelativelyPath(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 85);
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public final void E1(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048585, this, z2) == null) && S0() != null) {
            if (z2) {
                if (S0().e()) {
                    S0().j(false);
                    this.a = 1;
                }
            } else if (!S0().g()) {
                S0().j(true);
            }
        }
    }

    public final void Q1(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048609, this, z2) == null) && T0() != null) {
            if (z2) {
                if (T0().e()) {
                    T0().k(false);
                    this.a = 0;
                }
            } else if (!T0().g()) {
                T0().k(!z2);
            }
        }
    }

    public final void W1(boolean z2) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048621, this, z2) != null) || this.K == null || !z2) {
            return;
        }
        BotsDTO.BotListDTO.UserDTO userDTO = this.G;
        String str3 = null;
        if (userDTO != null) {
            str = userDTO.getPortrait();
            str2 = this.G.getNameShow();
        } else {
            str = null;
            str2 = null;
        }
        BotsDTO.BotListDTO.SkillDTO skillDTO = this.J;
        if (skillDTO != null) {
            str3 = skillDTO.getName();
        }
        this.K.setData(str, str2, str3);
        this.K.setVisibility(0);
    }

    public void f0(@NonNull UserReplyInfoData userReplyInfoData) {
        rk8 rk8Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048639, this, userReplyInfoData) != null) || (rk8Var = this.n) == null) {
            return;
        }
        rk8Var.G();
        this.n.k(new AtSelectData(userReplyInfoData.getmPortrait(), userReplyInfoData.getmNameShow(), String.valueOf(userReplyInfoData.getmUid()), userReplyInfoData.isRobot()), false);
    }

    public final void G1(GroupInputTool groupInputTool) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, groupInputTool) == null) && groupInputTool != null && this.B != null) {
            this.m = groupInputTool;
            this.x = groupInputTool.N();
            if (groupInputTool.U() != null && groupInputTool.L() != null) {
                this.y = new dl8(groupInputTool.U(), this.l, groupInputTool.L());
            }
            if (groupInputTool.T() != null && groupInputTool.L() != null) {
                this.z = new cl8(groupInputTool.T(), this.l, groupInputTool.L());
            }
            MessageManager.getInstance().registerListener(this.b0);
            e1();
            h1();
            g1();
            f1();
            if (groupInputTool.S() != null) {
                this.B.q(groupInputTool);
                Y1(groupInputTool.S());
                if (groupInputTool.I() != null) {
                    R1(groupInputTool.I());
                }
                if (this.q != 0 && !bi.isEmpty(TbSingleton.getInstance().getRoomDraft(Long.valueOf(this.q)))) {
                    C1(TbSingleton.getInstance().getRoomDraft(Long.valueOf(this.q)));
                }
                rk8 rk8Var = this.n;
                if (rk8Var != null) {
                    rk8Var.J(groupInputTool, this.k);
                    this.n.B();
                }
            }
        }
    }

    public void Z1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048627, this, z2) == null) {
            this.t = z2;
            if (this.k != null) {
                if (SharedPrefHelper.getInstance().getBoolean("key_group_chat_chatroom_audio_switch", true)) {
                    this.k.setToolEnabled(z2, 6);
                }
                this.k.D(new lh5(72, 3, Boolean.valueOf(z2)));
                if (this.k.p(37) != null && (this.k.p(37).m instanceof EmotionNoLaunchView)) {
                    ((EmotionNoLaunchView) this.k.p(37).m).setEnabled(z2);
                }
                if (SharedPrefHelper.getInstance().getBoolean("key_group_chat_chatroom_picture_switch", true) && this.k.p(38) != null && (this.k.p(38).m instanceof SendNoLaunchView)) {
                    ((SendNoLaunchView) this.k.p(38).m).setIconEnable(z2);
                    ((SendNoLaunchView) this.k.p(38).m).setSendInterceptToastText(this.s, z2);
                }
            }
            rk8 rk8Var = this.n;
            if (rk8Var != null) {
                rk8Var.K(z2);
            }
            GroupInputTool groupInputTool = this.m;
            if (groupInputTool != null && groupInputTool.J() != null && this.m.J().g() != null) {
                if (z2) {
                    this.m.J().g().setEnabled(true);
                    this.m.J().g().setOnClickListener(new f(this));
                    return;
                }
                this.m.J().g().setEnabled(false);
            }
        }
    }

    public void L1(SourceType sourceType, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{sourceType, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            if (l1()) {
                this.y.j(new n(this, sourceType, z2, z3));
            } else if (j1()) {
                this.z.k(new o(this, sourceType, z2, z3));
            } else {
                b2(sourceType, z2, z3);
            }
        }
    }

    public void X1(int i2, @NonNull Object obj, @NonNull fi8 fi8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048623, this, i2, obj, fi8Var) == null) {
            this.D = i2;
            this.E = obj;
            this.G = fi8Var.a;
            if (this.I == null) {
                this.I = new ArrayList();
            }
            this.I.clear();
            BotsDTO.BotListDTO.SkillDTO skillDTO = fi8Var.b;
            if (skillDTO != null && !ListUtils.isEmpty(skillDTO.getSubSkill())) {
                this.I.addAll(fi8Var.b.getSubSkill());
                x0(this.I);
            }
            fi8 fi8Var2 = this.F;
            if (fi8Var2 != null) {
                fi8Var2.d(fi8Var.c());
            }
        }
    }

    public final void b2(SourceType sourceType, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048631, this, new Object[]{sourceType, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            this.L = sourceType;
            GroupChatFragment groupChatFragment = this.l;
            if (groupChatFragment != null) {
                groupChatFragment.B2();
            }
            if (this.L == SourceType.TWO) {
                this.h = this.g;
                GroupInputTool groupInputTool = this.m;
                if (groupInputTool != null) {
                    if (groupInputTool.D()) {
                        l0(z3);
                        return;
                    } else if (this.m.O()) {
                        w1(z3);
                        return;
                    }
                }
            }
            a2(this.J, z2, z3);
        }
    }

    public void U1(int i2, boolean z2) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048617, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) && (groupInputTool = this.m) != null && groupInputTool.P() != null && (this.m.P().m instanceof SendNoLaunchView)) {
            if (i2 == 1) {
                ((SendNoLaunchView) this.m.P().m).setIsSendIcon(true);
                ((SendNoLaunchView) this.m.P().m).setSendVisibility(z2);
            } else if (i2 == 2) {
                ((SendNoLaunchView) this.m.P().m).setIsSendIcon(false);
                ((SendNoLaunchView) this.m.P().m).setSendVisibility(false);
            } else if (i2 == 3) {
                ((SendNoLaunchView) this.m.P().m).setIsSendIcon(false);
                ((SendNoLaunchView) this.m.P().m).setSendVisibility(true);
            }
        }
    }

    public final void c2(@NonNull BotsDTO.BotListDTO.SkillDTO skillDTO, boolean z2) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048633, this, skillDTO, z2) == null) && (groupInputTool = this.m) != null && groupInputTool.L() != null) {
            List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> items = skillDTO.getItems();
            tk8 tk8Var = this.o;
            if (tk8Var == null) {
                tk8 tk8Var2 = new tk8(this.m.L(), this.X);
                this.o = tk8Var2;
                tk8Var2.G(items, E0(), z2);
            } else {
                tk8Var.O(items, z2);
            }
            this.o.X(this.l.getPageContext());
            this.o.W(this.f1120T);
            j0(!ListUtils.isEmpty(items));
            Object obj = this.E;
            if (obj instanceof BaseMsg) {
                this.o.Y((BaseMsg) obj);
            }
            this.o.Z(k0(skillDTO.getType()));
            this.o.b0(z2, !ListUtils.isEmpty(items));
        }
    }

    public final void d2(@NonNull BotsDTO.BotListDTO.SkillDTO skillDTO, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048635, this, skillDTO, z2) == null) {
            List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> items = skillDTO.getItems();
            GroupInputTool groupInputTool = this.m;
            if (groupInputTool != null && groupInputTool.L() != null && !ListUtils.isEmpty(items)) {
                tk8 tk8Var = this.o;
                if (tk8Var == null) {
                    tk8 tk8Var2 = new tk8(this.m.L(), this.X);
                    this.o = tk8Var2;
                    tk8Var2.G(items, E0(), z2);
                } else {
                    tk8Var.O(items, z2);
                }
                this.o.X(this.l.getPageContext());
                this.o.W(this.f1120T);
                j0(!ListUtils.isEmpty(items));
                Object obj = this.E;
                if (obj instanceof BaseMsg) {
                    this.o.Y((BaseMsg) obj);
                }
                this.o.Z(k0(skillDTO.getType()));
                this.o.d0(new t(this), this.Z, z2);
            }
        }
    }

    public void t0(boolean z2, int i2) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048674, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) && (groupInputTool = this.m) != null && groupInputTool.S() != null && !this.m.Z() && this.x != null) {
            if (z2) {
                this.m.S().requestFocus();
            }
            if (!this.m.S().hasFocus()) {
                return;
            }
            boolean z3 = false;
            z3 = (i2 == 3 || i2 == 2) ? true : true;
            if (i2 != 2 && i2 != 3 && (TextUtils.isEmpty(this.g) || !"/".equals(this.g))) {
                this.x.t(null);
                return;
            }
            tk8 tk8Var = this.o;
            if (tk8Var != null && tk8Var.L() && this.L == SourceType.TWO) {
                return;
            }
            this.x.w(null, i2, Boolean.valueOf(z3));
        }
    }

    public void X0(List<InputBoxHandler.PaddingContent> list) {
        String type;
        AtData atData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048622, this, list) == null) && !list.isEmpty()) {
            this.Q.clear();
            for (int i2 = 0; i2 < list.size(); i2++) {
                String str = "";
                if (TextUtils.isEmpty(list.get(i2).getType())) {
                    type = "";
                } else {
                    type = list.get(i2).getType();
                }
                if ("at".equals(type) && (atData = list.get(i2).getAtData()) != null) {
                    if (!TextUtils.isEmpty(atData.getAtPortrait())) {
                        str = atData.getAtPortrait();
                    }
                    this.Q.add(new AtSelectData(str, atData.getAtName(), BIMManager.getBdUidFromBdUK(atData.getAtBaiduUk())));
                }
            }
        }
    }

    public void r1(@Nullable e0 e0Var) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048671, this, e0Var) == null) {
            b1(true, false, e0Var);
            h2();
            y0();
            v0();
            F1(false);
            GroupChatFragment groupChatFragment = this.l;
            if (groupChatFragment != null) {
                long l2 = groupChatFragment.l2();
                long j2 = this.l.j2();
                StatisticItem param = new StatisticItem("c15134").param("obj_type", 2).param("fid", j2).param("fname", this.l.k2()).param("room_id", l2);
                BotsDTO.BotListDTO.UserDTO userDTO = this.G;
                if (userDTO != null) {
                    str = BIMManager.getBdUidFromBdUK(userDTO.getUk());
                } else {
                    str = "";
                }
                TiebaStatic.log(param.param("obj_id", str).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
            rk8 rk8Var = this.n;
            if (rk8Var != null) {
                rk8Var.G();
            }
        }
    }

    public void x1(nc5 nc5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048683, this, nc5Var) == null) && nc5Var != null && nc5Var.c() != null && nc5Var.c().getRawBitmap() != null && this.B != null) {
            Activity pageActivity = this.j.getPageActivity();
            if (this.u == null || this.B.g() == null) {
                PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
                this.u = permissionJudgePolicy;
                this.B.r(permissionJudgePolicy);
            }
            this.u.clearRequestPermissionList();
            this.u.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.u.startRequestPermission(pageActivity)) {
                return;
            }
            ow5.b(new c(this, nc5Var), new d(this));
        }
    }

    public final void a2(BotsDTO.BotListDTO.SkillDTO skillDTO, boolean z2, boolean z3) {
        BotsDTO.BotListDTO.SkillDTO skillDTO2;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048629, this, new Object[]{skillDTO, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            if (skillDTO != null) {
                skillDTO2 = skillDTO.copy();
            } else {
                skillDTO2 = null;
            }
            if (this.m != null && skillDTO2 != null) {
                boolean z5 = false;
                if (this.L == SourceType.TWO) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                this.m.E(true);
                this.m.F(!z4);
                String str = "";
                if (skillDTO2.getKeyboard() == 1) {
                    if (!TextUtils.isEmpty(skillDTO2.getKeyboardContent())) {
                        I1(skillDTO2.getKeyboardContent());
                    } else {
                        I1("");
                    }
                    if (!TextUtils.isEmpty(skillDTO2.getExp())) {
                        J1(skillDTO2.getExp());
                    } else if (z4) {
                        J1(this.j.getString(R.string.obfuscated_res_0x7f0f095f));
                    }
                    U1(1, !TextUtils.isEmpty(this.g));
                    M1(false);
                    N1(false);
                    K1(false);
                    this.m.k0(new r(this));
                    if (this.m.S() != null) {
                        GroupInputTool groupInputTool = this.m;
                        if (skillDTO2.getKeyboardType() == 1) {
                            z5 = true;
                        }
                        groupInputTool.f0(z5);
                        this.m.S().l();
                    }
                    c2(skillDTO2, z3);
                } else {
                    if (this.m.S() != null) {
                        this.m.S().q();
                    }
                    this.m.k0(new s(this));
                    d2(skillDTO2, z3);
                }
                GroupChatFragment groupChatFragment = this.l;
                if (groupChatFragment != null) {
                    StatisticItem param = new StatisticItem("c15134").param("obj_type", 1).param("obj_name", skillDTO2.getName()).param("obj_source", P0()).param("fid", this.l.j2()).param("fname", this.l.k2()).param("room_id", groupChatFragment.l2());
                    BotsDTO.BotListDTO.UserDTO userDTO = this.G;
                    if (userDTO != null) {
                        str = BIMManager.getBdUidFromBdUK(userDTO.getUk());
                    }
                    TiebaStatic.log(param.param("obj_id", str).param("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        }
    }

    public final void b1(boolean z2, boolean z3, @Nullable e0 e0Var) {
        GroupChatFragment groupChatFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048630, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3), e0Var}) == null) && this.o != null && (groupChatFragment = this.l) != null) {
            groupChatFragment.E2(true);
            this.l.M2();
            this.o.F(new u(this, z2, z3, e0Var));
        }
    }

    public void e0(@NonNull AtSelectData atSelectData, boolean z2, boolean z3) {
        rk8 rk8Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048636, this, new Object[]{atSelectData, Boolean.valueOf(z2), Boolean.valueOf(z3)}) != null) || (rk8Var = this.n) == null) {
            return;
        }
        rk8Var.G();
        this.n.l(atSelectData, false, z2, z3);
    }

    public final void g2(int i2, String str, String str2, String str3, String str4, String str5, String str6, IUploadTransferListener iUploadTransferListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048644, this, new Object[]{Integer.valueOf(i2), str, str2, str3, str4, str5, str6, iUploadTransferListener}) == null) {
            new AsyncUploadTask(this.c, i2, str, str2, str3, str4, str5, str6, iUploadTransferListener).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    public final void h2() {
        GroupChatFragment groupChatFragment;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048647, this) == null) && (groupChatFragment = this.l) != null) {
            long l2 = groupChatFragment.l2();
            long j2 = this.l.j2();
            String k2 = this.l.k2();
            StatisticItem param = new StatisticItem("c15134").param("obj_type", 2).param("obj_source", P0());
            BotsDTO.BotListDTO.SkillDTO skillDTO = this.J;
            if (skillDTO != null) {
                str = skillDTO.getName();
            } else {
                str = StringUtil.NULL_STRING;
            }
            StatisticItem param2 = param.param("obj_name", str).param("fid", j2).param("fname", k2).param("room_id", l2);
            BotsDTO.BotListDTO.UserDTO userDTO = this.G;
            if (userDTO != null) {
                str2 = BIMManager.getBdUidFromBdUK(userDTO.getUk());
            } else {
                str2 = "";
            }
            TiebaStatic.log(param2.param("obj_id", str2).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @NonNull
    public final Map<String, Integer> i0(@NonNull String str, @NonNull List<AtSelectData> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048648, this, str, list)) == null) {
            HashMap hashMap = new HashMap();
            for (AtSelectData atSelectData : list) {
                int D0 = D0(str, atSelectData, hashMap, str.indexOf("@" + atSelectData.getNameShow()));
                if (D0 >= 0) {
                    hashMap.put(atSelectData.getUid(), Integer.valueOf(D0));
                }
            }
            return hashMap;
        }
        return (Map) invokeLL.objValue;
    }

    public void j2(@NonNull String str, @NonNull wk8 wk8Var) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048653, this, str, wk8Var) != null) || StringUtils.isNull(str)) {
            return;
        }
        Bitmap reSizeBitmap = PicManager.getInstance().getReSizeBitmap(vh.d().c(str));
        if (reSizeBitmap != null) {
            BdImage bdImage = new BdImage(reSizeBitmap, false);
            int width = bdImage.getWidth();
            i3 = bdImage.getHeight();
            i2 = width;
        } else {
            i2 = 0;
            i3 = 0;
        }
        BIMManager.genBosObjectUrl(this.c, str, "image/jpeg", "jpg", 12, i2, i3, new l(this, wk8Var, str));
    }

    public final void n1(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048662, this, str, str2) == null) {
            Iterator<ImageFileInfo> it = this.d.getChosedFiles().iterator();
            long j2 = 0;
            while (it.hasNext()) {
                j2++;
                SafeHandler.getInst().postDelayed(new e(this, it.next(), str, str2), 100 * j2);
            }
            WriteImagesInfo writeImagesInfo = this.d;
            if (writeImagesInfo != null) {
                writeImagesInfo.clear();
            }
        }
    }

    public void p1(int i2, int i3, @Nullable Intent intent) {
        sk8 sk8Var;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048667, this, i2, i3, intent) == null) && i3 == -1 && intent != null && (sk8Var = this.B) != null) {
            sk8Var.k(i2, i3, intent);
            if (i2 != 12010 && i2 != 12009 && i2 != 12002) {
                if (i2 == 12004) {
                    boolean booleanExtra = intent.getBooleanExtra(IntentConfig.IS_AT_SELECT_BOT_DATA, false);
                    intent.getStringExtra(AtListActivityConfig.CALL_AT_LIST_SOURCE);
                    ArrayList<AtSelectData> parcelableArrayListExtra = intent.getParcelableArrayListExtra(IntentConfig.AT_SELECT_LIST_DATA);
                    rk8 rk8Var = this.n;
                    if (rk8Var != null && parcelableArrayListExtra != null) {
                        rk8Var.N(parcelableArrayListExtra);
                        this.n.H(parcelableArrayListExtra, true);
                    }
                    if (this.x != null && booleanExtra) {
                        t0(false, 2);
                        return;
                    }
                    return;
                }
                return;
            }
            String stringExtra = intent.getStringExtra("file_name");
            if (stringExtra == null) {
                stringExtra = TbConfig.IMAGE_RESIZED_FILE;
                str = null;
            } else {
                str = TbConfig.LOCAL_PIC_DIR;
            }
            LocalPicModel localPicModel = this.e;
            if (localPicModel != null) {
                localPicModel.cancelLoadData();
                this.e = null;
            }
            String stringExtra2 = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra2 != null) {
                this.d.parseJson(stringExtra2);
                WriteImagesInfo writeImagesInfo = this.d;
                if (writeImagesInfo != null && !ListUtils.isEmpty(writeImagesInfo.getChosedFiles())) {
                    n1(str, stringExtra);
                    return;
                }
                LocalPicModel localPicModel2 = new LocalPicModel(str, stringExtra, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                this.e = localPicModel2;
                localPicModel2.setLoadDataCallBack(this.a0);
                this.e.getData();
                return;
            }
            LocalPicModel localPicModel3 = new LocalPicModel(str, stringExtra, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
            this.e = localPicModel3;
            localPicModel3.setLoadDataCallBack(this.a0);
            this.e.getData();
        }
    }

    public final void v1(boolean z2, boolean z3) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048679, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) && this.m != null) {
            if (!this.N) {
                v0();
            }
            boolean z4 = false;
            this.N = false;
            this.m.l0(false);
            this.m.f0(false);
            if (this.L == SourceType.TWO) {
                z4 = true;
            }
            if (z4 && !z3) {
                str = this.h;
            } else {
                str = this.g;
            }
            this.g = str;
            this.i = "";
            if (TextUtils.isEmpty(str)) {
                U1(2, true);
            } else {
                U1(3, true);
            }
            M1(true);
            N1(true);
            K1(true);
            this.l.E2(true);
            if (this.m.S() != null && z2) {
                this.m.S().m();
            }
            if (this.L == SourceType.ONE && !TextUtils.isEmpty(this.C)) {
                J1(this.C);
            } else if (z4) {
                if (!z3 && !TextUtils.isEmpty(this.g)) {
                    I1(this.g);
                }
                if (!TextUtils.isEmpty(this.C)) {
                    J1(this.C);
                } else {
                    J1(this.j.getString(R.string.im_msg_input_hint));
                }
            }
        }
    }

    public final void y1() {
        List<AtSelectData> list;
        Map<String, Integer> map;
        int i2;
        String str;
        BotsDTO.BotListDTO.SkillDTO skillDTO;
        String str2;
        String str3;
        List<AtSelectData> t2;
        Map<String, Integer> n2;
        long j2;
        List<AtSelectData> list2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048685, this) == null) {
            if (!this.t) {
                h0();
                EditorTools editorTools = this.k;
                if (editorTools != null) {
                    editorTools.r();
                }
            } else if (this.w != null) {
                S1();
                fi8 fi8Var = this.F;
                if (fi8Var != null) {
                    fi8Var.a = this.G;
                    fi8Var.b = this.J;
                    fi8Var.c = this.H;
                }
                if (this.n != null) {
                    if (j1() && (list2 = this.Q) != null && list2.size() > 0) {
                        t2 = this.Q;
                        this.g = e2();
                    } else {
                        t2 = this.n.t();
                    }
                    List<AtSelectData> list3 = t2;
                    if (j1() && this.n.s() != null) {
                        n2 = i0(this.g, this.Q);
                    } else {
                        this.n.y();
                        n2 = this.n.n();
                    }
                    if (!ListUtils.isEmpty(this.n.t())) {
                        StatisticItem statisticItem = new StatisticItem("c15128");
                        GroupChatFragment groupChatFragment = this.l;
                        long j3 = 0;
                        if (groupChatFragment != null) {
                            j2 = groupChatFragment.j2();
                        } else {
                            j2 = 0;
                        }
                        StatisticItem param = statisticItem.param("fid", j2);
                        GroupChatFragment groupChatFragment2 = this.l;
                        if (groupChatFragment2 != null) {
                            j3 = groupChatFragment2.l2();
                        }
                        TiebaStatic.log(param.param("room_id", j3).param("uid", TbadkCoreApplication.getCurrentAccount()));
                    }
                    map = n2;
                    list = list3;
                } else {
                    list = null;
                    map = null;
                }
                if (this.K != null && this.l != null && (skillDTO = this.J) != null && skillDTO.getName() != null) {
                    long l2 = this.l.l2();
                    long j22 = this.l.j2();
                    String k2 = this.l.k2();
                    StatisticItem param2 = new StatisticItem("c15134").param("obj_type", 3).param("obj_source", P0());
                    BotsDTO.BotListDTO.SkillDTO skillDTO2 = this.J;
                    if (skillDTO2 != null) {
                        str2 = skillDTO2.getName();
                    } else {
                        str2 = StringUtil.NULL_STRING;
                    }
                    StatisticItem param3 = param2.param("obj_name", str2).param("fid", j22).param("fname", k2).param("room_id", l2);
                    BotsDTO.BotListDTO.UserDTO userDTO = this.G;
                    if (userDTO == null) {
                        str3 = "";
                    } else {
                        str3 = BIMManager.getBdUidFromBdUK(userDTO.getUk());
                    }
                    TiebaStatic.log(param3.param("obj_id", str3).param("uid", TbadkCoreApplication.getCurrentAccount()));
                }
                if (l1()) {
                    i2 = 1;
                } else if (j1()) {
                    i2 = 4;
                } else if (this.F != null) {
                    if (this.E == null) {
                        i2 = 2;
                    } else {
                        i2 = 3;
                    }
                } else {
                    i2 = 0;
                }
                if (!an8.a(this.H)) {
                    this.P = true;
                    return;
                }
                xk8 xk8Var = this.w;
                String str4 = this.g;
                if (str4 == null) {
                    str = "";
                } else {
                    str = str4;
                }
                xk8Var.i(str, this.E, this.F, list, map, i2);
                h0();
                rk8 rk8Var = this.n;
                if (rk8Var != null) {
                    rk8Var.G();
                }
            }
        }
    }
}
