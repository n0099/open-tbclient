package com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputTool;

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
import com.baidu.tieba.b49;
import com.baidu.tieba.cq7;
import com.baidu.tieba.dj;
import com.baidu.tieba.e75;
import com.baidu.tieba.ej;
import com.baidu.tieba.eq5;
import com.baidu.tieba.gh;
import com.baidu.tieba.go7;
import com.baidu.tieba.im.chat.AbsMsglistView;
import com.baidu.tieba.im.chat.ISendVoiceView;
import com.baidu.tieba.im.model.LocalPicModel;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.GroupChatFragment;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputTool.GroupInputTool;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputTool.robotfloor.GroupChatRobotTopHeadView;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputTool.robotfloor.data.UserReplyInfoData;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.BotsDTO;
import com.baidu.tieba.kp5;
import com.baidu.tieba.lb5;
import com.baidu.tieba.mb5;
import com.baidu.tieba.mg5;
import com.baidu.tieba.on;
import com.baidu.tieba.oo5;
import com.baidu.tieba.op5;
import com.baidu.tieba.p35;
import com.baidu.tieba.rq7;
import com.baidu.tieba.sj;
import com.baidu.tieba.sq7;
import com.baidu.tieba.tq7;
import com.baidu.tieba.uq7;
import com.baidu.tieba.vq7;
import com.baidu.tieba.w9;
import com.baidu.tieba.wb5;
import com.baidu.tieba.wq7;
import com.baidu.tieba.xb5;
import com.baidu.tieba.xi;
import com.baidu.tieba.xq7;
import com.baidu.tieba.yq7;
import com.baidu.tieba.z11;
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
/* loaded from: classes5.dex */
public class GroupInputViewController implements VoiceManager.j, LifecycleObserver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public Object B;
    public cq7 C;
    public BotsDTO.BotListDTO.UserDTO D;
    public ArrayList<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> E;
    public List<BotsDTO.BotListDTO.SkillDTO> F;
    public BotsDTO.BotListDTO.SkillDTO G;
    public GroupChatRobotTopHeadView H;
    public SourceType I;
    public final CustomMessageListener J;
    public mb5 K;
    public sq7.j L;
    public GroupInputTool.h M;
    public final w9 N;
    public final CustomMessageListener O;
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
    public rq7 m;
    public sq7 n;
    public ISendVoiceView o;
    public Long p;
    public go7 q;
    public boolean r;
    public String s;
    public boolean t;
    public PermissionJudgePolicy u;
    public boolean v;
    @Nullable
    public wq7 w;
    public xq7 x;
    public yq7 y;
    public String z;

    /* loaded from: classes5.dex */
    public interface x {
        void a();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65567, this) == null) {
        }
    }

    public boolean Z(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048608, this, i2, i3)) == null) ? i2 > 1 && i2 > i3 : invokeII.booleanValue;
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

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageFileInfo a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ GroupInputViewController d;

        /* loaded from: classes5.dex */
        public class a extends kp5<Object> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // com.baidu.tieba.kp5
            public Object doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    b bVar = this.a;
                    bVar.d.b0(bVar.a);
                    return null;
                }
                return invokeV.objValue;
            }
        }

        /* renamed from: com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputTool.GroupInputViewController$b$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0319b implements oo5<Object> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public C0319b(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // com.baidu.tieba.oo5
            public void onReturnDataInUI(Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                    if (this.a.a.isGif()) {
                        this.a.d.d = new LocalPicModel(null, TbConfig.IMAGE_RESIZED_FILE, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                    } else {
                        b bVar = this.a;
                        bVar.d.d = new LocalPicModel(bVar.b, bVar.c, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                    }
                    this.a.d.d.setLoadDataCallBack(this.a.d.N);
                    this.a.d.d.getData();
                }
            }
        }

        public b(GroupInputViewController groupInputViewController, ImageFileInfo imageFileInfo, String str, String str2) {
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
                op5.b(new a(this), new C0319b(this));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements xq7.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        /* loaded from: classes5.dex */
        public class a implements xq7.d {
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

            @Override // com.baidu.tieba.xq7.d
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.O0(SourceType.ONE, false);
                }
            }
        }

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

        @Override // com.baidu.tieba.xq7.f
        public void a(BotsDTO.BotListDTO.UserDTO userDTO, BotsDTO.BotListDTO.SkillDTO skillDTO) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, userDTO, skillDTO) == null) && userDTO != null && skillDTO != null) {
                this.a.X0(userDTO, skillDTO);
                this.a.d0();
                this.a.J0(true);
                if (this.a.j0() != null) {
                    this.a.j0().n(new a(this));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements IGenBosObjectUrlListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vq7 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ GroupInputViewController c;

        /* loaded from: classes5.dex */
        public class a implements IUploadTransferListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ g b;

            public a(g gVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = gVar;
                this.a = str;
            }

            @Override // com.baidu.android.imsdk.upload.IUploadTransferListener
            public void onFailed(int i, int i2, String str) {
                vq7 vq7Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, str) == null) && (vq7Var = this.b.a) != null) {
                    vq7Var.a(i, i2, str);
                }
            }

            @Override // com.baidu.android.imsdk.upload.IUploadTransferListener
            public void onFinished(int i, String str) {
                vq7 vq7Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) && (vq7Var = this.b.a) != null) {
                    vq7Var.c(i, str, this.a);
                }
            }

            @Override // com.baidu.android.imsdk.upload.IUploadTransferListener
            public void onProgress(int i) {
                vq7 vq7Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (vq7Var = this.b.a) != null) {
                    vq7Var.b(i);
                }
            }
        }

        public g(GroupInputViewController groupInputViewController, vq7 vq7Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController, vq7Var, str};
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
            this.a = vq7Var;
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
                    if (dj.isEmpty(str4) || dj.isEmpty(str5) || dj.isEmpty(str6)) {
                        vq7 vq7Var = this.a;
                        if (vq7Var != null) {
                            vq7Var.a(i, 1, this.b);
                            return;
                        }
                        return;
                    }
                    this.c.k1(1, str4, str5, this.b, "image/jpeg", str2, str3, new a(this, str6));
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(572387337, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/inputTool/GroupInputViewController$SourceType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(572387337, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/inputTool/GroupInputViewController$SourceType;");
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
    public class a implements oo5<Map<String, Object>> {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oo5
        /* renamed from: a */
        public void onReturnDataInUI(Map<String, Object> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, map) == null) {
                this.a.d = new LocalPicModel(null, TbConfig.IMAGE_RESIZED_FILE, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                this.a.d.setExtraMap(map);
                this.a.d.setLoadDataCallBack(this.a.N);
                this.a.d.getData();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.l.R(false);
                this.a.v = true;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(GroupInputViewController groupInputViewController, int i) {
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean) || !((Boolean) customResponsedMessage.getData()).booleanValue() || !this.a.v) {
                return;
            }
            this.a.v = false;
            if (this.a.T()) {
                return;
            }
            this.a.Y(true, 1);
        }
    }

    /* loaded from: classes5.dex */
    public class f implements yq7.e {
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

        @Override // com.baidu.tieba.yq7.e
        public void a(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) != null) || this.a.l == null) {
                return;
            }
            if (this.a.k != null) {
                this.a.k.c2();
            }
            GroupInputViewController groupInputViewController = this.a;
            groupInputViewController.M0(groupInputViewController.h.getString(R.string.im_msg_input_hint));
            this.a.N0(false);
            this.a.l.n(i, i2, j, animatorListenerAdapter, z);
        }

        @Override // com.baidu.tieba.yq7.e
        public void b(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) != null) || this.a.l == null) {
                return;
            }
            if (this.a.k != null) {
                this.a.k.i2();
            }
            GroupInputViewController groupInputViewController = this.a;
            groupInputViewController.M0(groupInputViewController.z);
            this.a.N0(true);
            this.a.l.m(i, i2, j, animatorListenerAdapter, z);
        }

        @Override // com.baidu.tieba.yq7.e
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.V();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements GroupChatRobotTopHeadView.b {
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

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputTool.robotfloor.GroupChatRobotTopHeadView.b
        public void onCloseEvent() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.B0(null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements yq7.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SourceType a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ GroupInputViewController c;

        public i(GroupInputViewController groupInputViewController, SourceType sourceType, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController, sourceType, Boolean.valueOf(z)};
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
            this.a = sourceType;
            this.b = z;
        }

        @Override // com.baidu.tieba.yq7.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.c.h1(this.a, this.b);
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.n != null) {
                if (this.a.n.z()) {
                    this.a.n.s();
                    return;
                }
                this.a.n0(false);
                this.a.l1();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements go7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        @Override // com.baidu.tieba.go7
        public void setRecoding(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            }
        }

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

        @Override // com.baidu.tieba.go7
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.j != null && this.a.i0().f()) {
                    if (this.a.k == null) {
                        return true;
                    }
                    FragmentActivity fragmentActivity = this.a.k.getFragmentActivity();
                    if (this.a.u == null) {
                        this.a.u = new PermissionJudgePolicy();
                    }
                    this.a.u.clearRequestPermissionList();
                    this.a.u.appendRequestPermission(fragmentActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    this.a.u.appendRequestPermission(fragmentActivity, PermissionRequest.RESOURCE_AUDIO_CAPTURE);
                    return !this.a.u.startRequestPermission(fragmentActivity);
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.go7
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.i0() != null) {
                this.a.i0().cancelRecord();
            }
        }

        @Override // com.baidu.tieba.go7
        public boolean isForeground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.a.r;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.go7
        public void stopRecord() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.a.i0() != null) {
                this.a.i0().stopRecord();
            }
        }

        @Override // com.baidu.tieba.go7
        public void startRecord() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.a.i0() != null) {
                this.a.i0().c(this.a.l, -1);
                this.a.i0().d(sj.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.n != null && this.a.n.z()) {
                    this.a.n.s();
                    return;
                }
                this.a.o0(true, false, null);
                this.a.l1();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m implements sq7.i {
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

        @Override // com.baidu.tieba.sq7.i
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.G0();
                this.a.o0(true, true, null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ x c;
        public final /* synthetic */ GroupInputViewController d;

        public n(GroupInputViewController groupInputViewController, boolean z, boolean z2, x xVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController, Boolean.valueOf(z), Boolean.valueOf(z2), xVar};
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
            this.c = xVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, animator) != null) {
                return;
            }
            this.d.E0(this.a, this.b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) != null) {
                return;
            }
            this.d.E0(this.a, this.b);
            x xVar = this.c;
            if (xVar != null) {
                xVar.a();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static /* synthetic */ class o {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1007146761, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/inputTool/GroupInputViewController$o;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1007146761, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/inputTool/GroupInputViewController$o;");
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
    public class p extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(GroupInputViewController groupInputViewController, int i) {
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
                    this.a.m.D(this.a.a);
                }
                this.a.m1(booleanValue);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q implements mb5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        public q(GroupInputViewController groupInputViewController) {
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
        public void A(lb5 lb5Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, lb5Var) != null) || lb5Var == null) {
                return;
            }
            int i = lb5Var.a;
            if (i == 24) {
                Object obj = lb5Var.c;
                if (obj instanceof e75) {
                    e75 e75Var = (e75) obj;
                    if (e75Var.getType() != EmotionGroupType.LOCAL) {
                        this.a.F0(e75Var);
                    }
                }
            } else if (i == 8) {
                this.a.G0();
                this.a.n0(true);
            } else if (i == 4) {
                Object obj2 = lb5Var.c;
                if (obj2 instanceof String) {
                    this.a.f = (String) obj2;
                    this.a.Y(false, 1);
                }
            } else if (i == 14) {
                this.a.C0();
            } else if (i != 17) {
                if (i == 62) {
                    boolean booleanValue = ((Boolean) lb5Var.c).booleanValue();
                    if (this.a.l == null) {
                        return;
                    }
                    if (booleanValue) {
                        this.a.W();
                    } else {
                        this.a.Y(true, 1);
                    }
                    if (!this.a.l.M() || this.a.h0() != ToolState.TEXT) {
                        return;
                    }
                    this.a.T0(false);
                } else if (i == 63) {
                    ((Boolean) lb5Var.c).booleanValue();
                    if (this.a.l == null) {
                        return;
                    }
                    this.a.l.R(false);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r implements sq7.j {
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

        @Override // com.baidu.tieba.sq7.j
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZ(1048576, this, z) != null) {
                return;
            }
            this.a.a1(z);
        }
    }

    /* loaded from: classes5.dex */
    public class s implements xq7.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserReplyInfoData a;
        public final /* synthetic */ GroupInputViewController b;

        public s(GroupInputViewController groupInputViewController, UserReplyInfoData userReplyInfoData) {
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

        @Override // com.baidu.tieba.xq7.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.y.k(null, this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t implements x {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserReplyInfoData a;
        public final /* synthetic */ GroupInputViewController b;

        public t(GroupInputViewController groupInputViewController, UserReplyInfoData userReplyInfoData) {
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

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputTool.GroupInputViewController.x
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.y.k(null, this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u implements GroupInputTool.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputTool.GroupInputTool.h
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

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

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputTool.GroupInputTool.h
        public void b(VoiceData.VoiceModel voiceModel) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voiceModel) == null) && voiceModel != null && !StringUtils.isNull(voiceModel.getVoiceId()) && this.a.w != null) {
                this.a.w.b(voiceModel.getVoiceId(), voiceModel.getDuration());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class v extends w9 {
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

        @Override // com.baidu.tieba.w9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (obj instanceof LocalPicModel.ResponseData) {
                    LocalPicModel.ResponseData responseData = (LocalPicModel.ResponseData) obj;
                    String str = responseData.getBitmap().getWidth() + "," + responseData.getBitmap().getHeight();
                    if (responseData.getExtraMap() != null) {
                        this.a.w.a(responseData.getSPathGen(), str, responseData.getExtraMap());
                        return;
                    } else {
                        this.a.w.d(responseData.getSPathGen(), str);
                        return;
                    }
                }
                this.a.k.showToast(TbadkCoreApplication.getInst().getString(R.string.pic_parser_error));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w extends kp5<Map<String, Object>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e75 a;
        public final /* synthetic */ GroupInputViewController b;

        public w(GroupInputViewController groupInputViewController, e75 e75Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController, e75Var};
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
            this.a = e75Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kp5
        /* renamed from: a */
        public Map<String, Object> doInBackground() {
            InterceptResult invokeV;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                String d = mg5.b.d(this.a.d(), true);
                boolean exists = new File(d).exists();
                if (!exists) {
                    d = d.replace(".gif", ".jpg");
                }
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setFilePath(d);
                imageFileInfo.setIsGif(exists);
                this.b.b0(imageFileInfo);
                String b = mg5.b.b(this.a.d());
                int i = o.a[this.a.getType().ordinal()];
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
        this.a = ToolState.TEXT;
        this.c = new WriteImagesInfo(1);
        this.d = null;
        this.i = null;
        this.o = null;
        this.q = new k(this);
        this.t = true;
        this.z = null;
        this.C = new cq7();
        this.E = new ArrayList<>();
        this.H = null;
        this.J = new p(this, 2921790);
        this.K = new q(this);
        this.L = new r(this);
        this.M = new u(this);
        this.N = new v(this);
        this.O = new d(this, 2921785);
        this.k = groupChatFragment;
        this.h = groupChatFragment.getPageContext();
        this.b = groupChatFragment.getContext();
        v0();
        p0();
        MessageManager.getInstance().registerListener(this.J);
    }

    public void A0(@NonNull Bundle bundle) {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) && (voiceManager = this.j) != null) {
            voiceManager.onSaveInstanceState(this.h.getPageActivity());
        }
    }

    public void H0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.z = str;
        }
    }

    public final void J0(boolean z) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048585, this, z) != null) || (groupInputTool = this.l) == null) {
            return;
        }
        if (z) {
            groupInputTool.T(1);
        } else {
            groupInputTool.T(0);
        }
    }

    public void L0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.f = str;
            EditorTools editorTools = this.i;
            if (editorTools != null) {
                editorTools.C(new lb5(6, 3, str));
            }
        }
    }

    public void M0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.s = str;
            EditorTools editorTools = this.i;
            if (editorTools != null) {
                editorTools.C(new lb5(71, 3, str));
            }
        }
    }

    public void N0(boolean z) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048589, this, z) == null) && (groupInputTool = this.l) != null) {
            groupInputTool.U(z);
        }
    }

    public void Q0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048592, this, z) == null) && this.i.o(6) != null) {
            if (!z) {
                this.i.o(6).hide();
            } else {
                this.i.o(6).display();
            }
        }
    }

    public void S0(GroupInputTool.f fVar) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, fVar) == null) && (groupInputTool = this.l) != null) {
            groupInputTool.Y(fVar);
        }
    }

    public void U0(Long l2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, l2) == null) {
            this.p = l2;
        }
    }

    public void V0(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, view2) == null) {
            this.e = view2;
        }
    }

    public void Z0(@Nullable wq7 wq7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, wq7Var) == null) {
            this.w = wq7Var;
        }
    }

    public final void c0(@NonNull List<BotsDTO.BotListDTO.SkillDTO> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, list) == null) {
            for (BotsDTO.BotListDTO.SkillDTO skillDTO : list) {
                if (skillDTO != null && skillDTO.getType() == this.A) {
                    this.G = skillDTO;
                    return;
                }
            }
        }
    }

    public void d1(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, editorTools) == null) {
            this.i = editorTools;
        }
    }

    public final void m1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048635, this, z) == null) {
            if (z) {
                W();
                T0(true);
                return;
            }
            Y(true, 1);
            T0(false);
        }
    }

    public final void n0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048636, this, z) == null) {
            o0(false, z, null);
        }
    }

    public void O0(SourceType sourceType, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048590, this, sourceType, z) == null) {
            sq7 sq7Var = this.n;
            if (sq7Var != null && sq7Var.y()) {
                return;
            }
            if (x0()) {
                this.y.i(new i(this, sourceType, z));
            } else {
                h1(sourceType, z);
            }
        }
    }

    public void X0(BotsDTO.BotListDTO.UserDTO userDTO, BotsDTO.BotListDTO.SkillDTO skillDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048605, this, userDTO, skillDTO) == null) {
            this.D = userDTO;
            this.G = skillDTO;
        }
    }

    public final void h1(SourceType sourceType, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048625, this, sourceType, z) == null) {
            this.I = sourceType;
            GroupChatFragment groupChatFragment = this.k;
            if (groupChatFragment != null) {
                groupChatFragment.c2();
            }
            if (this.I == SourceType.TWO) {
                this.g = this.f;
            }
            g1(this.G, z);
        }
    }

    public void o1(@NonNull String str, @NonNull tq7 tq7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048639, this, str, tq7Var) == null) {
            uq7 uq7Var = new uq7(this.b, str, "audio/amr");
            uq7Var.b(tq7Var);
            BIMManager.audioTrans(this.b, str, "audio/amr", "amr", 12, uq7Var);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65568, this) == null) {
            VoiceManager voiceManager = this.j;
            if (voiceManager != null) {
                voiceManager.onDestory(this.h);
            }
            rq7 rq7Var = this.m;
            if (rq7Var != null) {
                rq7Var.x();
            }
            sq7 sq7Var = this.n;
            if (sq7Var != null) {
                sq7Var.B();
            }
            VoiceManager.setIsNeedBlackScreen(true);
            MessageManager.getInstance().unRegisterListener(this.O);
            MessageManager.getInstance().unRegisterListener(this.J);
        }
    }

    public final boolean T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            rq7 rq7Var = this.m;
            if (rq7Var == null || z11.h(rq7Var.t()) != 1 || !this.m.t().get(0).isRobot()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048646, this) == null) {
            if (this.j == null) {
                VoiceManager voiceManager = new VoiceManager();
                this.j = voiceManager;
                voiceManager.onCreate(this.h);
            }
            this.j.setSpeakerphoneOn(!TbadkCoreApplication.getInst().isHeadsetModeOn());
            VoiceManager.setIsUseMediaPlayer(true);
            VoiceManager.setIsNeedBlackScreen(false);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65569, this) == null) {
            this.r = false;
            VoiceManager voiceManager = this.j;
            if (voiceManager != null) {
                voiceManager.onPause();
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65570, this) == null) {
            this.r = true;
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
        if (interceptable == null || interceptable.invokeV(65571, this) == null) {
            if (g0() != null && g0().D()) {
                return;
            }
            TbSingleton.getInstance().setRoomDraft(this.p, f0());
        }
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            d0();
            if (x0()) {
                V();
            }
            a0();
            Y0(2, true);
            P0(true);
            Q0(true);
        }
    }

    public boolean U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            GroupInputTool groupInputTool = this.l;
            if (groupInputTool != null) {
                return groupInputTool.q();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void V() {
        yq7 yq7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && (yq7Var = this.y) != null) {
            yq7Var.i(null);
        }
    }

    public final void W() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && j0() != null) {
            j0().n(null);
        }
    }

    public void W0() {
        sq7 sq7Var;
        ArrayList<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (sq7Var = this.n) != null && (arrayList = (ArrayList) sq7Var.r()) != null) {
            this.E = arrayList;
        }
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.C.a();
            this.E.clear();
            this.D = null;
            this.G = null;
            this.B = null;
        }
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            this.f = null;
            EditorTools editorTools = this.i;
            if (editorTools != null) {
                editorTools.C(new lb5(9, -1, Boolean.TRUE));
            }
        }
    }

    public mb5 e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.K;
        }
        return (mb5) invokeV.objValue;
    }

    public GroupInputTool g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return this.l;
        }
        return (GroupInputTool) invokeV.objValue;
    }

    public ToolState h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return this.a;
        }
        return (ToolState) invokeV.objValue;
    }

    public b49 i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            VoiceManager voiceManager = this.j;
            if (voiceManager != null && voiceManager.getRecorderManager() != null) {
                return this.j.getRecorderManager();
            }
            return null;
        }
        return (b49) invokeV.objValue;
    }

    public xq7 j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            return this.x;
        }
        return (xq7) invokeV.objValue;
    }

    public yq7 k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            return this.y;
        }
        return (yq7) invokeV.objValue;
    }

    public SourceType l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return this.I;
        }
        return (SourceType) invokeV.objValue;
    }

    public void m0() {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048634, this) == null) && (groupInputTool = this.l) != null) {
            groupInputTool.J();
        }
    }

    public final void p0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048640, this) == null) && this.m == null) {
            this.m = new rq7(this.b, this.k);
        }
    }

    public final void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            ISendVoiceView iSendVoiceView = this.o;
            if (iSendVoiceView != null) {
                iSendVoiceView.setTouchCallBack(this.q);
            }
            GroupInputTool groupInputTool = this.l;
            if (groupInputTool != null) {
                groupInputTool.Z(this.M);
            }
        }
    }

    public final void r0() {
        xq7 xq7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048642, this) == null) && (xq7Var = this.x) != null) {
            xq7Var.m(new e(this));
        }
    }

    public final GroupChatRobotTopHeadView s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            GroupInputTool groupInputTool = this.l;
            if (groupInputTool == null) {
                return null;
            }
            GroupChatRobotTopHeadView G = groupInputTool.G();
            this.H = G;
            G.setEventCallback(new h(this));
            return this.H;
        }
        return (GroupChatRobotTopHeadView) invokeV.objValue;
    }

    public final void t0() {
        yq7 yq7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048644, this) == null) && (yq7Var = this.y) != null) {
            yq7Var.h(new f(this));
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            return this.j;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public boolean w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            if (FileHelper.checkSD()) {
                return true;
            }
            ej.Q(this.b, TbadkCoreApplication.getInst().getString(R.string.voice_error_sdcard));
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            yq7 yq7Var = this.y;
            if (yq7Var != null && yq7Var.d()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void B0(@Nullable x xVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xVar) == null) {
            o0(true, false, xVar);
            l1();
            d0();
            a0();
            J0(false);
            GroupChatFragment groupChatFragment = this.k;
            if (groupChatFragment != null) {
                long Z1 = groupChatFragment.Z1();
                long X1 = this.k.X1();
                TiebaStatic.log(new StatisticItem("c15134").param("obj_type", 2).param("fid", X1).param("fname", this.k.Y1()).param("room_id", Z1).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
            rq7 rq7Var = this.m;
            if (rq7Var != null) {
                rq7Var.B();
            }
        }
    }

    public final void C0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || !w0()) {
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

    public String f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
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

    public void D0(@NonNull UserReplyInfoData userReplyInfoData, @NonNull Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048579, this, userReplyInfoData, obj) != null) || this.m == null) {
            return;
        }
        this.B = obj;
        d0();
        X(userReplyInfoData);
        this.m.B();
        this.m.j(new AtSelectData(userReplyInfoData.getmPortrait(), userReplyInfoData.getmNameShow(), String.valueOf(userReplyInfoData.getmUid()), userReplyInfoData.isRobot()), false);
    }

    public final void R0(boolean z, String str) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048593, this, z, str) == null) && (editorTools = this.i) != null && editorTools.p(38) != null && (this.i.p(38).m instanceof SendNoLaunchView)) {
            ((SendNoLaunchView) this.i.p(38).m).setPicIconEnable(z);
            ((SendNoLaunchView) this.i.p(38).m).setSendInterceptToastText(str, z);
        }
    }

    public final void i1(List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> list, boolean z) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048627, this, list, z) == null) && (groupInputTool = this.l) != null && groupInputTool.z() != null) {
            sq7 sq7Var = this.n;
            if (sq7Var == null) {
                sq7 sq7Var2 = new sq7(this.l.z(), this.L);
                this.n = sq7Var2;
                sq7Var2.v(list, z);
            } else {
                sq7Var.A(list, z);
            }
            this.n.F(z, !ListUtils.isEmpty(list));
        }
    }

    public final void j1(List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> list, boolean z) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048629, this, list, z) == null) && (groupInputTool = this.l) != null && groupInputTool.z() != null && !ListUtils.isEmpty(list)) {
            sq7 sq7Var = this.n;
            if (sq7Var == null) {
                sq7 sq7Var2 = new sq7(this.l.z(), this.L);
                this.n = sq7Var2;
                sq7Var2.v(list, z);
            } else {
                sq7Var.A(list, z);
            }
            this.n.H(new m(this), z);
        }
    }

    public final void y0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048649, this, str, str2) == null) {
            Iterator<ImageFileInfo> it = this.c.getChosedFiles().iterator();
            long j2 = 0;
            while (it.hasNext()) {
                j2++;
                gh.a().postDelayed(new b(this, it.next(), str, str2), 100 * j2);
            }
            WriteImagesInfo writeImagesInfo = this.c;
            if (writeImagesInfo != null) {
                writeImagesInfo.clear();
            }
        }
    }

    public final void E0(boolean z, boolean z2) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && this.l != null) {
            a0();
            boolean z3 = false;
            this.l.X(false);
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
                Y0(2, true);
            } else {
                Y0(3, true);
            }
            P0(true);
            Q0(true);
            N0(true);
            if (this.l.H() != null && this.I == SourceType.TWO && z) {
                this.l.H().m();
            }
            if (this.I == SourceType.ONE && !TextUtils.isEmpty(this.z)) {
                M0(this.z);
            } else if (z3) {
                if (!z2 && !TextUtils.isEmpty(this.f)) {
                    L0(this.f);
                }
                if (!TextUtils.isEmpty(this.z)) {
                    M0(this.z);
                } else {
                    M0(this.h.getString(R.string.im_msg_input_hint));
                }
            }
        }
    }

    public void F0(e75 e75Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, e75Var) == null) && e75Var != null && e75Var.c() != null && e75Var.c().p() != null) {
            Activity pageActivity = this.h.getPageActivity();
            if (this.u == null) {
                this.u = new PermissionJudgePolicy();
            }
            this.u.clearRequestPermissionList();
            this.u.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.u.startRequestPermission(pageActivity)) {
                return;
            }
            op5.b(new w(this, e75Var), new a(this));
        }
    }

    public void I0(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString(TbEnum.ChatInputStatus.INPUT_DRAFT_KEY);
            if (this.i != null) {
                this.i.C(new lb5(6, 3, string));
            }
            this.f = string;
            if (jSONObject.getString(TbEnum.ChatInputStatus.INPUT_STATUS_KEY).equals(TbEnum.ChatInputStatus.INPUT_STATUS_VOICE) && this.i != null) {
                this.i.C(new lb5(1, 6, null));
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void P0(boolean z) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048591, this, z) == null) && (groupInputTool = this.l) != null && groupInputTool.w() != null && (this.l.w().m instanceof EmotionNoLaunchView)) {
            ((EmotionNoLaunchView) this.l.w().m).setNeedHideForever(z);
            if (!z) {
                this.l.w().m.hide();
            } else {
                this.l.w().m.display();
            }
        }
    }

    public final void b0(ImageFileInfo imageFileInfo) {
        Bitmap resizeBitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, imageFileInfo) == null) {
            try {
                if (imageFileInfo.isGif()) {
                    FileHelper.saveGifByRelativePath(imageFileInfo.getFilePath(), null, TbConfig.IMAGE_RESIZED_FILE);
                    FileHelper.saveGifByRelativePath(imageFileInfo.getFilePath(), null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                    return;
                }
                Bitmap c2 = eq5.c(0, this.b, null, imageFileInfo.getFilePath(), TbImageHelper.getInstance().getPostImageSize());
                if (c2 != null && FileHelper.saveBitmapByRelativelyPath(null, TbConfig.IMAGE_RESIZED_FILE, c2, 85) != null && (resizeBitmap = BitmapHelper.resizeBitmap(c2, 100)) != null) {
                    FileHelper.saveBitmapByRelativelyPath(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 85);
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public final void G0() {
        List<AtSelectData> list;
        Map<String, Integer> map;
        int i2;
        BotsDTO.BotListDTO.SkillDTO skillDTO;
        int i3;
        String str;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (!this.t) {
                S();
                EditorTools editorTools = this.i;
                if (editorTools != null) {
                    editorTools.r();
                }
            } else if (this.w != null) {
                W0();
                cq7 cq7Var = this.C;
                if (cq7Var != null) {
                    cq7Var.a = this.D;
                    cq7Var.b = this.G;
                    cq7Var.c = this.E;
                }
                rq7 rq7Var = this.m;
                if (rq7Var != null) {
                    rq7Var.w();
                    List<AtSelectData> r2 = this.m.r();
                    Map<String, Integer> k2 = this.m.k();
                    if (!ListUtils.isEmpty(this.m.r())) {
                        StatisticItem statisticItem = new StatisticItem("c15128");
                        GroupChatFragment groupChatFragment = this.k;
                        long j3 = 0;
                        if (groupChatFragment != null) {
                            j2 = groupChatFragment.X1();
                        } else {
                            j2 = 0;
                        }
                        StatisticItem param = statisticItem.param("fid", j2);
                        GroupChatFragment groupChatFragment2 = this.k;
                        if (groupChatFragment2 != null) {
                            j3 = groupChatFragment2.Z1();
                        }
                        TiebaStatic.log(param.param("room_id", j3).param("uid", TbadkCoreApplication.getCurrentAccount()));
                    }
                    map = k2;
                    list = r2;
                } else {
                    list = null;
                    map = null;
                }
                if (this.H != null && this.k != null && (skillDTO = this.G) != null && skillDTO.getName() != null) {
                    long Z1 = this.k.Z1();
                    long X1 = this.k.X1();
                    String Y1 = this.k.Y1();
                    StatisticItem param2 = new StatisticItem("c15134").param("obj_type", 3);
                    if (this.I == SourceType.ONE) {
                        i3 = 1;
                    } else {
                        i3 = 2;
                    }
                    StatisticItem param3 = param2.param("obj_source", i3);
                    BotsDTO.BotListDTO.SkillDTO skillDTO2 = this.G;
                    if (skillDTO2 != null) {
                        str = skillDTO2.getName();
                    } else {
                        str = StringUtil.NULL_STRING;
                    }
                    TiebaStatic.log(param3.param("obj_name", str).param("fid", X1).param("fname", Y1).param("room_id", Z1).param("uid", TbadkCoreApplication.getCurrentAccount()));
                }
                if (x0()) {
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
                wq7 wq7Var = this.w;
                String str2 = this.f;
                if (str2 == null) {
                    str2 = "";
                }
                wq7Var.c(str2, this.B, this.C, list, map, i2);
                S();
                rq7 rq7Var2 = this.m;
                if (rq7Var2 != null) {
                    rq7Var2.B();
                }
            }
        }
    }

    public void K0(GroupInputTool groupInputTool) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, groupInputTool) != null) || groupInputTool == null) {
            return;
        }
        this.l = groupInputTool;
        this.x = groupInputTool.B();
        if (groupInputTool.I() != null && groupInputTool.z() != null) {
            this.y = new yq7(groupInputTool.I(), this.k, groupInputTool.z());
        }
        MessageManager.getInstance().registerListener(this.O);
        r0();
        t0();
        s0();
        if (groupInputTool.H() != null) {
            d1(groupInputTool.H());
            EditorTools editorTools = this.i;
            if (editorTools != null) {
                editorTools.setActionListener(24, e0());
                this.i.setActionListener(8, e0());
                this.i.setActionListener(4, e0());
                this.i.setActionListener(14, e0());
                this.i.setActionListener(5, e0());
                this.i.setActionListener(17, e0());
                this.i.setActionListener(16, e0());
                this.i.setActionListener(62, e0());
                this.i.setActionListener(64, e0());
                this.i.setActionListener(63, e0());
            }
            if (groupInputTool.x() != null) {
                V0(groupInputTool.x());
            }
            if (groupInputTool.F() != null) {
                this.o = groupInputTool.F();
                q0();
            }
            f1(p35.m().i("key_group_chat_chatroom_audio_switch", true));
            R0(p35.m().i("key_group_chat_chatroom_picture_switch", true), this.b.getString(R.string.function_can_not_use));
            this.i.C(new lb5(73, 3, 200));
            if (this.p.longValue() != 0 && !dj.isEmpty(TbSingleton.getInstance().getRoomDraft(this.p))) {
                I0(TbSingleton.getInstance().getRoomDraft(this.p));
            }
            rq7 rq7Var = this.m;
            if (rq7Var != null) {
                rq7Var.q(groupInputTool, this.i);
                this.m.y();
            }
        }
    }

    public final void T0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048597, this, z) == null) && k0() != null) {
            if (z) {
                k0().j(false);
            } else if (!k0().f()) {
                k0().j(!z);
            }
        }
    }

    public final void X(@NonNull UserReplyInfoData userReplyInfoData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048604, this, userReplyInfoData) != null) || this.y == null) {
            return;
        }
        xq7 xq7Var = this.x;
        if (xq7Var != null && xq7Var.h()) {
            this.x.n(new s(this, userReplyInfoData));
        } else if (this.l.D()) {
            B0(new t(this, userReplyInfoData));
        } else {
            this.y.k(null, userReplyInfoData);
        }
    }

    public final void a1(boolean z) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048611, this, z) != null) || this.H == null || !z) {
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

    public final void f1(boolean z) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048621, this, z) == null) && (editorTools = this.i) != null) {
            if (editorTools.p(6) != null && !z) {
                this.i.p(6).f = R.color.CAM_X0109;
                this.i.p(6).k = false;
                return;
            }
            this.i.p(6).f = R.color.CAM_X0105;
            this.i.p(6).k = true;
        }
    }

    public final void Y(boolean z, int i2) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) && (groupInputTool = this.l) != null && groupInputTool.H() != null && !this.l.M() && this.x != null) {
            if (z) {
                this.l.H().requestFocus();
            }
            if (!this.l.H().hasFocus()) {
                return;
            }
            if (i2 != 2 && (TextUtils.isEmpty(this.f) || !this.f.equals("/"))) {
                this.x.n(null);
            } else {
                this.x.q(null, i2);
            }
        }
    }

    public void Y0(int i2, boolean z) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && (groupInputTool = this.l) != null && groupInputTool.E() != null && (this.l.E().m instanceof SendNoLaunchView)) {
            if (i2 == 1) {
                ((SendNoLaunchView) this.l.E().m).setIsSendIcon(true);
                ((SendNoLaunchView) this.l.E().m).setSendVisibility(z);
            } else if (i2 == 2) {
                ((SendNoLaunchView) this.l.E().m).setIsSendIcon(false);
                ((SendNoLaunchView) this.l.E().m).setSendVisibility(false);
            } else if (i2 == 3) {
                ((SendNoLaunchView) this.l.E().m).setIsSendIcon(false);
                ((SendNoLaunchView) this.l.E().m).setSendVisibility(true);
            }
        }
    }

    public void b1(int i2, @NonNull Object obj, @NonNull cq7 cq7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048613, this, i2, obj, cq7Var) == null) {
            sq7 sq7Var = this.n;
            if (sq7Var != null && sq7Var.y()) {
                return;
            }
            this.A = i2;
            this.B = obj;
            this.D = cq7Var.a;
            if (this.F == null) {
                this.F = new ArrayList();
            }
            this.F.clear();
            BotsDTO.BotListDTO.SkillDTO skillDTO = cq7Var.b;
            if (skillDTO != null && !ListUtils.isEmpty(skillDTO.getSubSkill())) {
                this.F.addAll(cq7Var.b.getSubSkill());
                c0(this.F);
            }
        }
    }

    public void e1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            this.t = z;
            if (this.i != null) {
                if (p35.m().i("key_group_chat_chatroom_audio_switch", true)) {
                    this.i.setToolEnabled(z, 6);
                }
                this.i.C(new lb5(72, 3, Boolean.valueOf(z)));
                if (this.i.p(37) != null && (this.i.p(37).m instanceof EmotionNoLaunchView)) {
                    ((EmotionNoLaunchView) this.i.p(37).m).setEnabled(z);
                }
                if (p35.m().i("key_group_chat_chatroom_picture_switch", true) && this.i.p(38) != null && (this.i.p(38).m instanceof SendNoLaunchView)) {
                    ((SendNoLaunchView) this.i.p(38).m).setIconEnable(z);
                    ((SendNoLaunchView) this.i.p(38).m).setSendInterceptToastText(this.s, z);
                }
            }
            rq7 rq7Var = this.m;
            if (rq7Var != null) {
                rq7Var.E(z);
            }
            GroupInputTool groupInputTool = this.l;
            if (groupInputTool != null && groupInputTool.y() != null && this.l.y().g() != null) {
                if (z) {
                    this.l.y().g().setEnabled(true);
                    this.l.y().g().setOnClickListener(new c(this));
                    return;
                }
                this.l.y().g().setEnabled(false);
            }
        }
    }

    public final void g1(BotsDTO.BotListDTO.SkillDTO skillDTO, boolean z) {
        BotsDTO.BotListDTO.SkillDTO skillDTO2;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048623, this, skillDTO, z) == null) {
            if (skillDTO != null) {
                skillDTO2 = skillDTO.copy();
            } else {
                skillDTO2 = null;
            }
            if (this.l != null && skillDTO2 != null) {
                int i2 = 1;
                if (this.I == SourceType.TWO) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.l.X(z);
                this.l.t(true);
                this.l.v(!z2);
                if (skillDTO2.getKeyboard() == 1) {
                    if (z2) {
                        this.g = this.f;
                        L0("");
                    }
                    if (!TextUtils.isEmpty(skillDTO2.getExp())) {
                        M0(skillDTO2.getExp());
                    } else if (z2) {
                        M0(this.h.getString(R.string.obfuscated_res_0x7f0f0895));
                    }
                    Y0(1, !TextUtils.isEmpty(this.f));
                    P0(false);
                    Q0(false);
                    N0(false);
                    this.l.W(new j(this));
                    if (this.l.H() != null) {
                        this.l.H().l();
                    }
                    i1(skillDTO2.getItems(), z2);
                } else {
                    if (this.l.H() != null) {
                        this.l.H().q();
                    }
                    this.l.W(new l(this));
                    j1(skillDTO2.getItems(), z2);
                }
                GroupChatFragment groupChatFragment = this.k;
                if (groupChatFragment != null) {
                    long Z1 = groupChatFragment.Z1();
                    long X1 = this.k.X1();
                    String Y1 = this.k.Y1();
                    StatisticItem param = new StatisticItem("c15134").param("obj_type", 1).param("obj_name", skillDTO2.getName());
                    if (this.I == SourceType.TWO) {
                        i2 = 2;
                    }
                    TiebaStatic.log(param.param("obj_source", i2).param("fid", X1).param("fname", Y1).param("room_id", Z1).param("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        }
    }

    public final void k1(int i2, String str, String str2, String str3, String str4, String str5, String str6, IUploadTransferListener iUploadTransferListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048631, this, new Object[]{Integer.valueOf(i2), str, str2, str3, str4, str5, str6, iUploadTransferListener}) == null) {
            new AsyncUploadTask(this.b, i2, str, str2, str3, str4, str5, str6, iUploadTransferListener).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    public final void l1() {
        GroupChatFragment groupChatFragment;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048633, this) == null) && (groupChatFragment = this.k) != null) {
            long Z1 = groupChatFragment.Z1();
            long X1 = this.k.X1();
            String Y1 = this.k.Y1();
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
            TiebaStatic.log(param2.param("obj_name", str).param("fid", X1).param("fname", Y1).param("room_id", Z1).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void n1(@NonNull String str, @NonNull vq7 vq7Var) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048637, this, str, vq7Var) != null) || StringUtils.isNull(str)) {
            return;
        }
        Bitmap reSizeBitmap = PicManager.getInstance().getReSizeBitmap(xi.d().c(str));
        if (reSizeBitmap != null) {
            on onVar = new on(reSizeBitmap, false);
            int r2 = onVar.r();
            i3 = onVar.m();
            i2 = r2;
        } else {
            i2 = 0;
            i3 = 0;
        }
        BIMManager.genBosObjectUrl(this.b, str, "image/jpeg", "jpg", 12, i2, i3, new g(this, vq7Var, str));
    }

    public final void o0(boolean z, boolean z2, @Nullable x xVar) {
        GroupChatFragment groupChatFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048638, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), xVar}) == null) && this.n != null && (groupChatFragment = this.k) != null) {
            groupChatFragment.i2();
            this.n.u(new n(this, z, z2, xVar));
        }
    }

    public void z0(int i2, int i3, @Nullable Intent intent) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIIL(1048650, this, i2, i3, intent) != null) || i3 != -1 || intent == null) {
            return;
        }
        if (i2 != 12010 && i2 != 12009 && i2 != 12002) {
            if (i2 == 12004) {
                boolean booleanExtra = intent.getBooleanExtra(IntentConfig.IS_AT_SELECT_BOT_DATA, false);
                ArrayList<AtSelectData> parcelableArrayListExtra = intent.getParcelableArrayListExtra(IntentConfig.AT_SELECT_LIST_DATA);
                if (this.m != null && !ListUtils.isEmpty(parcelableArrayListExtra)) {
                    this.m.G(parcelableArrayListExtra);
                    this.m.C(parcelableArrayListExtra);
                }
                if (this.x != null && booleanExtra) {
                    Y(false, 2);
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
                y0(str, stringExtra);
                return;
            }
            LocalPicModel localPicModel2 = new LocalPicModel(str, stringExtra, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
            this.d = localPicModel2;
            localPicModel2.setLoadDataCallBack(this.N);
            this.d.getData();
            return;
        }
        LocalPicModel localPicModel3 = new LocalPicModel(str, stringExtra, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
        this.d = localPicModel3;
        localPicModel3.setLoadDataCallBack(this.N);
        this.d.getData();
    }
}
