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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
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
import com.baidu.tieba.ai8;
import com.baidu.tieba.ci5;
import com.baidu.tieba.d31;
import com.baidu.tieba.di5;
import com.baidu.tieba.dj8;
import com.baidu.tieba.fj8;
import com.baidu.tieba.gd5;
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
import com.baidu.tieba.in;
import com.baidu.tieba.jj8;
import com.baidu.tieba.k9;
import com.baidu.tieba.mg8;
import com.baidu.tieba.nf8;
import com.baidu.tieba.no5;
import com.baidu.tieba.ny5;
import com.baidu.tieba.oh8;
import com.baidu.tieba.oi5;
import com.baidu.tieba.oi8;
import com.baidu.tieba.otb;
import com.baidu.tieba.ph8;
import com.baidu.tieba.pi5;
import com.baidu.tieba.pj8;
import com.baidu.tieba.qh8;
import com.baidu.tieba.qi;
import com.baidu.tieba.r95;
import com.baidu.tieba.rh8;
import com.baidu.tieba.sh8;
import com.baidu.tieba.sx5;
import com.baidu.tieba.th8;
import com.baidu.tieba.uh8;
import com.baidu.tieba.wi;
import com.baidu.tieba.ww5;
import com.baidu.tieba.wx5;
import com.baidu.tieba.xh8;
import com.baidu.tieba.xi;
import com.baidu.tieba.yg;
import com.baidu.tieba.yh8;
import com.baidu.tieba.zh8;
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
    public xh8 A;
    public ph8 B;
    public String C;
    public int D;
    public Object E;
    public nf8 F;
    public BotsDTO.BotListDTO.UserDTO G;
    public List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> H;
    public List<BotsDTO.BotListDTO.SkillDTO> I;
    public BotsDTO.BotListDTO.SkillDTO J;
    public GroupChatRobotTopHeadView K;
    public SourceType L;
    @NonNull
    public fj8 M;
    public boolean N;
    public boolean O;
    public boolean P;
    public List<AtSelectData> Q;
    public List<InputBoxHandler.BanData> R;
    public int S;
    @Nullable

    /* renamed from: T  reason: collision with root package name */
    public mg8 f1122T;
    public final CustomMessageListener U;
    public final CustomMessageListener V;
    public di5 W;
    public qh8.m X;
    public GroupInputTool.h Y;
    public qh8.l Z;
    public int a;
    public final k9 a0;
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
    public oh8 n;
    public qh8 o;
    public GroupInputTool p;
    public long q;
    public boolean r;
    public String s;
    public boolean t;
    public PermissionJudgePolicy u;
    public boolean v;
    @Nullable
    public uh8 w;
    public yh8 x;
    public ai8 y;
    public zh8 z;

    /* loaded from: classes6.dex */
    public interface e0 {
        void a();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65568, this) == null) {
        }
    }

    public boolean t0(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048673, this, i2, i3)) == null) ? i2 > 1 && i2 > i3 : invokeII.booleanValue;
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
        public class a extends sx5<Object> {
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

            @Override // com.baidu.tieba.sx5
            public Object doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    e eVar = this.a;
                    eVar.d.v0(eVar.a);
                    return null;
                }
                return invokeV.objValue;
            }
        }

        /* loaded from: classes6.dex */
        public class b implements ww5<Object> {
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

            @Override // com.baidu.tieba.ww5
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
                wx5.b(new a(this), new b(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements yh8.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        /* loaded from: classes6.dex */
        public class a implements yh8.d {
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

            @Override // com.baidu.tieba.yh8.d
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.J1(SourceType.ONE, false, false);
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

        @Override // com.baidu.tieba.yh8.f
        public void a(BotsDTO.BotListDTO.UserDTO userDTO, BotsDTO.BotListDTO.SkillDTO skillDTO) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, userDTO, skillDTO) == null) && userDTO != null && skillDTO != null) {
                this.a.R1(userDTO, skillDTO);
                this.a.f0();
                if (this.a.w != null) {
                    if (skillDTO.isFuncJump() && skillDTO.getAbilityItem() != null) {
                        this.a.w.l(skillDTO.getAbilityItem());
                        this.a.Y0();
                        return;
                    } else if (skillDTO.isFuncSendMsg() && !TextUtils.isEmpty(userDTO.getUk())) {
                        this.a.w.g(userDTO.getUk(), skillDTO.getType());
                        this.a.L0().t(null);
                        this.a.Y0();
                        return;
                    }
                }
                this.a.x0();
                this.a.D1(true);
                if (this.a.L0() != null) {
                    this.a.L0().t(new a(this));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements IGenBosObjectUrlListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ th8 a;
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
                th8 th8Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, str) == null) && (th8Var = this.b.a) != null) {
                    th8Var.a(i, i2, str);
                }
            }

            @Override // com.baidu.android.imsdk.upload.IUploadTransferListener
            public void onFinished(int i, String str) {
                th8 th8Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) && (th8Var = this.b.a) != null) {
                    th8Var.c(i, str, this.a);
                }
            }

            @Override // com.baidu.android.imsdk.upload.IUploadTransferListener
            public void onProgress(int i) {
                th8 th8Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (th8Var = this.b.a) != null) {
                    th8Var.b(i);
                }
            }
        }

        public l(GroupInputViewController groupInputViewController, th8 th8Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController, th8Var, str};
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
            this.a = th8Var;
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
                    if (wi.isEmpty(str4) || wi.isEmpty(str5) || wi.isEmpty(str6)) {
                        th8 th8Var = this.a;
                        if (th8Var != null) {
                            th8Var.a(i, 1, this.b);
                            return;
                        }
                        return;
                    }
                    this.c.e2(1, str4, str5, this.b, "image/jpeg", str2, str3, new a(this, str6));
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
    public class a implements qh8.l {
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

        @Override // com.baidu.tieba.qh8.l
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
                this.a.l.D2();
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
    public class b extends k9 {
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

        @Override // com.baidu.tieba.k9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (obj instanceof LocalPicModel.ResponseData) {
                    LocalPicModel.ResponseData responseData = (LocalPicModel.ResponseData) obj;
                    String str = responseData.getBitmap().getWidth() + "," + responseData.getBitmap().getHeight();
                    String sPathGen = responseData.getSPathGen();
                    if (this.a.k1() && this.a.o != null && !StringUtils.isNull(sPathGen)) {
                        this.a.o.P(sPathGen, str);
                        return;
                    } else if (responseData.getExtraMap() != null) {
                        this.a.w.b(responseData.getSPathGen(), str, responseData.getExtraMap());
                        return;
                    } else {
                        this.a.w.j(responseData.getSPathGen(), str);
                        return;
                    }
                }
                this.a.l.showToast(TbadkCoreApplication.getInst().getString(R.string.pic_parser_error));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b0 implements yh8.d {
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

        @Override // com.baidu.tieba.yh8.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.z.l(null, this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends sx5<Map<String, Object>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gd5 a;
        public final /* synthetic */ GroupInputViewController b;

        public c(GroupInputViewController groupInputViewController, gd5 gd5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController, gd5Var};
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
            this.a = gd5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sx5
        /* renamed from: a */
        public Map<String, Object> doInBackground() {
            InterceptResult invokeV;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                String d = no5.b.d(this.a.d(), true);
                boolean exists = new File(d).exists();
                if (!exists) {
                    d = d.replace(".gif", ".jpg");
                }
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setFilePath(d);
                imageFileInfo.setIsGif(exists);
                this.b.v0(imageFileInfo);
                String b = no5.b.b(this.a.d());
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
    public class d implements ww5<Map<String, Object>> {
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
        @Override // com.baidu.tieba.ww5
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
                this.a.m.d0(false);
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
                    if (!this.a.l0()) {
                        this.a.s0(true, 1);
                    }
                }
                if (!booleanValue && this.a.A != null) {
                    this.a.A.k();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements ai8.e {
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

        @Override // com.baidu.tieba.ai8.e
        public void a(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) != null) || this.a.m == null) {
                return;
            }
            if (this.a.l != null) {
                this.a.l.x2();
            }
            GroupInputViewController groupInputViewController = this.a;
            groupInputViewController.H1(groupInputViewController.j.getString(R.string.im_msg_input_hint));
            this.a.I1(false);
            this.a.m.u(i, i2, j, animatorListenerAdapter, z);
        }

        @Override // com.baidu.tieba.ai8.e
        public void b(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) != null) || this.a.m == null) {
                return;
            }
            GroupInputViewController groupInputViewController = this.a;
            groupInputViewController.H1(groupInputViewController.C);
            this.a.I1(true);
            this.a.m.s(i, i2, j, animatorListenerAdapter, z);
        }

        @Override // com.baidu.tieba.ai8.e
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.o0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements zh8.e {
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

        @Override // com.baidu.tieba.zh8.e
        public void a(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) != null) || this.a.m == null) {
                return;
            }
            if (this.a.l != null) {
                this.a.l.x2();
            }
            this.a.I1(false);
            this.a.m.u(i, i2, j, animatorListenerAdapter, z);
        }

        @Override // com.baidu.tieba.zh8.e
        public void b(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) != null) || this.a.m == null) {
                return;
            }
            GroupInputViewController groupInputViewController = this.a;
            groupInputViewController.H1(groupInputViewController.C);
            this.a.I1(true);
            this.a.m.s(i, i2, j, animatorListenerAdapter, z);
        }

        @Override // com.baidu.tieba.zh8.e
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.n0();
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
                this.a.g2(booleanValue);
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
                this.a.p1(null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n implements ai8.d {
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

        @Override // com.baidu.tieba.ai8.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.d.Z1(this.a, this.b, this.c);
        }
    }

    /* loaded from: classes6.dex */
    public class o implements zh8.d {
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

        @Override // com.baidu.tieba.zh8.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.d.Z1(this.a, this.b, this.c);
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
                groupInputViewController.Y1(groupInputViewController.J, false, this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q implements yh8.d {
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

        @Override // com.baidu.tieba.yh8.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                GroupInputViewController groupInputViewController = this.b;
                groupInputViewController.Y1(groupInputViewController.J, false, this.a);
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
                this.a.Z0(false);
                this.a.x0();
                this.a.f2();
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
                this.a.a1(true, false, null);
                this.a.f2();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class t implements qh8.k {
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

        @Override // com.baidu.tieba.qh8.k
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.w1();
                if (this.a.P) {
                    return;
                }
                this.a.a1(true, true, null);
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
            this.d.t1(this.a, this.b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) != null) {
                return;
            }
            this.d.t1(this.a, this.b);
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
    public class x implements di5 {
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

        @Override // com.baidu.tieba.di5
        public void C(ci5 ci5Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, ci5Var) != null) || ci5Var == null) {
                return;
            }
            int i = ci5Var.a;
            if (i == 24) {
                Object obj = ci5Var.c;
                if (obj instanceof gd5) {
                    gd5 gd5Var = (gd5) obj;
                    if (gd5Var.getType() != EmotionGroupType.LOCAL) {
                        this.a.v1(gd5Var);
                    }
                }
            } else if (i == 8) {
                this.a.w1();
                if (this.a.P) {
                    return;
                }
                this.a.Z0(true);
            } else if (i == 4) {
                Object obj2 = ci5Var.c;
                if (obj2 instanceof String) {
                    this.a.g = (String) obj2;
                    this.a.s0(false, 1);
                    this.a.A.m(100L);
                }
            } else if (i == 14) {
                this.a.q1();
            } else if (i != 17) {
                if (i == 62) {
                    boolean booleanValue = ((Boolean) ci5Var.c).booleanValue();
                    if (this.a.m == null) {
                        return;
                    }
                    if (booleanValue) {
                        this.a.p0();
                    } else {
                        this.a.s0(true, 1);
                    }
                    if (!this.a.m.Y() || this.a.K0() != ToolState.TEXT) {
                        return;
                    }
                    this.a.O1(false);
                    this.a.C1(false);
                } else if (i != 63 || this.a.m == null) {
                } else {
                    this.a.m.d0(false);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class y implements qh8.m {
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

        @Override // com.baidu.tieba.qh8.m
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZ(1048576, this, z) != null) {
                return;
            }
            this.a.U1(z);
        }
    }

    /* loaded from: classes6.dex */
    public class z implements yh8.d {
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

        @Override // com.baidu.tieba.yh8.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.y.l(null, this.a);
            }
        }
    }

    public GroupInputViewController(GroupChatFragment groupChatFragment, long j2, mg8 mg8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {groupChatFragment, Long.valueOf(j2), mg8Var};
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
        this.F = new nf8();
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
        this.f1122T = mg8Var;
        this.p = new GroupInputTool(this.l);
        ph8 ph8Var = new ph8(this.l);
        this.B = ph8Var;
        ph8Var.o(this.W);
        this.M = new dj8(this);
        this.A = new xh8(this.l, new otb() { // from class: com.baidu.tieba.nh8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.otb
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? GroupInputViewController.this.m1() : invokeV.objValue;
            }
        }, mg8Var);
        b1();
        E1(this.p);
        c1();
        MessageManager.getInstance().registerListener(this.U);
        MessageManager.getInstance().registerListener(this.V);
        qh8 qh8Var = this.o;
        if (qh8Var != null) {
            qh8Var.a0(this.Z);
        }
    }

    public void B1(List<InputBoxHandler.BanData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.R = list;
        }
    }

    public final void D1(boolean z2) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048583, this, z2) != null) || (groupInputTool = this.m) == null) {
            return;
        }
        if (z2) {
            groupInputTool.g0(1);
        } else {
            groupInputTool.g0(0);
        }
    }

    public void F1(String str) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, str) == null) && (editorTools = this.k) != null) {
            editorTools.C(new ci5(75, 3, str));
        }
    }

    public void G1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.g = str;
            if (!TextUtils.isEmpty(str)) {
                this.i = str;
            }
            EditorTools editorTools = this.k;
            if (editorTools != null) {
                editorTools.C(new ci5(6, 3, str));
            }
        }
    }

    public void H1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.s = str;
            EditorTools editorTools = this.k;
            if (editorTools != null) {
                editorTools.C(new ci5(71, 3, StringHelper.cutChineseAndEnglishWithEmoji(str, 28, "...")));
            }
        }
    }

    public void I1(boolean z2) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048593, this, z2) == null) && (groupInputTool = this.m) != null) {
            groupInputTool.h0(z2);
        }
    }

    public void L1(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048599, this, z2) == null) && this.k.o(6) != null) {
            if (!z2) {
                this.k.o(6).hide();
            } else {
                this.k.o(6).display();
            }
        }
    }

    public void M1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            this.S = i2;
        }
    }

    public void N1(GroupInputTool.f fVar) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048603, this, fVar) == null) && (groupInputTool = this.m) != null) {
            groupInputTool.l0(fVar);
        }
    }

    public void P1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, view2) == null) {
            this.f = view2;
        }
    }

    public void T1(@Nullable uh8 uh8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, uh8Var) == null) {
            this.w = uh8Var;
        }
    }

    public void W1(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, editorTools) == null) {
            this.k = editorTools;
        }
    }

    public void X0(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            x0();
            q0(str);
        }
    }

    public final void Z0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z2) == null) {
            a1(false, z2, null);
        }
    }

    @Nullable
    public final nf8 i0(@NonNull boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048649, this, z2)) == null) {
            nf8 nf8Var = this.F;
            if (nf8Var != null) {
                nf8Var.a = this.G;
                nf8Var.b = this.J;
                nf8Var.c = this.H;
                nf8Var.e(z2);
            }
            return this.F;
        }
        return (nf8) invokeZ.objValue;
    }

    @NonNull
    public final SkillSugRequest j0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048652, this, i2)) == null) {
            return new SkillSugRequest(i2, this.G.getUk(), this.l.h2(), this.l.j2());
        }
        return (SkillSugRequest) invokeI.objValue;
    }

    public final void k0(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048654, this, z2) == null) && L0() != null) {
            L0().t(new q(this, z2));
        }
    }

    public void o1(@NonNull Bundle bundle) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048663, this, bundle) == null) && (groupInputTool = this.p) != null) {
            groupInputTool.b0(bundle);
        }
    }

    public void onChangeSkinType(int i2) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048664, this, i2) == null) && (groupInputTool = this.p) != null) {
            groupInputTool.onChangeSkinType(i2);
        }
    }

    public final void u1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048676, this, z2) == null) {
            this.N = true;
            a1(true, false, new p(this, z2));
        }
    }

    public final void w0(@NonNull List<BotsDTO.BotListDTO.SkillDTO> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048679, this, list) == null) {
            for (BotsDTO.BotListDTO.SkillDTO skillDTO : list) {
                if (skillDTO != null && skillDTO.getType() == this.D) {
                    this.J = skillDTO;
                    return;
                }
            }
        }
    }

    public void x1(BotsDTO botsDTO) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048682, this, botsDTO) == null) && (groupInputTool = this.m) != null) {
            groupInputTool.c0(botsDTO);
        }
    }

    public void y1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048684, this, str) == null) {
            this.C = str;
        }
    }

    public void R1(BotsDTO.BotListDTO.UserDTO userDTO, BotsDTO.BotListDTO.SkillDTO skillDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048611, this, userDTO, skillDTO) == null) {
            this.G = userDTO;
            this.J = skillDTO;
        }
    }

    public void i2(@NonNull String str, @NonNull rh8 rh8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048651, this, str, rh8Var) == null) {
            sh8 sh8Var = new sh8(this.c, str, "audio/amr");
            sh8Var.b(rh8Var);
            BIMManager.audioTrans(this.c, str, "audio/amr", "amr", 12, sh8Var);
        }
    }

    public void r1(@NonNull UserReplyInfoData userReplyInfoData, @NonNull Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048670, this, userReplyInfoData, obj) == null) {
            this.E = obj;
            x0();
            r0(userReplyInfoData);
            e0(userReplyInfoData);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65569, this) == null) {
            ph8 ph8Var = this.B;
            if (ph8Var != null) {
                ph8Var.l();
            }
            oh8 oh8Var = this.n;
            if (oh8Var != null) {
                oh8Var.A();
            }
            qh8 qh8Var = this.o;
            if (qh8Var != null) {
                qh8Var.Q();
            }
            xh8 xh8Var = this.A;
            if (xh8Var != null) {
                xh8Var.o();
            }
            VoiceManager.setIsNeedBlackScreen(true);
            MessageManager.getInstance().unRegisterListener(this.b0);
            MessageManager.getInstance().unRegisterListener(this.U);
            MessageManager.getInstance().unRegisterListener(this.V);
        }
    }

    public String F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            EditorTools editorTools = this.k;
            if (editorTools == null) {
                return "";
            }
            oi5 p2 = editorTools.p(3);
            String str = TbEnum.ChatInputStatus.INPUT_STATUS_TEXT;
            if (p2 != null) {
                pi5 pi5Var = p2.m;
                if ((pi5Var instanceof View) && ((View) pi5Var).getVisibility() != 0) {
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

    public final void f0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048640, this) == null) && this.G != null && this.J != null) {
            jj8.f().h(jj8.f().c(this.G.getUk(), this.J.getType(), this.G.getNameShow(), this.J.getName(), this.G.getPortrait(), this.J.getDesc(), this.J.getFuncType()));
        }
    }

    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048643, this) == null) {
            x0();
            if (j1()) {
                o0();
            }
            if (i1()) {
                n0();
            }
            u0();
            qh8 qh8Var = this.o;
            if (qh8Var != null && qh8Var.L()) {
                Z0(true);
            }
            S1(2, true);
            K1(true);
            L1(true);
            this.Q.clear();
            this.P = false;
        }
    }

    public final void q1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048668, this) != null) || !h1()) {
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
        if (interceptable == null || interceptable.invokeV(65570, this) == null) {
            this.r = false;
            ph8 ph8Var = this.B;
            if (ph8Var != null) {
                ph8Var.m();
                this.B.p(this.r);
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65571, this) == null) {
            this.r = true;
            ph8 ph8Var = this.B;
            if (ph8Var != null) {
                ph8Var.n();
                this.B.p(this.r);
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65572, this) == null) {
            if (J0() != null && J0().M()) {
                return;
            }
            TbSingleton.getInstance().setRoomDraft(Long.valueOf(this.q), F0());
        }
    }

    public void A0() {
        BotsDTO.BotListDTO.SkillDTO skillDTO;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (skillDTO = this.J) != null && skillDTO.getItems() != null) {
            this.H.addAll(this.J.getItems());
        }
    }

    public oh8 B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.n;
        }
        return (oh8) invokeV.objValue;
    }

    public GroupInputTool E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.p;
        }
        return (GroupInputTool) invokeV.objValue;
    }

    public List<InputBoxHandler.BanData> G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.R;
        }
        return (List) invokeV.objValue;
    }

    @NonNull
    public String H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (TextUtils.isEmpty(this.g)) {
                return "";
            }
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    public String I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    public GroupInputTool J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.m;
        }
        return (GroupInputTool) invokeV.objValue;
    }

    public ToolState K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.b;
        }
        return (ToolState) invokeV.objValue;
    }

    public yh8 L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.x;
        }
        return (yh8) invokeV.objValue;
    }

    public BotsDTO.BotListDTO.UserDTO M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.G;
        }
        return (BotsDTO.BotListDTO.UserDTO) invokeV.objValue;
    }

    @Nullable
    public BotsDTO.BotListDTO.SkillDTO N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.J;
        }
        return (BotsDTO.BotListDTO.SkillDTO) invokeV.objValue;
    }

    public final int O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
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

    public qh8 P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.o;
        }
        return (qh8) invokeV.objValue;
    }

    public String Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
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

    public void Q1() {
        qh8 qh8Var;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048609, this) == null) && (qh8Var = this.o) != null && qh8Var.L() && (arrayList = (ArrayList) this.o.C()) != null) {
            this.H = arrayList;
        }
    }

    public zh8 R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.z;
        }
        return (zh8) invokeV.objValue;
    }

    public ai8 S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.y;
        }
        return (ai8) invokeV.objValue;
    }

    @NonNull
    public fj8 T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.M;
        }
        return (fj8) invokeV.objValue;
    }

    @Nullable
    public VoiceManager U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            ph8 ph8Var = this.B;
            if (ph8Var != null) {
                return ph8Var.y0();
            }
            return null;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public SourceType V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.L;
        }
        return (SourceType) invokeV.objValue;
    }

    public void Y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            xh8 xh8Var = this.A;
            if (xh8Var != null) {
                xh8Var.k();
            }
            GroupInputTool groupInputTool = this.m;
            if (groupInputTool != null) {
                groupInputTool.U();
            }
        }
    }

    public final void b1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048630, this) == null) && this.n == null) {
            this.n = new oh8(this.c, this.l);
        }
    }

    public final void c1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            ph8 ph8Var = this.B;
            if (ph8Var != null) {
                ph8Var.i();
            }
            GroupInputTool groupInputTool = this.m;
            if (groupInputTool != null) {
                groupInputTool.m0(this.Y);
            }
        }
    }

    public final void d1() {
        yh8 yh8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048635, this) == null) && (yh8Var = this.x) != null) {
            yh8Var.s(new h(this));
        }
    }

    public final GroupChatRobotTopHeadView e1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            GroupInputTool groupInputTool = this.m;
            if (groupInputTool == null) {
                return null;
            }
            GroupChatRobotTopHeadView Q = groupInputTool.Q();
            this.K = Q;
            Q.setEventCallback(new m(this));
            return this.K;
        }
        return (GroupChatRobotTopHeadView) invokeV.objValue;
    }

    public final void f1() {
        zh8 zh8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048641, this) == null) && (zh8Var = this.z) != null) {
            zh8Var.i(new j(this));
        }
    }

    public final void g1() {
        ai8 ai8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048644, this) == null) && (ai8Var = this.y) != null) {
            ai8Var.i(new i(this));
        }
    }

    public boolean h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            if (FileHelper.checkSD()) {
                return true;
            }
            xi.Q(this.c, TbadkCoreApplication.getInst().getString(R.string.voice_error_sdcard));
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean i1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) {
            zh8 zh8Var = this.z;
            if (zh8Var != null && zh8Var.e()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            ai8 ai8Var = this.y;
            if (ai8Var != null && ai8Var.e()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) {
            GroupInputTool groupInputTool = this.m;
            if (groupInputTool != null && groupInputTool.M() && this.O) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            GroupInputTool groupInputTool = this.m;
            if (groupInputTool != null) {
                return groupInputTool.v();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public /* synthetic */ CharSequence m1() {
        return this.g;
    }

    public void n0() {
        zh8 zh8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048660, this) == null) && (zh8Var = this.z) != null) {
            zh8Var.k(null);
        }
    }

    public void o0() {
        ai8 ai8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048662, this) == null) && (ai8Var = this.y) != null) {
            ai8Var.j(null);
        }
    }

    public final void p0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048665, this) == null) && L0() != null) {
            L0().t(null);
        }
    }

    public void s1() {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048672, this) == null) && (groupInputTool = this.m) != null) {
            groupInputTool.e0(false);
        }
    }

    public final void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048675, this) == null) {
            this.F.a();
            this.H.clear();
            this.G = null;
            this.J = null;
            this.E = null;
        }
    }

    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048681, this) == null) {
            this.g = null;
            EditorTools editorTools = this.k;
            if (editorTools != null) {
                editorTools.C(new ci5(9, -1, Boolean.TRUE));
            }
        }
    }

    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048683, this) == null) {
            try {
                w1();
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    public void A1(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString(TbEnum.ChatInputStatus.INPUT_DRAFT_KEY);
            if (this.k != null) {
                this.k.C(new ci5(6, 3, optString));
            }
            this.g = optString;
            if (TextUtils.equals(jSONObject.optString(TbEnum.ChatInputStatus.INPUT_STATUS_KEY), TbEnum.ChatInputStatus.INPUT_STATUS_VOICE) && this.k != null) {
                this.k.C(new ci5(1, 6, null));
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void K1(boolean z2) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048597, this, z2) == null) && (groupInputTool = this.m) != null && groupInputTool.E() != null && (this.m.E().m instanceof EmotionNoLaunchView)) {
            ((EmotionNoLaunchView) this.m.E().m).setNeedHideForever(z2);
            if (!z2) {
                this.m.E().m.hide();
            } else {
                this.m.E().m.display();
            }
        }
    }

    public final void q0(@NonNull String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048667, this, str) != null) || this.z == null) {
            return;
        }
        yh8 yh8Var = this.x;
        if (yh8Var != null && yh8Var.k()) {
            this.x.t(new b0(this, str));
        } else if (this.m.M()) {
            p1(new c0(this, str));
        } else {
            this.z.l(null, str);
            this.l.B2(true);
            if (j1()) {
                this.y.k(false);
                this.a = 0;
            }
        }
    }

    public final void r0(@NonNull UserReplyInfoData userReplyInfoData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048669, this, userReplyInfoData) != null) || this.y == null) {
            return;
        }
        yh8 yh8Var = this.x;
        if (yh8Var != null && yh8Var.k()) {
            this.x.t(new z(this, userReplyInfoData));
        } else if (this.m.M()) {
            p1(new a0(this, userReplyInfoData));
        } else {
            this.y.l(null, userReplyInfoData);
            this.l.B2(true);
            if (i1()) {
                this.z.j(false);
                this.a = 1;
            }
        }
    }

    public final void v0(ImageFileInfo imageFileInfo) {
        Bitmap resizeBitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048677, this, imageFileInfo) == null) {
            try {
                if (imageFileInfo.isGif()) {
                    FileHelper.saveGifByRelativePath(imageFileInfo.getFilePath(), null, TbConfig.IMAGE_RESIZED_FILE);
                    FileHelper.saveGifByRelativePath(imageFileInfo.getFilePath(), null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                    return;
                }
                Bitmap c2 = ny5.c(0, this.c, null, imageFileInfo.getFilePath(), TbImageHelper.getInstance().getPostImageSize());
                if (c2 != null && FileHelper.saveBitmapByRelativelyPath(null, TbConfig.IMAGE_RESIZED_FILE, c2, 85) != null && (resizeBitmap = BitmapHelper.resizeBitmap(c2, 100)) != null) {
                    FileHelper.saveBitmapByRelativelyPath(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 85);
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public final int C0(String str, AtSelectData atSelectData, Map<String, Integer> map, int i2) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048580, this, str, atSelectData, map, i2)) == null) {
            if (!map.containsValue(Integer.valueOf(i2))) {
                return i2;
            }
            return C0(str, atSelectData, map, str.indexOf("@" + atSelectData.getNameShow(), i2 + 1));
        }
        return invokeLLLI.intValue;
    }

    public void z1(@Nullable Object obj, @Nullable BotsDTO.BotListDTO.UserDTO userDTO, @Nullable BotsDTO.BotListDTO.SkillDTO skillDTO, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048686, this, new Object[]{obj, userDTO, skillDTO, Boolean.valueOf(z2)}) == null) {
            this.E = obj;
            this.G = userDTO;
            this.J = skillDTO;
            nf8 nf8Var = this.F;
            if (nf8Var != null) {
                nf8Var.d(z2);
            }
        }
    }

    public final void C1(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z2) == null) && R0() != null) {
            if (z2) {
                if (R0().e()) {
                    R0().j(false);
                    this.a = 1;
                }
            } else if (!R0().g()) {
                R0().j(true);
            }
        }
    }

    public final void O1(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048605, this, z2) == null) && S0() != null) {
            if (z2) {
                if (S0().e()) {
                    S0().k(false);
                    this.a = 0;
                }
            } else if (!S0().g()) {
                S0().k(!z2);
            }
        }
    }

    public final void U1(boolean z2) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048617, this, z2) != null) || this.K == null || !z2) {
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

    public void e0(@NonNull UserReplyInfoData userReplyInfoData) {
        oh8 oh8Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048637, this, userReplyInfoData) != null) || (oh8Var = this.n) == null) {
            return;
        }
        oh8Var.G();
        this.n.k(new AtSelectData(userReplyInfoData.getmPortrait(), userReplyInfoData.getmNameShow(), String.valueOf(userReplyInfoData.getmUid()), userReplyInfoData.isRobot()), false);
    }

    public final void g2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048645, this, z2) == null) {
            if (z2) {
                p0();
                O1(true);
                C1(true);
                if (!J0().a0()) {
                    this.l.C2(true);
                    return;
                }
                return;
            }
            s0(true, 1);
            int i2 = this.a;
            if (i2 == 0) {
                O1(false);
            } else if (i2 == 1) {
                C1(false);
            }
        }
    }

    @NonNull
    public oi8 D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            oi8 oi8Var = new oi8();
            oi8Var.g(this.l.j2());
            oi8Var.h(this.l.m2());
            oi8Var.e(this.l.h2());
            oi8Var.f(this.l.i2());
            return oi8Var;
        }
        return (oi8) invokeV.objValue;
    }

    public String c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            if (this.S == 0) {
                return d2() + this.g;
            }
            return this.g + d2();
        }
        return (String) invokeV.objValue;
    }

    public final String d2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
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

    public final boolean l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
            oh8 oh8Var = this.n;
            if (oh8Var == null || d31.h(oh8Var.v()) != 1 || !this.n.v().get(0).isRobot()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void z0() {
        BotsDTO.BotListDTO.SkillDTO skillDTO;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048685, this) == null) && (skillDTO = this.J) != null && skillDTO.isCanKeyboardInput()) {
            if (!TextUtils.isEmpty(this.J.getKeyboardContent())) {
                G1(this.J.getKeyboardContent());
            } else {
                G1("");
            }
        }
    }

    public final void E1(GroupInputTool groupInputTool) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, groupInputTool) == null) && groupInputTool != null && this.B != null) {
            this.m = groupInputTool;
            this.x = groupInputTool.L();
            if (groupInputTool.T() != null && groupInputTool.I() != null) {
                this.y = new ai8(groupInputTool.T(), this.l, groupInputTool.I());
            }
            if (groupInputTool.S() != null && groupInputTool.I() != null) {
                this.z = new zh8(groupInputTool.S(), this.l, groupInputTool.I());
            }
            MessageManager.getInstance().registerListener(this.b0);
            d1();
            g1();
            f1();
            e1();
            if (groupInputTool.R() != null) {
                this.B.q(groupInputTool);
                W1(groupInputTool.R());
                if (groupInputTool.G() != null) {
                    P1(groupInputTool.G());
                }
                if (this.q != 0 && !wi.isEmpty(TbSingleton.getInstance().getRoomDraft(Long.valueOf(this.q)))) {
                    A1(TbSingleton.getInstance().getRoomDraft(Long.valueOf(this.q)));
                }
                oh8 oh8Var = this.n;
                if (oh8Var != null) {
                    oh8Var.J(groupInputTool, this.k);
                    this.n.B();
                }
            }
        }
    }

    public void X1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z2) == null) {
            this.t = z2;
            if (this.k != null) {
                if (r95.p().l("key_group_chat_chatroom_audio_switch", true)) {
                    this.k.setToolEnabled(z2, 6);
                }
                this.k.C(new ci5(72, 3, Boolean.valueOf(z2)));
                if (this.k.p(37) != null && (this.k.p(37).m instanceof EmotionNoLaunchView)) {
                    ((EmotionNoLaunchView) this.k.p(37).m).setEnabled(z2);
                }
                if (r95.p().l("key_group_chat_chatroom_picture_switch", true) && this.k.p(38) != null && (this.k.p(38).m instanceof SendNoLaunchView)) {
                    ((SendNoLaunchView) this.k.p(38).m).setIconEnable(z2);
                    ((SendNoLaunchView) this.k.p(38).m).setSendInterceptToastText(this.s, z2);
                }
            }
            oh8 oh8Var = this.n;
            if (oh8Var != null) {
                oh8Var.K(z2);
            }
            GroupInputTool groupInputTool = this.m;
            if (groupInputTool != null && groupInputTool.H() != null && this.m.H().g() != null) {
                if (z2) {
                    this.m.H().g().setEnabled(true);
                    this.m.H().g().setOnClickListener(new f(this));
                    return;
                }
                this.m.H().g().setEnabled(false);
            }
        }
    }

    public void J1(SourceType sourceType, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{sourceType, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            if (j1()) {
                this.y.j(new n(this, sourceType, z2, z3));
            } else if (i1()) {
                this.z.k(new o(this, sourceType, z2, z3));
            } else {
                Z1(sourceType, z2, z3);
            }
        }
    }

    public void V1(int i2, @NonNull Object obj, @NonNull nf8 nf8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048619, this, i2, obj, nf8Var) == null) {
            this.D = i2;
            this.E = obj;
            this.G = nf8Var.a;
            if (this.I == null) {
                this.I = new ArrayList();
            }
            this.I.clear();
            BotsDTO.BotListDTO.SkillDTO skillDTO = nf8Var.b;
            if (skillDTO != null && !ListUtils.isEmpty(skillDTO.getSubSkill())) {
                this.I.addAll(nf8Var.b.getSubSkill());
                w0(this.I);
            }
            nf8 nf8Var2 = this.F;
            if (nf8Var2 != null) {
                nf8Var2.d(nf8Var.c());
            }
        }
    }

    public final void Z1(SourceType sourceType, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048627, this, new Object[]{sourceType, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            this.L = sourceType;
            GroupChatFragment groupChatFragment = this.l;
            if (groupChatFragment != null) {
                groupChatFragment.x2();
            }
            if (this.L == SourceType.TWO) {
                this.h = this.g;
                GroupInputTool groupInputTool = this.m;
                if (groupInputTool != null) {
                    if (groupInputTool.w()) {
                        k0(z3);
                        return;
                    } else if (this.m.M()) {
                        u1(z3);
                        return;
                    }
                }
            }
            Y1(this.J, z2, z3);
        }
    }

    public void S1(int i2, boolean z2) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) && (groupInputTool = this.m) != null && groupInputTool.N() != null && (this.m.N().m instanceof SendNoLaunchView)) {
            if (i2 == 1) {
                ((SendNoLaunchView) this.m.N().m).setIsSendIcon(true);
                ((SendNoLaunchView) this.m.N().m).setSendVisibility(z2);
            } else if (i2 == 2) {
                ((SendNoLaunchView) this.m.N().m).setIsSendIcon(false);
                ((SendNoLaunchView) this.m.N().m).setSendVisibility(false);
            } else if (i2 == 3) {
                ((SendNoLaunchView) this.m.N().m).setIsSendIcon(false);
                ((SendNoLaunchView) this.m.N().m).setSendVisibility(true);
            }
        }
    }

    public final void a2(@NonNull BotsDTO.BotListDTO.SkillDTO skillDTO, boolean z2) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048629, this, skillDTO, z2) == null) && (groupInputTool = this.m) != null && groupInputTool.I() != null) {
            List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> items = skillDTO.getItems();
            qh8 qh8Var = this.o;
            if (qh8Var == null) {
                qh8 qh8Var2 = new qh8(this.m.I(), this.X);
                this.o = qh8Var2;
                qh8Var2.G(items, D0(), z2);
            } else {
                qh8Var.O(items, z2);
            }
            this.o.X(this.l.getPageContext());
            this.o.W(this.f1122T);
            i0(!ListUtils.isEmpty(items));
            Object obj = this.E;
            if (obj instanceof BaseMsg) {
                this.o.Y((BaseMsg) obj);
            }
            this.o.Z(j0(skillDTO.getType()));
            this.o.b0(z2, !ListUtils.isEmpty(items));
        }
    }

    public final void b2(@NonNull BotsDTO.BotListDTO.SkillDTO skillDTO, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048631, this, skillDTO, z2) == null) {
            List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> items = skillDTO.getItems();
            GroupInputTool groupInputTool = this.m;
            if (groupInputTool != null && groupInputTool.I() != null && !ListUtils.isEmpty(items)) {
                qh8 qh8Var = this.o;
                if (qh8Var == null) {
                    qh8 qh8Var2 = new qh8(this.m.I(), this.X);
                    this.o = qh8Var2;
                    qh8Var2.G(items, D0(), z2);
                } else {
                    qh8Var.O(items, z2);
                }
                this.o.X(this.l.getPageContext());
                this.o.W(this.f1122T);
                i0(!ListUtils.isEmpty(items));
                Object obj = this.E;
                if (obj instanceof BaseMsg) {
                    this.o.Y((BaseMsg) obj);
                }
                this.o.Z(j0(skillDTO.getType()));
                this.o.d0(new t(this), this.Z, z2);
            }
        }
    }

    public void s0(boolean z2, int i2) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048671, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) && (groupInputTool = this.m) != null && groupInputTool.R() != null && !this.m.Y() && this.x != null) {
            if (z2) {
                this.m.R().requestFocus();
            }
            if (!this.m.R().hasFocus()) {
                return;
            }
            boolean z3 = false;
            z3 = (i2 == 3 || i2 == 2) ? true : true;
            if (i2 != 2 && i2 != 3 && (TextUtils.isEmpty(this.g) || !"/".equals(this.g))) {
                this.x.t(null);
                return;
            }
            qh8 qh8Var = this.o;
            if (qh8Var != null && qh8Var.L() && this.L == SourceType.TWO) {
                return;
            }
            this.x.w(null, i2, Boolean.valueOf(z3));
        }
    }

    public void W0(List<InputBoxHandler.PaddingContent> list) {
        String type;
        AtData atData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048620, this, list) == null) && !list.isEmpty()) {
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

    public void p1(@Nullable e0 e0Var) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048666, this, e0Var) == null) {
            a1(true, false, e0Var);
            f2();
            x0();
            u0();
            D1(false);
            GroupChatFragment groupChatFragment = this.l;
            if (groupChatFragment != null) {
                long j2 = groupChatFragment.j2();
                long h2 = this.l.h2();
                StatisticItem param = new StatisticItem("c15134").param("obj_type", 2).param("fid", h2).param("fname", this.l.i2()).param("room_id", j2);
                BotsDTO.BotListDTO.UserDTO userDTO = this.G;
                if (userDTO != null) {
                    str = BIMManager.getBdUidFromBdUK(userDTO.getUk());
                } else {
                    str = "";
                }
                TiebaStatic.log(param.param("obj_id", str).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
            oh8 oh8Var = this.n;
            if (oh8Var != null) {
                oh8Var.G();
            }
        }
    }

    public void v1(gd5 gd5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048678, this, gd5Var) == null) && gd5Var != null && gd5Var.c() != null && gd5Var.c().p() != null && this.B != null) {
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
            wx5.b(new c(this, gd5Var), new d(this));
        }
    }

    public final void Y1(BotsDTO.BotListDTO.SkillDTO skillDTO, boolean z2, boolean z3) {
        BotsDTO.BotListDTO.SkillDTO skillDTO2;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048625, this, new Object[]{skillDTO, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
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
                this.m.C(true);
                this.m.D(!z4);
                String str = "";
                if (skillDTO2.getKeyboard() == 1) {
                    if (!TextUtils.isEmpty(skillDTO2.getKeyboardContent())) {
                        G1(skillDTO2.getKeyboardContent());
                    } else {
                        G1("");
                    }
                    if (!TextUtils.isEmpty(skillDTO2.getExp())) {
                        H1(skillDTO2.getExp());
                    } else if (z4) {
                        H1(this.j.getString(R.string.obfuscated_res_0x7f0f0953));
                    }
                    S1(1, !TextUtils.isEmpty(this.g));
                    K1(false);
                    L1(false);
                    I1(false);
                    this.m.j0(new r(this));
                    if (this.m.R() != null) {
                        GroupInputTool groupInputTool = this.m;
                        if (skillDTO2.getKeyboardType() == 1) {
                            z5 = true;
                        }
                        groupInputTool.e0(z5);
                        this.m.R().l();
                    }
                    a2(skillDTO2, z3);
                } else {
                    if (this.m.R() != null) {
                        this.m.R().q();
                    }
                    this.m.j0(new s(this));
                    b2(skillDTO2, z3);
                }
                GroupChatFragment groupChatFragment = this.l;
                if (groupChatFragment != null) {
                    StatisticItem param = new StatisticItem("c15134").param("obj_type", 1).param("obj_name", skillDTO2.getName()).param("obj_source", O0()).param("fid", this.l.h2()).param("fname", this.l.i2()).param("room_id", groupChatFragment.j2());
                    BotsDTO.BotListDTO.UserDTO userDTO = this.G;
                    if (userDTO != null) {
                        str = BIMManager.getBdUidFromBdUK(userDTO.getUk());
                    }
                    TiebaStatic.log(param.param("obj_id", str).param("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        }
    }

    public final void a1(boolean z2, boolean z3, @Nullable e0 e0Var) {
        GroupChatFragment groupChatFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048628, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3), e0Var}) == null) && this.o != null && (groupChatFragment = this.l) != null) {
            groupChatFragment.B2(true);
            this.l.J2();
            this.o.F(new u(this, z2, z3, e0Var));
        }
    }

    public void d0(@NonNull AtSelectData atSelectData, boolean z2, boolean z3) {
        oh8 oh8Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048634, this, new Object[]{atSelectData, Boolean.valueOf(z2), Boolean.valueOf(z3)}) != null) || (oh8Var = this.n) == null) {
            return;
        }
        oh8Var.G();
        this.n.l(atSelectData, false, z2, z3);
    }

    public final void e2(int i2, String str, String str2, String str3, String str4, String str5, String str6, IUploadTransferListener iUploadTransferListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048639, this, new Object[]{Integer.valueOf(i2), str, str2, str3, str4, str5, str6, iUploadTransferListener}) == null) {
            new AsyncUploadTask(this.c, i2, str, str2, str3, str4, str5, str6, iUploadTransferListener).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    public final void f2() {
        GroupChatFragment groupChatFragment;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048642, this) == null) && (groupChatFragment = this.l) != null) {
            long j2 = groupChatFragment.j2();
            long h2 = this.l.h2();
            String i2 = this.l.i2();
            StatisticItem param = new StatisticItem("c15134").param("obj_type", 2).param("obj_source", O0());
            BotsDTO.BotListDTO.SkillDTO skillDTO = this.J;
            if (skillDTO != null) {
                str = skillDTO.getName();
            } else {
                str = StringUtil.NULL_STRING;
            }
            StatisticItem param2 = param.param("obj_name", str).param("fid", h2).param("fname", i2).param("room_id", j2);
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
    public final Map<String, Integer> h0(@NonNull String str, @NonNull List<AtSelectData> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048646, this, str, list)) == null) {
            HashMap hashMap = new HashMap();
            for (AtSelectData atSelectData : list) {
                int C0 = C0(str, atSelectData, hashMap, str.indexOf("@" + atSelectData.getNameShow()));
                if (C0 >= 0) {
                    hashMap.put(atSelectData.getUid(), Integer.valueOf(C0));
                }
            }
            return hashMap;
        }
        return (Map) invokeLL.objValue;
    }

    public void h2(@NonNull String str, @NonNull th8 th8Var) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048648, this, str, th8Var) != null) || StringUtils.isNull(str)) {
            return;
        }
        Bitmap reSizeBitmap = PicManager.getInstance().getReSizeBitmap(qi.d().c(str));
        if (reSizeBitmap != null) {
            in inVar = new in(reSizeBitmap, false);
            int r2 = inVar.r();
            i3 = inVar.m();
            i2 = r2;
        } else {
            i2 = 0;
            i3 = 0;
        }
        BIMManager.genBosObjectUrl(this.c, str, "image/jpeg", "jpg", 12, i2, i3, new l(this, th8Var, str));
    }

    public final void l1(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048657, this, str, str2) == null) {
            Iterator<ImageFileInfo> it = this.d.getChosedFiles().iterator();
            long j2 = 0;
            while (it.hasNext()) {
                j2++;
                yg.a().postDelayed(new e(this, it.next(), str, str2), 100 * j2);
            }
            WriteImagesInfo writeImagesInfo = this.d;
            if (writeImagesInfo != null) {
                writeImagesInfo.clear();
            }
        }
    }

    public void n1(int i2, int i3, @Nullable Intent intent) {
        ph8 ph8Var;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048661, this, i2, i3, intent) == null) && i3 == -1 && intent != null && (ph8Var = this.B) != null) {
            ph8Var.k(i2, i3, intent);
            if (i2 != 12010 && i2 != 12009 && i2 != 12002) {
                if (i2 == 12004) {
                    boolean booleanExtra = intent.getBooleanExtra(IntentConfig.IS_AT_SELECT_BOT_DATA, false);
                    intent.getStringExtra(AtListActivityConfig.CALL_AT_LIST_SOURCE);
                    ArrayList<AtSelectData> parcelableArrayListExtra = intent.getParcelableArrayListExtra(IntentConfig.AT_SELECT_LIST_DATA);
                    oh8 oh8Var = this.n;
                    if (oh8Var != null && parcelableArrayListExtra != null) {
                        oh8Var.N(parcelableArrayListExtra);
                        this.n.H(parcelableArrayListExtra, true);
                    }
                    if (this.x != null && booleanExtra) {
                        s0(false, 2);
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
                    l1(str, stringExtra);
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

    public final void t1(boolean z2, boolean z3) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048674, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) && this.m != null) {
            if (!this.N) {
                u0();
            }
            boolean z4 = false;
            this.N = false;
            this.m.k0(false);
            this.m.e0(false);
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
                S1(2, true);
            } else {
                S1(3, true);
            }
            K1(true);
            L1(true);
            I1(true);
            this.l.B2(true);
            if (this.m.R() != null && z2) {
                this.m.R().m();
            }
            if (this.L == SourceType.ONE && !TextUtils.isEmpty(this.C)) {
                H1(this.C);
            } else if (z4) {
                if (!z3 && !TextUtils.isEmpty(this.g)) {
                    G1(this.g);
                }
                if (!TextUtils.isEmpty(this.C)) {
                    H1(this.C);
                } else {
                    H1(this.j.getString(R.string.im_msg_input_hint));
                }
            }
        }
    }

    public final void w1() {
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
        if (interceptable == null || interceptable.invokeV(1048680, this) == null) {
            if (!this.t) {
                g0();
                EditorTools editorTools = this.k;
                if (editorTools != null) {
                    editorTools.r();
                }
            } else if (this.w != null) {
                Q1();
                nf8 nf8Var = this.F;
                if (nf8Var != null) {
                    nf8Var.a = this.G;
                    nf8Var.b = this.J;
                    nf8Var.c = this.H;
                }
                if (this.n != null) {
                    if (i1() && (list2 = this.Q) != null && list2.size() > 0) {
                        t2 = this.Q;
                        this.g = c2();
                    } else {
                        t2 = this.n.t();
                    }
                    List<AtSelectData> list3 = t2;
                    if (i1() && this.n.s() != null) {
                        n2 = h0(this.g, this.Q);
                    } else {
                        this.n.y();
                        n2 = this.n.n();
                    }
                    if (!ListUtils.isEmpty(this.n.t())) {
                        StatisticItem statisticItem = new StatisticItem("c15128");
                        GroupChatFragment groupChatFragment = this.l;
                        long j3 = 0;
                        if (groupChatFragment != null) {
                            j2 = groupChatFragment.h2();
                        } else {
                            j2 = 0;
                        }
                        StatisticItem param = statisticItem.param("fid", j2);
                        GroupChatFragment groupChatFragment2 = this.l;
                        if (groupChatFragment2 != null) {
                            j3 = groupChatFragment2.j2();
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
                    long j22 = this.l.j2();
                    long h2 = this.l.h2();
                    String i22 = this.l.i2();
                    StatisticItem param2 = new StatisticItem("c15134").param("obj_type", 3).param("obj_source", O0());
                    BotsDTO.BotListDTO.SkillDTO skillDTO2 = this.J;
                    if (skillDTO2 != null) {
                        str2 = skillDTO2.getName();
                    } else {
                        str2 = StringUtil.NULL_STRING;
                    }
                    StatisticItem param3 = param2.param("obj_name", str2).param("fid", h2).param("fname", i22).param("room_id", j22);
                    BotsDTO.BotListDTO.UserDTO userDTO = this.G;
                    if (userDTO == null) {
                        str3 = "";
                    } else {
                        str3 = BIMManager.getBdUidFromBdUK(userDTO.getUk());
                    }
                    TiebaStatic.log(param3.param("obj_id", str3).param("uid", TbadkCoreApplication.getCurrentAccount()));
                }
                if (j1()) {
                    i2 = 1;
                } else if (i1()) {
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
                if (!pj8.a(this.H)) {
                    this.P = true;
                    return;
                }
                uh8 uh8Var = this.w;
                String str4 = this.g;
                if (str4 == null) {
                    str = "";
                } else {
                    str = str4;
                }
                uh8Var.f(str, this.E, this.F, list, map, i2);
                g0();
                oh8 oh8Var = this.n;
                if (oh8Var != null) {
                    oh8Var.G();
                }
            }
        }
    }
}
