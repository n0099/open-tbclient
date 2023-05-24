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
import com.baidu.searchbox.wordscommand.WordCommandManager;
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
import com.baidu.tieba.aa8;
import com.baidu.tieba.ak5;
import com.baidu.tieba.au5;
import com.baidu.tieba.cn;
import com.baidu.tieba.da8;
import com.baidu.tieba.df5;
import com.baidu.tieba.ea5;
import com.baidu.tieba.ea8;
import com.baidu.tieba.ef5;
import com.baidu.tieba.et5;
import com.baidu.tieba.f9;
import com.baidu.tieba.fa8;
import com.baidu.tieba.ga8;
import com.baidu.tieba.hb8;
import com.baidu.tieba.im.chat.AbsMsglistView;
import com.baidu.tieba.im.model.LocalPicModel;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.GroupChatFragment;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ability.InputBoxHandler;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.GroupInputTool;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.GroupInputViewController;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.GroupChatRobotTopHeadView;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.data.UserReplyInfoData;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.BotsDTO;
import com.baidu.tieba.is5;
import com.baidu.tieba.it5;
import com.baidu.tieba.jb8;
import com.baidu.tieba.ki;
import com.baidu.tieba.nb8;
import com.baidu.tieba.o65;
import com.baidu.tieba.q11;
import com.baidu.tieba.qi;
import com.baidu.tieba.ri;
import com.baidu.tieba.sb8;
import com.baidu.tieba.se5;
import com.baidu.tieba.sg;
import com.baidu.tieba.t88;
import com.baidu.tieba.te5;
import com.baidu.tieba.u98;
import com.baidu.tieba.ua8;
import com.baidu.tieba.v78;
import com.baidu.tieba.v98;
import com.baidu.tieba.w98;
import com.baidu.tieba.x98;
import com.baidu.tieba.y98;
import com.baidu.tieba.z7b;
import com.baidu.tieba.z98;
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
    public v98 A;
    public String B;
    public int C;
    public Object D;
    public v78 E;
    public BotsDTO.BotListDTO.UserDTO F;
    public List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> G;
    public List<BotsDTO.BotListDTO.SkillDTO> H;
    public BotsDTO.BotListDTO.SkillDTO I;
    public GroupChatRobotTopHeadView J;
    public SourceType K;
    @NonNull
    public jb8 L;
    public boolean M;
    public boolean N;
    public boolean O;
    public List<AtSelectData> P;
    public List<InputBoxHandler.BanData> Q;
    public int R;
    public final CustomMessageListener S;
    public final CustomMessageListener T;
    public te5 U;
    public w98.l V;
    public GroupInputTool.h W;
    public w98.k X;
    public final f9 Y;
    public final CustomMessageListener Z;
    public ToolState a;
    public Context b;
    public WriteImagesInfo c;
    public LocalPicModel d;
    public View e;
    public String f;
    public String g;
    public String h;
    public TbPageContext i;
    public EditorTools j;
    public GroupChatFragment k;
    public GroupInputTool l;
    public u98 m;
    public w98 n;
    public GroupInputTool o;
    public long p;
    public boolean q;
    public String r;
    public boolean s;
    public PermissionJudgePolicy t;
    public boolean u;
    @Nullable
    public aa8 v;
    public ea8 w;
    public ga8 x;
    public fa8 y;
    public da8 z;

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

    public boolean r0(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048664, this, i2, i3)) == null) ? i2 > 1 && i2 > i3 : invokeII.booleanValue;
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
        public class a extends et5<Object> {
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

            @Override // com.baidu.tieba.et5
            public Object doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    e eVar = this.a;
                    eVar.d.t0(eVar.a);
                    return null;
                }
                return invokeV.objValue;
            }
        }

        /* loaded from: classes6.dex */
        public class b implements is5<Object> {
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

            @Override // com.baidu.tieba.is5
            public void onReturnDataInUI(Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                    if (this.a.a.isGif()) {
                        this.a.d.d = new LocalPicModel(null, TbConfig.IMAGE_RESIZED_FILE, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                    } else {
                        e eVar = this.a;
                        eVar.d.d = new LocalPicModel(eVar.b, eVar.c, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                    }
                    this.a.d.d.setLoadDataCallBack(this.a.d.Y);
                    this.a.d.d.getData();
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
                it5.b(new a(this), new b(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements ea8.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        /* loaded from: classes6.dex */
        public class a implements ea8.d {
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

            @Override // com.baidu.tieba.ea8.d
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.E1(SourceType.ONE, false, false);
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

        @Override // com.baidu.tieba.ea8.f
        public void a(BotsDTO.BotListDTO.UserDTO userDTO, BotsDTO.BotListDTO.SkillDTO skillDTO) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, userDTO, skillDTO) == null) && userDTO != null && skillDTO != null) {
                this.a.M1(userDTO, skillDTO);
                this.a.f0();
                if (this.a.v != null) {
                    if (skillDTO.isFuncJump() && skillDTO.getAbilityItem() != null) {
                        this.a.v.l(skillDTO.getAbilityItem());
                        this.a.T0();
                        return;
                    } else if (skillDTO.isFuncSendMsg() && !TextUtils.isEmpty(userDTO.getUk())) {
                        this.a.v.g(userDTO.getUk(), skillDTO.getType());
                        this.a.J0().s(null);
                        this.a.T0();
                        return;
                    }
                }
                this.a.v0();
                this.a.y1(true);
                if (this.a.J0() != null) {
                    this.a.J0().s(new a(this));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements IGenBosObjectUrlListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z98 a;
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
                z98 z98Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, str) == null) && (z98Var = this.b.a) != null) {
                    z98Var.a(i, i2, str);
                }
            }

            @Override // com.baidu.android.imsdk.upload.IUploadTransferListener
            public void onFinished(int i, String str) {
                z98 z98Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) && (z98Var = this.b.a) != null) {
                    z98Var.c(i, str, this.a);
                }
            }

            @Override // com.baidu.android.imsdk.upload.IUploadTransferListener
            public void onProgress(int i) {
                z98 z98Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (z98Var = this.b.a) != null) {
                    z98Var.b(i);
                }
            }
        }

        public l(GroupInputViewController groupInputViewController, z98 z98Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController, z98Var, str};
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
            this.a = z98Var;
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
                    if (qi.isEmpty(str4) || qi.isEmpty(str5) || qi.isEmpty(str6)) {
                        z98 z98Var = this.a;
                        if (z98Var != null) {
                            z98Var.a(i, 1, this.b);
                            return;
                        }
                        return;
                    }
                    this.c.Z1(1, str4, str5, this.b, WordCommandManager.IMAGE_JPEG, str2, str3, new a(this, str6));
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
            SourceType sourceType = new SourceType("TWO", 1);
            TWO = sourceType;
            $VALUES = new SourceType[]{ONE, sourceType};
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
    public class a implements w98.k {
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

        @Override // com.baidu.tieba.w98.k
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
                this.a.k.B2();
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
                this.b.x.l(null, this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends f9 {
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

        @Override // com.baidu.tieba.f9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (obj instanceof LocalPicModel.ResponseData) {
                    LocalPicModel.ResponseData responseData = (LocalPicModel.ResponseData) obj;
                    String str = responseData.getBitmap().getWidth() + "," + responseData.getBitmap().getHeight();
                    String sPathGen = responseData.getSPathGen();
                    if (this.a.f1() && this.a.n != null && !StringUtils.isNull(sPathGen)) {
                        this.a.n.L(sPathGen, str);
                        return;
                    } else if (responseData.getExtraMap() != null) {
                        this.a.v.b(responseData.getSPathGen(), str, responseData.getExtraMap());
                        return;
                    } else {
                        this.a.v.j(responseData.getSPathGen(), str);
                        return;
                    }
                }
                this.a.k.showToast(TbadkCoreApplication.getInst().getString(R.string.pic_parser_error));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b0 implements ea8.d {
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

        @Override // com.baidu.tieba.ea8.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.y.l(null, this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends et5<Map<String, Object>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ea5 a;
        public final /* synthetic */ GroupInputViewController b;

        public c(GroupInputViewController groupInputViewController, ea5 ea5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController, ea5Var};
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
            this.a = ea5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.et5
        /* renamed from: a */
        public Map<String, Object> doInBackground() {
            InterceptResult invokeV;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                String d = ak5.b.d(this.a.d(), true);
                boolean exists = new File(d).exists();
                if (!exists) {
                    d = d.replace(".gif", ".jpg");
                }
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setFilePath(d);
                imageFileInfo.setIsGif(exists);
                this.b.t0(imageFileInfo);
                String b = ak5.b.b(this.a.d());
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
                this.b.y.l(null, this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements is5<Map<String, Object>> {
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
        @Override // com.baidu.tieba.is5
        /* renamed from: a */
        public void onReturnDataInUI(Map<String, Object> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, map) == null) {
                this.a.d = new LocalPicModel(null, TbConfig.IMAGE_RESIZED_FILE, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                this.a.d.setExtraMap(map);
                this.a.d.setLoadDataCallBack(this.a.Y);
                this.a.d.getData();
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
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voiceModel) == null) && voiceModel != null && !StringUtils.isNull(voiceModel.getVoiceId()) && this.a.v != null) {
                this.a.v.d(voiceModel.getVoiceId(), voiceModel.getDuration());
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
                this.a.l.d0(false);
                this.a.u = true;
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
                if (booleanValue && this.a.u) {
                    this.a.u = false;
                    if (!this.a.j0()) {
                        this.a.q0(true, 1);
                    }
                }
                if (!booleanValue && this.a.z != null) {
                    this.a.z.k();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements ga8.e {
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

        @Override // com.baidu.tieba.ga8.e
        public void a(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) != null) || this.a.l == null) {
                return;
            }
            if (this.a.k != null) {
                this.a.k.v2();
            }
            GroupInputViewController groupInputViewController = this.a;
            groupInputViewController.C1(groupInputViewController.i.getString(R.string.im_msg_input_hint));
            this.a.D1(false);
            this.a.l.u(i, i2, j, animatorListenerAdapter, z);
        }

        @Override // com.baidu.tieba.ga8.e
        public void b(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) != null) || this.a.l == null) {
                return;
            }
            GroupInputViewController groupInputViewController = this.a;
            groupInputViewController.C1(groupInputViewController.B);
            this.a.D1(true);
            this.a.l.s(i, i2, j, animatorListenerAdapter, z);
        }

        @Override // com.baidu.tieba.ga8.e
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.m0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements fa8.e {
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

        @Override // com.baidu.tieba.fa8.e
        public void a(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) != null) || this.a.l == null) {
                return;
            }
            if (this.a.k != null) {
                this.a.k.v2();
            }
            this.a.D1(false);
            this.a.l.u(i, i2, j, animatorListenerAdapter, z);
        }

        @Override // com.baidu.tieba.fa8.e
        public void b(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) != null) || this.a.l == null) {
                return;
            }
            GroupInputViewController groupInputViewController = this.a;
            groupInputViewController.C1(groupInputViewController.B);
            this.a.D1(true);
            this.a.l.s(i, i2, j, animatorListenerAdapter, z);
        }

        @Override // com.baidu.tieba.fa8.e
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.l0();
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
                if (this.a.a == toolState) {
                    return;
                }
                this.a.a = toolState;
                if (this.a.m != null) {
                    this.a.m.I(this.a.a);
                }
                this.a.b2(booleanValue);
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
                this.a.k1(null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n implements ga8.d {
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

        @Override // com.baidu.tieba.ga8.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.d.U1(this.a, this.b, this.c);
        }
    }

    /* loaded from: classes6.dex */
    public class o implements fa8.d {
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

        @Override // com.baidu.tieba.fa8.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.d.U1(this.a, this.b, this.c);
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
                groupInputViewController.T1(groupInputViewController.I, false, this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q implements ea8.d {
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

        @Override // com.baidu.tieba.ea8.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                GroupInputViewController groupInputViewController = this.b;
                groupInputViewController.T1(groupInputViewController.I, false, this.a);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.n != null) {
                if (this.a.n.I()) {
                    this.a.n.z();
                    return;
                }
                this.a.U0(false);
                this.a.v0();
                this.a.a2();
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
                if (this.a.n != null && this.a.n.I()) {
                    this.a.n.z();
                    return;
                }
                this.a.V0(true, false, null);
                this.a.a2();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class t implements w98.j {
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

        @Override // com.baidu.tieba.w98.j
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.r1();
                if (this.a.O) {
                    return;
                }
                this.a.V0(true, true, null);
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
            this.d.o1(this.a, this.b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) != null) {
                return;
            }
            this.d.o1(this.a, this.b);
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
                this.a.N = ((Boolean) customResponsedMessage.getData()).booleanValue();
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
    public class x implements te5 {
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

        @Override // com.baidu.tieba.te5
        public void C(se5 se5Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, se5Var) != null) || se5Var == null) {
                return;
            }
            int i = se5Var.a;
            if (i == 24) {
                Object obj = se5Var.c;
                if (obj instanceof ea5) {
                    ea5 ea5Var = (ea5) obj;
                    if (ea5Var.getType() != EmotionGroupType.LOCAL) {
                        this.a.q1(ea5Var);
                    }
                }
            } else if (i == 8) {
                this.a.r1();
                if (this.a.O) {
                    return;
                }
                this.a.U0(true);
            } else if (i == 4) {
                Object obj2 = se5Var.c;
                if (obj2 instanceof String) {
                    this.a.f = (String) obj2;
                    this.a.q0(false, 1);
                    this.a.z.m(100L);
                }
            } else if (i == 14) {
                this.a.l1();
            } else if (i != 17) {
                if (i == 62) {
                    boolean booleanValue = ((Boolean) se5Var.c).booleanValue();
                    if (this.a.l == null) {
                        return;
                    }
                    if (booleanValue) {
                        this.a.n0();
                    } else {
                        this.a.q0(true, 1);
                    }
                    if (!this.a.l.Y() || this.a.I0() != ToolState.TEXT) {
                        return;
                    }
                    this.a.J1(false);
                    this.a.x1(false);
                } else if (i != 63 || this.a.l == null) {
                } else {
                    this.a.l.d0(false);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class y implements w98.l {
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

        @Override // com.baidu.tieba.w98.l
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZ(1048576, this, z) != null) {
                return;
            }
            this.a.P1(z);
        }
    }

    /* loaded from: classes6.dex */
    public class z implements ea8.d {
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

        @Override // com.baidu.tieba.ea8.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.x.l(null, this.a);
            }
        }
    }

    public GroupInputViewController(GroupChatFragment groupChatFragment, long j2, t88 t88Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {groupChatFragment, Long.valueOf(j2), t88Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = ToolState.TEXT;
        this.c = new WriteImagesInfo(1);
        this.d = null;
        this.j = null;
        this.s = true;
        this.B = null;
        this.E = new v78();
        this.G = new ArrayList();
        this.J = null;
        this.N = false;
        this.O = false;
        this.P = new ArrayList();
        this.Q = new ArrayList();
        this.R = 0;
        this.S = new k(this, 2921790);
        this.T = new v(this, 2921800);
        this.U = new x(this);
        this.V = new y(this);
        this.W = new d0(this);
        this.X = new a(this);
        this.Y = new b(this);
        this.Z = new g(this, 2921785);
        this.p = j2;
        this.k = groupChatFragment;
        this.i = groupChatFragment.getPageContext();
        this.b = groupChatFragment.getContext();
        this.o = new GroupInputTool(this.k);
        v98 v98Var = new v98(this.k);
        this.A = v98Var;
        v98Var.o(this.U);
        this.L = new hb8(this);
        this.z = new da8(this.k, new z7b() { // from class: com.baidu.tieba.t98
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.z7b
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? GroupInputViewController.this.h1() : invokeV.objValue;
            }
        }, t88Var);
        W0();
        z1(this.o);
        X0();
        MessageManager.getInstance().registerListener(this.S);
        MessageManager.getInstance().registerListener(this.T);
        w98 w98Var = this.n;
        if (w98Var != null) {
            w98Var.R(this.X);
        }
    }

    public void A1(String str) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && (editorTools = this.j) != null) {
            editorTools.C(new se5(75, 3, str));
        }
    }

    public void B1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f = str;
            if (!TextUtils.isEmpty(str)) {
                this.h = str;
            }
            EditorTools editorTools = this.j;
            if (editorTools != null) {
                editorTools.C(new se5(6, 3, str));
            }
        }
    }

    public void C1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.r = str;
            EditorTools editorTools = this.j;
            if (editorTools != null) {
                editorTools.C(new se5(71, 3, StringHelper.cutChineseAndEnglishWithEmoji(str, 28, StringHelper.STRING_MORE)));
            }
        }
    }

    public void D1(boolean z2) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z2) == null) && (groupInputTool = this.l) != null) {
            groupInputTool.h0(z2);
        }
    }

    public void G1(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048589, this, z2) == null) && this.j.o(6) != null) {
            if (!z2) {
                this.j.o(6).hide();
            } else {
                this.j.o(6).display();
            }
        }
    }

    public void H1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.R = i2;
        }
    }

    public void I1(GroupInputTool.f fVar) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, fVar) == null) && (groupInputTool = this.l) != null) {
            groupInputTool.l0(fVar);
        }
    }

    public void K1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, view2) == null) {
            this.e = view2;
        }
    }

    public void O1(@Nullable aa8 aa8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, aa8Var) == null) {
            this.v = aa8Var;
        }
    }

    public void R1(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, editorTools) == null) {
            this.j = editorTools;
        }
    }

    public void S0(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            v0();
            o0(str);
        }
    }

    public final void U0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z2) == null) {
            V0(false, z2, null);
        }
    }

    public final void b2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048631, this, z2) == null) {
            if (z2) {
                n0();
                J1(true);
                x1(true);
                return;
            }
            q0(true, 1);
            J1(false);
            x1(false);
        }
    }

    public final void i0(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048645, this, z2) == null) && J0() != null) {
            J0().s(new q(this, z2));
        }
    }

    public void j1(@NonNull Bundle bundle) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048648, this, bundle) == null) && (groupInputTool = this.o) != null) {
            groupInputTool.b0(bundle);
        }
    }

    public void onChangeSkinType(int i2) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048659, this, i2) == null) && (groupInputTool = this.o) != null) {
            groupInputTool.onChangeSkinType(i2);
        }
    }

    public final void p1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048661, this, z2) == null) {
            this.M = true;
            V0(true, false, new p(this, z2));
        }
    }

    public void s1(BotsDTO botsDTO) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048667, this, botsDTO) == null) && (groupInputTool = this.l) != null) {
            groupInputTool.c0(botsDTO);
        }
    }

    public void t1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048669, this, str) == null) {
            this.B = str;
        }
    }

    public final void u0(@NonNull List<BotsDTO.BotListDTO.SkillDTO> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048670, this, list) == null) {
            for (BotsDTO.BotListDTO.SkillDTO skillDTO : list) {
                if (skillDTO != null && skillDTO.getType() == this.C) {
                    this.I = skillDTO;
                    return;
                }
            }
        }
    }

    public void w1(List<InputBoxHandler.BanData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048675, this, list) == null) {
            this.Q = list;
        }
    }

    public final void y1(boolean z2) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048679, this, z2) != null) || (groupInputTool = this.l) == null) {
            return;
        }
        if (z2) {
            groupInputTool.g0(1);
        } else {
            groupInputTool.g0(0);
        }
    }

    public void M1(BotsDTO.BotListDTO.UserDTO userDTO, BotsDTO.BotListDTO.SkillDTO skillDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, userDTO, skillDTO) == null) {
            this.F = userDTO;
            this.I = skillDTO;
        }
    }

    public void d2(@NonNull String str, @NonNull x98 x98Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048636, this, str, x98Var) == null) {
            y98 y98Var = new y98(this.b, str, "audio/amr");
            y98Var.b(x98Var);
            BIMManager.audioTrans(this.b, str, "audio/amr", "amr", 12, y98Var);
        }
    }

    public void m1(@NonNull UserReplyInfoData userReplyInfoData, @NonNull Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048654, this, userReplyInfoData, obj) == null) {
            this.D = obj;
            v0();
            p0(userReplyInfoData);
            e0(userReplyInfoData);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65569, this) == null) {
            v98 v98Var = this.A;
            if (v98Var != null) {
                v98Var.l();
            }
            u98 u98Var = this.m;
            if (u98Var != null) {
                u98Var.A();
            }
            w98 w98Var = this.n;
            if (w98Var != null) {
                w98Var.M();
            }
            da8 da8Var = this.z;
            if (da8Var != null) {
                da8Var.o();
            }
            VoiceManager.setIsNeedBlackScreen(true);
            MessageManager.getInstance().unRegisterListener(this.Z);
            MessageManager.getInstance().unRegisterListener(this.S);
            MessageManager.getInstance().unRegisterListener(this.T);
        }
    }

    public String D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            EditorTools editorTools = this.j;
            if (editorTools == null) {
                return "";
            }
            df5 p2 = editorTools.p(3);
            String str = TbEnum.ChatInputStatus.INPUT_STATUS_TEXT;
            if (p2 != null) {
                ef5 ef5Var = p2.m;
                if ((ef5Var instanceof View) && ((View) ef5Var).getVisibility() != 0) {
                    str = TbEnum.ChatInputStatus.INPUT_STATUS_VOICE;
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put(TbEnum.ChatInputStatus.INPUT_DRAFT_KEY, this.f);
            hashMap.put(TbEnum.ChatInputStatus.INPUT_STATUS_KEY, str);
            return OrmObject.jsonStrWithObject((AbsMsglistView.DraftContent) OrmObject.objectWithMap(hashMap, AbsMsglistView.DraftContent.class));
        }
        return (String) invokeV.objValue;
    }

    public final void f0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048639, this) == null) && this.F != null && this.I != null) {
            nb8.f().h(nb8.f().c(this.F.getUk(), this.I.getType(), this.F.getNameShow(), this.I.getName(), this.F.getPortrait(), this.I.getDesc(), this.I.getFuncType()));
        }
    }

    public final void l1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048652, this) != null) || !c1()) {
            return;
        }
        EditorTools editorTools = this.j;
        if (editorTools != null) {
            editorTools.r();
        }
        this.c.mIsFromIm = true;
        AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.b, this.c.toJsonString(), true, false);
        albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
        albumFloatActivityConfig.setResourceType(1);
        albumFloatActivityConfig.setCanEditImage(false);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65570, this) == null) {
            this.q = false;
            v98 v98Var = this.A;
            if (v98Var != null) {
                v98Var.m();
                this.A.p(this.q);
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65571, this) == null) {
            this.q = true;
            v98 v98Var = this.A;
            if (v98Var != null) {
                v98Var.n();
                this.A.p(this.q);
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65572, this) == null) {
            if (H0() != null && H0().M()) {
                return;
            }
            TbSingleton.getInstance().setRoomDraft(Long.valueOf(this.p), D0());
        }
    }

    public GroupInputTool C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.o;
        }
        return (GroupInputTool) invokeV.objValue;
    }

    public List<InputBoxHandler.BanData> E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.Q;
        }
        return (List) invokeV.objValue;
    }

    @NonNull
    public String F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (TextUtils.isEmpty(this.f)) {
                return "";
            }
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public String G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public GroupInputTool H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.l;
        }
        return (GroupInputTool) invokeV.objValue;
    }

    public ToolState I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.a;
        }
        return (ToolState) invokeV.objValue;
    }

    public ea8 J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.w;
        }
        return (ea8) invokeV.objValue;
    }

    public w98 K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.n;
        }
        return (w98) invokeV.objValue;
    }

    public String L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (TextUtils.isEmpty(this.h)) {
                if (TextUtils.isEmpty(this.g)) {
                    return "";
                }
                return this.g;
            }
            return this.h;
        }
        return (String) invokeV.objValue;
    }

    public void L1() {
        w98 w98Var;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && (w98Var = this.n) != null && w98Var.H() && (arrayList = (ArrayList) this.n.y()) != null) {
            this.G = arrayList;
        }
    }

    public fa8 M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.y;
        }
        return (fa8) invokeV.objValue;
    }

    public ga8 N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.x;
        }
        return (ga8) invokeV.objValue;
    }

    @NonNull
    public jb8 O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.L;
        }
        return (jb8) invokeV.objValue;
    }

    @Nullable
    public VoiceManager P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            v98 v98Var = this.A;
            if (v98Var != null) {
                return v98Var.x0();
            }
            return null;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public SourceType Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.K;
        }
        return (SourceType) invokeV.objValue;
    }

    public void T0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            da8 da8Var = this.z;
            if (da8Var != null) {
                da8Var.k();
            }
            GroupInputTool groupInputTool = this.l;
            if (groupInputTool != null) {
                groupInputTool.U();
            }
        }
    }

    public final void W0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048620, this) == null) && this.m == null) {
            this.m = new u98(this.b, this.k);
        }
    }

    public final void X0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            v98 v98Var = this.A;
            if (v98Var != null) {
                v98Var.i();
            }
            GroupInputTool groupInputTool = this.l;
            if (groupInputTool != null) {
                groupInputTool.m0(this.W);
            }
        }
    }

    public final void Y0() {
        ea8 ea8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048624, this) == null) && (ea8Var = this.w) != null) {
            ea8Var.r(new h(this));
        }
    }

    public final GroupChatRobotTopHeadView Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            GroupInputTool groupInputTool = this.l;
            if (groupInputTool == null) {
                return null;
            }
            GroupChatRobotTopHeadView Q = groupInputTool.Q();
            this.J = Q;
            Q.setEventCallback(new m(this));
            return this.J;
        }
        return (GroupChatRobotTopHeadView) invokeV.objValue;
    }

    public final void a1() {
        fa8 fa8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048628, this) == null) && (fa8Var = this.y) != null) {
            fa8Var.i(new j(this));
        }
    }

    public final void b1() {
        ga8 ga8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048630, this) == null) && (ga8Var = this.x) != null) {
            ga8Var.i(new i(this));
        }
    }

    public boolean c1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            if (FileHelper.checkSD()) {
                return true;
            }
            ri.Q(this.b, TbadkCoreApplication.getInst().getString(R.string.voice_error_sdcard));
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            fa8 fa8Var = this.y;
            if (fa8Var != null && fa8Var.e()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean e1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            ga8 ga8Var = this.x;
            if (ga8Var != null && ga8Var.e()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            GroupInputTool groupInputTool = this.l;
            if (groupInputTool != null && groupInputTool.M() && this.N) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public /* synthetic */ CharSequence h1() {
        return this.f;
    }

    public boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            GroupInputTool groupInputTool = this.l;
            if (groupInputTool != null) {
                return groupInputTool.v();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void l0() {
        fa8 fa8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048651, this) == null) && (fa8Var = this.y) != null) {
            fa8Var.k(null);
        }
    }

    public void m0() {
        ga8 ga8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048653, this) == null) && (ga8Var = this.x) != null) {
            ga8Var.j(null);
        }
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048655, this) == null) && J0() != null) {
            J0().s(null);
        }
    }

    public void n1() {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048656, this) == null) && (groupInputTool = this.l) != null) {
            groupInputTool.e0(false);
        }
    }

    public final void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048666, this) == null) {
            this.E.a();
            this.G.clear();
            this.F = null;
            this.I = null;
            this.D = null;
        }
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048672, this) == null) {
            this.f = null;
            EditorTools editorTools = this.j;
            if (editorTools != null) {
                editorTools.C(new se5(9, -1, Boolean.TRUE));
            }
        }
    }

    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048674, this) == null) {
            try {
                r1();
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    public void y0() {
        BotsDTO.BotListDTO.SkillDTO skillDTO;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048678, this) == null) && (skillDTO = this.I) != null && skillDTO.getItems() != null) {
            this.G.addAll(this.I.getItems());
        }
    }

    public u98 z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) {
            return this.m;
        }
        return (u98) invokeV.objValue;
    }

    public final int A0(String str, AtSelectData atSelectData, Map<String, Integer> map, int i2) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048576, this, str, atSelectData, map, i2)) == null) {
            if (!map.containsValue(Integer.valueOf(i2))) {
                return i2;
            }
            return A0(str, atSelectData, map, str.indexOf("@" + atSelectData.getNameShow(), i2 + 1));
        }
        return invokeLLLI.intValue;
    }

    public void u1(@Nullable Object obj, @Nullable BotsDTO.BotListDTO.UserDTO userDTO, @Nullable BotsDTO.BotListDTO.SkillDTO skillDTO, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048671, this, new Object[]{obj, userDTO, skillDTO, Boolean.valueOf(z2)}) == null) {
            this.D = obj;
            this.F = userDTO;
            this.I = skillDTO;
            v78 v78Var = this.E;
            if (v78Var != null) {
                v78Var.d(z2);
            }
        }
    }

    @NonNull
    public ua8 B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ua8 ua8Var = new ua8();
            ua8Var.g(this.k.i2());
            ua8Var.h(this.k.k2());
            ua8Var.e(this.k.g2());
            ua8Var.f(this.k.h2());
            return ua8Var;
        }
        return (ua8) invokeV.objValue;
    }

    public String X1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            if (this.R == 0) {
                return Y1() + this.f;
            }
            return this.f + Y1();
        }
        return (String) invokeV.objValue;
    }

    public final String Y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            StringBuilder sb = new StringBuilder();
            for (AtSelectData atSelectData : this.P) {
                sb.append("@");
                sb.append(atSelectData.getNameShow());
                sb.append(" ");
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            v0();
            if (e1()) {
                m0();
            }
            if (d1()) {
                l0();
            }
            s0();
            N1(2, true);
            F1(true);
            G1(true);
            this.P.clear();
            this.O = false;
        }
    }

    public final boolean j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            u98 u98Var = this.m;
            if (u98Var == null || q11.h(u98Var.v()) != 1 || !this.m.v().get(0).isRobot()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void x0() {
        BotsDTO.BotListDTO.SkillDTO skillDTO;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048676, this) == null) && (skillDTO = this.I) != null && skillDTO.isCanKeyboardInput()) {
            if (!TextUtils.isEmpty(this.I.getKeyboardContent())) {
                B1(this.I.getKeyboardContent());
            } else {
                B1("");
            }
        }
    }

    public void E1(SourceType sourceType, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{sourceType, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            if (e1()) {
                this.x.j(new n(this, sourceType, z2, z3));
            } else if (d1()) {
                this.y.k(new o(this, sourceType, z2, z3));
            } else {
                U1(sourceType, z2, z3);
            }
        }
    }

    public void Q1(int i2, @NonNull Object obj, @NonNull v78 v78Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048609, this, i2, obj, v78Var) == null) {
            this.C = i2;
            this.D = obj;
            this.F = v78Var.a;
            if (this.H == null) {
                this.H = new ArrayList();
            }
            this.H.clear();
            BotsDTO.BotListDTO.SkillDTO skillDTO = v78Var.b;
            if (skillDTO != null && !ListUtils.isEmpty(skillDTO.getSubSkill())) {
                this.H.addAll(v78Var.b.getSubSkill());
                u0(this.H);
            }
            v78 v78Var2 = this.E;
            if (v78Var2 != null) {
                v78Var2.d(v78Var.c());
            }
        }
    }

    public final void U1(SourceType sourceType, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048617, this, new Object[]{sourceType, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            this.K = sourceType;
            GroupChatFragment groupChatFragment = this.k;
            if (groupChatFragment != null) {
                groupChatFragment.v2();
            }
            if (this.K == SourceType.TWO) {
                this.g = this.f;
                GroupInputTool groupInputTool = this.l;
                if (groupInputTool != null) {
                    if (groupInputTool.z()) {
                        i0(z3);
                        return;
                    } else if (this.l.M()) {
                        p1(z3);
                        return;
                    }
                }
            }
            T1(this.I, z2, z3);
        }
    }

    public void F1(boolean z2) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z2) == null) && (groupInputTool = this.l) != null && groupInputTool.E() != null && (this.l.E().m instanceof EmotionNoLaunchView)) {
            ((EmotionNoLaunchView) this.l.E().m).setNeedHideForever(z2);
            if (!z2) {
                this.l.E().m.hide();
            } else {
                this.l.E().m.display();
            }
        }
    }

    public final void o0(@NonNull String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048657, this, str) != null) || this.y == null) {
            return;
        }
        ea8 ea8Var = this.w;
        if (ea8Var != null && ea8Var.k()) {
            this.w.s(new b0(this, str));
        } else if (this.l.M()) {
            k1(new c0(this, str));
        } else {
            this.y.l(null, str);
            this.k.z2(true);
        }
    }

    public final void p0(@NonNull UserReplyInfoData userReplyInfoData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048660, this, userReplyInfoData) != null) || this.x == null) {
            return;
        }
        ea8 ea8Var = this.w;
        if (ea8Var != null && ea8Var.k()) {
            this.w.s(new z(this, userReplyInfoData));
        } else if (this.l.M()) {
            k1(new a0(this, userReplyInfoData));
        } else {
            this.x.l(null, userReplyInfoData);
            this.k.z2(true);
        }
    }

    public final void t0(ImageFileInfo imageFileInfo) {
        Bitmap resizeBitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048668, this, imageFileInfo) == null) {
            try {
                if (imageFileInfo.isGif()) {
                    FileHelper.saveGifByRelativePath(imageFileInfo.getFilePath(), null, TbConfig.IMAGE_RESIZED_FILE);
                    FileHelper.saveGifByRelativePath(imageFileInfo.getFilePath(), null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                    return;
                }
                Bitmap c2 = au5.c(0, this.b, null, imageFileInfo.getFilePath(), TbImageHelper.getInstance().getPostImageSize());
                if (c2 != null && FileHelper.saveBitmapByRelativelyPath(null, TbConfig.IMAGE_RESIZED_FILE, c2, 85) != null && (resizeBitmap = BitmapHelper.resizeBitmap(c2, 100)) != null) {
                    FileHelper.saveBitmapByRelativelyPath(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 85);
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public void v1(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048673, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString(TbEnum.ChatInputStatus.INPUT_DRAFT_KEY);
            if (this.j != null) {
                this.j.C(new se5(6, 3, optString));
            }
            this.f = optString;
            if (TextUtils.equals(jSONObject.optString(TbEnum.ChatInputStatus.INPUT_STATUS_KEY), TbEnum.ChatInputStatus.INPUT_STATUS_VOICE) && this.j != null) {
                this.j.C(new se5(1, 6, null));
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public final void J1(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048595, this, z2) == null) && N0() != null) {
            if (z2) {
                N0().k(false);
            } else if (!N0().g()) {
                N0().k(!z2);
            }
        }
    }

    public final void P1(boolean z2) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048607, this, z2) != null) || this.J == null || !z2) {
            return;
        }
        BotsDTO.BotListDTO.UserDTO userDTO = this.F;
        String str3 = null;
        if (userDTO != null) {
            str = userDTO.getPortrait();
            str2 = this.F.getNameShow();
        } else {
            str = null;
            str2 = null;
        }
        BotsDTO.BotListDTO.SkillDTO skillDTO = this.I;
        if (skillDTO != null) {
            str3 = skillDTO.getName();
        }
        this.J.setData(str, str2, str3);
        this.J.setVisibility(0);
    }

    public void e0(@NonNull UserReplyInfoData userReplyInfoData) {
        u98 u98Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048637, this, userReplyInfoData) != null) || (u98Var = this.m) == null) {
            return;
        }
        u98Var.G();
        this.m.k(new AtSelectData(userReplyInfoData.getmPortrait(), userReplyInfoData.getmNameShow(), String.valueOf(userReplyInfoData.getmUid()), userReplyInfoData.isRobot()), false);
    }

    public final void x1(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048677, this, z2) == null) && M0() != null) {
            if (z2) {
                M0().j(false);
            } else if (!M0().g()) {
                M0().j(true);
            }
        }
    }

    public void N1(int i2, boolean z2) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) && (groupInputTool = this.l) != null && groupInputTool.N() != null && (this.l.N().m instanceof SendNoLaunchView)) {
            if (i2 == 1) {
                ((SendNoLaunchView) this.l.N().m).setIsSendIcon(true);
                ((SendNoLaunchView) this.l.N().m).setSendVisibility(z2);
            } else if (i2 == 2) {
                ((SendNoLaunchView) this.l.N().m).setIsSendIcon(false);
                ((SendNoLaunchView) this.l.N().m).setSendVisibility(false);
            } else if (i2 == 3) {
                ((SendNoLaunchView) this.l.N().m).setIsSendIcon(false);
                ((SendNoLaunchView) this.l.N().m).setSendVisibility(true);
            }
        }
    }

    public void q0(boolean z2, int i2) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048662, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) && (groupInputTool = this.l) != null && groupInputTool.R() != null && !this.l.Y() && this.w != null) {
            if (z2) {
                this.l.R().requestFocus();
            }
            if (!this.l.R().hasFocus()) {
                return;
            }
            boolean z3 = false;
            z3 = (i2 == 3 || i2 == 2) ? true : true;
            if (i2 != 2 && i2 != 3 && (TextUtils.isEmpty(this.f) || !"/".equals(this.f))) {
                this.w.s(null);
                return;
            }
            w98 w98Var = this.n;
            if (w98Var != null && w98Var.H() && this.K == SourceType.TWO) {
                return;
            }
            this.w.v(null, i2, Boolean.valueOf(z3));
        }
    }

    public void R0(List<InputBoxHandler.PaddingContent> list) {
        String type;
        InputBoxHandler.AtData atData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048610, this, list) == null) && !list.isEmpty()) {
            this.P.clear();
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
                    this.P.add(new AtSelectData(str, atData.getAtName(), BIMManager.getBdUidFromBdUK(atData.getAtBaiduUk())));
                }
            }
        }
    }

    public void k1(@Nullable e0 e0Var) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, e0Var) == null) {
            V0(true, false, e0Var);
            a2();
            v0();
            s0();
            y1(false);
            GroupChatFragment groupChatFragment = this.k;
            if (groupChatFragment != null) {
                long i2 = groupChatFragment.i2();
                long g2 = this.k.g2();
                StatisticItem param = new StatisticItem("c15134").param("obj_type", 2).param("fid", g2).param("fname", this.k.h2()).param("room_id", i2);
                BotsDTO.BotListDTO.UserDTO userDTO = this.F;
                if (userDTO != null) {
                    str = BIMManager.getBdUidFromBdUK(userDTO.getUk());
                } else {
                    str = "";
                }
                TiebaStatic.log(param.param("obj_id", str).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
            u98 u98Var = this.m;
            if (u98Var != null) {
                u98Var.G();
            }
        }
    }

    public void q1(ea5 ea5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048663, this, ea5Var) == null) && ea5Var != null && ea5Var.c() != null && ea5Var.c().p() != null && this.A != null) {
            Activity pageActivity = this.i.getPageActivity();
            if (this.t == null || this.A.g() == null) {
                PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
                this.t = permissionJudgePolicy;
                this.A.r(permissionJudgePolicy);
            }
            this.t.clearRequestPermissionList();
            this.t.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.t.startRequestPermission(pageActivity)) {
                return;
            }
            it5.b(new c(this, ea5Var), new d(this));
        }
    }

    public void S1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z2) == null) {
            this.s = z2;
            if (this.j != null) {
                if (o65.m().i("key_group_chat_chatroom_audio_switch", true)) {
                    this.j.setToolEnabled(z2, 6);
                }
                this.j.C(new se5(72, 3, Boolean.valueOf(z2)));
                if (this.j.p(37) != null && (this.j.p(37).m instanceof EmotionNoLaunchView)) {
                    ((EmotionNoLaunchView) this.j.p(37).m).setEnabled(z2);
                }
                if (o65.m().i("key_group_chat_chatroom_picture_switch", true) && this.j.p(38) != null && (this.j.p(38).m instanceof SendNoLaunchView)) {
                    ((SendNoLaunchView) this.j.p(38).m).setIconEnable(z2);
                    ((SendNoLaunchView) this.j.p(38).m).setSendInterceptToastText(this.r, z2);
                }
            }
            u98 u98Var = this.m;
            if (u98Var != null) {
                u98Var.K(z2);
            }
            GroupInputTool groupInputTool = this.l;
            if (groupInputTool != null && groupInputTool.H() != null && this.l.H().g() != null) {
                if (z2) {
                    this.l.H().g().setEnabled(true);
                    this.l.H().g().setOnClickListener(new f(this));
                    return;
                }
                this.l.H().g().setEnabled(false);
            }
        }
    }

    public final void z1(GroupInputTool groupInputTool) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048681, this, groupInputTool) == null) && groupInputTool != null && this.A != null) {
            this.l = groupInputTool;
            this.w = groupInputTool.L();
            if (groupInputTool.T() != null && groupInputTool.I() != null) {
                this.x = new ga8(groupInputTool.T(), this.k, groupInputTool.I());
            }
            if (groupInputTool.S() != null && groupInputTool.I() != null) {
                this.y = new fa8(groupInputTool.S(), this.k, groupInputTool.I());
            }
            MessageManager.getInstance().registerListener(this.Z);
            Y0();
            b1();
            a1();
            Z0();
            if (groupInputTool.R() != null) {
                this.A.q(groupInputTool);
                R1(groupInputTool.R());
                if (groupInputTool.G() != null) {
                    K1(groupInputTool.G());
                }
                if (this.p != 0 && !qi.isEmpty(TbSingleton.getInstance().getRoomDraft(Long.valueOf(this.p)))) {
                    v1(TbSingleton.getInstance().getRoomDraft(Long.valueOf(this.p)));
                }
                u98 u98Var = this.m;
                if (u98Var != null) {
                    u98Var.J(groupInputTool, this.j);
                    this.m.B();
                }
            }
        }
    }

    public final void T1(BotsDTO.BotListDTO.SkillDTO skillDTO, boolean z2, boolean z3) {
        BotsDTO.BotListDTO.SkillDTO skillDTO2;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048615, this, new Object[]{skillDTO, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            if (skillDTO != null) {
                skillDTO2 = skillDTO.copy();
            } else {
                skillDTO2 = null;
            }
            if (this.l != null && skillDTO2 != null) {
                boolean z5 = false;
                int i2 = 1;
                if (this.K == SourceType.TWO) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                this.l.C(true);
                this.l.D(!z4);
                String str = "";
                if (skillDTO2.getKeyboard() == 1) {
                    if (!TextUtils.isEmpty(skillDTO2.getKeyboardContent())) {
                        B1(skillDTO2.getKeyboardContent());
                    } else {
                        B1("");
                    }
                    if (!TextUtils.isEmpty(skillDTO2.getExp())) {
                        C1(skillDTO2.getExp());
                    } else if (z4) {
                        C1(this.i.getString(R.string.obfuscated_res_0x7f0f0916));
                    }
                    N1(1, !TextUtils.isEmpty(this.f));
                    F1(false);
                    G1(false);
                    D1(false);
                    this.l.j0(new r(this));
                    if (this.l.R() != null) {
                        GroupInputTool groupInputTool = this.l;
                        if (skillDTO2.getKeyboardType() == 1) {
                            z5 = true;
                        }
                        groupInputTool.e0(z5);
                        this.l.R().l();
                    }
                    V1(skillDTO2.getItems(), z3);
                } else {
                    if (this.l.R() != null) {
                        this.l.R().q();
                    }
                    this.l.j0(new s(this));
                    W1(skillDTO2.getItems(), z3);
                }
                GroupChatFragment groupChatFragment = this.k;
                if (groupChatFragment != null) {
                    long i22 = groupChatFragment.i2();
                    long g2 = this.k.g2();
                    String h2 = this.k.h2();
                    StatisticItem param = new StatisticItem("c15134").param("obj_type", 1).param("obj_name", skillDTO2.getName());
                    if (this.K == SourceType.TWO) {
                        i2 = 2;
                    }
                    StatisticItem param2 = param.param("obj_source", i2).param("fid", g2).param("fname", h2).param("room_id", i22);
                    BotsDTO.BotListDTO.UserDTO userDTO = this.F;
                    if (userDTO != null) {
                        str = BIMManager.getBdUidFromBdUK(userDTO.getUk());
                    }
                    TiebaStatic.log(param2.param("obj_id", str).param("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        }
    }

    public final void V0(boolean z2, boolean z3, @Nullable e0 e0Var) {
        GroupChatFragment groupChatFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048618, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3), e0Var}) == null) && this.n != null && (groupChatFragment = this.k) != null) {
            groupChatFragment.z2(true);
            this.k.G2();
            this.n.B(new u(this, z2, z3, e0Var));
        }
    }

    public void d0(@NonNull AtSelectData atSelectData, boolean z2, boolean z3) {
        u98 u98Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048634, this, new Object[]{atSelectData, Boolean.valueOf(z2), Boolean.valueOf(z3)}) != null) || (u98Var = this.m) == null) {
            return;
        }
        u98Var.G();
        this.m.l(atSelectData, false, z2, z3);
    }

    public final void V1(List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> list, boolean z2) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048619, this, list, z2) == null) && (groupInputTool = this.l) != null && groupInputTool.I() != null) {
            w98 w98Var = this.n;
            if (w98Var == null) {
                w98 w98Var2 = new w98(this.l.I(), this.V);
                this.n = w98Var2;
                w98Var2.C(list, B0(), z2);
            } else {
                w98Var.K(list, z2);
            }
            this.n.S(z2, !ListUtils.isEmpty(list));
        }
    }

    public final void g1(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048642, this, str, str2) == null) {
            Iterator<ImageFileInfo> it = this.c.getChosedFiles().iterator();
            long j2 = 0;
            while (it.hasNext()) {
                j2++;
                sg.a().postDelayed(new e(this, it.next(), str, str2), 100 * j2);
            }
            WriteImagesInfo writeImagesInfo = this.c;
            if (writeImagesInfo != null) {
                writeImagesInfo.clear();
            }
        }
    }

    public final void W1(List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> list, boolean z2) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048621, this, list, z2) == null) && (groupInputTool = this.l) != null && groupInputTool.I() != null && !ListUtils.isEmpty(list)) {
            w98 w98Var = this.n;
            if (w98Var == null) {
                w98 w98Var2 = new w98(this.l.I(), this.V);
                this.n = w98Var2;
                w98Var2.C(list, B0(), z2);
            } else {
                w98Var.K(list, z2);
            }
            this.n.U(new t(this), this.X, z2);
        }
    }

    public void c2(@NonNull String str, @NonNull z98 z98Var) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048633, this, str, z98Var) != null) || StringUtils.isNull(str)) {
            return;
        }
        Bitmap reSizeBitmap = PicManager.getInstance().getReSizeBitmap(ki.d().c(str));
        if (reSizeBitmap != null) {
            cn cnVar = new cn(reSizeBitmap, false);
            int r2 = cnVar.r();
            i3 = cnVar.m();
            i2 = r2;
        } else {
            i2 = 0;
            i3 = 0;
        }
        BIMManager.genBosObjectUrl(this.b, str, WordCommandManager.IMAGE_JPEG, "jpg", 12, i2, i3, new l(this, z98Var, str));
    }

    @NonNull
    public final Map<String, Integer> h0(@NonNull String str, @NonNull List<AtSelectData> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048643, this, str, list)) == null) {
            HashMap hashMap = new HashMap();
            for (AtSelectData atSelectData : list) {
                int A0 = A0(str, atSelectData, hashMap, str.indexOf("@" + atSelectData.getNameShow()));
                if (A0 >= 0) {
                    hashMap.put(atSelectData.getUid(), Integer.valueOf(A0));
                }
            }
            return hashMap;
        }
        return (Map) invokeLL.objValue;
    }

    public final void Z1(int i2, String str, String str2, String str3, String str4, String str5, String str6, IUploadTransferListener iUploadTransferListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048627, this, new Object[]{Integer.valueOf(i2), str, str2, str3, str4, str5, str6, iUploadTransferListener}) == null) {
            new AsyncUploadTask(this.b, i2, str, str2, str3, str4, str5, str6, iUploadTransferListener).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    public final void a2() {
        GroupChatFragment groupChatFragment;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048629, this) == null) && (groupChatFragment = this.k) != null) {
            long i2 = groupChatFragment.i2();
            long g2 = this.k.g2();
            String h2 = this.k.h2();
            int i3 = 2;
            StatisticItem param = new StatisticItem("c15134").param("obj_type", 2);
            if (this.K == SourceType.ONE) {
                i3 = 1;
            }
            StatisticItem param2 = param.param("obj_source", i3);
            BotsDTO.BotListDTO.SkillDTO skillDTO = this.I;
            if (skillDTO != null) {
                str = skillDTO.getName();
            } else {
                str = StringUtil.NULL_STRING;
            }
            StatisticItem param3 = param2.param("obj_name", str).param("fid", g2).param("fname", h2).param("room_id", i2);
            BotsDTO.BotListDTO.UserDTO userDTO = this.F;
            if (userDTO != null) {
                str2 = BIMManager.getBdUidFromBdUK(userDTO.getUk());
            } else {
                str2 = "";
            }
            TiebaStatic.log(param3.param("obj_id", str2).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void i1(int i2, int i3, @Nullable Intent intent) {
        v98 v98Var;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048646, this, i2, i3, intent) == null) && i3 == -1 && intent != null && (v98Var = this.A) != null) {
            v98Var.k(i2, i3, intent);
            if (i2 != 12010 && i2 != 12009 && i2 != 12002) {
                if (i2 == 12004) {
                    boolean booleanExtra = intent.getBooleanExtra(IntentConfig.IS_AT_SELECT_BOT_DATA, false);
                    intent.getStringExtra(AtListActivityConfig.CALL_AT_LIST_SOURCE);
                    ArrayList<AtSelectData> parcelableArrayListExtra = intent.getParcelableArrayListExtra(IntentConfig.AT_SELECT_LIST_DATA);
                    u98 u98Var = this.m;
                    if (u98Var != null && parcelableArrayListExtra != null) {
                        u98Var.N(parcelableArrayListExtra);
                        this.m.H(parcelableArrayListExtra, true);
                    }
                    if (this.w != null && booleanExtra) {
                        q0(false, 2);
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
            LocalPicModel localPicModel = this.d;
            if (localPicModel != null) {
                localPicModel.cancelLoadData();
                this.d = null;
            }
            String stringExtra2 = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra2 != null) {
                this.c.parseJson(stringExtra2);
                WriteImagesInfo writeImagesInfo = this.c;
                if (writeImagesInfo != null && !ListUtils.isEmpty(writeImagesInfo.getChosedFiles())) {
                    g1(str, stringExtra);
                    return;
                }
                LocalPicModel localPicModel2 = new LocalPicModel(str, stringExtra, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                this.d = localPicModel2;
                localPicModel2.setLoadDataCallBack(this.Y);
                this.d.getData();
                return;
            }
            LocalPicModel localPicModel3 = new LocalPicModel(str, stringExtra, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
            this.d = localPicModel3;
            localPicModel3.setLoadDataCallBack(this.Y);
            this.d.getData();
        }
    }

    public final void o1(boolean z2, boolean z3) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048658, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) && this.l != null) {
            if (!this.M) {
                s0();
            }
            boolean z4 = false;
            this.M = false;
            this.l.k0(false);
            this.l.e0(false);
            if (this.K == SourceType.TWO) {
                z4 = true;
            }
            if (z4 && !z3) {
                str = this.g;
            } else {
                str = this.f;
            }
            this.f = str;
            this.h = "";
            if (TextUtils.isEmpty(str)) {
                N1(2, true);
            } else {
                N1(3, true);
            }
            F1(true);
            G1(true);
            D1(true);
            if (this.l.R() != null && z2) {
                this.l.R().m();
            }
            if (this.K == SourceType.ONE && !TextUtils.isEmpty(this.B)) {
                C1(this.B);
            } else if (z4) {
                if (!z3 && !TextUtils.isEmpty(this.f)) {
                    B1(this.f);
                }
                if (!TextUtils.isEmpty(this.B)) {
                    C1(this.B);
                } else {
                    C1(this.i.getString(R.string.im_msg_input_hint));
                }
            }
        }
    }

    public final void r1() {
        List<AtSelectData> list;
        Map<String, Integer> map;
        int i2;
        String str;
        BotsDTO.BotListDTO.SkillDTO skillDTO;
        int i3;
        String str2;
        String str3;
        List<AtSelectData> t2;
        Map<String, Integer> n2;
        long j2;
        List<AtSelectData> list2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048665, this) == null) {
            if (!this.s) {
                g0();
                EditorTools editorTools = this.j;
                if (editorTools != null) {
                    editorTools.r();
                }
            } else if (this.v != null) {
                L1();
                v78 v78Var = this.E;
                if (v78Var != null) {
                    v78Var.a = this.F;
                    v78Var.b = this.I;
                    v78Var.c = this.G;
                }
                if (this.m != null) {
                    if (d1() && (list2 = this.P) != null && list2.size() > 0) {
                        t2 = this.P;
                        this.f = X1();
                    } else {
                        t2 = this.m.t();
                    }
                    List<AtSelectData> list3 = t2;
                    if (d1() && this.m.s() != null) {
                        n2 = h0(this.f, this.P);
                    } else {
                        this.m.y();
                        n2 = this.m.n();
                    }
                    if (!ListUtils.isEmpty(this.m.t())) {
                        StatisticItem statisticItem = new StatisticItem("c15128");
                        GroupChatFragment groupChatFragment = this.k;
                        long j3 = 0;
                        if (groupChatFragment != null) {
                            j2 = groupChatFragment.g2();
                        } else {
                            j2 = 0;
                        }
                        StatisticItem param = statisticItem.param("fid", j2);
                        GroupChatFragment groupChatFragment2 = this.k;
                        if (groupChatFragment2 != null) {
                            j3 = groupChatFragment2.i2();
                        }
                        TiebaStatic.log(param.param("room_id", j3).param("uid", TbadkCoreApplication.getCurrentAccount()));
                    }
                    map = n2;
                    list = list3;
                } else {
                    list = null;
                    map = null;
                }
                if (this.J != null && this.k != null && (skillDTO = this.I) != null && skillDTO.getName() != null) {
                    long i22 = this.k.i2();
                    long g2 = this.k.g2();
                    String h2 = this.k.h2();
                    StatisticItem param2 = new StatisticItem("c15134").param("obj_type", 3);
                    if (this.K == SourceType.ONE) {
                        i3 = 1;
                    } else {
                        i3 = 2;
                    }
                    StatisticItem param3 = param2.param("obj_source", i3);
                    BotsDTO.BotListDTO.SkillDTO skillDTO2 = this.I;
                    if (skillDTO2 != null) {
                        str2 = skillDTO2.getName();
                    } else {
                        str2 = StringUtil.NULL_STRING;
                    }
                    StatisticItem param4 = param3.param("obj_name", str2).param("fid", g2).param("fname", h2).param("room_id", i22);
                    BotsDTO.BotListDTO.UserDTO userDTO = this.F;
                    if (userDTO == null) {
                        str3 = "";
                    } else {
                        str3 = BIMManager.getBdUidFromBdUK(userDTO.getUk());
                    }
                    TiebaStatic.log(param4.param("obj_id", str3).param("uid", TbadkCoreApplication.getCurrentAccount()));
                }
                if (e1()) {
                    i2 = 1;
                } else if (d1()) {
                    i2 = 4;
                } else if (this.E != null) {
                    if (this.D == null) {
                        i2 = 2;
                    } else {
                        i2 = 3;
                    }
                } else {
                    i2 = 0;
                }
                if (!sb8.a(this.G)) {
                    this.O = true;
                    return;
                }
                aa8 aa8Var = this.v;
                String str4 = this.f;
                if (str4 == null) {
                    str = "";
                } else {
                    str = str4;
                }
                aa8Var.f(str, this.D, this.E, list, map, i2);
                g0();
                u98 u98Var = this.m;
                if (u98Var != null) {
                    u98Var.G();
                }
            }
        }
    }
}
