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
import com.baidu.tieba.a11;
import com.baidu.tieba.a6b;
import com.baidu.tieba.a78;
import com.baidu.tieba.a88;
import com.baidu.tieba.b88;
import com.baidu.tieba.bi;
import com.baidu.tieba.c68;
import com.baidu.tieba.c88;
import com.baidu.tieba.d88;
import com.baidu.tieba.e88;
import com.baidu.tieba.f55;
import com.baidu.tieba.f88;
import com.baidu.tieba.hi;
import com.baidu.tieba.i88;
import com.baidu.tieba.ii;
import com.baidu.tieba.im.chat.AbsMsglistView;
import com.baidu.tieba.im.model.LocalPicModel;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.GroupChatFragment;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.GroupInputTool;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.GroupInputViewController;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.GroupChatRobotTopHeadView;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.data.UserReplyInfoData;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.BotsDTO;
import com.baidu.tieba.j88;
import com.baidu.tieba.jd5;
import com.baidu.tieba.jg;
import com.baidu.tieba.k88;
import com.baidu.tieba.kd5;
import com.baidu.tieba.l98;
import com.baidu.tieba.n98;
import com.baidu.tieba.r98;
import com.baidu.tieba.ri5;
import com.baidu.tieba.rs5;
import com.baidu.tieba.tm;
import com.baidu.tieba.ud5;
import com.baidu.tieba.v85;
import com.baidu.tieba.vd5;
import com.baidu.tieba.vr5;
import com.baidu.tieba.w98;
import com.baidu.tieba.y88;
import com.baidu.tieba.z78;
import com.baidu.tieba.z8;
import com.baidu.tieba.z88;
import com.baidu.tieba.zq5;
import com.baidu.tieba.zr5;
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
/* loaded from: classes5.dex */
public class GroupInputViewController implements LifecycleObserver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public int B;
    public Object C;
    public c68 D;
    public BotsDTO.BotListDTO.UserDTO E;
    public List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> F;
    public List<BotsDTO.BotListDTO.SkillDTO> G;
    public BotsDTO.BotListDTO.SkillDTO H;
    public GroupChatRobotTopHeadView I;
    public SourceType J;
    @NonNull
    public n98 K;
    public boolean L;
    public boolean M;
    public boolean N;
    public final CustomMessageListener O;
    public final CustomMessageListener P;
    public kd5 Q;
    public b88.l R;
    public GroupInputTool.h S;
    public b88.k T;
    public final z8 U;
    public final CustomMessageListener V;
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
    public z78 m;
    public b88 n;
    public GroupInputTool o;
    public long p;
    public boolean q;
    public String r;
    public boolean s;
    public PermissionJudgePolicy t;
    public boolean u;
    @Nullable
    public f88 v;
    public j88 w;
    public k88 x;
    public i88 y;
    public a88 z;

    /* loaded from: classes5.dex */
    public interface a0 {
        void a();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65567, this) == null) {
        }
    }

    public boolean n0(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048641, this, i2, i3)) == null) ? i2 > 1 && i2 > i3 : invokeII.booleanValue;
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageFileInfo a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ GroupInputViewController d;

        /* loaded from: classes5.dex */
        public class a extends vr5<Object> {
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

            @Override // com.baidu.tieba.vr5
            public Object doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    c cVar = this.a;
                    cVar.d.p0(cVar.a);
                    return null;
                }
                return invokeV.objValue;
            }
        }

        /* loaded from: classes5.dex */
        public class b implements zq5<Object> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public b(c cVar) {
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

            @Override // com.baidu.tieba.zq5
            public void onReturnDataInUI(Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                    if (this.a.a.isGif()) {
                        this.a.d.d = new LocalPicModel(null, TbConfig.IMAGE_RESIZED_FILE, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                    } else {
                        c cVar = this.a;
                        cVar.d.d = new LocalPicModel(cVar.b, cVar.c, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                    }
                    this.a.d.d.setLoadDataCallBack(this.a.d.U);
                    this.a.d.d.getData();
                }
            }
        }

        public c(GroupInputViewController groupInputViewController, ImageFileInfo imageFileInfo, String str, String str2) {
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
                zr5.b(new a(this), new b(this));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements j88.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        /* loaded from: classes5.dex */
        public class a implements j88.d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

            public a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = fVar;
            }

            @Override // com.baidu.tieba.j88.d
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.s1(SourceType.ONE, false, false);
                }
            }
        }

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

        @Override // com.baidu.tieba.j88.f
        public void a(BotsDTO.BotListDTO.UserDTO userDTO, BotsDTO.BotListDTO.SkillDTO skillDTO) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, userDTO, skillDTO) == null) && userDTO != null && skillDTO != null) {
                this.a.z1(userDTO, skillDTO);
                this.a.e0();
                if (this.a.v != null) {
                    if (skillDTO.isFuncJump() && skillDTO.getAbilityItem() != null) {
                        this.a.v.m(skillDTO.getAbilityItem());
                        this.a.L0();
                        return;
                    } else if (skillDTO.isFuncSendMsg() && !TextUtils.isEmpty(userDTO.getUk())) {
                        this.a.v.i(userDTO.getUk(), skillDTO.getType());
                        this.a.D0().s(null);
                        this.a.L0();
                        return;
                    }
                }
                this.a.r0();
                this.a.m1(true);
                if (this.a.D0() != null) {
                    this.a.D0().s(new a(this));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements IGenBosObjectUrlListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e88 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ GroupInputViewController c;

        /* loaded from: classes5.dex */
        public class a implements IUploadTransferListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ h b;

            public a(h hVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = hVar;
                this.a = str;
            }

            @Override // com.baidu.android.imsdk.upload.IUploadTransferListener
            public void onFailed(int i, int i2, String str) {
                e88 e88Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, str) == null) && (e88Var = this.b.a) != null) {
                    e88Var.a(i, i2, str);
                }
            }

            @Override // com.baidu.android.imsdk.upload.IUploadTransferListener
            public void onFinished(int i, String str) {
                e88 e88Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) && (e88Var = this.b.a) != null) {
                    e88Var.c(i, str, this.a);
                }
            }

            @Override // com.baidu.android.imsdk.upload.IUploadTransferListener
            public void onProgress(int i) {
                e88 e88Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (e88Var = this.b.a) != null) {
                    e88Var.b(i);
                }
            }
        }

        public h(GroupInputViewController groupInputViewController, e88 e88Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController, e88Var, str};
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
            this.a = e88Var;
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
                    if (hi.isEmpty(str4) || hi.isEmpty(str5) || hi.isEmpty(str6)) {
                        e88 e88Var = this.a;
                        if (e88Var != null) {
                            e88Var.a(i, 1, this.b);
                            return;
                        }
                        return;
                    }
                    this.c.K1(1, str4, str5, this.b, "image/jpeg", str2, str3, new a(this, str6));
                    return;
                }
                this.a.a(i, 1, this.b);
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
    public class a extends vr5<Map<String, Object>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v85 a;
        public final /* synthetic */ GroupInputViewController b;

        public a(GroupInputViewController groupInputViewController, v85 v85Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController, v85Var};
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
            this.a = v85Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vr5
        /* renamed from: a */
        public Map<String, Object> doInBackground() {
            InterceptResult invokeV;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                String d = ri5.b.d(this.a.d(), true);
                boolean exists = new File(d).exists();
                if (!exists) {
                    d = d.replace(".gif", ".jpg");
                }
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setFilePath(d);
                imageFileInfo.setIsGif(exists);
                this.b.p0(imageFileInfo);
                String b = ri5.b.b(this.a.d());
                int i = r.a[this.a.getType().ordinal()];
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

    /* loaded from: classes5.dex */
    public class b implements zq5<Map<String, Object>> {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zq5
        /* renamed from: a */
        public void onReturnDataInUI(Map<String, Object> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, map) == null) {
                this.a.d = new LocalPicModel(null, TbConfig.IMAGE_RESIZED_FILE, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                this.a.d.setExtraMap(map);
                this.a.d.setLoadDataCallBack(this.a.U);
                this.a.d.getData();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.l.d0(false);
                this.a.u = true;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(GroupInputViewController groupInputViewController, int i) {
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
                    if (!this.a.h0()) {
                        this.a.m0(true, 1);
                    }
                }
                if (!booleanValue && this.a.y != null) {
                    this.a.y.k();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements k88.e {
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

        @Override // com.baidu.tieba.k88.e
        public void a(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) != null) || this.a.l == null) {
                return;
            }
            if (this.a.k != null) {
                this.a.k.u2();
            }
            GroupInputViewController groupInputViewController = this.a;
            groupInputViewController.q1(groupInputViewController.i.getString(R.string.im_msg_input_hint));
            this.a.r1(false);
            this.a.l.v(i, i2, j, animatorListenerAdapter, z);
        }

        @Override // com.baidu.tieba.k88.e
        public void b(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) != null) || this.a.l == null) {
                return;
            }
            if (this.a.k != null) {
                this.a.k.F2();
            }
            GroupInputViewController groupInputViewController = this.a;
            groupInputViewController.q1(groupInputViewController.A);
            this.a.r1(true);
            this.a.l.u(i, i2, j, animatorListenerAdapter, z);
        }

        @Override // com.baidu.tieba.k88.e
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.j0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements GroupChatRobotTopHeadView.b {
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

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.GroupChatRobotTopHeadView.b
        public void onCloseEvent() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a1(null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements k88.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SourceType a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ GroupInputViewController d;

        public j(GroupInputViewController groupInputViewController, SourceType sourceType, boolean z, boolean z2) {
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

        @Override // com.baidu.tieba.k88.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.d.H1(this.a, this.b, this.c);
        }
    }

    /* loaded from: classes5.dex */
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
                if (this.a.a != toolState) {
                    this.a.a = toolState;
                    if (this.a.m != null) {
                        this.a.m.G(this.a.a);
                    }
                    this.a.M1(booleanValue);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements a0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ GroupInputViewController b;

        public l(GroupInputViewController groupInputViewController, boolean z) {
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

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.GroupInputViewController.a0
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                GroupInputViewController groupInputViewController = this.b;
                groupInputViewController.G1(groupInputViewController.H, false, this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m implements j88.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ GroupInputViewController b;

        public m(GroupInputViewController groupInputViewController, boolean z) {
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

        @Override // com.baidu.tieba.j88.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                GroupInputViewController groupInputViewController = this.b;
                groupInputViewController.G1(groupInputViewController.H, false, this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.n != null) {
                if (!this.a.n.I()) {
                    this.a.M0(false);
                    this.a.r0();
                    this.a.L1();
                    return;
                }
                this.a.n.z();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        public o(GroupInputViewController groupInputViewController) {
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
                this.a.N0(true, false, null);
                this.a.L1();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p implements b88.j {
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

        @Override // com.baidu.tieba.b88.j
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.h1();
            if (this.a.N) {
                return;
            }
            this.a.N0(true, true, null);
        }
    }

    /* loaded from: classes5.dex */
    public class q extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ a0 c;
        public final /* synthetic */ GroupInputViewController d;

        public q(GroupInputViewController groupInputViewController, boolean z, boolean z2, a0 a0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController, Boolean.valueOf(z), Boolean.valueOf(z2), a0Var};
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
            this.c = a0Var;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, animator) != null) {
                return;
            }
            this.d.e1(this.a, this.b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) != null) {
                return;
            }
            this.d.e1(this.a, this.b);
            a0 a0Var = this.c;
            if (a0Var != null) {
                a0Var.a();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static /* synthetic */ class r {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1108333382, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/inputtool/GroupInputViewController$r;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1108333382, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/inputtool/GroupInputViewController$r;");
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

    /* loaded from: classes5.dex */
    public class s extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(GroupInputViewController groupInputViewController, int i) {
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
                this.a.M = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t implements kd5 {
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

        @Override // com.baidu.tieba.kd5
        public void C(jd5 jd5Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, jd5Var) != null) || jd5Var == null) {
                return;
            }
            int i = jd5Var.a;
            if (i == 24) {
                Object obj = jd5Var.c;
                if (obj instanceof v85) {
                    v85 v85Var = (v85) obj;
                    if (v85Var.getType() != EmotionGroupType.LOCAL) {
                        this.a.g1(v85Var);
                    }
                }
            } else if (i != 8) {
                if (i == 4) {
                    Object obj2 = jd5Var.c;
                    if (obj2 instanceof String) {
                        this.a.f = (String) obj2;
                        this.a.m0(false, 1);
                        this.a.y.m(100L);
                    }
                } else if (i != 14) {
                    if (i != 17) {
                        if (i == 62) {
                            boolean booleanValue = ((Boolean) jd5Var.c).booleanValue();
                            if (this.a.l == null) {
                                return;
                            }
                            if (!booleanValue) {
                                this.a.m0(true, 1);
                            } else {
                                this.a.k0();
                            }
                            if (this.a.l.Y() && this.a.C0() == ToolState.TEXT) {
                                this.a.w1(false);
                            }
                        } else if (i != 63 || this.a.l == null) {
                        } else {
                            this.a.l.d0(false);
                        }
                    }
                } else {
                    this.a.b1();
                }
            } else {
                this.a.h1();
                if (!this.a.N) {
                    this.a.M0(true);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u implements b88.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        public u(GroupInputViewController groupInputViewController) {
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

        @Override // com.baidu.tieba.b88.l
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZ(1048576, this, z) != null) {
                return;
            }
            this.a.C1(z);
        }
    }

    /* loaded from: classes5.dex */
    public class v implements j88.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserReplyInfoData a;
        public final /* synthetic */ GroupInputViewController b;

        public v(GroupInputViewController groupInputViewController, UserReplyInfoData userReplyInfoData) {
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

        @Override // com.baidu.tieba.j88.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.x.l(null, this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w implements a0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserReplyInfoData a;
        public final /* synthetic */ GroupInputViewController b;

        public w(GroupInputViewController groupInputViewController, UserReplyInfoData userReplyInfoData) {
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

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.GroupInputViewController.a0
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.x.l(null, this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class x implements GroupInputTool.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.GroupInputTool.h
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

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

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.GroupInputTool.h
        public void b(VoiceData.VoiceModel voiceModel) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voiceModel) == null) && voiceModel != null && !StringUtils.isNull(voiceModel.getVoiceId()) && this.a.v != null) {
                this.a.v.e(voiceModel.getVoiceId(), voiceModel.getDuration());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class y implements b88.k {
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

        @Override // com.baidu.tieba.b88.k
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
                this.a.k.A2();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class z extends z8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        public z(GroupInputViewController groupInputViewController) {
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

        @Override // com.baidu.tieba.z8
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (obj instanceof LocalPicModel.ResponseData) {
                    LocalPicModel.ResponseData responseData = (LocalPicModel.ResponseData) obj;
                    String str = responseData.getBitmap().getWidth() + "," + responseData.getBitmap().getHeight();
                    String sPathGen = responseData.getSPathGen();
                    if (this.a.V0() && this.a.n != null && !StringUtils.isNull(sPathGen)) {
                        this.a.n.L(sPathGen, str);
                        return;
                    } else if (responseData.getExtraMap() != null) {
                        this.a.v.b(responseData.getSPathGen(), str, responseData.getExtraMap());
                        return;
                    } else {
                        this.a.v.l(responseData.getSPathGen(), str);
                        return;
                    }
                }
                this.a.k.showToast(TbadkCoreApplication.getInst().getString(R.string.pic_parser_error));
            }
        }
    }

    public GroupInputViewController(GroupChatFragment groupChatFragment, long j2, a78 a78Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {groupChatFragment, Long.valueOf(j2), a78Var};
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
        this.A = null;
        this.D = new c68();
        this.F = new ArrayList();
        this.I = null;
        this.M = false;
        this.N = false;
        this.O = new k(this, 2921790);
        this.P = new s(this, 2921800);
        this.Q = new t(this);
        this.R = new u(this);
        this.S = new x(this);
        this.T = new y(this);
        this.U = new z(this);
        this.V = new e(this, 2921785);
        this.p = j2;
        this.k = groupChatFragment;
        this.i = groupChatFragment.getPageContext();
        this.b = groupChatFragment.getContext();
        this.o = new GroupInputTool(this.k);
        a88 a88Var = new a88(this.k);
        this.z = a88Var;
        a88Var.o(this.Q);
        this.K = new l98(this);
        this.y = new i88(this.k, new a6b() { // from class: com.baidu.tieba.y78
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.a6b
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? GroupInputViewController.this.X0() : invokeV.objValue;
            }
        }, a78Var);
        O0();
        n1(this.o);
        P0();
        MessageManager.getInstance().registerListener(this.O);
        MessageManager.getInstance().registerListener(this.P);
        b88 b88Var = this.n;
        if (b88Var != null) {
            b88Var.R(this.T);
        }
    }

    public void O1(@NonNull String str, @NonNull c88 c88Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048605, this, str, c88Var) == null) {
            d88 d88Var = new d88(this.b, str, "audio/amr");
            d88Var.b(c88Var);
            BIMManager.audioTrans(this.b, str, "audio/amr", "amr", 12, d88Var);
        }
    }

    public void c1(@NonNull UserReplyInfoData userReplyInfoData, @NonNull Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048620, this, userReplyInfoData, obj) == null) {
            this.C = obj;
            r0();
            l0(userReplyInfoData);
            d0(userReplyInfoData);
        }
    }

    public void z1(BotsDTO.BotListDTO.UserDTO userDTO, BotsDTO.BotListDTO.SkillDTO skillDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048667, this, userDTO, skillDTO) == null) {
            this.E = userDTO;
            this.H = skillDTO;
        }
    }

    public void B1(@Nullable f88 f88Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, f88Var) == null) {
            this.v = f88Var;
        }
    }

    public void E1(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, editorTools) == null) {
            this.j = editorTools;
        }
    }

    public final void M0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z2) == null) {
            N0(false, z2, null);
        }
    }

    public final void M1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z2) == null) {
            if (z2) {
                k0();
                w1(true);
                return;
            }
            m0(true, 1);
            w1(false);
        }
    }

    public void Z0(@NonNull Bundle bundle) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048616, this, bundle) == null) && (groupInputTool = this.o) != null) {
            groupInputTool.b0(bundle);
        }
    }

    public final void f1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z2) == null) {
            this.L = true;
            N0(true, false, new l(this, z2));
        }
    }

    public final void g0(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048627, this, z2) == null) && D0() != null) {
            D0().s(new m(this, z2));
        }
    }

    public void i1(BotsDTO botsDTO) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048632, this, botsDTO) == null) && (groupInputTool = this.l) != null) {
            groupInputTool.c0(botsDTO);
        }
    }

    public void j1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, str) == null) {
            this.A = str;
        }
    }

    public final void m1(boolean z2) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048640, this, z2) != null) || (groupInputTool = this.l) == null) {
            return;
        }
        if (z2) {
            groupInputTool.g0(1);
        } else {
            groupInputTool.g0(0);
        }
    }

    public void o1(String str) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048644, this, str) == null) && (editorTools = this.j) != null) {
            editorTools.C(new jd5(75, 3, str));
        }
    }

    public void onChangeSkinType(int i2) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048645, this, i2) == null) && (groupInputTool = this.o) != null) {
            groupInputTool.onChangeSkinType(i2);
        }
    }

    public void p1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, str) == null) {
            this.f = str;
            if (!TextUtils.isEmpty(str)) {
                this.h = str;
            }
            EditorTools editorTools = this.j;
            if (editorTools != null) {
                editorTools.C(new jd5(6, 3, str));
            }
        }
    }

    public final void q0(@NonNull List<BotsDTO.BotListDTO.SkillDTO> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, list) == null) {
            for (BotsDTO.BotListDTO.SkillDTO skillDTO : list) {
                if (skillDTO != null && skillDTO.getType() == this.B) {
                    this.H = skillDTO;
                    return;
                }
            }
        }
    }

    public void q1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048649, this, str) == null) {
            this.r = str;
            EditorTools editorTools = this.j;
            if (editorTools != null) {
                editorTools.C(new jd5(71, 3, StringHelper.cutChineseAndEnglishWithEmoji(str, 28, StringHelper.STRING_MORE)));
            }
        }
    }

    public void r1(boolean z2) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048651, this, z2) == null) && (groupInputTool = this.l) != null) {
            groupInputTool.h0(z2);
        }
    }

    public void u1(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048657, this, z2) == null) && this.j.o(6) != null) {
            if (!z2) {
                this.j.o(6).hide();
            } else {
                this.j.o(6).display();
            }
        }
    }

    public void v1(GroupInputTool.f fVar) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048659, this, fVar) == null) && (groupInputTool = this.l) != null) {
            groupInputTool.l0(fVar);
        }
    }

    public void x1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048663, this, view2) == null) {
            this.e = view2;
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65568, this) == null) {
            a88 a88Var = this.z;
            if (a88Var != null) {
                a88Var.l();
            }
            z78 z78Var = this.m;
            if (z78Var != null) {
                z78Var.y();
            }
            b88 b88Var = this.n;
            if (b88Var != null) {
                b88Var.M();
            }
            i88 i88Var = this.y;
            if (i88Var != null) {
                i88Var.o();
            }
            VoiceManager.setIsNeedBlackScreen(true);
            MessageManager.getInstance().unRegisterListener(this.V);
            MessageManager.getInstance().unRegisterListener(this.O);
            MessageManager.getInstance().unRegisterListener(this.P);
        }
    }

    public final void b1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048618, this) != null) || !T0()) {
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

    public final void e0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048623, this) == null) && this.E != null && this.H != null) {
            r98.f().h(r98.f().c(this.E.getUk(), this.H.getType(), this.E.getNameShow(), this.H.getName(), this.E.getPortrait(), this.H.getDesc(), this.H.getFuncType()));
        }
    }

    public String y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) {
            EditorTools editorTools = this.j;
            if (editorTools == null) {
                return "";
            }
            ud5 p2 = editorTools.p(3);
            String str = TbEnum.ChatInputStatus.INPUT_STATUS_TEXT;
            if (p2 != null) {
                vd5 vd5Var = p2.m;
                if ((vd5Var instanceof View) && ((View) vd5Var).getVisibility() != 0) {
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

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65569, this) == null) {
            this.q = false;
            a88 a88Var = this.z;
            if (a88Var != null) {
                a88Var.m();
                this.z.p(this.q);
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65570, this) == null) {
            this.q = true;
            a88 a88Var = this.z;
            if (a88Var != null) {
                a88Var.n();
                this.z.p(this.q);
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65571, this) == null) {
            if (B0() != null && B0().N()) {
                return;
            }
            TbSingleton.getInstance().setRoomDraft(Long.valueOf(this.p), y0());
        }
    }

    public String A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public GroupInputTool B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.l;
        }
        return (GroupInputTool) invokeV.objValue;
    }

    public ToolState C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a;
        }
        return (ToolState) invokeV.objValue;
    }

    public j88 D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.w;
        }
        return (j88) invokeV.objValue;
    }

    public b88 E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.n;
        }
        return (b88) invokeV.objValue;
    }

    public String F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
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

    public k88 G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.x;
        }
        return (k88) invokeV.objValue;
    }

    @Nullable
    public z88 H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return I0().f();
        }
        return (z88) invokeV.objValue;
    }

    @NonNull
    public n98 I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.K;
        }
        return (n98) invokeV.objValue;
    }

    @Nullable
    public VoiceManager J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            a88 a88Var = this.z;
            if (a88Var != null) {
                return a88Var.y0();
            }
            return null;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public SourceType K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.J;
        }
        return (SourceType) invokeV.objValue;
    }

    public void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            i88 i88Var = this.y;
            if (i88Var != null) {
                i88Var.k();
            }
            GroupInputTool groupInputTool = this.l;
            if (groupInputTool != null) {
                groupInputTool.U();
            }
        }
    }

    public final void O0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && this.m == null) {
            this.m = new z78(this.b, this.k);
        }
    }

    public final void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            a88 a88Var = this.z;
            if (a88Var != null) {
                a88Var.i();
            }
            GroupInputTool groupInputTool = this.l;
            if (groupInputTool != null) {
                groupInputTool.m0(this.S);
            }
        }
    }

    public final void Q0() {
        j88 j88Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && (j88Var = this.w) != null) {
            j88Var.r(new f(this));
        }
    }

    public final GroupChatRobotTopHeadView R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            GroupInputTool groupInputTool = this.l;
            if (groupInputTool == null) {
                return null;
            }
            GroupChatRobotTopHeadView R = groupInputTool.R();
            this.I = R;
            R.setEventCallback(new i(this));
            return this.I;
        }
        return (GroupChatRobotTopHeadView) invokeV.objValue;
    }

    public final void S0() {
        k88 k88Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048609, this) == null) && (k88Var = this.x) != null) {
            k88Var.i(new g(this));
        }
    }

    public boolean T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            if (FileHelper.checkSD()) {
                return true;
            }
            ii.Q(this.b, TbadkCoreApplication.getInst().getString(R.string.voice_error_sdcard));
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            k88 k88Var = this.x;
            if (k88Var != null && k88Var.e()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            GroupInputTool groupInputTool = this.l;
            if (groupInputTool != null && groupInputTool.N() && this.M) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public /* synthetic */ CharSequence X0() {
        return this.f;
    }

    public void d1() {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048622, this) == null) && (groupInputTool = this.l) != null) {
            groupInputTool.e0(false);
        }
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            r0();
            if (U0()) {
                j0();
            }
            o0();
            A1(2, true);
            t1(true);
            u1(true);
            this.N = false;
        }
    }

    public boolean i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            GroupInputTool groupInputTool = this.l;
            if (groupInputTool != null) {
                return groupInputTool.w();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void j0() {
        k88 k88Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048633, this) == null) && (k88Var = this.x) != null) {
            k88Var.j(null);
        }
    }

    public final void k0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048635, this) == null) && D0() != null) {
            D0().s(null);
        }
    }

    public final void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048643, this) == null) {
            this.D.a();
            this.F.clear();
            this.E = null;
            this.H = null;
            this.C = null;
        }
    }

    public void r0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048650, this) == null) {
            this.f = null;
            EditorTools editorTools = this.j;
            if (editorTools != null) {
                editorTools.C(new jd5(9, -1, Boolean.TRUE));
            }
        }
    }

    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048652, this) == null) {
            try {
                h1();
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    public void u0() {
        BotsDTO.BotListDTO.SkillDTO skillDTO;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048656, this) == null) && (skillDTO = this.H) != null && skillDTO.getItems() != null) {
            this.F.addAll(this.H.getItems());
        }
    }

    public z78 v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            return this.m;
        }
        return (z78) invokeV.objValue;
    }

    public GroupInputTool x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) {
            return this.o;
        }
        return (GroupInputTool) invokeV.objValue;
    }

    public void y1() {
        b88 b88Var;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048665, this) == null) && (b88Var = this.n) != null && b88Var.H() && (arrayList = (ArrayList) this.n.y()) != null) {
            this.F = arrayList;
        }
    }

    @NonNull
    public String z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) {
            if (TextUtils.isEmpty(this.f)) {
                return "";
            }
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public void A1(int i2, boolean z2) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) && (groupInputTool = this.l) != null && groupInputTool.O() != null && (this.l.O().m instanceof SendNoLaunchView)) {
            if (i2 == 1) {
                ((SendNoLaunchView) this.l.O().m).setIsSendIcon(true);
                ((SendNoLaunchView) this.l.O().m).setSendVisibility(z2);
            } else if (i2 == 2) {
                ((SendNoLaunchView) this.l.O().m).setIsSendIcon(false);
                ((SendNoLaunchView) this.l.O().m).setSendVisibility(false);
            } else if (i2 == 3) {
                ((SendNoLaunchView) this.l.O().m).setIsSendIcon(false);
                ((SendNoLaunchView) this.l.O().m).setSendVisibility(true);
            }
        }
    }

    public void m0(boolean z2, int i2) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048639, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) && (groupInputTool = this.l) != null && groupInputTool.S() != null && !this.l.Y() && this.w != null) {
            if (z2) {
                this.l.S().requestFocus();
            }
            if (!this.l.S().hasFocus()) {
                return;
            }
            boolean z3 = false;
            z3 = (i2 == 3 || i2 == 2) ? true : true;
            if (i2 != 2 && i2 != 3 && (TextUtils.isEmpty(this.f) || !"/".equals(this.f))) {
                this.w.s(null);
                return;
            }
            b88 b88Var = this.n;
            if (b88Var != null && b88Var.H() && this.J == SourceType.TWO) {
                return;
            }
            this.w.v(null, i2, Boolean.valueOf(z3));
        }
    }

    public final void C1(boolean z2) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048581, this, z2) != null) || this.I == null || !z2) {
            return;
        }
        BotsDTO.BotListDTO.UserDTO userDTO = this.E;
        String str3 = null;
        if (userDTO != null) {
            str = userDTO.getPortrait();
            str2 = this.E.getNameShow();
        } else {
            str = null;
            str2 = null;
        }
        BotsDTO.BotListDTO.SkillDTO skillDTO = this.H;
        if (skillDTO != null) {
            str3 = skillDTO.getName();
        }
        this.I.setData(str, str2, str3);
        this.I.setVisibility(0);
    }

    public void d0(@NonNull UserReplyInfoData userReplyInfoData) {
        z78 z78Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048621, this, userReplyInfoData) != null) || (z78Var = this.m) == null) {
            return;
        }
        z78Var.E();
        this.m.j(new AtSelectData(userReplyInfoData.getmPortrait(), userReplyInfoData.getmNameShow(), String.valueOf(userReplyInfoData.getmUid()), userReplyInfoData.isRobot()), false);
    }

    public final void w1(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048661, this, z2) == null) && G0() != null) {
            if (z2) {
                G0().k(false);
            } else if (!G0().g()) {
                G0().k(!z2);
            }
        }
    }

    public void D1(int i2, @NonNull Object obj, @NonNull c68 c68Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048583, this, i2, obj, c68Var) == null) {
            this.B = i2;
            this.C = obj;
            this.E = c68Var.a;
            if (this.G == null) {
                this.G = new ArrayList();
            }
            this.G.clear();
            BotsDTO.BotListDTO.SkillDTO skillDTO = c68Var.b;
            if (skillDTO != null && !ListUtils.isEmpty(skillDTO.getSubSkill())) {
                this.G.addAll(c68Var.b.getSubSkill());
                q0(this.G);
            }
            c68 c68Var2 = this.D;
            if (c68Var2 != null) {
                c68Var2.d(c68Var.c());
            }
        }
    }

    public final void H1(SourceType sourceType, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{sourceType, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            this.J = sourceType;
            GroupChatFragment groupChatFragment = this.k;
            if (groupChatFragment != null) {
                groupChatFragment.u2();
            }
            if (this.J == SourceType.TWO) {
                this.g = this.f;
                GroupInputTool groupInputTool = this.l;
                if (groupInputTool != null) {
                    if (groupInputTool.A()) {
                        g0(z3);
                        return;
                    } else if (this.l.N()) {
                        f1(z3);
                        return;
                    }
                }
            }
            G1(this.H, z2, z3);
        }
    }

    public void F1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z2) == null) {
            this.s = z2;
            if (this.j != null) {
                if (f55.m().i("key_group_chat_chatroom_audio_switch", true)) {
                    this.j.setToolEnabled(z2, 6);
                }
                this.j.C(new jd5(72, 3, Boolean.valueOf(z2)));
                if (this.j.p(37) != null && (this.j.p(37).m instanceof EmotionNoLaunchView)) {
                    ((EmotionNoLaunchView) this.j.p(37).m).setEnabled(z2);
                }
                if (f55.m().i("key_group_chat_chatroom_picture_switch", true) && this.j.p(38) != null && (this.j.p(38).m instanceof SendNoLaunchView)) {
                    ((SendNoLaunchView) this.j.p(38).m).setIconEnable(z2);
                    ((SendNoLaunchView) this.j.p(38).m).setSendInterceptToastText(this.r, z2);
                }
            }
            z78 z78Var = this.m;
            if (z78Var != null) {
                z78Var.I(z2);
            }
            GroupInputTool groupInputTool = this.l;
            if (groupInputTool != null && groupInputTool.I() != null && this.l.I().g() != null) {
                if (z2) {
                    this.l.I().g().setEnabled(true);
                    this.l.I().g().setOnClickListener(new d(this));
                    return;
                }
                this.l.I().g().setEnabled(false);
            }
        }
    }

    public final void G1(BotsDTO.BotListDTO.SkillDTO skillDTO, boolean z2, boolean z3) {
        BotsDTO.BotListDTO.SkillDTO skillDTO2;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{skillDTO, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            if (skillDTO != null) {
                skillDTO2 = skillDTO.copy();
            } else {
                skillDTO2 = null;
            }
            if (this.l != null && skillDTO2 != null) {
                boolean z5 = false;
                int i2 = 1;
                if (this.J == SourceType.TWO) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                this.l.D(true);
                this.l.E(!z4);
                String str = "";
                if (skillDTO2.getKeyboard() == 1) {
                    if (!TextUtils.isEmpty(skillDTO2.getKeyboardContent())) {
                        p1(skillDTO2.getKeyboardContent());
                    } else {
                        p1("");
                    }
                    if (!TextUtils.isEmpty(skillDTO2.getExp())) {
                        q1(skillDTO2.getExp());
                    } else if (z4) {
                        q1(this.i.getString(R.string.obfuscated_res_0x7f0f08a8));
                    }
                    A1(1, !TextUtils.isEmpty(this.f));
                    t1(false);
                    u1(false);
                    r1(false);
                    this.l.j0(new n(this));
                    if (this.l.S() != null) {
                        GroupInputTool groupInputTool = this.l;
                        if (skillDTO2.getKeyboardType() == 1) {
                            z5 = true;
                        }
                        groupInputTool.e0(z5);
                        this.l.S().l();
                    }
                    I1(skillDTO2.getItems(), z3);
                } else {
                    if (this.l.S() != null) {
                        this.l.S().q();
                    }
                    this.l.j0(new o(this));
                    J1(skillDTO2.getItems(), z3);
                }
                GroupChatFragment groupChatFragment = this.k;
                if (groupChatFragment != null) {
                    long h2 = groupChatFragment.h2();
                    long f2 = this.k.f2();
                    String g2 = this.k.g2();
                    StatisticItem param = new StatisticItem("c15134").param("obj_type", 1).param("obj_name", skillDTO2.getName());
                    if (this.J == SourceType.TWO) {
                        i2 = 2;
                    }
                    StatisticItem param2 = param.param("obj_source", i2).param("fid", f2).param("fname", g2).param("room_id", h2);
                    BotsDTO.BotListDTO.UserDTO userDTO = this.E;
                    if (userDTO != null) {
                        str = BIMManager.getBdUidFromBdUK(userDTO.getUk());
                    }
                    TiebaStatic.log(param2.param("obj_id", str).param("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        }
    }

    public final void I1(List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> list, boolean z2) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048593, this, list, z2) == null) && (groupInputTool = this.l) != null && groupInputTool.J() != null) {
            b88 b88Var = this.n;
            if (b88Var == null) {
                b88 b88Var2 = new b88(this.l.J(), this.R);
                this.n = b88Var2;
                b88Var2.C(list, w0(), z2);
            } else {
                b88Var.K(list, z2);
            }
            this.n.S(z2, !ListUtils.isEmpty(list));
        }
    }

    public final void W0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048613, this, str, str2) == null) {
            Iterator<ImageFileInfo> it = this.c.getChosedFiles().iterator();
            long j2 = 0;
            while (it.hasNext()) {
                j2++;
                jg.a().postDelayed(new c(this, it.next(), str, str2), 100 * j2);
            }
            WriteImagesInfo writeImagesInfo = this.c;
            if (writeImagesInfo != null) {
                writeImagesInfo.clear();
            }
        }
    }

    public final void J1(List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> list, boolean z2) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048595, this, list, z2) == null) && (groupInputTool = this.l) != null && groupInputTool.J() != null && !ListUtils.isEmpty(list)) {
            b88 b88Var = this.n;
            if (b88Var == null) {
                b88 b88Var2 = new b88(this.l.J(), this.R);
                this.n = b88Var2;
                b88Var2.C(list, w0(), z2);
            } else {
                b88Var.K(list, z2);
            }
            this.n.U(new p(this), this.T, z2);
        }
    }

    public void N1(@NonNull String str, @NonNull e88 e88Var) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048603, this, str, e88Var) != null) || StringUtils.isNull(str)) {
            return;
        }
        Bitmap reSizeBitmap = PicManager.getInstance().getReSizeBitmap(bi.d().c(str));
        if (reSizeBitmap != null) {
            tm tmVar = new tm(reSizeBitmap, false);
            int r2 = tmVar.r();
            i3 = tmVar.m();
            i2 = r2;
        } else {
            i2 = 0;
            i3 = 0;
        }
        BIMManager.genBosObjectUrl(this.b, str, "image/jpeg", "jpg", 12, i2, i3, new h(this, e88Var, str));
    }

    public final void K1(int i2, String str, String str2, String str3, String str4, String str5, String str6, IUploadTransferListener iUploadTransferListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i2), str, str2, str3, str4, str5, str6, iUploadTransferListener}) == null) {
            new AsyncUploadTask(this.b, i2, str, str2, str3, str4, str5, str6, iUploadTransferListener).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    public final void L1() {
        GroupChatFragment groupChatFragment;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && (groupChatFragment = this.k) != null) {
            long h2 = groupChatFragment.h2();
            long f2 = this.k.f2();
            String g2 = this.k.g2();
            int i2 = 2;
            StatisticItem param = new StatisticItem("c15134").param("obj_type", 2);
            if (this.J == SourceType.ONE) {
                i2 = 1;
            }
            StatisticItem param2 = param.param("obj_source", i2);
            BotsDTO.BotListDTO.SkillDTO skillDTO = this.H;
            if (skillDTO != null) {
                str = skillDTO.getName();
            } else {
                str = StringUtil.NULL_STRING;
            }
            StatisticItem param3 = param2.param("obj_name", str).param("fid", f2).param("fname", g2).param("room_id", h2);
            BotsDTO.BotListDTO.UserDTO userDTO = this.E;
            if (userDTO != null) {
                str2 = BIMManager.getBdUidFromBdUK(userDTO.getUk());
            } else {
                str2 = "";
            }
            TiebaStatic.log(param3.param("obj_id", str2).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public final void N0(boolean z2, boolean z3, @Nullable a0 a0Var) {
        GroupChatFragment groupChatFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3), a0Var}) == null) && this.n != null && (groupChatFragment = this.k) != null) {
            groupChatFragment.y2(true);
            this.k.F2();
            this.n.B(new q(this, z2, z3, a0Var));
        }
    }

    public void c0(@NonNull AtSelectData atSelectData, boolean z2, boolean z3) {
        z78 z78Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048619, this, new Object[]{atSelectData, Boolean.valueOf(z2), Boolean.valueOf(z3)}) != null) || (z78Var = this.m) == null) {
            return;
        }
        z78Var.E();
        this.m.k(atSelectData, false, z2, z3);
    }

    public void s1(SourceType sourceType, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048653, this, new Object[]{sourceType, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            if (U0()) {
                this.x.j(new j(this, sourceType, z2, z3));
            } else {
                H1(sourceType, z2, z3);
            }
        }
    }

    public void Y0(int i2, int i3, @Nullable Intent intent) {
        a88 a88Var;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048615, this, i2, i3, intent) == null) && i3 == -1 && intent != null && (a88Var = this.z) != null) {
            a88Var.k(i2, i3, intent);
            if (i2 != 12010 && i2 != 12009 && i2 != 12002) {
                if (i2 == 12004) {
                    boolean booleanExtra = intent.getBooleanExtra(IntentConfig.IS_AT_SELECT_BOT_DATA, false);
                    intent.getStringExtra(AtListActivityConfig.CALL_AT_LIST_SOURCE);
                    ArrayList<AtSelectData> parcelableArrayListExtra = intent.getParcelableArrayListExtra(IntentConfig.AT_SELECT_LIST_DATA);
                    z78 z78Var = this.m;
                    if (z78Var != null && parcelableArrayListExtra != null) {
                        z78Var.L(parcelableArrayListExtra);
                        this.m.F(parcelableArrayListExtra, true);
                    }
                    if (this.w != null && booleanExtra) {
                        m0(false, 2);
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
                    W0(str, stringExtra);
                    return;
                }
                LocalPicModel localPicModel2 = new LocalPicModel(str, stringExtra, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                this.d = localPicModel2;
                localPicModel2.setLoadDataCallBack(this.U);
                this.d.getData();
                return;
            }
            LocalPicModel localPicModel3 = new LocalPicModel(str, stringExtra, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
            this.d = localPicModel3;
            localPicModel3.setLoadDataCallBack(this.U);
            this.d.getData();
        }
    }

    public void a1(@Nullable a0 a0Var) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, a0Var) == null) {
            N0(true, false, a0Var);
            L1();
            r0();
            o0();
            m1(false);
            GroupChatFragment groupChatFragment = this.k;
            if (groupChatFragment != null) {
                long h2 = groupChatFragment.h2();
                long f2 = this.k.f2();
                StatisticItem param = new StatisticItem("c15134").param("obj_type", 2).param("fid", f2).param("fname", this.k.g2()).param("room_id", h2);
                BotsDTO.BotListDTO.UserDTO userDTO = this.E;
                if (userDTO != null) {
                    str = BIMManager.getBdUidFromBdUK(userDTO.getUk());
                } else {
                    str = "";
                }
                TiebaStatic.log(param.param("obj_id", str).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
            z78 z78Var = this.m;
            if (z78Var != null) {
                z78Var.E();
            }
        }
    }

    public void g1(v85 v85Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048628, this, v85Var) == null) && v85Var != null && v85Var.c() != null && v85Var.c().p() != null && this.z != null) {
            Activity pageActivity = this.i.getPageActivity();
            if (this.t == null || this.z.g() == null) {
                PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
                this.t = permissionJudgePolicy;
                this.z.r(permissionJudgePolicy);
            }
            this.t.clearRequestPermissionList();
            this.t.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.t.startRequestPermission(pageActivity)) {
                return;
            }
            zr5.b(new a(this, v85Var), new b(this));
        }
    }

    public final void e1(boolean z2, boolean z3) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) && this.l != null) {
            if (!this.L) {
                o0();
            }
            boolean z4 = false;
            this.L = false;
            this.l.k0(false);
            this.l.e0(false);
            if (this.J == SourceType.TWO) {
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
                A1(2, true);
            } else {
                A1(3, true);
            }
            t1(true);
            u1(true);
            r1(true);
            if (this.l.S() != null && z2) {
                this.l.S().m();
            }
            if (this.J == SourceType.ONE && !TextUtils.isEmpty(this.A)) {
                q1(this.A);
            } else if (z4) {
                if (!z3 && !TextUtils.isEmpty(this.f)) {
                    p1(this.f);
                }
                if (!TextUtils.isEmpty(this.A)) {
                    q1(this.A);
                } else {
                    q1(this.i.getString(R.string.im_msg_input_hint));
                }
            }
        }
    }

    public final boolean h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            z78 z78Var = this.m;
            if (z78Var == null || a11.h(z78Var.t()) != 1 || !this.m.t().get(0).isRobot()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void t0() {
        BotsDTO.BotListDTO.SkillDTO skillDTO;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048654, this) == null) && (skillDTO = this.H) != null && skillDTO.isCanKeyboardInput()) {
            if (!TextUtils.isEmpty(this.H.getKeyboardContent())) {
                p1(this.H.getKeyboardContent());
            } else {
                p1("");
            }
        }
    }

    @NonNull
    public y88 w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            y88 y88Var = new y88();
            y88Var.g(this.k.h2());
            y88Var.h(this.k.j2());
            y88Var.e(this.k.f2());
            y88Var.f(this.k.g2());
            return y88Var;
        }
        return (y88) invokeV.objValue;
    }

    public final void h1() {
        List<AtSelectData> list;
        Map<String, Integer> map;
        int i2;
        String str;
        BotsDTO.BotListDTO.SkillDTO skillDTO;
        int i3;
        String str2;
        String str3;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            if (!this.s) {
                f0();
                EditorTools editorTools = this.j;
                if (editorTools != null) {
                    editorTools.r();
                }
            } else if (this.v != null) {
                y1();
                c68 c68Var = this.D;
                if (c68Var != null) {
                    c68Var.a = this.E;
                    c68Var.b = this.H;
                    c68Var.c = this.F;
                }
                z78 z78Var = this.m;
                if (z78Var != null) {
                    z78Var.w();
                    List<AtSelectData> r2 = this.m.r();
                    Map<String, Integer> l2 = this.m.l();
                    if (!ListUtils.isEmpty(this.m.r())) {
                        StatisticItem statisticItem = new StatisticItem("c15128");
                        GroupChatFragment groupChatFragment = this.k;
                        long j3 = 0;
                        if (groupChatFragment != null) {
                            j2 = groupChatFragment.f2();
                        } else {
                            j2 = 0;
                        }
                        StatisticItem param = statisticItem.param("fid", j2);
                        GroupChatFragment groupChatFragment2 = this.k;
                        if (groupChatFragment2 != null) {
                            j3 = groupChatFragment2.h2();
                        }
                        TiebaStatic.log(param.param("room_id", j3).param("uid", TbadkCoreApplication.getCurrentAccount()));
                    }
                    map = l2;
                    list = r2;
                } else {
                    list = null;
                    map = null;
                }
                if (this.I != null && this.k != null && (skillDTO = this.H) != null && skillDTO.getName() != null) {
                    long h2 = this.k.h2();
                    long f2 = this.k.f2();
                    String g2 = this.k.g2();
                    StatisticItem param2 = new StatisticItem("c15134").param("obj_type", 3);
                    if (this.J == SourceType.ONE) {
                        i3 = 1;
                    } else {
                        i3 = 2;
                    }
                    StatisticItem param3 = param2.param("obj_source", i3);
                    BotsDTO.BotListDTO.SkillDTO skillDTO2 = this.H;
                    if (skillDTO2 != null) {
                        str2 = skillDTO2.getName();
                    } else {
                        str2 = StringUtil.NULL_STRING;
                    }
                    StatisticItem param4 = param3.param("obj_name", str2).param("fid", f2).param("fname", g2).param("room_id", h2);
                    BotsDTO.BotListDTO.UserDTO userDTO = this.E;
                    if (userDTO == null) {
                        str3 = "";
                    } else {
                        str3 = BIMManager.getBdUidFromBdUK(userDTO.getUk());
                    }
                    TiebaStatic.log(param4.param("obj_id", str3).param("uid", TbadkCoreApplication.getCurrentAccount()));
                }
                if (U0()) {
                    i2 = 1;
                } else if (this.D != null) {
                    if (this.C == null) {
                        i2 = 2;
                    } else {
                        i2 = 3;
                    }
                } else {
                    i2 = 0;
                }
                if (!w98.a(this.F)) {
                    this.N = true;
                    return;
                }
                f88 f88Var = this.v;
                String str4 = this.f;
                if (str4 == null) {
                    str = "";
                } else {
                    str = str4;
                }
                f88Var.g(str, this.C, this.D, list, map, i2);
                f0();
                z78 z78Var2 = this.m;
                if (z78Var2 != null) {
                    z78Var2.E();
                }
            }
        }
    }

    public void k1(@Nullable Object obj, @Nullable BotsDTO.BotListDTO.UserDTO userDTO, @Nullable BotsDTO.BotListDTO.SkillDTO skillDTO, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048636, this, new Object[]{obj, userDTO, skillDTO, Boolean.valueOf(z2)}) == null) {
            this.C = obj;
            this.E = userDTO;
            this.H = skillDTO;
            c68 c68Var = this.D;
            if (c68Var != null) {
                c68Var.d(z2);
            }
        }
    }

    public final void l0(@NonNull UserReplyInfoData userReplyInfoData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048637, this, userReplyInfoData) != null) || this.x == null) {
            return;
        }
        j88 j88Var = this.w;
        if (j88Var != null && j88Var.k()) {
            this.w.s(new v(this, userReplyInfoData));
        } else if (this.l.N()) {
            a1(new w(this, userReplyInfoData));
        } else {
            this.x.l(null, userReplyInfoData);
            this.k.y2(true);
        }
    }

    public void l1(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048638, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString(TbEnum.ChatInputStatus.INPUT_DRAFT_KEY);
            if (this.j != null) {
                this.j.C(new jd5(6, 3, optString));
            }
            this.f = optString;
            if (TextUtils.equals(jSONObject.optString(TbEnum.ChatInputStatus.INPUT_STATUS_KEY), TbEnum.ChatInputStatus.INPUT_STATUS_VOICE) && this.j != null) {
                this.j.C(new jd5(1, 6, null));
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public final void p0(ImageFileInfo imageFileInfo) {
        Bitmap resizeBitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, imageFileInfo) == null) {
            try {
                if (imageFileInfo.isGif()) {
                    FileHelper.saveGifByRelativePath(imageFileInfo.getFilePath(), null, TbConfig.IMAGE_RESIZED_FILE);
                    FileHelper.saveGifByRelativePath(imageFileInfo.getFilePath(), null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                    return;
                }
                Bitmap c2 = rs5.c(0, this.b, null, imageFileInfo.getFilePath(), TbImageHelper.getInstance().getPostImageSize());
                if (c2 != null && FileHelper.saveBitmapByRelativelyPath(null, TbConfig.IMAGE_RESIZED_FILE, c2, 85) != null && (resizeBitmap = BitmapHelper.resizeBitmap(c2, 100)) != null) {
                    FileHelper.saveBitmapByRelativelyPath(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 85);
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public void t1(boolean z2) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048655, this, z2) == null) && (groupInputTool = this.l) != null && groupInputTool.F() != null && (this.l.F().m instanceof EmotionNoLaunchView)) {
            ((EmotionNoLaunchView) this.l.F().m).setNeedHideForever(z2);
            if (!z2) {
                this.l.F().m.hide();
            } else {
                this.l.F().m.display();
            }
        }
    }

    public final void n1(GroupInputTool groupInputTool) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048642, this, groupInputTool) == null) && groupInputTool != null && this.z != null) {
            this.l = groupInputTool;
            this.w = groupInputTool.M();
            if (groupInputTool.T() != null && groupInputTool.J() != null) {
                this.x = new k88(groupInputTool.T(), this.k, groupInputTool.J());
            }
            MessageManager.getInstance().registerListener(this.V);
            Q0();
            S0();
            R0();
            if (groupInputTool.S() != null) {
                this.z.q(groupInputTool);
                E1(groupInputTool.S());
                if (groupInputTool.H() != null) {
                    x1(groupInputTool.H());
                }
                if (this.p != 0 && !hi.isEmpty(TbSingleton.getInstance().getRoomDraft(Long.valueOf(this.p)))) {
                    l1(TbSingleton.getInstance().getRoomDraft(Long.valueOf(this.p)));
                }
                z78 z78Var = this.m;
                if (z78Var != null) {
                    z78Var.H(groupInputTool, this.j);
                    this.m.z();
                }
            }
        }
    }
}
