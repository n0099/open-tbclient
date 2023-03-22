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
import com.baidu.tieba.ai;
import com.baidu.tieba.aq5;
import com.baidu.tieba.aw7;
import com.baidu.tieba.b75;
import com.baidu.tieba.dw7;
import com.baidu.tieba.ew7;
import com.baidu.tieba.ex7;
import com.baidu.tieba.fsa;
import com.baidu.tieba.fv7;
import com.baidu.tieba.fw7;
import com.baidu.tieba.gi;
import com.baidu.tieba.gx7;
import com.baidu.tieba.hi;
import com.baidu.tieba.hu7;
import com.baidu.tieba.im.chat.AbsMsglistView;
import com.baidu.tieba.im.model.LocalPicModel;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.GroupChatFragment;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.GroupInputTool;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.GroupInputViewController;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.GroupChatRobotTopHeadView;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.data.UserReplyInfoData;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.BotsDTO;
import com.baidu.tieba.jg;
import com.baidu.tieba.lb5;
import com.baidu.tieba.m35;
import com.baidu.tieba.mb5;
import com.baidu.tieba.qq5;
import com.baidu.tieba.rm;
import com.baidu.tieba.rw7;
import com.baidu.tieba.tg5;
import com.baidu.tieba.uv7;
import com.baidu.tieba.vv7;
import com.baidu.tieba.w01;
import com.baidu.tieba.wb5;
import com.baidu.tieba.wp5;
import com.baidu.tieba.wv7;
import com.baidu.tieba.xb5;
import com.baidu.tieba.xv7;
import com.baidu.tieba.yv7;
import com.baidu.tieba.z8;
import com.baidu.tieba.zo5;
import com.baidu.tieba.zv7;
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
/* loaded from: classes4.dex */
public class GroupInputViewController implements LifecycleObserver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public Object B;
    public hu7 C;
    public BotsDTO.BotListDTO.UserDTO D;
    public List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> E;
    public List<BotsDTO.BotListDTO.SkillDTO> F;
    public BotsDTO.BotListDTO.SkillDTO G;
    public GroupChatRobotTopHeadView H;
    public SourceType I;
    @NonNull
    public gx7 J;
    public final CustomMessageListener K;
    public mb5 L;
    public wv7.j M;
    public GroupInputTool.h N;
    public final z8 O;
    public final CustomMessageListener P;
    public ToolState a;
    public Context b;
    public WriteImagesInfo c;
    public LocalPicModel d;
    public View e;
    public String f;
    public String g;
    public TbPageContext h;
    public EditorTools i;
    public GroupChatFragment j;
    public GroupInputTool k;
    public uv7 l;
    public wv7 m;
    public GroupInputTool n;
    public long o;
    public boolean p;
    public String q;
    public boolean r;
    public PermissionJudgePolicy s;
    public boolean t;
    @Nullable
    public aw7 u;
    public ew7 v;
    public fw7 w;
    public dw7 x;
    public vv7 y;
    public String z;

    /* loaded from: classes4.dex */
    public interface w {
        void a();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65567, this) == null) {
        }
    }

    public boolean e0(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048615, this, i2, i3)) == null) ? i2 > 1 && i2 > i3 : invokeII.booleanValue;
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageFileInfo a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ GroupInputViewController d;

        /* renamed from: com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.GroupInputViewController$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0296a extends wp5<Object> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0296a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // com.baidu.tieba.wp5
            public Object doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    a aVar = this.a;
                    aVar.d.g0(aVar.a);
                    return null;
                }
                return invokeV.objValue;
            }
        }

        /* loaded from: classes4.dex */
        public class b implements zo5<Object> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public b(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // com.baidu.tieba.zo5
            public void onReturnDataInUI(Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                    if (this.a.a.isGif()) {
                        this.a.d.d = new LocalPicModel(null, TbConfig.IMAGE_RESIZED_FILE, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                    } else {
                        a aVar = this.a;
                        aVar.d.d = new LocalPicModel(aVar.b, aVar.c, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                    }
                    this.a.d.d.setLoadDataCallBack(this.a.d.O);
                    this.a.d.d.getData();
                }
            }
        }

        public a(GroupInputViewController groupInputViewController, ImageFileInfo imageFileInfo, String str, String str2) {
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
                aq5.b(new C0296a(this), new b(this));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements ew7.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        /* loaded from: classes4.dex */
        public class a implements ew7.d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // com.baidu.tieba.ew7.d
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.Z0(SourceType.ONE, false, false);
                }
            }
        }

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

        @Override // com.baidu.tieba.ew7.f
        public void a(BotsDTO.BotListDTO.UserDTO userDTO, BotsDTO.BotListDTO.SkillDTO skillDTO) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, userDTO, skillDTO) == null) && userDTO != null && skillDTO != null) {
                this.a.g1(userDTO, skillDTO);
                this.a.i0();
                this.a.T0(true);
                if (this.a.o0() != null) {
                    this.a.o0().n(new a(this));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements IGenBosObjectUrlListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zv7 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ GroupInputViewController c;

        /* loaded from: classes4.dex */
        public class a implements IUploadTransferListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ f b;

            public a(f fVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = fVar;
                this.a = str;
            }

            @Override // com.baidu.android.imsdk.upload.IUploadTransferListener
            public void onFailed(int i, int i2, String str) {
                zv7 zv7Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, str) == null) && (zv7Var = this.b.a) != null) {
                    zv7Var.a(i, i2, str);
                }
            }

            @Override // com.baidu.android.imsdk.upload.IUploadTransferListener
            public void onFinished(int i, String str) {
                zv7 zv7Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) && (zv7Var = this.b.a) != null) {
                    zv7Var.c(i, str, this.a);
                }
            }

            @Override // com.baidu.android.imsdk.upload.IUploadTransferListener
            public void onProgress(int i) {
                zv7 zv7Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (zv7Var = this.b.a) != null) {
                    zv7Var.b(i);
                }
            }
        }

        public f(GroupInputViewController groupInputViewController, zv7 zv7Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController, zv7Var, str};
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
            this.a = zv7Var;
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
                    if (gi.isEmpty(str4) || gi.isEmpty(str5) || gi.isEmpty(str6)) {
                        zv7 zv7Var = this.a;
                        if (zv7Var != null) {
                            zv7Var.a(i, 1, this.b);
                            return;
                        }
                        return;
                    }
                    this.c.r1(1, str4, str5, this.b, "image/jpeg", str2, str3, new a(this, str6));
                    return;
                }
                this.a.a(i, 1, this.b);
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

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.k.Z(false);
                this.a.t = true;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(GroupInputViewController groupInputViewController, int i) {
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
                if (booleanValue && this.a.t) {
                    this.a.t = false;
                    if (!this.a.Y()) {
                        this.a.d0(true, 1);
                    }
                }
                if (!booleanValue && this.a.x != null) {
                    this.a.x.g();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements fw7.e {
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

        @Override // com.baidu.tieba.fw7.e
        public void a(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) != null) || this.a.k == null) {
                return;
            }
            if (this.a.j != null) {
                this.a.j.o2();
            }
            GroupInputViewController groupInputViewController = this.a;
            groupInputViewController.X0(groupInputViewController.h.getString(R.string.im_msg_input_hint));
            this.a.Y0(false);
            this.a.k.o(i, i2, j, animatorListenerAdapter, z);
        }

        @Override // com.baidu.tieba.fw7.e
        public void b(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) != null) || this.a.k == null) {
                return;
            }
            if (this.a.j != null) {
                this.a.j.y2();
            }
            GroupInputViewController groupInputViewController = this.a;
            groupInputViewController.X0(groupInputViewController.z);
            this.a.Y0(true);
            this.a.k.n(i, i2, j, animatorListenerAdapter, z);
        }

        @Override // com.baidu.tieba.fw7.e
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.a0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements GroupChatRobotTopHeadView.b {
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

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.GroupChatRobotTopHeadView.b
        public void onCloseEvent() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.J0(null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements fw7.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SourceType a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ GroupInputViewController d;

        public h(GroupInputViewController groupInputViewController, SourceType sourceType, boolean z, boolean z2) {
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

        @Override // com.baidu.tieba.fw7.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.d.o1(this.a, this.b, this.c);
        }
    }

    /* loaded from: classes4.dex */
    public class i implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.m != null) {
                if (this.a.m.z()) {
                    this.a.m.s();
                    return;
                }
                this.a.v0(false);
                this.a.i0();
                this.a.s1();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.m != null && this.a.m.z()) {
                    this.a.m.s();
                    return;
                }
                this.a.w0(true, false, null);
                this.a.s1();
            }
        }
    }

    /* loaded from: classes4.dex */
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
                if (this.a.l != null) {
                    this.a.l.E(this.a.a);
                }
                this.a.t1(booleanValue);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements wv7.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        public l(GroupInputViewController groupInputViewController) {
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

        @Override // com.baidu.tieba.wv7.i
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.O0();
                this.a.w0(true, true, null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ w c;
        public final /* synthetic */ GroupInputViewController d;

        public m(GroupInputViewController groupInputViewController, boolean z, boolean z2, w wVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController, Boolean.valueOf(z), Boolean.valueOf(z2), wVar};
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
            this.c = wVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, animator) != null) {
                return;
            }
            this.d.M0(this.a, this.b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) != null) {
                return;
            }
            this.d.M0(this.a, this.b);
            w wVar = this.c;
            if (wVar != null) {
                wVar.a();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static /* synthetic */ class n {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1108333258, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/inputtool/GroupInputViewController$n;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1108333258, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/inputtool/GroupInputViewController$n;");
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
    public class o implements mb5 {
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

        @Override // com.baidu.tieba.mb5
        public void C(lb5 lb5Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, lb5Var) != null) || lb5Var == null) {
                return;
            }
            int i = lb5Var.a;
            if (i == 24) {
                Object obj = lb5Var.c;
                if (obj instanceof b75) {
                    b75 b75Var = (b75) obj;
                    if (b75Var.getType() != EmotionGroupType.LOCAL) {
                        this.a.N0(b75Var);
                    }
                }
            } else if (i == 8) {
                this.a.O0();
                this.a.v0(true);
            } else if (i == 4) {
                Object obj2 = lb5Var.c;
                if (obj2 instanceof String) {
                    this.a.f = (String) obj2;
                    this.a.d0(false, 1);
                    this.a.x.i(100L);
                }
            } else if (i == 14) {
                this.a.K0();
            } else if (i != 17) {
                if (i == 62) {
                    boolean booleanValue = ((Boolean) lb5Var.c).booleanValue();
                    if (this.a.k == null) {
                        return;
                    }
                    if (booleanValue) {
                        this.a.b0();
                    } else {
                        this.a.d0(true, 1);
                    }
                    if (!this.a.k.U() || this.a.n0() != ToolState.TEXT) {
                        return;
                    }
                    this.a.d1(false);
                } else if (i != 63 || this.a.k == null) {
                } else {
                    this.a.k.Z(false);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p implements wv7.j {
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

        @Override // com.baidu.tieba.wv7.j
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZ(1048576, this, z) != null) {
                return;
            }
            this.a.j1(z);
        }
    }

    /* loaded from: classes4.dex */
    public class q implements ew7.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserReplyInfoData a;
        public final /* synthetic */ GroupInputViewController b;

        public q(GroupInputViewController groupInputViewController, UserReplyInfoData userReplyInfoData) {
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

        @Override // com.baidu.tieba.ew7.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.w.l(null, this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class r implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserReplyInfoData a;
        public final /* synthetic */ GroupInputViewController b;

        public r(GroupInputViewController groupInputViewController, UserReplyInfoData userReplyInfoData) {
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

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.GroupInputViewController.w
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.w.l(null, this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class s implements GroupInputTool.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.GroupInputTool.h
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

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.GroupInputTool.h
        public void b(VoiceData.VoiceModel voiceModel) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voiceModel) == null) && voiceModel != null && !StringUtils.isNull(voiceModel.getVoiceId()) && this.a.u != null) {
                this.a.u.b(voiceModel.getVoiceId(), voiceModel.getDuration());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class t extends z8 {
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

        @Override // com.baidu.tieba.z8
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (obj instanceof LocalPicModel.ResponseData) {
                    LocalPicModel.ResponseData responseData = (LocalPicModel.ResponseData) obj;
                    String str = responseData.getBitmap().getWidth() + "," + responseData.getBitmap().getHeight();
                    if (responseData.getExtraMap() != null) {
                        this.a.u.a(responseData.getSPathGen(), str, responseData.getExtraMap());
                        return;
                    } else {
                        this.a.u.d(responseData.getSPathGen(), str);
                        return;
                    }
                }
                this.a.j.showToast(TbadkCoreApplication.getInst().getString(R.string.pic_parser_error));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class u extends wp5<Map<String, Object>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b75 a;
        public final /* synthetic */ GroupInputViewController b;

        public u(GroupInputViewController groupInputViewController, b75 b75Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController, b75Var};
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
            this.a = b75Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wp5
        /* renamed from: a */
        public Map<String, Object> doInBackground() {
            InterceptResult invokeV;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                String d = tg5.b.d(this.a.d(), true);
                boolean exists = new File(d).exists();
                if (!exists) {
                    d = d.replace(".gif", ".jpg");
                }
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setFilePath(d);
                imageFileInfo.setIsGif(exists);
                this.b.g0(imageFileInfo);
                String b = tg5.b.b(this.a.d());
                int i = n.a[this.a.getType().ordinal()];
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
    public class v implements zo5<Map<String, Object>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        public v(GroupInputViewController groupInputViewController) {
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
        @Override // com.baidu.tieba.zo5
        /* renamed from: a */
        public void onReturnDataInUI(Map<String, Object> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, map) == null) {
                this.a.d = new LocalPicModel(null, TbConfig.IMAGE_RESIZED_FILE, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                this.a.d.setExtraMap(map);
                this.a.d.setLoadDataCallBack(this.a.O);
                this.a.d.getData();
            }
        }
    }

    public GroupInputViewController(GroupChatFragment groupChatFragment, long j2, fv7 fv7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {groupChatFragment, Long.valueOf(j2), fv7Var};
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
        this.i = null;
        this.r = true;
        this.z = null;
        this.C = new hu7();
        this.E = new ArrayList();
        this.H = null;
        this.K = new k(this, 2921790);
        this.L = new o(this);
        this.M = new p(this);
        this.N = new s(this);
        this.O = new t(this);
        this.P = new c(this, 2921785);
        this.o = j2;
        this.j = groupChatFragment;
        this.h = groupChatFragment.getPageContext();
        this.b = groupChatFragment.getContext();
        this.n = new GroupInputTool(this.j);
        vv7 vv7Var = new vv7(this.j);
        this.y = vv7Var;
        vv7Var.o(this.L);
        this.J = new ex7(this);
        this.x = new dw7(this.j, new fsa() { // from class: com.baidu.tieba.tv7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.fsa
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? GroupInputViewController.this.F0() : invokeV.objValue;
            }
        }, fv7Var);
        x0();
        U0(this.n);
        y0();
        MessageManager.getInstance().registerListener(this.K);
    }

    public void H0(int i2) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i2) == null) && (groupInputTool = this.n) != null) {
            groupInputTool.W(i2);
        }
    }

    public void I0(@NonNull Bundle bundle) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) && (groupInputTool = this.n) != null) {
            groupInputTool.X(bundle);
        }
    }

    public void P0(BotsDTO botsDTO) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, botsDTO) == null) && (groupInputTool = this.k) != null) {
            groupInputTool.Y(botsDTO);
        }
    }

    public void Q0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.z = str;
        }
    }

    public final void T0(boolean z) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048595, this, z) != null) || (groupInputTool = this.k) == null) {
            return;
        }
        if (z) {
            groupInputTool.b0(1);
        } else {
            groupInputTool.b0(0);
        }
    }

    public void V0(String str) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, str) == null) && (editorTools = this.i) != null) {
            editorTools.C(new lb5(75, 3, str));
        }
    }

    public void W0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            this.f = str;
            EditorTools editorTools = this.i;
            if (editorTools != null) {
                editorTools.C(new lb5(6, 3, str));
            }
        }
    }

    public void X0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            this.q = str;
            EditorTools editorTools = this.i;
            if (editorTools != null) {
                editorTools.C(new lb5(71, 3, StringHelper.cutChineseAndEnglishWithEmoji(str, 28, StringHelper.STRING_MORE)));
            }
        }
    }

    public void Y0(boolean z) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048604, this, z) == null) && (groupInputTool = this.k) != null) {
            groupInputTool.c0(z);
        }
    }

    public void b1(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048610, this, z) == null) && this.i.o(6) != null) {
            if (!z) {
                this.i.o(6).hide();
            } else {
                this.i.o(6).display();
            }
        }
    }

    public void c1(GroupInputTool.f fVar) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048612, this, fVar) == null) && (groupInputTool = this.k) != null) {
            groupInputTool.g0(fVar);
        }
    }

    public void e1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, view2) == null) {
            this.e = view2;
        }
    }

    public final void h0(@NonNull List<BotsDTO.BotListDTO.SkillDTO> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, list) == null) {
            for (BotsDTO.BotListDTO.SkillDTO skillDTO : list) {
                if (skillDTO != null && skillDTO.getType() == this.A) {
                    this.G = skillDTO;
                    return;
                }
            }
        }
    }

    public void i1(@Nullable aw7 aw7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, aw7Var) == null) {
            this.u = aw7Var;
        }
    }

    public void l1(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, editorTools) == null) {
            this.i = editorTools;
        }
    }

    public final void t1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048646, this, z) == null) {
            if (z) {
                b0();
                d1(true);
                return;
            }
            d0(true, 1);
            d1(false);
        }
    }

    public final void v0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048649, this, z) == null) {
            w0(false, z, null);
        }
    }

    public void L0(@NonNull UserReplyInfoData userReplyInfoData, @NonNull Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, userReplyInfoData, obj) == null) {
            this.B = obj;
            i0();
            c0(userReplyInfoData);
        }
    }

    public void V(@NonNull AtSelectData atSelectData, boolean z) {
        uv7 uv7Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048597, this, atSelectData, z) != null) || (uv7Var = this.l) == null) {
            return;
        }
        uv7Var.C();
        this.l.k(atSelectData, false, z);
    }

    public void g1(BotsDTO.BotListDTO.UserDTO userDTO, BotsDTO.BotListDTO.SkillDTO skillDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048620, this, userDTO, skillDTO) == null) {
            this.D = userDTO;
            this.G = skillDTO;
        }
    }

    public void v1(@NonNull String str, @NonNull xv7 xv7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048650, this, str, xv7Var) == null) {
            yv7 yv7Var = new yv7(this.b, str, "audio/amr");
            yv7Var.b(xv7Var);
            BIMManager.audioTrans(this.b, str, "audio/amr", "amr", 12, yv7Var);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65568, this) == null) {
            vv7 vv7Var = this.y;
            if (vv7Var != null) {
                vv7Var.l();
            }
            uv7 uv7Var = this.l;
            if (uv7Var != null) {
                uv7Var.y();
            }
            wv7 wv7Var = this.m;
            if (wv7Var != null) {
                wv7Var.B();
            }
            dw7 dw7Var = this.x;
            if (dw7Var != null) {
                dw7Var.k();
            }
            VoiceManager.setIsNeedBlackScreen(true);
            MessageManager.getInstance().unRegisterListener(this.P);
            MessageManager.getInstance().unRegisterListener(this.K);
        }
    }

    public final boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            uv7 uv7Var = this.l;
            if (uv7Var == null || w01.h(uv7Var.u()) != 1 || !this.l.u().get(0).isRobot()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65569, this) == null) {
            this.p = false;
            vv7 vv7Var = this.y;
            if (vv7Var != null) {
                vv7Var.m();
                this.y.p(this.p);
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65570, this) == null) {
            this.p = true;
            vv7 vv7Var = this.y;
            if (vv7Var != null) {
                vv7Var.n();
                this.y.p(this.p);
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65571, this) == null) {
            if (m0() != null && m0().G()) {
                return;
            }
            TbSingleton.getInstance().setRoomDraft(Long.valueOf(this.o), l0());
        }
    }

    public final GroupChatRobotTopHeadView A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            GroupInputTool groupInputTool = this.k;
            if (groupInputTool == null) {
                return null;
            }
            GroupChatRobotTopHeadView L = groupInputTool.L();
            this.H = L;
            L.setEventCallback(new g(this));
            return this.H;
        }
        return (GroupChatRobotTopHeadView) invokeV.objValue;
    }

    public final void B0() {
        fw7 fw7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (fw7Var = this.w) != null) {
            fw7Var.i(new e(this));
        }
    }

    public boolean C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (FileHelper.checkSD()) {
                return true;
            }
            hi.Q(this.b, TbadkCoreApplication.getInst().getString(R.string.voice_error_sdcard));
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            fw7 fw7Var = this.w;
            if (fw7Var != null && fw7Var.e()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public /* synthetic */ CharSequence F0() {
        return this.f;
    }

    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            i0();
            if (D0()) {
                a0();
            }
            f0();
            h1(2, true);
            a1(true);
            b1(true);
        }
    }

    public boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            GroupInputTool groupInputTool = this.k;
            if (groupInputTool != null) {
                return groupInputTool.q();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void a0() {
        fw7 fw7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && (fw7Var = this.w) != null) {
            fw7Var.j(null);
        }
    }

    public final void b0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048609, this) == null) && o0() != null) {
            o0().n(null);
        }
    }

    public final void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            this.C.a();
            this.E.clear();
            this.D = null;
            this.G = null;
            this.B = null;
        }
    }

    public void f1() {
        wv7 wv7Var;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048618, this) == null) && (wv7Var = this.m) != null && (arrayList = (ArrayList) wv7Var.r()) != null) {
            this.E = arrayList;
        }
    }

    public void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            this.f = null;
            EditorTools editorTools = this.i;
            if (editorTools != null) {
                editorTools.C(new lb5(9, -1, Boolean.TRUE));
            }
        }
    }

    public uv7 j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return this.l;
        }
        return (uv7) invokeV.objValue;
    }

    public GroupInputTool k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            return this.n;
        }
        return (GroupInputTool) invokeV.objValue;
    }

    public GroupInputTool m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            return this.k;
        }
        return (GroupInputTool) invokeV.objValue;
    }

    public ToolState n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return this.a;
        }
        return (ToolState) invokeV.objValue;
    }

    public ew7 o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            return this.v;
        }
        return (ew7) invokeV.objValue;
    }

    public fw7 p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            return this.w;
        }
        return (fw7) invokeV.objValue;
    }

    @Nullable
    public rw7 q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            return r0().f();
        }
        return (rw7) invokeV.objValue;
    }

    @NonNull
    public gx7 r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            return this.J;
        }
        return (gx7) invokeV.objValue;
    }

    @Nullable
    public VoiceManager s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            vv7 vv7Var = this.y;
            if (vv7Var != null) {
                return vv7Var.w0();
            }
            return null;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public SourceType t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            return this.I;
        }
        return (SourceType) invokeV.objValue;
    }

    public void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048647, this) == null) {
            dw7 dw7Var = this.x;
            if (dw7Var != null) {
                dw7Var.g();
            }
            GroupInputTool groupInputTool = this.k;
            if (groupInputTool != null) {
                groupInputTool.Q();
            }
        }
    }

    public final void x0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048652, this) == null) && this.l == null) {
            this.l = new uv7(this.b, this.j);
        }
    }

    public final void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048653, this) == null) {
            vv7 vv7Var = this.y;
            if (vv7Var != null) {
                vv7Var.i();
            }
            GroupInputTool groupInputTool = this.k;
            if (groupInputTool != null) {
                groupInputTool.h0(this.N);
            }
        }
    }

    public final void z0() {
        ew7 ew7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048654, this) == null) && (ew7Var = this.v) != null) {
            ew7Var.m(new d(this));
        }
    }

    public final void E0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            Iterator<ImageFileInfo> it = this.c.getChosedFiles().iterator();
            long j2 = 0;
            while (it.hasNext()) {
                j2++;
                jg.a().postDelayed(new a(this, it.next(), str, str2), 100 * j2);
            }
            WriteImagesInfo writeImagesInfo = this.c;
            if (writeImagesInfo != null) {
                writeImagesInfo.clear();
            }
        }
    }

    public final void p1(List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> list, boolean z) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048638, this, list, z) == null) && (groupInputTool = this.k) != null && groupInputTool.D() != null) {
            wv7 wv7Var = this.m;
            if (wv7Var == null) {
                wv7 wv7Var2 = new wv7(this.k.D(), this.M);
                this.m = wv7Var2;
                wv7Var2.v(list, z);
            } else {
                wv7Var.A(list, z);
            }
            this.m.F(z, !ListUtils.isEmpty(list));
        }
    }

    public final void q1(List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> list, boolean z) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048640, this, list, z) == null) && (groupInputTool = this.k) != null && groupInputTool.D() != null && !ListUtils.isEmpty(list)) {
            wv7 wv7Var = this.m;
            if (wv7Var == null) {
                wv7 wv7Var2 = new wv7(this.k.D(), this.M);
                this.m = wv7Var2;
                wv7Var2.v(list, z);
            } else {
                wv7Var.A(list, z);
            }
            this.m.H(new l(this), z);
        }
    }

    public void G0(int i2, int i3, @Nullable Intent intent) {
        vv7 vv7Var;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048582, this, i2, i3, intent) == null) && i3 == -1 && intent != null && (vv7Var = this.y) != null) {
            vv7Var.k(i2, i3, intent);
            if (i2 != 12010 && i2 != 12009 && i2 != 12002) {
                if (i2 == 12004) {
                    boolean booleanExtra = intent.getBooleanExtra(IntentConfig.IS_AT_SELECT_BOT_DATA, false);
                    ArrayList<AtSelectData> parcelableArrayListExtra = intent.getParcelableArrayListExtra(IntentConfig.AT_SELECT_LIST_DATA);
                    if (this.l != null && !ListUtils.isEmpty(parcelableArrayListExtra)) {
                        this.l.H(parcelableArrayListExtra);
                        this.l.D(parcelableArrayListExtra);
                    }
                    if (this.v != null && booleanExtra) {
                        d0(false, 2);
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
                    E0(str, stringExtra);
                    return;
                }
                LocalPicModel localPicModel2 = new LocalPicModel(str, stringExtra, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                this.d = localPicModel2;
                localPicModel2.setLoadDataCallBack(this.O);
                this.d.getData();
                return;
            }
            LocalPicModel localPicModel3 = new LocalPicModel(str, stringExtra, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
            this.d = localPicModel3;
            localPicModel3.setLoadDataCallBack(this.O);
            this.d.getData();
        }
    }

    public void J0(@Nullable w wVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, wVar) == null) {
            w0(true, false, wVar);
            s1();
            i0();
            f0();
            T0(false);
            GroupChatFragment groupChatFragment = this.j;
            if (groupChatFragment != null) {
                long h2 = groupChatFragment.h2();
                long f2 = this.j.f2();
                StatisticItem param = new StatisticItem("c15134").param("obj_type", 2).param("fid", f2).param("fname", this.j.g2()).param("room_id", h2);
                BotsDTO.BotListDTO.UserDTO userDTO = this.D;
                if (userDTO != null) {
                    str = BIMManager.getBdUidFromBdUK(userDTO.getUk());
                } else {
                    str = "";
                }
                TiebaStatic.log(param.param("obj_id", str).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
            uv7 uv7Var = this.l;
            if (uv7Var != null) {
                uv7Var.C();
            }
        }
    }

    public void N0(b75 b75Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, b75Var) == null) && b75Var != null && b75Var.c() != null && b75Var.c().p() != null && this.y != null) {
            Activity pageActivity = this.h.getPageActivity();
            if (this.s == null || this.y.g() == null) {
                PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
                this.s = permissionJudgePolicy;
                this.y.r(permissionJudgePolicy);
            }
            this.s.clearRequestPermissionList();
            this.s.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.s.startRequestPermission(pageActivity)) {
                return;
            }
            aq5.b(new u(this, b75Var), new v(this));
        }
    }

    public final void K0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048586, this) != null) || !C0()) {
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
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
    }

    public String l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            EditorTools editorTools = this.i;
            if (editorTools == null) {
                return "";
            }
            wb5 p2 = editorTools.p(3);
            String str = TbEnum.ChatInputStatus.INPUT_STATUS_TEXT;
            if (p2 != null) {
                xb5 xb5Var = p2.m;
                if ((xb5Var instanceof View) && ((View) xb5Var).getVisibility() != 0) {
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

    public final void M0(boolean z, boolean z2) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && this.k != null) {
            f0();
            boolean z3 = false;
            this.k.f0(false);
            if (this.I == SourceType.TWO) {
                z3 = true;
            }
            if (z3 && !z2) {
                str = this.g;
            } else {
                str = this.f;
            }
            this.f = str;
            if (TextUtils.isEmpty(str)) {
                h1(2, true);
            } else {
                h1(3, true);
            }
            a1(true);
            b1(true);
            Y0(true);
            if (this.k.O() != null && z) {
                this.k.O().m();
            }
            if (this.I == SourceType.ONE && !TextUtils.isEmpty(this.z)) {
                X0(this.z);
            } else if (z3) {
                if (!z2 && !TextUtils.isEmpty(this.f)) {
                    W0(this.f);
                }
                if (!TextUtils.isEmpty(this.z)) {
                    X0(this.z);
                } else {
                    X0(this.h.getString(R.string.im_msg_input_hint));
                }
            }
        }
    }

    public final void O0() {
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
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (!this.r) {
                X();
                EditorTools editorTools = this.i;
                if (editorTools != null) {
                    editorTools.r();
                }
            } else if (this.u != null) {
                f1();
                hu7 hu7Var = this.C;
                if (hu7Var != null) {
                    hu7Var.a = this.D;
                    hu7Var.b = this.G;
                    hu7Var.c = this.E;
                }
                uv7 uv7Var = this.l;
                if (uv7Var != null) {
                    uv7Var.x();
                    List<AtSelectData> s2 = this.l.s();
                    Map<String, Integer> l2 = this.l.l();
                    if (!ListUtils.isEmpty(this.l.s())) {
                        StatisticItem statisticItem = new StatisticItem("c15128");
                        GroupChatFragment groupChatFragment = this.j;
                        long j3 = 0;
                        if (groupChatFragment != null) {
                            j2 = groupChatFragment.f2();
                        } else {
                            j2 = 0;
                        }
                        StatisticItem param = statisticItem.param("fid", j2);
                        GroupChatFragment groupChatFragment2 = this.j;
                        if (groupChatFragment2 != null) {
                            j3 = groupChatFragment2.h2();
                        }
                        TiebaStatic.log(param.param("room_id", j3).param("uid", TbadkCoreApplication.getCurrentAccount()));
                    }
                    map = l2;
                    list = s2;
                } else {
                    list = null;
                    map = null;
                }
                if (this.H != null && this.j != null && (skillDTO = this.G) != null && skillDTO.getName() != null) {
                    long h2 = this.j.h2();
                    long f2 = this.j.f2();
                    String g2 = this.j.g2();
                    StatisticItem param2 = new StatisticItem("c15134").param("obj_type", 3);
                    if (this.I == SourceType.ONE) {
                        i3 = 1;
                    } else {
                        i3 = 2;
                    }
                    StatisticItem param3 = param2.param("obj_source", i3);
                    BotsDTO.BotListDTO.SkillDTO skillDTO2 = this.G;
                    if (skillDTO2 != null) {
                        str2 = skillDTO2.getName();
                    } else {
                        str2 = StringUtil.NULL_STRING;
                    }
                    StatisticItem param4 = param3.param("obj_name", str2).param("fid", f2).param("fname", g2).param("room_id", h2);
                    BotsDTO.BotListDTO.UserDTO userDTO = this.D;
                    if (userDTO == null) {
                        str3 = "";
                    } else {
                        str3 = BIMManager.getBdUidFromBdUK(userDTO.getUk());
                    }
                    TiebaStatic.log(param4.param("obj_id", str3).param("uid", TbadkCoreApplication.getCurrentAccount()));
                }
                if (D0()) {
                    i2 = 1;
                } else if (this.C != null) {
                    if (this.B == null) {
                        i2 = 2;
                    } else {
                        i2 = 3;
                    }
                } else {
                    i2 = 0;
                }
                aw7 aw7Var = this.u;
                String str4 = this.f;
                if (str4 == null) {
                    str = "";
                } else {
                    str = str4;
                }
                aw7Var.c(str, this.B, this.C, list, map, i2);
                X();
                uv7 uv7Var2 = this.l;
                if (uv7Var2 != null) {
                    uv7Var2.C();
                }
            }
        }
    }

    public void R0(@Nullable Object obj, @Nullable BotsDTO.BotListDTO.UserDTO userDTO, @Nullable BotsDTO.BotListDTO.SkillDTO skillDTO, @Nullable List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{obj, userDTO, skillDTO, list, Boolean.valueOf(z)}) == null) {
            this.B = obj;
            this.D = userDTO;
            this.G = skillDTO;
            hu7 hu7Var = this.C;
            if (hu7Var != null) {
                hu7Var.c(z);
            }
        }
    }

    public void S0(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048594, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString(TbEnum.ChatInputStatus.INPUT_DRAFT_KEY);
            if (this.i != null) {
                this.i.C(new lb5(6, 3, optString));
            }
            this.f = optString;
            if (TextUtils.equals(jSONObject.optString(TbEnum.ChatInputStatus.INPUT_STATUS_KEY), TbEnum.ChatInputStatus.INPUT_STATUS_VOICE) && this.i != null) {
                this.i.C(new lb5(1, 6, null));
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void a1(boolean z) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048608, this, z) == null) && (groupInputTool = this.k) != null && groupInputTool.A() != null && (this.k.A().m instanceof EmotionNoLaunchView)) {
            ((EmotionNoLaunchView) this.k.A().m).setNeedHideForever(z);
            if (!z) {
                this.k.A().m.hide();
            } else {
                this.k.A().m.display();
            }
        }
    }

    public final void c0(@NonNull UserReplyInfoData userReplyInfoData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048611, this, userReplyInfoData) != null) || this.w == null) {
            return;
        }
        ew7 ew7Var = this.v;
        if (ew7Var != null && ew7Var.h()) {
            this.v.n(new q(this, userReplyInfoData));
        } else if (this.k.G()) {
            J0(new r(this, userReplyInfoData));
        } else {
            this.w.l(null, userReplyInfoData);
            this.j.q2(true);
        }
    }

    public final void g0(ImageFileInfo imageFileInfo) {
        Bitmap resizeBitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, imageFileInfo) == null) {
            try {
                if (imageFileInfo.isGif()) {
                    FileHelper.saveGifByRelativePath(imageFileInfo.getFilePath(), null, TbConfig.IMAGE_RESIZED_FILE);
                    FileHelper.saveGifByRelativePath(imageFileInfo.getFilePath(), null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                    return;
                }
                Bitmap c2 = qq5.c(0, this.b, null, imageFileInfo.getFilePath(), TbImageHelper.getInstance().getPostImageSize());
                if (c2 != null && FileHelper.saveBitmapByRelativelyPath(null, TbConfig.IMAGE_RESIZED_FILE, c2, 85) != null && (resizeBitmap = BitmapHelper.resizeBitmap(c2, 100)) != null) {
                    FileHelper.saveBitmapByRelativelyPath(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 85);
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public final void U0(GroupInputTool groupInputTool) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, groupInputTool) == null) && groupInputTool != null && this.y != null) {
            this.k = groupInputTool;
            this.v = groupInputTool.F();
            if (groupInputTool.P() != null && groupInputTool.D() != null) {
                this.w = new fw7(groupInputTool.P(), this.j, groupInputTool.D());
            }
            MessageManager.getInstance().registerListener(this.P);
            z0();
            B0();
            A0();
            if (groupInputTool.O() != null) {
                this.y.q(groupInputTool);
                l1(groupInputTool.O());
                if (groupInputTool.B() != null) {
                    e1(groupInputTool.B());
                }
                if (this.o != 0 && !gi.isEmpty(TbSingleton.getInstance().getRoomDraft(Long.valueOf(this.o)))) {
                    S0(TbSingleton.getInstance().getRoomDraft(Long.valueOf(this.o)));
                }
                uv7 uv7Var = this.l;
                if (uv7Var != null) {
                    uv7Var.r(groupInputTool, this.i);
                    this.l.z();
                }
            }
        }
    }

    public void W(@NonNull UserReplyInfoData userReplyInfoData) {
        uv7 uv7Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048599, this, userReplyInfoData) != null) || (uv7Var = this.l) == null) {
            return;
        }
        uv7Var.C();
        this.l.j(new AtSelectData(userReplyInfoData.getmPortrait(), userReplyInfoData.getmNameShow(), String.valueOf(userReplyInfoData.getmUid()), userReplyInfoData.isRobot()), false);
    }

    public final void d1(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048614, this, z) == null) && p0() != null) {
            if (z) {
                p0().k(false);
            } else if (!p0().g()) {
                p0().k(!z);
            }
        }
    }

    public final void j1(boolean z) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048626, this, z) != null) || this.H == null || !z) {
            return;
        }
        BotsDTO.BotListDTO.UserDTO userDTO = this.D;
        String str3 = null;
        if (userDTO != null) {
            str = userDTO.getPortrait();
            str2 = this.D.getNameShow();
        } else {
            str = null;
            str2 = null;
        }
        BotsDTO.BotListDTO.SkillDTO skillDTO = this.G;
        if (skillDTO != null) {
            str3 = skillDTO.getName();
        }
        this.H.setData(str, str2, str3);
        this.H.setVisibility(0);
    }

    public void Z0(SourceType sourceType, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{sourceType, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            wv7 wv7Var = this.m;
            if (wv7Var != null && wv7Var.y()) {
                return;
            }
            if (D0()) {
                this.w.j(new h(this, sourceType, z, z2));
            } else {
                o1(sourceType, z, z2);
            }
        }
    }

    public void k1(int i2, @NonNull Object obj, @NonNull hu7 hu7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048628, this, i2, obj, hu7Var) == null) {
            wv7 wv7Var = this.m;
            if (wv7Var != null && wv7Var.y()) {
                return;
            }
            this.A = i2;
            this.B = obj;
            this.D = hu7Var.a;
            if (this.F == null) {
                this.F = new ArrayList();
            }
            this.F.clear();
            BotsDTO.BotListDTO.SkillDTO skillDTO = hu7Var.b;
            if (skillDTO != null && !ListUtils.isEmpty(skillDTO.getSubSkill())) {
                this.F.addAll(hu7Var.b.getSubSkill());
                h0(this.F);
            }
            hu7 hu7Var2 = this.C;
            if (hu7Var2 != null) {
                hu7Var2.c(hu7Var.b());
            }
        }
    }

    public final void d0(boolean z, int i2) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) && (groupInputTool = this.k) != null && groupInputTool.O() != null && !this.k.U() && this.v != null) {
            if (z) {
                this.k.O().requestFocus();
            }
            if (!this.k.O().hasFocus()) {
                return;
            }
            if (i2 != 2 && (TextUtils.isEmpty(this.f) || !this.f.equals("/"))) {
                this.v.n(null);
            } else {
                this.v.q(null, i2);
            }
        }
    }

    public void h1(int i2, boolean z) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && (groupInputTool = this.k) != null && groupInputTool.H() != null && (this.k.H().m instanceof SendNoLaunchView)) {
            if (i2 == 1) {
                ((SendNoLaunchView) this.k.H().m).setIsSendIcon(true);
                ((SendNoLaunchView) this.k.H().m).setSendVisibility(z);
            } else if (i2 == 2) {
                ((SendNoLaunchView) this.k.H().m).setIsSendIcon(false);
                ((SendNoLaunchView) this.k.H().m).setSendVisibility(false);
            } else if (i2 == 3) {
                ((SendNoLaunchView) this.k.H().m).setIsSendIcon(false);
                ((SendNoLaunchView) this.k.H().m).setSendVisibility(true);
            }
        }
    }

    public void m1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048632, this, z) == null) {
            this.r = z;
            if (this.i != null) {
                if (m35.m().i("key_group_chat_chatroom_audio_switch", true)) {
                    this.i.setToolEnabled(z, 6);
                }
                this.i.C(new lb5(72, 3, Boolean.valueOf(z)));
                if (this.i.p(37) != null && (this.i.p(37).m instanceof EmotionNoLaunchView)) {
                    ((EmotionNoLaunchView) this.i.p(37).m).setEnabled(z);
                }
                if (m35.m().i("key_group_chat_chatroom_picture_switch", true) && this.i.p(38) != null && (this.i.p(38).m instanceof SendNoLaunchView)) {
                    ((SendNoLaunchView) this.i.p(38).m).setIconEnable(z);
                    ((SendNoLaunchView) this.i.p(38).m).setSendInterceptToastText(this.q, z);
                }
            }
            uv7 uv7Var = this.l;
            if (uv7Var != null) {
                uv7Var.F(z);
            }
            GroupInputTool groupInputTool = this.k;
            if (groupInputTool != null && groupInputTool.C() != null && this.k.C().g() != null) {
                if (z) {
                    this.k.C().g().setEnabled(true);
                    this.k.C().g().setOnClickListener(new b(this));
                    return;
                }
                this.k.C().g().setEnabled(false);
            }
        }
    }

    public final void n1(BotsDTO.BotListDTO.SkillDTO skillDTO, boolean z, boolean z2) {
        BotsDTO.BotListDTO.SkillDTO skillDTO2;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048634, this, new Object[]{skillDTO, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (skillDTO != null) {
                skillDTO2 = skillDTO.copy();
            } else {
                skillDTO2 = null;
            }
            if (this.k != null && skillDTO2 != null) {
                int i2 = 1;
                if (this.I == SourceType.TWO) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                this.k.f0(z);
                this.k.u(true);
                this.k.x(!z3);
                String str = "";
                if (skillDTO2.getKeyboard() == 1) {
                    if (!TextUtils.isEmpty(skillDTO2.getKeyboardContent())) {
                        W0(skillDTO2.getKeyboardContent());
                    } else {
                        W0("");
                    }
                    this.g = this.f;
                    if (!TextUtils.isEmpty(skillDTO2.getExp())) {
                        X0(skillDTO2.getExp());
                    } else if (z3) {
                        X0(this.h.getString(R.string.obfuscated_res_0x7f0f089f));
                    }
                    h1(1, !TextUtils.isEmpty(this.f));
                    a1(false);
                    b1(false);
                    Y0(false);
                    this.k.e0(new i(this));
                    if (this.k.O() != null) {
                        this.k.O().l();
                    }
                    p1(skillDTO2.getItems(), z2);
                } else {
                    if (this.k.O() != null) {
                        this.k.O().q();
                    }
                    this.k.e0(new j(this));
                    q1(skillDTO2.getItems(), z2);
                }
                GroupChatFragment groupChatFragment = this.j;
                if (groupChatFragment != null) {
                    long h2 = groupChatFragment.h2();
                    long f2 = this.j.f2();
                    String g2 = this.j.g2();
                    StatisticItem param = new StatisticItem("c15134").param("obj_type", 1).param("obj_name", skillDTO2.getName());
                    if (this.I == SourceType.TWO) {
                        i2 = 2;
                    }
                    StatisticItem param2 = param.param("obj_source", i2).param("fid", f2).param("fname", g2).param("room_id", h2);
                    BotsDTO.BotListDTO.UserDTO userDTO = this.D;
                    if (userDTO != null) {
                        str = BIMManager.getBdUidFromBdUK(userDTO.getUk());
                    }
                    TiebaStatic.log(param2.param("obj_id", str).param("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        }
    }

    public final void o1(SourceType sourceType, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048636, this, new Object[]{sourceType, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.I = sourceType;
            GroupChatFragment groupChatFragment = this.j;
            if (groupChatFragment != null) {
                groupChatFragment.o2();
            }
            if (this.I == SourceType.TWO) {
                this.g = this.f;
            }
            n1(this.G, z, z2);
        }
    }

    public final void w0(boolean z, boolean z2, @Nullable w wVar) {
        GroupChatFragment groupChatFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048651, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), wVar}) == null) && this.m != null && (groupChatFragment = this.j) != null) {
            groupChatFragment.q2(true);
            this.j.y2();
            this.m.u(new m(this, z, z2, wVar));
        }
    }

    public final void r1(int i2, String str, String str2, String str3, String str4, String str5, String str6, IUploadTransferListener iUploadTransferListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048642, this, new Object[]{Integer.valueOf(i2), str, str2, str3, str4, str5, str6, iUploadTransferListener}) == null) {
            new AsyncUploadTask(this.b, i2, str, str2, str3, str4, str5, str6, iUploadTransferListener).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    public final void s1() {
        GroupChatFragment groupChatFragment;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048644, this) == null) && (groupChatFragment = this.j) != null) {
            long h2 = groupChatFragment.h2();
            long f2 = this.j.f2();
            String g2 = this.j.g2();
            int i2 = 2;
            StatisticItem param = new StatisticItem("c15134").param("obj_type", 2);
            if (this.I == SourceType.ONE) {
                i2 = 1;
            }
            StatisticItem param2 = param.param("obj_source", i2);
            BotsDTO.BotListDTO.SkillDTO skillDTO = this.G;
            if (skillDTO != null) {
                str = skillDTO.getName();
            } else {
                str = StringUtil.NULL_STRING;
            }
            StatisticItem param3 = param2.param("obj_name", str).param("fid", f2).param("fname", g2).param("room_id", h2);
            BotsDTO.BotListDTO.UserDTO userDTO = this.D;
            if (userDTO != null) {
                str2 = BIMManager.getBdUidFromBdUK(userDTO.getUk());
            } else {
                str2 = "";
            }
            TiebaStatic.log(param3.param("obj_id", str2).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void u1(@NonNull String str, @NonNull zv7 zv7Var) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048648, this, str, zv7Var) != null) || StringUtils.isNull(str)) {
            return;
        }
        Bitmap reSizeBitmap = PicManager.getInstance().getReSizeBitmap(ai.d().c(str));
        if (reSizeBitmap != null) {
            rm rmVar = new rm(reSizeBitmap, false);
            int r2 = rmVar.r();
            i3 = rmVar.m();
            i2 = r2;
        } else {
            i2 = 0;
            i3 = 0;
        }
        BIMManager.genBosObjectUrl(this.b, str, "image/jpeg", "jpg", 12, i2, i3, new f(this, zv7Var, str));
    }
}
