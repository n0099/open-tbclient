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
import com.baidu.tieba.a68;
import com.baidu.tieba.b58;
import com.baidu.tieba.b68;
import com.baidu.tieba.bd5;
import com.baidu.tieba.bi;
import com.baidu.tieba.c68;
import com.baidu.tieba.cd5;
import com.baidu.tieba.d68;
import com.baidu.tieba.dr5;
import com.baidu.tieba.e2b;
import com.baidu.tieba.e68;
import com.baidu.tieba.f85;
import com.baidu.tieba.g48;
import com.baidu.tieba.gq5;
import com.baidu.tieba.h68;
import com.baidu.tieba.hi;
import com.baidu.tieba.hr5;
import com.baidu.tieba.i68;
import com.baidu.tieba.i78;
import com.baidu.tieba.ii;
import com.baidu.tieba.im.chat.AbsMsglistView;
import com.baidu.tieba.im.model.LocalPicModel;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.GroupChatFragment;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.GroupInputTool;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.GroupInputViewController;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.GroupChatRobotTopHeadView;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.data.UserReplyInfoData;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.BotsDTO;
import com.baidu.tieba.j68;
import com.baidu.tieba.jg;
import com.baidu.tieba.k78;
import com.baidu.tieba.o78;
import com.baidu.tieba.q45;
import com.baidu.tieba.qc5;
import com.baidu.tieba.rc5;
import com.baidu.tieba.t78;
import com.baidu.tieba.tm;
import com.baidu.tieba.v68;
import com.baidu.tieba.w68;
import com.baidu.tieba.xr5;
import com.baidu.tieba.y01;
import com.baidu.tieba.y58;
import com.baidu.tieba.yh5;
import com.baidu.tieba.z58;
import com.baidu.tieba.z8;
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
    public int A;
    public Object B;
    public g48 C;
    public BotsDTO.BotListDTO.UserDTO D;
    public List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> E;
    public List<BotsDTO.BotListDTO.SkillDTO> F;
    public BotsDTO.BotListDTO.SkillDTO G;
    public GroupChatRobotTopHeadView H;
    public SourceType I;
    @NonNull
    public k78 J;
    public boolean K;
    public boolean L;
    public boolean M;
    public final CustomMessageListener N;
    public final CustomMessageListener O;
    public rc5 P;
    public a68.l Q;
    public GroupInputTool.h R;
    public a68.k S;
    public final z8 T;
    public final CustomMessageListener U;
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
    public y58 l;
    public a68 m;
    public GroupInputTool n;
    public long o;
    public boolean p;
    public String q;
    public boolean r;
    public PermissionJudgePolicy s;
    public boolean t;
    @Nullable
    public e68 u;
    public i68 v;
    public j68 w;
    public h68 x;
    public z58 y;
    public String z;

    /* loaded from: classes5.dex */
    public interface a0 {
        void a();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65566, this) == null) {
        }
    }

    public boolean g0(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048620, this, i2, i3)) == null) ? i2 > 1 && i2 > i3 : invokeII.booleanValue;
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
        public class a extends dr5<Object> {
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

            @Override // com.baidu.tieba.dr5
            public Object doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    c cVar = this.a;
                    cVar.d.i0(cVar.a);
                    return null;
                }
                return invokeV.objValue;
            }
        }

        /* loaded from: classes5.dex */
        public class b implements gq5<Object> {
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

            @Override // com.baidu.tieba.gq5
            public void onReturnDataInUI(Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                    if (this.a.a.isGif()) {
                        this.a.d.d = new LocalPicModel(null, TbConfig.IMAGE_RESIZED_FILE, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                    } else {
                        c cVar = this.a;
                        cVar.d.d = new LocalPicModel(cVar.b, cVar.c, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                    }
                    this.a.d.d.setLoadDataCallBack(this.a.d.T);
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
                hr5.b(new a(this), new b(this));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements i68.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        /* loaded from: classes5.dex */
        public class a implements i68.d {
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

            @Override // com.baidu.tieba.i68.d
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.f1(SourceType.ONE, false, false);
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

        @Override // com.baidu.tieba.i68.f
        public void a(BotsDTO.BotListDTO.UserDTO userDTO, BotsDTO.BotListDTO.SkillDTO skillDTO) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, userDTO, skillDTO) == null) && userDTO != null && skillDTO != null) {
                this.a.m1(userDTO, skillDTO);
                this.a.k0();
                this.a.Z0(true);
                if (this.a.r0() != null) {
                    this.a.r0().q(new a(this));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements IGenBosObjectUrlListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d68 a;
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
                d68 d68Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, str) == null) && (d68Var = this.b.a) != null) {
                    d68Var.a(i, i2, str);
                }
            }

            @Override // com.baidu.android.imsdk.upload.IUploadTransferListener
            public void onFinished(int i, String str) {
                d68 d68Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) && (d68Var = this.b.a) != null) {
                    d68Var.c(i, str, this.a);
                }
            }

            @Override // com.baidu.android.imsdk.upload.IUploadTransferListener
            public void onProgress(int i) {
                d68 d68Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (d68Var = this.b.a) != null) {
                    d68Var.b(i);
                }
            }
        }

        public h(GroupInputViewController groupInputViewController, d68 d68Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController, d68Var, str};
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
            this.a = d68Var;
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
                        d68 d68Var = this.a;
                        if (d68Var != null) {
                            d68Var.a(i, 1, this.b);
                            return;
                        }
                        return;
                    }
                    this.c.x1(1, str4, str5, this.b, "image/jpeg", str2, str3, new a(this, str6));
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
    public class a extends dr5<Map<String, Object>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f85 a;
        public final /* synthetic */ GroupInputViewController b;

        public a(GroupInputViewController groupInputViewController, f85 f85Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController, f85Var};
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
            this.a = f85Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dr5
        /* renamed from: a */
        public Map<String, Object> doInBackground() {
            InterceptResult invokeV;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                String d = yh5.b.d(this.a.d(), true);
                boolean exists = new File(d).exists();
                if (!exists) {
                    d = d.replace(".gif", ".jpg");
                }
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setFilePath(d);
                imageFileInfo.setIsGif(exists);
                this.b.i0(imageFileInfo);
                String b = yh5.b.b(this.a.d());
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
    public class b implements gq5<Map<String, Object>> {
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
        @Override // com.baidu.tieba.gq5
        /* renamed from: a */
        public void onReturnDataInUI(Map<String, Object> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, map) == null) {
                this.a.d = new LocalPicModel(null, TbConfig.IMAGE_RESIZED_FILE, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                this.a.d.setExtraMap(map);
                this.a.d.setLoadDataCallBack(this.a.T);
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
                this.a.k.Z(false);
                this.a.t = true;
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
                if (booleanValue && this.a.t) {
                    this.a.t = false;
                    if (!this.a.a0()) {
                        this.a.f0(true, 1);
                    }
                }
                if (!booleanValue && this.a.x != null) {
                    this.a.x.g();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements j68.e {
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

        @Override // com.baidu.tieba.j68.e
        public void a(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) != null) || this.a.k == null) {
                return;
            }
            if (this.a.j != null) {
                this.a.j.s2();
            }
            GroupInputViewController groupInputViewController = this.a;
            groupInputViewController.d1(groupInputViewController.h.getString(R.string.im_msg_input_hint));
            this.a.e1(false);
            this.a.k.r(i, i2, j, animatorListenerAdapter, z);
        }

        @Override // com.baidu.tieba.j68.e
        public void b(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) != null) || this.a.k == null) {
                return;
            }
            if (this.a.j != null) {
                this.a.j.D2();
            }
            GroupInputViewController groupInputViewController = this.a;
            groupInputViewController.d1(groupInputViewController.z);
            this.a.e1(true);
            this.a.k.q(i, i2, j, animatorListenerAdapter, z);
        }

        @Override // com.baidu.tieba.j68.e
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.c0();
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
                this.a.N0(null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements j68.d {
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

        @Override // com.baidu.tieba.j68.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.d.u1(this.a, this.b, this.c);
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
                if (this.a.a == toolState) {
                    return;
                }
                this.a.a = toolState;
                if (this.a.l != null) {
                    this.a.l.D(this.a.a);
                }
                this.a.z1(booleanValue);
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
                groupInputViewController.t1(groupInputViewController.G, false, this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m implements i68.d {
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

        @Override // com.baidu.tieba.i68.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                GroupInputViewController groupInputViewController = this.b;
                groupInputViewController.t1(groupInputViewController.G, false, this.a);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.m != null) {
                if (this.a.m.I()) {
                    this.a.m.z();
                    return;
                }
                this.a.y0(false);
                this.a.k0();
                this.a.y1();
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
                if (this.a.m != null && this.a.m.I()) {
                    this.a.m.z();
                    return;
                }
                this.a.z0(true, false, null);
                this.a.y1();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p implements a68.j {
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

        @Override // com.baidu.tieba.a68.j
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.U0();
                if (this.a.M) {
                    return;
                }
                this.a.z0(true, true, null);
            }
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
            this.d.R0(this.a, this.b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) != null) {
                return;
            }
            this.d.R0(this.a, this.b);
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
                this.a.L = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t implements rc5 {
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

        @Override // com.baidu.tieba.rc5
        public void C(qc5 qc5Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, qc5Var) != null) || qc5Var == null) {
                return;
            }
            int i = qc5Var.a;
            if (i == 24) {
                Object obj = qc5Var.c;
                if (obj instanceof f85) {
                    f85 f85Var = (f85) obj;
                    if (f85Var.getType() != EmotionGroupType.LOCAL) {
                        this.a.T0(f85Var);
                    }
                }
            } else if (i == 8) {
                this.a.U0();
                if (this.a.M) {
                    return;
                }
                this.a.y0(true);
            } else if (i == 4) {
                Object obj2 = qc5Var.c;
                if (obj2 instanceof String) {
                    this.a.f = (String) obj2;
                    this.a.f0(false, 1);
                    this.a.x.i(100L);
                }
            } else if (i == 14) {
                this.a.O0();
            } else if (i != 17) {
                if (i == 62) {
                    boolean booleanValue = ((Boolean) qc5Var.c).booleanValue();
                    if (this.a.k == null) {
                        return;
                    }
                    if (booleanValue) {
                        this.a.d0();
                    } else {
                        this.a.f0(true, 1);
                    }
                    if (!this.a.k.T() || this.a.q0() != ToolState.TEXT) {
                        return;
                    }
                    this.a.j1(false);
                } else if (i != 63 || this.a.k == null) {
                } else {
                    this.a.k.Z(false);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u implements a68.l {
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

        @Override // com.baidu.tieba.a68.l
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZ(1048576, this, z) != null) {
                return;
            }
            this.a.p1(z);
        }
    }

    /* loaded from: classes5.dex */
    public class v implements i68.d {
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

        @Override // com.baidu.tieba.i68.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.w.l(null, this.a);
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
                this.b.w.l(null, this.a);
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
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voiceModel) == null) && voiceModel != null && !StringUtils.isNull(voiceModel.getVoiceId()) && this.a.u != null) {
                this.a.u.d(voiceModel.getVoiceId(), voiceModel.getDuration());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class y implements a68.k {
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

        @Override // com.baidu.tieba.a68.k
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
                this.a.j.w2();
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
                    if (this.a.H0() && this.a.m != null && !StringUtils.isNull(sPathGen)) {
                        this.a.m.L(sPathGen, str);
                        return;
                    } else if (responseData.getExtraMap() != null) {
                        this.a.u.b(responseData.getSPathGen(), str, responseData.getExtraMap());
                        return;
                    } else {
                        this.a.u.g(responseData.getSPathGen(), str);
                        return;
                    }
                }
                this.a.j.showToast(TbadkCoreApplication.getInst().getString(R.string.pic_parser_error));
            }
        }
    }

    public GroupInputViewController(GroupChatFragment groupChatFragment, long j2, b58 b58Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {groupChatFragment, Long.valueOf(j2), b58Var};
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
        this.C = new g48();
        this.E = new ArrayList();
        this.H = null;
        this.L = false;
        this.M = false;
        this.N = new k(this, 2921790);
        this.O = new s(this, 2921800);
        this.P = new t(this);
        this.Q = new u(this);
        this.R = new x(this);
        this.S = new y(this);
        this.T = new z(this);
        this.U = new e(this, 2921785);
        this.o = j2;
        this.j = groupChatFragment;
        this.h = groupChatFragment.getPageContext();
        this.b = groupChatFragment.getContext();
        this.n = new GroupInputTool(this.j);
        z58 z58Var = new z58(this.j);
        this.y = z58Var;
        z58Var.o(this.P);
        this.J = new i78(this);
        this.x = new h68(this.j, new e2b() { // from class: com.baidu.tieba.x58
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.e2b
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? GroupInputViewController.this.J0() : invokeV.objValue;
            }
        }, b58Var);
        A0();
        a1(this.n);
        B0();
        MessageManager.getInstance().registerListener(this.N);
        MessageManager.getInstance().registerListener(this.O);
        a68 a68Var = this.m;
        if (a68Var != null) {
            a68Var.R(this.S);
        }
    }

    public void K0(int i2, int i3, @Nullable Intent intent) {
        z58 z58Var;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048588, this, i2, i3, intent) == null) && i3 == -1 && intent != null && (z58Var = this.y) != null) {
            z58Var.k(i2, i3, intent);
            if (i2 != 12010 && i2 != 12009 && i2 != 12002) {
                if (i2 == 12004) {
                    boolean booleanExtra = intent.getBooleanExtra(IntentConfig.IS_AT_SELECT_BOT_DATA, false);
                    String stringExtra = intent.getStringExtra(AtListActivityConfig.CALL_AT_LIST_SOURCE);
                    ArrayList<AtSelectData> parcelableArrayListExtra = intent.getParcelableArrayListExtra(IntentConfig.AT_SELECT_LIST_DATA);
                    if (TextUtils.equals(AtListActivityConfig.GROUP_BOT_SKILL, stringExtra)) {
                        this.m.J(parcelableArrayListExtra);
                        return;
                    }
                    if (this.l != null && !ListUtils.isEmpty(parcelableArrayListExtra)) {
                        this.l.H(parcelableArrayListExtra);
                        this.l.C(parcelableArrayListExtra);
                    }
                    if (this.v != null && booleanExtra) {
                        f0(false, 2);
                        return;
                    }
                    return;
                }
                return;
            }
            String stringExtra2 = intent.getStringExtra("file_name");
            if (stringExtra2 == null) {
                stringExtra2 = TbConfig.IMAGE_RESIZED_FILE;
                str = null;
            } else {
                str = TbConfig.LOCAL_PIC_DIR;
            }
            LocalPicModel localPicModel = this.d;
            if (localPicModel != null) {
                localPicModel.cancelLoadData();
                this.d = null;
            }
            String stringExtra3 = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra3 != null) {
                this.c.parseJson(stringExtra3);
                WriteImagesInfo writeImagesInfo = this.c;
                if (writeImagesInfo != null && !ListUtils.isEmpty(writeImagesInfo.getChosedFiles())) {
                    I0(str, stringExtra2);
                    return;
                }
                LocalPicModel localPicModel2 = new LocalPicModel(str, stringExtra2, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                this.d = localPicModel2;
                localPicModel2.setLoadDataCallBack(this.T);
                this.d.getData();
                return;
            }
            LocalPicModel localPicModel3 = new LocalPicModel(str, stringExtra2, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
            this.d = localPicModel3;
            localPicModel3.setLoadDataCallBack(this.T);
            this.d.getData();
        }
    }

    public void L0(int i2) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048589, this, i2) == null) && (groupInputTool = this.n) != null) {
            groupInputTool.W(i2);
        }
    }

    public void M0(@NonNull Bundle bundle) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) && (groupInputTool = this.n) != null) {
            groupInputTool.X(bundle);
        }
    }

    public final void S0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z2) == null) {
            this.K = true;
            z0(true, false, new l(this, z2));
        }
    }

    public void V0(BotsDTO botsDTO) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, botsDTO) == null) && (groupInputTool = this.k) != null) {
            groupInputTool.Y(botsDTO);
        }
    }

    public void W0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.z = str;
        }
    }

    public final void Z(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048606, this, z2) == null) && r0() != null) {
            r0().q(new m(this, z2));
        }
    }

    public final void Z0(boolean z2) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048607, this, z2) != null) || (groupInputTool = this.k) == null) {
            return;
        }
        if (z2) {
            groupInputTool.c0(1);
        } else {
            groupInputTool.c0(0);
        }
    }

    public void b1(String str) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048611, this, str) == null) && (editorTools = this.i) != null) {
            editorTools.C(new qc5(75, 3, str));
        }
    }

    public void c1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
            this.f = str;
            EditorTools editorTools = this.i;
            if (editorTools != null) {
                editorTools.C(new qc5(6, 3, str));
            }
        }
    }

    public void d1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, str) == null) {
            this.q = str;
            EditorTools editorTools = this.i;
            if (editorTools != null) {
                editorTools.C(new qc5(71, 3, StringHelper.cutChineseAndEnglishWithEmoji(str, 28, StringHelper.STRING_MORE)));
            }
        }
    }

    public void e1(boolean z2) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048617, this, z2) == null) && (groupInputTool = this.k) != null) {
            groupInputTool.d0(z2);
        }
    }

    public void h1(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048623, this, z2) == null) && this.i.o(6) != null) {
            if (!z2) {
                this.i.o(6).hide();
            } else {
                this.i.o(6).display();
            }
        }
    }

    public void i1(GroupInputTool.f fVar) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048625, this, fVar) == null) && (groupInputTool = this.k) != null) {
            groupInputTool.h0(fVar);
        }
    }

    public final void j0(@NonNull List<BotsDTO.BotListDTO.SkillDTO> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, list) == null) {
            for (BotsDTO.BotListDTO.SkillDTO skillDTO : list) {
                if (skillDTO != null && skillDTO.getType() == this.A) {
                    this.G = skillDTO;
                    return;
                }
            }
        }
    }

    public void k1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, view2) == null) {
            this.e = view2;
        }
    }

    public void o1(@Nullable e68 e68Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, e68Var) == null) {
            this.u = e68Var;
        }
    }

    public void r1(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, editorTools) == null) {
            this.i = editorTools;
        }
    }

    public final void y0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048656, this, z2) == null) {
            z0(false, z2, null);
        }
    }

    public final void z1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048659, this, z2) == null) {
            if (z2) {
                d0();
                j1(true);
                return;
            }
            f0(true, 1);
            j1(false);
        }
    }

    public void B1(@NonNull String str, @NonNull b68 b68Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, b68Var) == null) {
            c68 c68Var = new c68(this.b, str, "audio/amr");
            c68Var.b(b68Var);
            BIMManager.audioTrans(this.b, str, "audio/amr", "amr", 12, c68Var);
        }
    }

    public void P0(@NonNull UserReplyInfoData userReplyInfoData, @NonNull Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, userReplyInfoData, obj) == null) {
            this.B = obj;
            k0();
            e0(userReplyInfoData);
        }
    }

    public void W(@NonNull AtSelectData atSelectData, boolean z2) {
        y58 y58Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048600, this, atSelectData, z2) != null) || (y58Var = this.l) == null) {
            return;
        }
        y58Var.B();
        this.l.k(atSelectData, false, z2);
    }

    public void m1(BotsDTO.BotListDTO.UserDTO userDTO, BotsDTO.BotListDTO.SkillDTO skillDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048633, this, userDTO, skillDTO) == null) {
            this.D = userDTO;
            this.G = skillDTO;
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65567, this) == null) {
            z58 z58Var = this.y;
            if (z58Var != null) {
                z58Var.l();
            }
            y58 y58Var = this.l;
            if (y58Var != null) {
                y58Var.x();
            }
            a68 a68Var = this.m;
            if (a68Var != null) {
                a68Var.M();
            }
            h68 h68Var = this.x;
            if (h68Var != null) {
                h68Var.k();
            }
            VoiceManager.setIsNeedBlackScreen(true);
            MessageManager.getInstance().unRegisterListener(this.U);
            MessageManager.getInstance().unRegisterListener(this.N);
            MessageManager.getInstance().unRegisterListener(this.O);
        }
    }

    public final void O0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048592, this) != null) || !F0()) {
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

    public final void X() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && this.D != null && this.G != null) {
            o78.f().h(o78.f().c(this.D.getUk(), this.G.getType(), this.D.getNameShow(), this.G.getName(), this.D.getPortrait(), this.G.getDesc()));
        }
    }

    public String o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            EditorTools editorTools = this.i;
            if (editorTools == null) {
                return "";
            }
            bd5 p2 = editorTools.p(3);
            String str = TbEnum.ChatInputStatus.INPUT_STATUS_TEXT;
            if (p2 != null) {
                cd5 cd5Var = p2.m;
                if ((cd5Var instanceof View) && ((View) cd5Var).getVisibility() != 0) {
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
        if (interceptable == null || interceptable.invokeV(65568, this) == null) {
            this.p = false;
            z58 z58Var = this.y;
            if (z58Var != null) {
                z58Var.m();
                this.y.p(this.p);
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65569, this) == null) {
            this.p = true;
            z58 z58Var = this.y;
            if (z58Var != null) {
                z58Var.n();
                this.y.p(this.p);
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65570, this) == null) {
            if (p0() != null && p0().I()) {
                return;
            }
            TbSingleton.getInstance().setRoomDraft(Long.valueOf(this.o), o0());
        }
    }

    public final void A0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.l == null) {
            this.l = new y58(this.b, this.j);
        }
    }

    public final void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            z58 z58Var = this.y;
            if (z58Var != null) {
                z58Var.i();
            }
            GroupInputTool groupInputTool = this.k;
            if (groupInputTool != null) {
                groupInputTool.i0(this.R);
            }
        }
    }

    public final void C0() {
        i68 i68Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (i68Var = this.v) != null) {
            i68Var.p(new f(this));
        }
    }

    public final GroupChatRobotTopHeadView D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            GroupInputTool groupInputTool = this.k;
            if (groupInputTool == null) {
                return null;
            }
            GroupChatRobotTopHeadView M = groupInputTool.M();
            this.H = M;
            M.setEventCallback(new i(this));
            return this.H;
        }
        return (GroupChatRobotTopHeadView) invokeV.objValue;
    }

    public final void E0() {
        j68 j68Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (j68Var = this.w) != null) {
            j68Var.i(new g(this));
        }
    }

    public boolean F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (FileHelper.checkSD()) {
                return true;
            }
            ii.Q(this.b, TbadkCoreApplication.getInst().getString(R.string.voice_error_sdcard));
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            j68 j68Var = this.w;
            if (j68Var != null && j68Var.e()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            GroupInputTool groupInputTool = this.k;
            if (groupInputTool != null && groupInputTool.I() && this.L) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public /* synthetic */ CharSequence J0() {
        return this.f;
    }

    public void Q0() {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (groupInputTool = this.k) != null) {
            groupInputTool.a0(false);
        }
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            k0();
            if (G0()) {
                c0();
            }
            h0();
            n1(2, true);
            g1(true);
            h1(true);
            this.M = false;
        }
    }

    public boolean b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            GroupInputTool groupInputTool = this.k;
            if (groupInputTool != null) {
                return groupInputTool.s();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void c0() {
        j68 j68Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && (j68Var = this.w) != null) {
            j68Var.j(null);
        }
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048614, this) == null) && r0() != null) {
            r0().q(null);
        }
    }

    public final void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            this.C.a();
            this.E.clear();
            this.D = null;
            this.G = null;
            this.B = null;
        }
    }

    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            this.f = null;
            EditorTools editorTools = this.i;
            if (editorTools != null) {
                editorTools.C(new qc5(9, -1, Boolean.TRUE));
            }
        }
    }

    public y58 l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            return this.l;
        }
        return (y58) invokeV.objValue;
    }

    public void l1() {
        a68 a68Var;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048631, this) == null) && (a68Var = this.m) != null && a68Var.H() && (arrayList = (ArrayList) this.m.y()) != null) {
            this.E = arrayList;
        }
    }

    public GroupInputTool n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return this.n;
        }
        return (GroupInputTool) invokeV.objValue;
    }

    public GroupInputTool p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            return this.k;
        }
        return (GroupInputTool) invokeV.objValue;
    }

    public ToolState q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            return this.a;
        }
        return (ToolState) invokeV.objValue;
    }

    public i68 r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            return this.v;
        }
        return (i68) invokeV.objValue;
    }

    public j68 s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            return this.w;
        }
        return (j68) invokeV.objValue;
    }

    @Nullable
    public w68 t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            return u0().f();
        }
        return (w68) invokeV.objValue;
    }

    @NonNull
    public k78 u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            return this.J;
        }
        return (k78) invokeV.objValue;
    }

    @Nullable
    public VoiceManager v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) {
            z58 z58Var = this.y;
            if (z58Var != null) {
                return z58Var.x0();
            }
            return null;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public SourceType w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            return this.I;
        }
        return (SourceType) invokeV.objValue;
    }

    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048654, this) == null) {
            h68 h68Var = this.x;
            if (h68Var != null) {
                h68Var.g();
            }
            GroupInputTool groupInputTool = this.k;
            if (groupInputTool != null) {
                groupInputTool.P();
            }
        }
    }

    public void A1(@NonNull String str, @NonNull d68 d68Var) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, d68Var) != null) || StringUtils.isNull(str)) {
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
        BIMManager.genBosObjectUrl(this.b, str, "image/jpeg", "jpg", 12, i2, i3, new h(this, d68Var, str));
    }

    public final void w1(List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> list, boolean z2) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048653, this, list, z2) == null) && (groupInputTool = this.k) != null && groupInputTool.F() != null && !ListUtils.isEmpty(list)) {
            a68 a68Var = this.m;
            if (a68Var == null) {
                a68 a68Var2 = new a68(this.k.F(), this.Q);
                this.m = a68Var2;
                a68Var2.C(list, m0(), z2);
            } else {
                a68Var.K(list, z2);
            }
            this.m.U(new p(this), this.S, z2);
        }
    }

    public final void I0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, str2) == null) {
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

    public final void v1(List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> list, boolean z2) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048651, this, list, z2) == null) && (groupInputTool = this.k) != null && groupInputTool.F() != null) {
            a68 a68Var = this.m;
            if (a68Var == null) {
                a68 a68Var2 = new a68(this.k.F(), this.Q);
                this.m = a68Var2;
                a68Var2.C(list, m0(), z2);
            } else {
                a68Var.K(list, z2);
            }
            this.m.S(z2, !ListUtils.isEmpty(list));
        }
    }

    public void N0(@Nullable a0 a0Var) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, a0Var) == null) {
            z0(true, false, a0Var);
            y1();
            k0();
            h0();
            Z0(false);
            GroupChatFragment groupChatFragment = this.j;
            if (groupChatFragment != null) {
                long g2 = groupChatFragment.g2();
                long e2 = this.j.e2();
                StatisticItem param = new StatisticItem("c15134").param("obj_type", 2).param("fid", e2).param("fname", this.j.f2()).param("room_id", g2);
                BotsDTO.BotListDTO.UserDTO userDTO = this.D;
                if (userDTO != null) {
                    str = BIMManager.getBdUidFromBdUK(userDTO.getUk());
                } else {
                    str = "";
                }
                TiebaStatic.log(param.param("obj_id", str).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
            y58 y58Var = this.l;
            if (y58Var != null) {
                y58Var.B();
            }
        }
    }

    public void T0(f85 f85Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, f85Var) == null) && f85Var != null && f85Var.c() != null && f85Var.c().p() != null && this.y != null) {
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
            hr5.b(new a(this, f85Var), new b(this));
        }
    }

    public final void R0(boolean z2, boolean z3) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) && this.k != null) {
            if (!this.K) {
                h0();
            }
            boolean z4 = false;
            this.K = false;
            this.k.g0(false);
            this.k.a0(false);
            if (this.I == SourceType.TWO) {
                z4 = true;
            }
            if (z4 && !z3) {
                str = this.g;
            } else {
                str = this.f;
            }
            this.f = str;
            if (TextUtils.isEmpty(str)) {
                n1(2, true);
            } else {
                n1(3, true);
            }
            g1(true);
            h1(true);
            e1(true);
            if (this.k.N() != null && z2) {
                this.k.N().m();
            }
            if (this.I == SourceType.ONE && !TextUtils.isEmpty(this.z)) {
                d1(this.z);
            } else if (z4) {
                if (!z3 && !TextUtils.isEmpty(this.f)) {
                    c1(this.f);
                }
                if (!TextUtils.isEmpty(this.z)) {
                    d1(this.z);
                } else {
                    d1(this.h.getString(R.string.im_msg_input_hint));
                }
            }
        }
    }

    public final void U0() {
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
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if (!this.r) {
                Y();
                EditorTools editorTools = this.i;
                if (editorTools != null) {
                    editorTools.r();
                }
            } else if (this.u != null) {
                l1();
                g48 g48Var = this.C;
                if (g48Var != null) {
                    g48Var.a = this.D;
                    g48Var.b = this.G;
                    g48Var.c = this.E;
                }
                y58 y58Var = this.l;
                if (y58Var != null) {
                    y58Var.w();
                    List<AtSelectData> r2 = this.l.r();
                    Map<String, Integer> l2 = this.l.l();
                    if (!ListUtils.isEmpty(this.l.r())) {
                        StatisticItem statisticItem = new StatisticItem("c15128");
                        GroupChatFragment groupChatFragment = this.j;
                        long j3 = 0;
                        if (groupChatFragment != null) {
                            j2 = groupChatFragment.e2();
                        } else {
                            j2 = 0;
                        }
                        StatisticItem param = statisticItem.param("fid", j2);
                        GroupChatFragment groupChatFragment2 = this.j;
                        if (groupChatFragment2 != null) {
                            j3 = groupChatFragment2.g2();
                        }
                        TiebaStatic.log(param.param("room_id", j3).param("uid", TbadkCoreApplication.getCurrentAccount()));
                    }
                    map = l2;
                    list = r2;
                } else {
                    list = null;
                    map = null;
                }
                if (this.H != null && this.j != null && (skillDTO = this.G) != null && skillDTO.getName() != null) {
                    long g2 = this.j.g2();
                    long e2 = this.j.e2();
                    String f2 = this.j.f2();
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
                    StatisticItem param4 = param3.param("obj_name", str2).param("fid", e2).param("fname", f2).param("room_id", g2);
                    BotsDTO.BotListDTO.UserDTO userDTO = this.D;
                    if (userDTO == null) {
                        str3 = "";
                    } else {
                        str3 = BIMManager.getBdUidFromBdUK(userDTO.getUk());
                    }
                    TiebaStatic.log(param4.param("obj_id", str3).param("uid", TbadkCoreApplication.getCurrentAccount()));
                }
                if (G0()) {
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
                if (!t78.a(this.E)) {
                    this.M = true;
                    return;
                }
                e68 e68Var = this.u;
                String str4 = this.f;
                if (str4 == null) {
                    str = "";
                } else {
                    str = str4;
                }
                e68Var.f(str, this.B, this.C, list, map, i2);
                Y();
                y58 y58Var2 = this.l;
                if (y58Var2 != null) {
                    y58Var2.B();
                }
            }
        }
    }

    public void X0(@Nullable Object obj, @Nullable BotsDTO.BotListDTO.UserDTO userDTO, @Nullable BotsDTO.BotListDTO.SkillDTO skillDTO, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{obj, userDTO, skillDTO, Boolean.valueOf(z2)}) == null) {
            this.B = obj;
            this.D = userDTO;
            this.G = skillDTO;
            g48 g48Var = this.C;
            if (g48Var != null) {
                g48Var.d(z2);
            }
        }
    }

    public void Y0(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048605, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString(TbEnum.ChatInputStatus.INPUT_DRAFT_KEY);
            if (this.i != null) {
                this.i.C(new qc5(6, 3, optString));
            }
            this.f = optString;
            if (TextUtils.equals(jSONObject.optString(TbEnum.ChatInputStatus.INPUT_STATUS_KEY), TbEnum.ChatInputStatus.INPUT_STATUS_VOICE) && this.i != null) {
                this.i.C(new qc5(1, 6, null));
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public final void e0(@NonNull UserReplyInfoData userReplyInfoData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048616, this, userReplyInfoData) != null) || this.w == null) {
            return;
        }
        i68 i68Var = this.v;
        if (i68Var != null && i68Var.j()) {
            this.v.q(new v(this, userReplyInfoData));
        } else if (this.k.I()) {
            N0(new w(this, userReplyInfoData));
        } else {
            this.w.l(null, userReplyInfoData);
            this.j.u2(true);
        }
    }

    public void g1(boolean z2) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048621, this, z2) == null) && (groupInputTool = this.k) != null && groupInputTool.C() != null && (this.k.C().m instanceof EmotionNoLaunchView)) {
            ((EmotionNoLaunchView) this.k.C().m).setNeedHideForever(z2);
            if (!z2) {
                this.k.C().m.hide();
            } else {
                this.k.C().m.display();
            }
        }
    }

    public final void i0(ImageFileInfo imageFileInfo) {
        Bitmap resizeBitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, imageFileInfo) == null) {
            try {
                if (imageFileInfo.isGif()) {
                    FileHelper.saveGifByRelativePath(imageFileInfo.getFilePath(), null, TbConfig.IMAGE_RESIZED_FILE);
                    FileHelper.saveGifByRelativePath(imageFileInfo.getFilePath(), null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                    return;
                }
                Bitmap c2 = xr5.c(0, this.b, null, imageFileInfo.getFilePath(), TbImageHelper.getInstance().getPostImageSize());
                if (c2 != null && FileHelper.saveBitmapByRelativelyPath(null, TbConfig.IMAGE_RESIZED_FILE, c2, 85) != null && (resizeBitmap = BitmapHelper.resizeBitmap(c2, 100)) != null) {
                    FileHelper.saveBitmapByRelativelyPath(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 85);
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public final boolean a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            y58 y58Var = this.l;
            if (y58Var == null || y01.h(y58Var.t()) != 1 || !this.l.t().get(0).isRobot()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @NonNull
    public v68 m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            v68 v68Var = new v68();
            v68Var.g(this.j.g2());
            v68Var.h(this.j.i2());
            v68Var.e(this.j.e2());
            v68Var.f(this.j.f2());
            return v68Var;
        }
        return (v68) invokeV.objValue;
    }

    public final void a1(GroupInputTool groupInputTool) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048609, this, groupInputTool) == null) && groupInputTool != null && this.y != null) {
            this.k = groupInputTool;
            this.v = groupInputTool.H();
            if (groupInputTool.O() != null && groupInputTool.F() != null) {
                this.w = new j68(groupInputTool.O(), this.j, groupInputTool.F());
            }
            MessageManager.getInstance().registerListener(this.U);
            C0();
            E0();
            D0();
            if (groupInputTool.N() != null) {
                this.y.q(groupInputTool);
                r1(groupInputTool.N());
                if (groupInputTool.D() != null) {
                    k1(groupInputTool.D());
                }
                if (this.o != 0 && !hi.isEmpty(TbSingleton.getInstance().getRoomDraft(Long.valueOf(this.o)))) {
                    Y0(TbSingleton.getInstance().getRoomDraft(Long.valueOf(this.o)));
                }
                y58 y58Var = this.l;
                if (y58Var != null) {
                    y58Var.E(groupInputTool, this.i);
                    this.l.y();
                }
            }
        }
    }

    public void f0(boolean z2, int i2) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048618, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) && (groupInputTool = this.k) != null && groupInputTool.N() != null && !this.k.T() && this.v != null) {
            if (z2) {
                this.k.N().requestFocus();
            }
            if (!this.k.N().hasFocus()) {
                return;
            }
            boolean z3 = false;
            z3 = (i2 == 3 || i2 == 2) ? true : true;
            if (i2 != 2 && i2 != 3 && (TextUtils.isEmpty(this.f) || !"/".equals(this.f))) {
                this.v.q(null);
                return;
            }
            a68 a68Var = this.m;
            if (a68Var != null && a68Var.H() && this.I == SourceType.TWO) {
                return;
            }
            this.v.t(null, i2, Boolean.valueOf(z3));
        }
    }

    public void n1(int i2, boolean z2) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048635, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) && (groupInputTool = this.k) != null && groupInputTool.J() != null && (this.k.J().m instanceof SendNoLaunchView)) {
            if (i2 == 1) {
                ((SendNoLaunchView) this.k.J().m).setIsSendIcon(true);
                ((SendNoLaunchView) this.k.J().m).setSendVisibility(z2);
            } else if (i2 == 2) {
                ((SendNoLaunchView) this.k.J().m).setIsSendIcon(false);
                ((SendNoLaunchView) this.k.J().m).setSendVisibility(false);
            } else if (i2 == 3) {
                ((SendNoLaunchView) this.k.J().m).setIsSendIcon(false);
                ((SendNoLaunchView) this.k.J().m).setSendVisibility(true);
            }
        }
    }

    public void f1(SourceType sourceType, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048619, this, new Object[]{sourceType, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            if (G0()) {
                this.w.j(new j(this, sourceType, z2, z3));
            } else {
                u1(sourceType, z2, z3);
            }
        }
    }

    public final void z0(boolean z2, boolean z3, @Nullable a0 a0Var) {
        GroupChatFragment groupChatFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048658, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3), a0Var}) == null) && this.m != null && (groupChatFragment = this.j) != null) {
            groupChatFragment.u2(true);
            this.j.D2();
            this.m.B(new q(this, z2, z3, a0Var));
        }
    }

    public final void j1(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048627, this, z2) == null) && s0() != null) {
            if (z2) {
                s0().k(false);
            } else if (!s0().g()) {
                s0().k(!z2);
            }
        }
    }

    public final void p1(boolean z2) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048639, this, z2) != null) || this.H == null || !z2) {
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

    public void q1(int i2, @NonNull Object obj, @NonNull g48 g48Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048641, this, i2, obj, g48Var) == null) {
            this.A = i2;
            this.B = obj;
            this.D = g48Var.a;
            if (this.F == null) {
                this.F = new ArrayList();
            }
            this.F.clear();
            BotsDTO.BotListDTO.SkillDTO skillDTO = g48Var.b;
            if (skillDTO != null && !ListUtils.isEmpty(skillDTO.getSubSkill())) {
                this.F.addAll(g48Var.b.getSubSkill());
                j0(this.F);
            }
            g48 g48Var2 = this.C;
            if (g48Var2 != null) {
                g48Var2.d(g48Var.c());
            }
        }
    }

    public final void u1(SourceType sourceType, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048649, this, new Object[]{sourceType, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            this.I = sourceType;
            GroupChatFragment groupChatFragment = this.j;
            if (groupChatFragment != null) {
                groupChatFragment.s2();
            }
            if (this.I == SourceType.TWO) {
                this.g = this.f;
                GroupInputTool groupInputTool = this.k;
                if (groupInputTool != null) {
                    if (groupInputTool.w()) {
                        Z(z3);
                        return;
                    } else if (this.k.I()) {
                        S0(z3);
                        return;
                    }
                }
            }
            t1(this.G, z2, z3);
        }
    }

    public void s1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048645, this, z2) == null) {
            this.r = z2;
            if (this.i != null) {
                if (q45.m().i("key_group_chat_chatroom_audio_switch", true)) {
                    this.i.setToolEnabled(z2, 6);
                }
                this.i.C(new qc5(72, 3, Boolean.valueOf(z2)));
                if (this.i.p(37) != null && (this.i.p(37).m instanceof EmotionNoLaunchView)) {
                    ((EmotionNoLaunchView) this.i.p(37).m).setEnabled(z2);
                }
                if (q45.m().i("key_group_chat_chatroom_picture_switch", true) && this.i.p(38) != null && (this.i.p(38).m instanceof SendNoLaunchView)) {
                    ((SendNoLaunchView) this.i.p(38).m).setIconEnable(z2);
                    ((SendNoLaunchView) this.i.p(38).m).setSendInterceptToastText(this.q, z2);
                }
            }
            y58 y58Var = this.l;
            if (y58Var != null) {
                y58Var.F(z2);
            }
            GroupInputTool groupInputTool = this.k;
            if (groupInputTool != null && groupInputTool.E() != null && this.k.E().g() != null) {
                if (z2) {
                    this.k.E().g().setEnabled(true);
                    this.k.E().g().setOnClickListener(new d(this));
                    return;
                }
                this.k.E().g().setEnabled(false);
            }
        }
    }

    public final void t1(BotsDTO.BotListDTO.SkillDTO skillDTO, boolean z2, boolean z3) {
        BotsDTO.BotListDTO.SkillDTO skillDTO2;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048647, this, new Object[]{skillDTO, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            if (skillDTO != null) {
                skillDTO2 = skillDTO.copy();
            } else {
                skillDTO2 = null;
            }
            if (this.k != null && skillDTO2 != null) {
                boolean z5 = false;
                int i2 = 1;
                if (this.I == SourceType.TWO) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                this.k.z(true);
                this.k.B(!z4);
                X();
                String str = "";
                if (skillDTO2.getKeyboard() == 1) {
                    if (!TextUtils.isEmpty(skillDTO2.getKeyboardContent())) {
                        c1(skillDTO2.getKeyboardContent());
                    } else {
                        c1("");
                    }
                    this.g = this.f;
                    if (!TextUtils.isEmpty(skillDTO2.getExp())) {
                        d1(skillDTO2.getExp());
                    } else if (z4) {
                        d1(this.h.getString(R.string.obfuscated_res_0x7f0f0898));
                    }
                    n1(1, !TextUtils.isEmpty(this.f));
                    g1(false);
                    h1(false);
                    e1(false);
                    this.k.f0(new n(this));
                    if (this.k.N() != null) {
                        GroupInputTool groupInputTool = this.k;
                        if (skillDTO2.getKeyboardType() == 1) {
                            z5 = true;
                        }
                        groupInputTool.a0(z5);
                        this.k.N().l();
                    }
                    v1(skillDTO2.getItems(), z3);
                } else {
                    if (this.k.N() != null) {
                        this.k.N().q();
                    }
                    this.k.f0(new o(this));
                    w1(skillDTO2.getItems(), z3);
                }
                GroupChatFragment groupChatFragment = this.j;
                if (groupChatFragment != null) {
                    long g2 = groupChatFragment.g2();
                    long e2 = this.j.e2();
                    String f2 = this.j.f2();
                    StatisticItem param = new StatisticItem("c15134").param("obj_type", 1).param("obj_name", skillDTO2.getName());
                    if (this.I == SourceType.TWO) {
                        i2 = 2;
                    }
                    StatisticItem param2 = param.param("obj_source", i2).param("fid", e2).param("fname", f2).param("room_id", g2);
                    BotsDTO.BotListDTO.UserDTO userDTO = this.D;
                    if (userDTO != null) {
                        str = BIMManager.getBdUidFromBdUK(userDTO.getUk());
                    }
                    TiebaStatic.log(param2.param("obj_id", str).param("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        }
    }

    public final void x1(int i2, String str, String str2, String str3, String str4, String str5, String str6, IUploadTransferListener iUploadTransferListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048655, this, new Object[]{Integer.valueOf(i2), str, str2, str3, str4, str5, str6, iUploadTransferListener}) == null) {
            new AsyncUploadTask(this.b, i2, str, str2, str3, str4, str5, str6, iUploadTransferListener).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    public final void y1() {
        GroupChatFragment groupChatFragment;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048657, this) == null) && (groupChatFragment = this.j) != null) {
            long g2 = groupChatFragment.g2();
            long e2 = this.j.e2();
            String f2 = this.j.f2();
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
            StatisticItem param3 = param2.param("obj_name", str).param("fid", e2).param("fname", f2).param("room_id", g2);
            BotsDTO.BotListDTO.UserDTO userDTO = this.D;
            if (userDTO != null) {
                str2 = BIMManager.getBdUidFromBdUK(userDTO.getUk());
            } else {
                str2 = "";
            }
            TiebaStatic.log(param3.param("obj_id", str2).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }
}
