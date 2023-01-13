package com.baidu.tieba.imMessageCenter.chatgroup.grouppage.inputTool;

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
import androidx.fragment.app.FragmentActivity;
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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PicManager;
import com.baidu.tbadk.core.util.StatisticItem;
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
import com.baidu.tieba.a75;
import com.baidu.tieba.bc5;
import com.baidu.tieba.bh;
import com.baidu.tieba.cz4;
import com.baidu.tieba.dk5;
import com.baidu.tieba.dl5;
import com.baidu.tieba.im.chat.AbsMsglistView;
import com.baidu.tieba.im.chat.ISendVoiceView;
import com.baidu.tieba.im.model.LocalPicModel;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.GroupChatFragment;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.itemdata.BaseImageMsg;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.itemdata.TextGenImageMsg;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.itemdata.VoiceMsg;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.inputTool.GroupInputTool;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.inputTool.robotfloor.GroupChatRobotTopHeadView;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.repo.entity.BotsDTO;
import com.baidu.tieba.jn;
import com.baidu.tieba.k75;
import com.baidu.tieba.l75;
import com.baidu.tieba.ll7;
import com.baidu.tieba.ml7;
import com.baidu.tieba.nj;
import com.baidu.tieba.nl7;
import com.baidu.tieba.ol7;
import com.baidu.tieba.pl7;
import com.baidu.tieba.r25;
import com.baidu.tieba.r9;
import com.baidu.tieba.si;
import com.baidu.tieba.tl5;
import com.baidu.tieba.v01;
import com.baidu.tieba.vj7;
import com.baidu.tieba.xk7;
import com.baidu.tieba.yi;
import com.baidu.tieba.z65;
import com.baidu.tieba.zi;
import com.baidu.tieba.zk5;
import com.baidu.tieba.zy8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class GroupInputViewController implements VoiceManager.j, LifecycleObserver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseMsg A;
    public xk7 B;
    public BotsDTO.BotListDTO.UserDTO C;
    public ArrayList<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> D;
    public List<BotsDTO.BotListDTO.SkillDTO> E;
    public BotsDTO.BotListDTO.SkillDTO F;
    public GroupChatRobotTopHeadView G;
    public SourceType H;
    public final CustomMessageListener I;
    public a75 J;
    public final r9 K;
    public GroupInputTool.j L;
    public vj7 M;
    public final CustomMessageListener N;
    public ToolState a;
    public Context b;
    public WriteImagesInfo c;
    public LocalPicModel d;
    public View e;
    public String f;
    public String g;
    public TbPageContext h;
    public EditorTools i;
    public VoiceManager j;
    public GroupChatFragment k;
    public GroupInputTool l;
    public ll7 m;
    public ml7 n;
    public ISendVoiceView o;
    public Long p;
    public boolean q;
    public String r;
    public boolean s;
    public PermissionJudgePolicy t;
    public boolean u;
    @Nullable
    public t v;
    public pl7 w;
    public ml7.j x;
    public String y;
    public int z;

    /* loaded from: classes4.dex */
    public interface t {
        void a(@NonNull String str, @NonNull String str2, @NonNull Map<String, Object> map);

        void b(@NonNull String str, @Nullable BaseMsg baseMsg, @Nullable xk7 xk7Var, @Nullable List<AtSelectData> list, @Nullable Map<String, Integer> map);

        void c(@NonNull String str, int i);

        void d(@NonNull String str, @NonNull String str2);
    }

    /* loaded from: classes4.dex */
    public interface u {
        void a(int i, int i2, String str);

        void b(int i);

        void c(int i, String str, String str2);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
        }
    }

    public boolean N(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048592, this, i2, i3)) == null) ? i2 > 1 && i2 > i3 : invokeII.booleanValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i c1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    /* loaded from: classes4.dex */
    public class c implements pl7.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        /* loaded from: classes4.dex */
        public class a implements pl7.d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // com.baidu.tieba.pl7.d
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.y0(SourceType.ONE, false);
                }
            }
        }

        public c(GroupInputViewController groupInputViewController) {
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

        @Override // com.baidu.tieba.pl7.f
        public void a(BotsDTO.BotListDTO.UserDTO userDTO, BotsDTO.BotListDTO.SkillDTO skillDTO) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, userDTO, skillDTO) == null) && userDTO != null && skillDTO != null) {
                this.a.G0(userDTO, skillDTO);
                this.a.R();
                this.a.s0(true);
                if (this.a.X() != null) {
                    this.a.X().n(new a(this));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements IGenBosObjectUrlListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u a;
        public final /* synthetic */ BaseImageMsg b;
        public final /* synthetic */ GroupInputViewController c;

        /* loaded from: classes4.dex */
        public class a implements IUploadTransferListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ d b;

            public a(d dVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = dVar;
                this.a = str;
            }

            @Override // com.baidu.android.imsdk.upload.IUploadTransferListener
            public void onFailed(int i, int i2, String str) {
                u uVar;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, str) == null) && (uVar = this.b.a) != null) {
                    uVar.a(i, i2, str);
                }
            }

            @Override // com.baidu.android.imsdk.upload.IUploadTransferListener
            public void onFinished(int i, String str) {
                u uVar;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) && (uVar = this.b.a) != null) {
                    uVar.c(i, str, this.a);
                }
            }

            @Override // com.baidu.android.imsdk.upload.IUploadTransferListener
            public void onProgress(int i) {
                u uVar;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (uVar = this.b.a) != null) {
                    uVar.b(i);
                }
            }
        }

        public d(GroupInputViewController groupInputViewController, u uVar, BaseImageMsg baseImageMsg) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController, uVar, baseImageMsg};
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
            this.a = uVar;
            this.b = baseImageMsg;
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
                    if (yi.isEmpty(str4) || yi.isEmpty(str5) || yi.isEmpty(str6)) {
                        u uVar = this.a;
                        if (uVar != null) {
                            uVar.a(i, 1, this.b.getThumbUrl());
                            return;
                        }
                        return;
                    }
                    this.c.Q0(1, str4, str5, this.b.getThumbUrl(), "image/jpeg", str2, str3, new a(this, str6));
                } else if (this.a != null && this.b.getThumbUrl() != null) {
                    this.a.a(i, 1, this.b.getThumbUrl());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class q implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageFileInfo a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ GroupInputViewController d;

        /* loaded from: classes4.dex */
        public class a extends zk5<Object> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ q a;

            public a(q qVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {qVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = qVar;
            }

            @Override // com.baidu.tieba.zk5
            public Object doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    q qVar = this.a;
                    qVar.d.P(qVar.a);
                    return null;
                }
                return invokeV.objValue;
            }
        }

        /* loaded from: classes4.dex */
        public class b implements dk5<Object> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ q a;

            public b(q qVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {qVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = qVar;
            }

            @Override // com.baidu.tieba.dk5
            public void onReturnDataInUI(Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                    if (this.a.a.isGif()) {
                        this.a.d.d = new LocalPicModel(null, TbConfig.IMAGE_RESIZED_FILE, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                    } else {
                        q qVar = this.a;
                        qVar.d.d = new LocalPicModel(qVar.b, qVar.c, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                    }
                    this.a.d.d.setLoadDataCallBack(this.a.d.K);
                    this.a.d.d.getData();
                }
            }
        }

        public q(GroupInputViewController groupInputViewController, ImageFileInfo imageFileInfo, String str, String str2) {
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
                dl5.b(new a(this), new b(this));
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class SourceType {
        public static final /* synthetic */ SourceType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final SourceType ONE;
        public static final SourceType TWO;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2110499831, "Lcom/baidu/tieba/imMessageCenter/chatgroup/grouppage/inputTool/GroupInputViewController$SourceType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2110499831, "Lcom/baidu/tieba/imMessageCenter/chatgroup/grouppage/inputTool/GroupInputViewController$SourceType;");
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

    /* loaded from: classes4.dex */
    public class a implements vj7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        @Override // com.baidu.tieba.vj7
        public void setRecoding(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            }
        }

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

        @Override // com.baidu.tieba.vj7
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.j != null && this.a.W().f()) {
                    if (this.a.k == null) {
                        return true;
                    }
                    FragmentActivity fragmentActivity = this.a.k.getFragmentActivity();
                    if (this.a.t == null) {
                        this.a.t = new PermissionJudgePolicy();
                    }
                    this.a.t.clearRequestPermissionList();
                    this.a.t.appendRequestPermission(fragmentActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    this.a.t.appendRequestPermission(fragmentActivity, PermissionRequest.RESOURCE_AUDIO_CAPTURE);
                    return !this.a.t.startRequestPermission(fragmentActivity);
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.vj7
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.W() != null) {
                this.a.W().cancelRecord();
            }
        }

        @Override // com.baidu.tieba.vj7
        public boolean isForeground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.a.q;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.vj7
        public void stopRecord() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.a.W() != null) {
                this.a.W().stopRecord();
            }
        }

        @Override // com.baidu.tieba.vj7
        public void startRecord() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.a.W() != null) {
                this.a.W().c(this.a.l, -1);
                this.a.W().d(nj.c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(GroupInputViewController groupInputViewController, int i) {
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean) || !((Boolean) customResponsedMessage.getData()).booleanValue() || !this.a.u) {
                return;
            }
            this.a.u = false;
            this.a.l.G().requestFocus();
            if (this.a.L()) {
                return;
            }
            this.a.M();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements GroupChatRobotTopHeadView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        public e(GroupInputViewController groupInputViewController) {
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

        @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.inputTool.robotfloor.GroupChatRobotTopHeadView.b
        public void onCloseEvent() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.k0();
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.n != null) {
                if (this.a.n.z()) {
                    this.a.n.s();
                    return;
                }
                this.a.Z(false);
                this.a.R0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        public g(GroupInputViewController groupInputViewController) {
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
                if (this.a.n == null || !this.a.n.z()) {
                    this.a.a0(true, false);
                    this.a.R0();
                    return;
                }
                this.a.n.s();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements ml7.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

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

        @Override // com.baidu.tieba.ml7.i
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.o0();
            this.a.a0(true, true);
        }
    }

    /* loaded from: classes4.dex */
    public class i extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ GroupInputViewController c;

        public i(GroupInputViewController groupInputViewController, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController, Boolean.valueOf(z), Boolean.valueOf(z2)};
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
            this.a = z;
            this.b = z2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.c.m0(this.a, this.b);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.c.m0(this.a, this.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static /* synthetic */ class j {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(175174254, "Lcom/baidu/tieba/imMessageCenter/chatgroup/grouppage/inputTool/GroupInputViewController$j;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(175174254, "Lcom/baidu/tieba/imMessageCenter/chatgroup/grouppage/inputTool/GroupInputViewController$j;");
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

    /* loaded from: classes4.dex */
    public class k implements ml7.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        public k(GroupInputViewController groupInputViewController) {
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

        @Override // com.baidu.tieba.ml7.j
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZ(1048576, this, z) != null) {
                return;
            }
            this.a.I0(z);
        }
    }

    /* loaded from: classes4.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(GroupInputViewController groupInputViewController, int i) {
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
                GroupInputViewController groupInputViewController = this.a;
                if (booleanValue) {
                    toolState = ToolState.VOICE;
                } else {
                    toolState = ToolState.TEXT;
                }
                groupInputViewController.a = toolState;
                if (this.a.m != null) {
                    this.a.m.C(this.a.a);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m implements a75 {
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

        @Override // com.baidu.tieba.a75
        public void A(z65 z65Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, z65Var) != null) || z65Var == null) {
                return;
            }
            int i = z65Var.a;
            if (i == 24) {
                Object obj = z65Var.c;
                if (obj instanceof r25) {
                    r25 r25Var = (r25) obj;
                    if (r25Var.getType() != EmotionGroupType.LOCAL) {
                        this.a.n0(r25Var);
                    }
                }
            } else if (i != 8) {
                if (i == 4) {
                    Object obj2 = z65Var.c;
                    if (obj2 instanceof String) {
                        this.a.f = (String) obj2;
                        this.a.M();
                    }
                } else if (i != 14) {
                    if (i != 17) {
                        if (i == 62) {
                            boolean booleanValue = ((Boolean) z65Var.c).booleanValue();
                            if (this.a.l == null) {
                                return;
                            }
                            if (booleanValue) {
                                this.a.X().n(null);
                                return;
                            }
                            this.a.l.G().requestFocus();
                            this.a.M();
                        } else if (i == 63) {
                            boolean booleanValue2 = ((Boolean) z65Var.c).booleanValue();
                            if (this.a.l == null) {
                                return;
                            }
                            this.a.l.O(false);
                            if (booleanValue2) {
                                this.a.X().n(null);
                                return;
                            }
                            this.a.l.G().requestFocus();
                            this.a.M();
                        }
                    }
                } else {
                    this.a.l0();
                }
            } else {
                this.a.o0();
                this.a.Z(true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n extends r9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        public n(GroupInputViewController groupInputViewController) {
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

        @Override // com.baidu.tieba.r9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (obj instanceof LocalPicModel.ResponseData) {
                    LocalPicModel.ResponseData responseData = (LocalPicModel.ResponseData) obj;
                    String str = responseData.getBitmap().getWidth() + "," + responseData.getBitmap().getHeight();
                    if (responseData.getExtraMap() != null) {
                        this.a.v.a(responseData.getSPathGen(), str, responseData.getExtraMap());
                        return;
                    } else {
                        this.a.v.d(responseData.getSPathGen(), str);
                        return;
                    }
                }
                this.a.k.showToast(TbadkCoreApplication.getInst().getString(R.string.pic_parser_error));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o extends zk5<Map<String, Object>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r25 a;
        public final /* synthetic */ GroupInputViewController b;

        public o(GroupInputViewController groupInputViewController, r25 r25Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController, r25Var};
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
            this.a = r25Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zk5
        /* renamed from: a */
        public Map<String, Object> doInBackground() {
            InterceptResult invokeV;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                String d = bc5.b.d(this.a.d(), true);
                boolean exists = new File(d).exists();
                if (!exists) {
                    d = d.replace(".gif", ".jpg");
                }
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setFilePath(d);
                imageFileInfo.setIsGif(exists);
                this.b.P(imageFileInfo);
                String b = bc5.b.b(this.a.d());
                int i = j.a[this.a.getType().ordinal()];
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
                hashMap.put("meme_id", b);
                hashMap.put("meme_type", str);
                return hashMap;
            }
            return (Map) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class p implements dk5<Map<String, Object>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        public p(GroupInputViewController groupInputViewController) {
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
        @Override // com.baidu.tieba.dk5
        /* renamed from: a */
        public void onReturnDataInUI(Map<String, Object> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, map) == null) {
                this.a.d = new LocalPicModel(null, TbConfig.IMAGE_RESIZED_FILE, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                this.a.d.setExtraMap(map);
                this.a.d.setLoadDataCallBack(this.a.K);
                this.a.d.getData();
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.l.O(false);
                this.a.u = true;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class s implements GroupInputTool.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.inputTool.GroupInputTool.j
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

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

        @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.inputTool.GroupInputTool.j
        public void b(VoiceData.VoiceModel voiceModel) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voiceModel) == null) && voiceModel != null && !StringUtils.isNull(voiceModel.getVoiceId()) && this.a.v != null) {
                this.a.v.c(voiceModel.getVoiceId(), voiceModel.getDuration());
            }
        }
    }

    public GroupInputViewController(GroupChatFragment groupChatFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {groupChatFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new WriteImagesInfo(1);
        this.d = null;
        this.i = null;
        this.o = null;
        this.s = true;
        this.x = new k(this);
        this.y = null;
        this.B = new xk7();
        this.D = new ArrayList<>();
        this.G = null;
        this.I = new l(this, 2921790);
        this.J = new m(this);
        this.K = new n(this);
        this.L = new s(this);
        this.M = new a(this);
        this.N = new b(this, 2921785);
        this.k = groupChatFragment;
        this.h = groupChatFragment.getPageContext();
        this.b = groupChatFragment.getContext();
        f0();
        b0();
        MessageManager.getInstance().registerListener(this.I);
    }

    public void A0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.i.o(6) != null) {
            if (!z) {
                this.i.o(6).hide();
            } else {
                this.i.o(6).display();
            }
        }
    }

    public void C0(GroupInputTool.h hVar) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hVar) == null) && (groupInputTool = this.l) != null) {
            groupInputTool.V(hVar);
        }
    }

    public void D0(Long l2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, l2) == null) {
            this.p = l2;
        }
    }

    public void E0(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            this.e = view2;
        }
    }

    public void K0(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, editorTools) == null) {
            this.i = editorTools;
        }
    }

    public final void Q(@NonNull List<BotsDTO.BotListDTO.SkillDTO> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, list) == null) {
            for (BotsDTO.BotListDTO.SkillDTO skillDTO : list) {
                if (skillDTO != null && skillDTO.getType() == this.z) {
                    this.F = skillDTO;
                    return;
                }
            }
        }
    }

    public final void Z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            a0(false, z);
        }
    }

    public void j0(@NonNull Bundle bundle) {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048622, this, bundle) == null) && (voiceManager = this.j) != null) {
            voiceManager.onSaveInstanceState(this.h.getPageActivity());
        }
    }

    public void p0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, str) == null) {
            this.y = str;
        }
    }

    public void q0(@Nullable t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, tVar) == null) {
            this.v = tVar;
        }
    }

    public final void s0(boolean z) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048631, this, z) != null) || (groupInputTool = this.l) == null) {
            return;
        }
        if (z) {
            groupInputTool.Q(1);
        } else {
            groupInputTool.Q(0);
        }
    }

    public void v0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, str) == null) {
            this.f = str;
            EditorTools editorTools = this.i;
            if (editorTools != null) {
                editorTools.C(new z65(6, 3, str));
            }
        }
    }

    public void w0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, str) == null) {
            this.r = str;
            EditorTools editorTools = this.i;
            if (editorTools != null) {
                editorTools.C(new z65(71, 3, str));
            }
        }
    }

    public void x0(boolean z) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048636, this, z) == null) && (groupInputTool = this.l) != null) {
            groupInputTool.R(z);
        }
    }

    public void G0(BotsDTO.BotListDTO.UserDTO userDTO, BotsDTO.BotListDTO.SkillDTO skillDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, userDTO, skillDTO) == null) {
            this.C = userDTO;
            this.F = skillDTO;
        }
    }

    public void T0(@NonNull VoiceMsg voiceMsg, @NonNull nl7 nl7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048605, this, voiceMsg, nl7Var) == null) {
            String path = voiceMsg.getPath();
            ol7 ol7Var = new ol7(this.b, voiceMsg, path, "audio/amr");
            ol7Var.b(nl7Var);
            BIMManager.audioTrans(this.b, path, "audio/amr", "amr", 12, ol7Var);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            VoiceManager voiceManager = this.j;
            if (voiceManager != null) {
                voiceManager.onDestory(this.h);
            }
            ll7 ll7Var = this.m;
            if (ll7Var != null) {
                ll7Var.w();
            }
            ml7 ml7Var = this.n;
            if (ml7Var != null) {
                ml7Var.B();
            }
            MessageManager.getInstance().unRegisterListener(this.N);
            MessageManager.getInstance().unRegisterListener(this.I);
        }
    }

    public final boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ll7 ll7Var = this.m;
            if (ll7Var == null || v01.h(ll7Var.s()) != 1 || !this.m.s().get(0).isRobot()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, this) == null) {
            this.q = false;
            VoiceManager voiceManager = this.j;
            if (voiceManager != null) {
                voiceManager.onPause();
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, this) == null) {
            this.q = true;
            VoiceManager voiceManager = this.j;
            if (voiceManager != null) {
                voiceManager.onResume(this.h);
                this.j.setSpeakerphoneOn(true ^ TbadkCoreApplication.getInst().isHeadsetModeOn());
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, this) == null) {
            if (V() != null && V().B()) {
                return;
            }
            TbSingleton.getInstance().setRoomDraft(this.p, U());
        }
    }

    public void F0() {
        ml7 ml7Var;
        ArrayList<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (ml7Var = this.n) != null && (arrayList = (ArrayList) ml7Var.r()) != null) {
            this.D = arrayList;
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            R();
            O();
            H0(2, true);
            z0(true);
            A0(true);
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.B.a();
            this.D.clear();
            this.C = null;
            this.F = null;
            this.A = null;
        }
    }

    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.f = null;
            EditorTools editorTools = this.i;
            if (editorTools != null) {
                editorTools.C(new z65(9, -1, Boolean.TRUE));
            }
        }
    }

    public a75 T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.J;
        }
        return (a75) invokeV.objValue;
    }

    public GroupInputTool V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.l;
        }
        return (GroupInputTool) invokeV.objValue;
    }

    public zy8 W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            VoiceManager voiceManager = this.j;
            if (voiceManager != null && voiceManager.getRecorderManager() != null) {
                return this.j.getRecorderManager();
            }
            return null;
        }
        return (zy8) invokeV.objValue;
    }

    public pl7 X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.w;
        }
        return (pl7) invokeV.objValue;
    }

    public SourceType Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.H;
        }
        return (SourceType) invokeV.objValue;
    }

    public final void b0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048613, this) == null) && this.m == null) {
            this.m = new ll7(this.b, this.k);
        }
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            ISendVoiceView iSendVoiceView = this.o;
            if (iSendVoiceView != null) {
                iSendVoiceView.setTouchCallBack(this.M);
            }
            GroupInputTool groupInputTool = this.l;
            if (groupInputTool != null) {
                groupInputTool.W(this.L);
            }
        }
    }

    public final void d0() {
        pl7 pl7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048616, this) == null) && (pl7Var = this.w) != null) {
            pl7Var.m(new c(this));
        }
    }

    public final GroupChatRobotTopHeadView e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            GroupInputTool groupInputTool = this.l;
            if (groupInputTool == null) {
                return null;
            }
            GroupChatRobotTopHeadView F = groupInputTool.F();
            this.G = F;
            F.setEventCallback(new e(this));
            return this.G;
        }
        return (GroupChatRobotTopHeadView) invokeV.objValue;
    }

    public final void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            if (this.j == null) {
                VoiceManager voiceManager = new VoiceManager();
                this.j = voiceManager;
                voiceManager.onCreate(this.h);
            }
            this.j.setSpeakerphoneOn(!TbadkCoreApplication.getInst().isHeadsetModeOn());
            VoiceManager.setIsUseMediaPlayer(true);
        }
    }

    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            if (FileHelper.checkSD()) {
                return true;
            }
            zi.Q(this.b, TbadkCoreApplication.getInst().getString(R.string.voice_error_sdcard));
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return this.j;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public final void B0(boolean z, String str) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, str) == null) && (editorTools = this.i) != null && editorTools.p(38) != null && (this.i.p(38).m instanceof SendNoLaunchView)) {
            ((SendNoLaunchView) this.i.p(38).m).setPicIconEnable(z);
            ((SendNoLaunchView) this.i.p(38).m).setSendInterceptToastText(str, z);
        }
    }

    public final void O0(List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> list, boolean z) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048595, this, list, z) == null) && (groupInputTool = this.l) != null && groupInputTool.y() != null) {
            ml7 ml7Var = this.n;
            if (ml7Var == null) {
                ml7 ml7Var2 = new ml7(this.l.y(), this.x);
                this.n = ml7Var2;
                ml7Var2.v(list, z);
            } else {
                ml7Var.A(list, z);
            }
            this.n.F(z, !ListUtils.isEmpty(list));
        }
    }

    public final void P0(List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> list, boolean z) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048597, this, list, z) == null) && (groupInputTool = this.l) != null && groupInputTool.y() != null && !ListUtils.isEmpty(list)) {
            ml7 ml7Var = this.n;
            if (ml7Var == null) {
                ml7 ml7Var2 = new ml7(this.l.y(), this.x);
                this.n = ml7Var2;
                ml7Var2.v(list, z);
            } else {
                ml7Var.A(list, z);
            }
            this.n.H(new h(this), z);
        }
    }

    public final void a0(boolean z, boolean z2) {
        GroupChatFragment groupChatFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && this.n != null && (groupChatFragment = this.k) != null) {
            groupChatFragment.g2();
            this.n.u(new i(this, z, z2));
        }
    }

    public final void h0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048620, this, str, str2) == null) {
            Iterator<ImageFileInfo> it = this.c.getChosedFiles().iterator();
            long j2 = 0;
            while (it.hasNext()) {
                j2++;
                bh.a().postDelayed(new q(this, it.next(), str, str2), 100 * j2);
            }
            WriteImagesInfo writeImagesInfo = this.c;
            if (writeImagesInfo != null) {
                writeImagesInfo.clear();
            }
        }
    }

    public void y0(SourceType sourceType, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048637, this, sourceType, z) == null) {
            ml7 ml7Var = this.n;
            if (ml7Var != null && ml7Var.y()) {
                return;
            }
            this.H = sourceType;
            GroupChatFragment groupChatFragment = this.k;
            if (groupChatFragment != null) {
                groupChatFragment.a2();
            }
            if (this.H == SourceType.TWO) {
                this.g = this.f;
            }
            N0(this.F, z);
        }
    }

    public void H0(int i2, boolean z) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && (groupInputTool = this.l) != null && groupInputTool.D() != null && (this.l.D().m instanceof SendNoLaunchView)) {
            if (i2 == 1) {
                ((SendNoLaunchView) this.l.D().m).setIsSendIcon(true);
                ((SendNoLaunchView) this.l.D().m).setSendVisibility(z);
            } else if (i2 == 2) {
                ((SendNoLaunchView) this.l.D().m).setIsSendIcon(false);
                ((SendNoLaunchView) this.l.D().m).setSendVisibility(false);
            } else if (i2 == 3) {
                ((SendNoLaunchView) this.l.D().m).setIsSendIcon(false);
                ((SendNoLaunchView) this.l.D().m).setSendVisibility(true);
            }
        }
    }

    public final void I0(boolean z) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) != null) || this.G == null || !z) {
            return;
        }
        BotsDTO.BotListDTO.UserDTO userDTO = this.C;
        String str3 = null;
        if (userDTO != null) {
            str = userDTO.getPortrait();
            str2 = this.C.getNameShow();
        } else {
            str = null;
            str2 = null;
        }
        BotsDTO.BotListDTO.SkillDTO skillDTO = this.F;
        if (skillDTO != null) {
            str3 = skillDTO.getName();
        }
        this.G.setData(str, str2, str3);
        this.G.setVisibility(0);
    }

    public final void M0(boolean z) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048591, this, z) == null) && (editorTools = this.i) != null) {
            if (editorTools.p(6) != null && !z) {
                this.i.p(6).f = R.color.CAM_X0109;
                this.i.p(6).k = false;
                return;
            }
            this.i.p(6).f = R.color.CAM_X0105;
            this.i.p(6).k = true;
        }
    }

    public void J0(int i2, @NonNull BaseMsg baseMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i2, baseMsg) == null) {
            ml7 ml7Var = this.n;
            if (ml7Var != null && ml7Var.y()) {
                return;
            }
            this.z = i2;
            this.A = baseMsg;
            S(baseMsg);
            if (this.E == null) {
                this.E = new ArrayList();
            }
            this.E.clear();
            BaseMsg baseMsg2 = this.A;
            if (baseMsg2 instanceof TextGenImageMsg) {
                TextGenImageMsg textGenImageMsg = (TextGenImageMsg) baseMsg2;
                if (textGenImageMsg.getSubSkillConfig() != null && textGenImageMsg.getSubSkillConfig().a != null) {
                    this.E.addAll(textGenImageMsg.getSubSkillConfig().a);
                    Q(this.E);
                }
            }
        }
    }

    public void S0(BaseImageMsg<?> baseImageMsg, @NonNull u uVar) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048603, this, baseImageMsg, uVar) == null) && baseImageMsg != null && baseImageMsg.getThumbUrl() != null) {
            Bitmap reSizeBitmap = PicManager.getInstance().getReSizeBitmap(si.d().c(baseImageMsg.getThumbUrl()));
            if (reSizeBitmap != null) {
                jn jnVar = new jn(reSizeBitmap, false);
                int r2 = jnVar.r();
                i3 = jnVar.m();
                i2 = r2;
            } else {
                i2 = 0;
                i3 = 0;
            }
            BIMManager.genBosObjectUrl(this.b, baseImageMsg.getThumbUrl(), "image/jpeg", "jpg", 12, i2, i3, new d(this, uVar, baseImageMsg));
        }
    }

    public void L0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.s = z;
            if (this.i != null) {
                if (cz4.l().i("key_group_chat_chatroom_audio_switch", true)) {
                    this.i.setToolEnabled(z, 6);
                }
                this.i.C(new z65(72, 3, Boolean.valueOf(z)));
                if (this.i.p(37) != null && (this.i.p(37).m instanceof EmotionNoLaunchView)) {
                    ((EmotionNoLaunchView) this.i.p(37).m).setEnabled(z);
                }
                if (cz4.l().i("key_group_chat_chatroom_picture_switch", true) && this.i.p(38) != null && (this.i.p(38).m instanceof SendNoLaunchView)) {
                    ((SendNoLaunchView) this.i.p(38).m).setIconEnable(z);
                    ((SendNoLaunchView) this.i.p(38).m).setSendInterceptToastText(this.r, z);
                }
            }
            ll7 ll7Var = this.m;
            if (ll7Var != null) {
                ll7Var.D(z);
            }
            GroupInputTool groupInputTool = this.l;
            if (groupInputTool != null && groupInputTool.x() != null && this.l.x().g() != null) {
                if (z) {
                    this.l.x().g().setEnabled(true);
                    this.l.x().g().setOnClickListener(new r(this));
                    return;
                }
                this.l.x().g().setEnabled(false);
            }
        }
    }

    public final void M() {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (groupInputTool = this.l) != null && this.w != null && !groupInputTool.J()) {
            if (this.l.G() == null || this.l.G().hasFocus()) {
                if (!TextUtils.isEmpty(this.f) && this.f.equals("/")) {
                    this.w.q(null, 1);
                } else {
                    this.w.n(null);
                }
            }
        }
    }

    public String U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            EditorTools editorTools = this.i;
            if (editorTools == null) {
                return "";
            }
            k75 p2 = editorTools.p(3);
            String str = TbEnum.ChatInputStatus.INPUT_STATUS_TEXT;
            if (p2 != null) {
                l75 l75Var = p2.m;
                if ((l75Var instanceof View) && ((View) l75Var).getVisibility() != 0) {
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

    public final void l0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048624, this) != null) || !g0()) {
            return;
        }
        EditorTools editorTools = this.i;
        if (editorTools != null) {
            editorTools.r();
        }
        this.c.mIsFromIm = true;
        AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.b, this.c.toJsonString(), true, false);
        albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
        albumFloatActivityConfig.setResourceType(1);
        albumFloatActivityConfig.setCanEditImage(false);
        albumFloatActivityConfig.setCanSelectGif(false);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
    }

    public final void N0(BotsDTO.BotListDTO.SkillDTO skillDTO, boolean z) {
        BotsDTO.BotListDTO.SkillDTO skillDTO2;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048593, this, skillDTO, z) == null) {
            if (skillDTO != null) {
                skillDTO2 = skillDTO.copy();
            } else {
                skillDTO2 = null;
            }
            if (this.l != null && skillDTO2 != null) {
                int i2 = 1;
                if (this.H == SourceType.TWO) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.l.U(z);
                this.l.q(true);
                this.l.t(!z2);
                if (skillDTO2.getKeyboard() == 1) {
                    if (z2) {
                        this.g = this.f;
                        v0("");
                    }
                    if (!TextUtils.isEmpty(skillDTO2.getExp())) {
                        w0(skillDTO2.getExp());
                    } else if (z2) {
                        w0(this.h.getString(R.string.obfuscated_res_0x7f0f0867));
                    }
                    H0(1, !TextUtils.isEmpty(this.f));
                    z0(false);
                    A0(false);
                    x0(false);
                    this.l.T(new f(this));
                    if (this.l.G() != null) {
                        this.l.G().l();
                    }
                    O0(skillDTO2.getItems(), z2);
                } else {
                    if (this.l.G() != null) {
                        this.l.G().q();
                    }
                    this.l.T(new g(this));
                    P0(skillDTO2.getItems(), z2);
                }
                GroupChatFragment groupChatFragment = this.k;
                if (groupChatFragment != null) {
                    long X1 = groupChatFragment.X1();
                    long V1 = this.k.V1();
                    String W1 = this.k.W1();
                    StatisticItem param = new StatisticItem("c15134").param("obj_type", 1).param("obj_name", skillDTO2.getName());
                    if (this.H == SourceType.TWO) {
                        i2 = 2;
                    }
                    TiebaStatic.log(param.param("obj_source", i2).param("fid", V1).param("fname", W1).param("room_id", X1).param("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        }
    }

    public final void P(ImageFileInfo imageFileInfo) {
        Bitmap resizeBitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, imageFileInfo) == null) {
            try {
                if (imageFileInfo.isGif()) {
                    FileHelper.saveGifByRelativePath(imageFileInfo.getFilePath(), null, TbConfig.IMAGE_RESIZED_FILE);
                    FileHelper.saveGifByRelativePath(imageFileInfo.getFilePath(), null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                    return;
                }
                Bitmap c2 = tl5.c(0, this.b, null, imageFileInfo.getFilePath(), TbImageHelper.getInstance().getPostImageSize());
                if (c2 != null && FileHelper.saveBitmapByRelativelyPath(null, TbConfig.IMAGE_RESIZED_FILE, c2, 85) != null && (resizeBitmap = BitmapHelper.resizeBitmap(c2, 100)) != null) {
                    FileHelper.saveBitmapByRelativelyPath(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 85);
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public final void S(BaseMsg baseMsg) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, baseMsg) == null) && baseMsg != null && baseMsg.getCommonMsgField() != null) {
            BotsDTO.BotListDTO.UserDTO userDTO = new BotsDTO.BotListDTO.UserDTO();
            this.C = userDTO;
            userDTO.setName(baseMsg.getCommonMsgField().getUserName());
            this.C.setNameShow(baseMsg.getCommonMsgField().getUserName());
            this.C.setPortrait(baseMsg.getCommonMsgField().getPortrait());
            this.C.setUk(BIMManager.getBdUKFromBdUid(String.valueOf(baseMsg.getCommonMsgField().getUserId())));
        }
    }

    public void n0(r25 r25Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048626, this, r25Var) == null) && r25Var != null && r25Var.c() != null && r25Var.c().p() != null) {
            Activity pageActivity = this.h.getPageActivity();
            if (this.t == null) {
                this.t = new PermissionJudgePolicy();
            }
            this.t.clearRequestPermissionList();
            this.t.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.t.startRequestPermission(pageActivity)) {
                return;
            }
            dl5.b(new o(this, r25Var), new p(this));
        }
    }

    public void r0(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048630, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString(TbEnum.ChatInputStatus.INPUT_DRAFT_KEY);
            if (this.i != null) {
                this.i.C(new z65(6, 3, string));
            }
            this.f = string;
            if (jSONObject.getString(TbEnum.ChatInputStatus.INPUT_STATUS_KEY).equals(TbEnum.ChatInputStatus.INPUT_STATUS_VOICE) && this.i != null) {
                this.i.C(new z65(1, 6, null));
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void z0(boolean z) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048638, this, z) == null) && (groupInputTool = this.l) != null && groupInputTool.u() != null && (this.l.u().m instanceof EmotionNoLaunchView)) {
            ((EmotionNoLaunchView) this.l.u().m).setNeedHideForever(z);
            if (!z) {
                this.l.u().m.hide();
            } else {
                this.l.u().m.display();
            }
        }
    }

    public final void Q0(int i2, String str, String str2, String str3, String str4, String str5, String str6, IUploadTransferListener iUploadTransferListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Integer.valueOf(i2), str, str2, str3, str4, str5, str6, iUploadTransferListener}) == null) {
            new AsyncUploadTask(this.b, i2, str, str2, str3, str4, str5, str6, iUploadTransferListener).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    public final void R0() {
        GroupChatFragment groupChatFragment;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && (groupChatFragment = this.k) != null) {
            long X1 = groupChatFragment.X1();
            long V1 = this.k.V1();
            String W1 = this.k.W1();
            int i2 = 2;
            StatisticItem param = new StatisticItem("c15134").param("obj_type", 2);
            if (this.H == SourceType.ONE) {
                i2 = 1;
            }
            StatisticItem param2 = param.param("obj_source", i2);
            BotsDTO.BotListDTO.SkillDTO skillDTO = this.F;
            if (skillDTO != null) {
                str = skillDTO.getName();
            } else {
                str = StringUtil.NULL_STRING;
            }
            TiebaStatic.log(param2.param("obj_name", str).param("fid", V1).param("fname", W1).param("room_id", X1).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            a0(true, false);
            R0();
            R();
            O();
            s0(false);
            GroupChatFragment groupChatFragment = this.k;
            if (groupChatFragment != null) {
                long X1 = groupChatFragment.X1();
                long V1 = this.k.V1();
                TiebaStatic.log(new StatisticItem("c15134").param("obj_type", 2).param("fid", V1).param("fname", this.k.W1()).param("room_id", X1).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
            ll7 ll7Var = this.m;
            if (ll7Var != null) {
                ll7Var.A();
            }
        }
    }

    public void i0(int i2, int i3, @Nullable Intent intent) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIIL(1048621, this, i2, i3, intent) != null) || i3 != -1 || intent == null) {
            return;
        }
        if (i2 != 12010 && i2 != 12009 && i2 != 12002) {
            if (i2 == 12004) {
                boolean booleanExtra = intent.getBooleanExtra(IntentConfig.IS_AT_SELECT_BOT_DATA, false);
                ArrayList<AtSelectData> parcelableArrayListExtra = intent.getParcelableArrayListExtra(IntentConfig.AT_SELECT_LIST_DATA);
                if (this.m != null && !ListUtils.isEmpty(parcelableArrayListExtra)) {
                    this.m.F(parcelableArrayListExtra);
                    this.m.B(parcelableArrayListExtra);
                }
                pl7 pl7Var = this.w;
                if (pl7Var != null && booleanExtra) {
                    pl7Var.q(null, 2);
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
                h0(str, stringExtra);
                return;
            }
            LocalPicModel localPicModel2 = new LocalPicModel(str, stringExtra, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
            this.d = localPicModel2;
            localPicModel2.setLoadDataCallBack(this.K);
            this.d.getData();
            return;
        }
        LocalPicModel localPicModel3 = new LocalPicModel(str, stringExtra, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
        this.d = localPicModel3;
        localPicModel3.setLoadDataCallBack(this.K);
        this.d.getData();
    }

    public final void m0(boolean z, boolean z2) {
        GroupInputTool groupInputTool;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048625, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && (groupInputTool = this.l) != null) {
            boolean z3 = false;
            groupInputTool.U(false);
            if (this.H == SourceType.TWO) {
                z3 = true;
            }
            if (z3 && !z2) {
                str = this.g;
            } else {
                str = this.f;
            }
            this.f = str;
            if (TextUtils.isEmpty(str)) {
                H0(2, true);
            } else {
                H0(3, true);
            }
            z0(true);
            A0(true);
            x0(true);
            if (this.l.G() != null && this.H == SourceType.TWO && z) {
                this.l.G().m();
            }
            if (this.H == SourceType.ONE && !TextUtils.isEmpty(this.y)) {
                w0(this.y);
            } else if (z3) {
                if (!z2 && !TextUtils.isEmpty(this.f)) {
                    v0(this.f);
                }
                if (!TextUtils.isEmpty(this.y)) {
                    w0(this.y);
                } else {
                    w0(this.h.getString(R.string.im_msg_input_hint));
                }
            }
        }
    }

    public final void o0() {
        List<AtSelectData> list;
        Map<String, Integer> map;
        GroupChatFragment groupChatFragment;
        int i2;
        String str;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            if (!this.s) {
                K();
                EditorTools editorTools = this.i;
                if (editorTools != null) {
                    editorTools.r();
                }
            } else if (this.v != null) {
                F0();
                xk7 xk7Var = this.B;
                if (xk7Var != null) {
                    xk7Var.a = this.C;
                    xk7Var.b = this.F;
                    xk7Var.c = this.D;
                }
                ll7 ll7Var = this.m;
                if (ll7Var != null) {
                    ll7Var.v();
                    List<AtSelectData> q2 = this.m.q();
                    Map<String, Integer> j3 = this.m.j();
                    if (!ListUtils.isEmpty(this.m.q())) {
                        StatisticItem statisticItem = new StatisticItem("c15128");
                        GroupChatFragment groupChatFragment2 = this.k;
                        long j4 = 0;
                        if (groupChatFragment2 != null) {
                            j2 = groupChatFragment2.V1();
                        } else {
                            j2 = 0;
                        }
                        StatisticItem param = statisticItem.param("fid", j2);
                        GroupChatFragment groupChatFragment3 = this.k;
                        if (groupChatFragment3 != null) {
                            j4 = groupChatFragment3.X1();
                        }
                        TiebaStatic.log(param.param("room_id", j4).param("uid", TbadkCoreApplication.getCurrentAccount()));
                    }
                    map = j3;
                    list = q2;
                } else {
                    list = null;
                    map = null;
                }
                if (this.G != null && (groupChatFragment = this.k) != null) {
                    long X1 = groupChatFragment.X1();
                    long V1 = this.k.V1();
                    String W1 = this.k.W1();
                    StatisticItem param2 = new StatisticItem("c15134").param("obj_type", 3);
                    if (this.H == SourceType.ONE) {
                        i2 = 1;
                    } else {
                        i2 = 2;
                    }
                    StatisticItem param3 = param2.param("obj_source", i2);
                    BotsDTO.BotListDTO.SkillDTO skillDTO = this.F;
                    if (skillDTO != null) {
                        str = skillDTO.getName();
                    } else {
                        str = StringUtil.NULL_STRING;
                    }
                    TiebaStatic.log(param3.param("obj_name", str).param("fid", V1).param("fname", W1).param("room_id", X1).param("uid", TbadkCoreApplication.getCurrentAccount()));
                }
                t tVar = this.v;
                String str2 = this.f;
                if (str2 == null) {
                    str2 = "";
                }
                tVar.b(str2, this.A, this.B, list, map);
                K();
                ll7 ll7Var2 = this.m;
                if (ll7Var2 != null) {
                    ll7Var2.A();
                }
            }
        }
    }

    public void u0(GroupInputTool groupInputTool) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048633, this, groupInputTool) != null) || groupInputTool == null) {
            return;
        }
        this.l = groupInputTool;
        this.w = groupInputTool.A();
        MessageManager.getInstance().registerListener(this.N);
        d0();
        e0();
        if (groupInputTool.G() != null) {
            K0(groupInputTool.G());
            EditorTools editorTools = this.i;
            if (editorTools != null) {
                editorTools.setActionListener(24, T());
                this.i.setActionListener(8, T());
                this.i.setActionListener(4, T());
                this.i.setActionListener(14, T());
                this.i.setActionListener(5, T());
                this.i.setActionListener(17, T());
                this.i.setActionListener(16, T());
                this.i.setActionListener(62, T());
                this.i.setActionListener(64, T());
                this.i.setActionListener(63, T());
            }
            if (groupInputTool.w() != null) {
                E0(groupInputTool.w());
            }
            if (groupInputTool.E() != null) {
                this.o = groupInputTool.E();
                c0();
            }
            M0(cz4.l().i("key_group_chat_chatroom_audio_switch", true));
            B0(cz4.l().i("key_group_chat_chatroom_picture_switch", true), this.b.getString(R.string.function_can_not_use));
            this.i.C(new z65(73, 3, 200));
            if (this.p.longValue() != 0 && !yi.isEmpty(TbSingleton.getInstance().getRoomDraft(this.p))) {
                r0(TbSingleton.getInstance().getRoomDraft(this.p));
            }
            ll7 ll7Var = this.m;
            if (ll7Var != null) {
                ll7Var.p(groupInputTool, this.i);
                this.m.x();
            }
        }
    }
}
