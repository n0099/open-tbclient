package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class tc8 extends dk5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean F;
    public String G;
    public String H;
    public String I;
    public PermissionJudgePolicy J;

    /* loaded from: classes7.dex */
    public class a implements zh5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tc8 a;

        public a(tc8 tc8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tc8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tc8Var;
        }

        @Override // com.baidu.tieba.zh5
        public void C(yh5 yh5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, yh5Var) == null) {
                Object obj = yh5Var.c;
                if ((obj instanceof dd5) && EmotionGroupType.isSendAsPic(((dd5) obj).getType())) {
                    if (this.a.J == null) {
                        this.a.J = new PermissionJudgePolicy();
                    }
                    this.a.J.clearRequestPermissionList();
                    this.a.J.appendRequestPermission(this.a.m.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.a.J.startRequestPermission(this.a.m.getPageActivity())) {
                        return;
                    }
                    this.a.f((dd5) yh5Var.c);
                    this.a.w(false, null);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tc8(EditorTools editorTools) {
        super(editorTools);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {editorTools};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((EditorTools) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        editorTools.setActionListener(24, new a(this));
    }

    @Override // com.baidu.tieba.dk5
    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (this.F) {
                ez9.r(this.G, this);
            } else {
                ez9.p(str, this);
            }
        }
    }

    @Override // com.baidu.tieba.dk5
    public void H(String str, WriteData writeData) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, writeData) == null) {
            if (this.g.k0() == null) {
                this.g.setWriteData(t0());
            }
            if (this.g.k0() == null) {
                return;
            }
            this.g.k0().setIsBJHPost(this.t);
            this.g.k0().setWriteImagesInfo(this.b);
            NewWriteModel newWriteModel = this.g;
            if (this.b.size() > 0) {
                z = true;
            } else {
                z = false;
            }
            newWriteModel.q0(z);
            if (str == null) {
                this.g.k0().setContent(this.c);
            }
            VoiceData.VoiceModel voiceModel = this.e;
            if (voiceModel != null) {
                if (voiceModel.getId() != null) {
                    this.g.k0().setVoice(this.e.getId());
                    this.g.k0().setVoiceDuringTime(this.e.getDuration());
                } else {
                    this.g.k0().setVoice(null);
                    this.g.k0().setVoiceDuringTime(-1);
                }
            } else {
                this.g.k0().setVoice(null);
                this.g.k0().setVoiceDuringTime(-1);
            }
            if (!this.g.i0()) {
                this.m.showToast(R.string.write_img_limit);
                return;
            }
            zj5 zj5Var = this.w;
            if (zj5Var != null && zj5Var.a()) {
                return;
            }
            this.g.k0().onPostDataParse(this.d);
            if (!this.g.v0()) {
            }
        }
    }

    @Override // com.baidu.tieba.dk5
    public void O(String str) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            WriteData k0 = this.g.k0();
            if (k0 == null) {
                if (this.F) {
                    i = 2;
                } else {
                    i = 1;
                }
                k0 = new WriteData(i);
                k0.setThreadId(str);
                k0.setWriteImagesInfo(this.b);
            }
            k0.onSaveDrafDataParse(this.d);
            if (!vi.isEmpty(this.I)) {
                k0.setFromForumId(this.I);
            }
            k0.setContent(this.c);
            k0.setVoiceModel(this.e);
            if (this.F) {
                k0.setReplyId(this.H);
                k0.setThreadId(this.G);
                ez9.B(this.G, k0);
                return;
            }
            ez9.z(str, k0);
        }
    }

    public WriteData t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            WriteData writeData = new WriteData();
            if (this.j != null) {
                if (this.x && !this.F) {
                    writeData.setCanNoForum(true);
                    writeData.setVForumId(this.j.getId());
                    writeData.setVForumName(this.j.getName());
                    writeData.setForumId("0");
                    writeData.setForumName("");
                } else {
                    writeData.setCanNoForum(false);
                    writeData.setVForumId("");
                    writeData.setVForumName("");
                    writeData.setForumId(this.j.getId());
                    writeData.setForumName(this.j.getName());
                }
            }
            writeData.setThreadId(this.l);
            if (!this.F) {
                writeData.setType(1);
            } else {
                writeData.setType(2);
                writeData.setFloor(this.G);
                writeData.setFloorNum(0);
                writeData.setReplyId(this.H);
                writeData.setRepostId(this.G);
            }
            return writeData;
        }
        return (WriteData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.dk5
    public void w(boolean z, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048580, this, z, postWriteCallBackData) == null) {
            PbEditorData pbEditorData = new PbEditorData();
            pbEditorData.setEditorType(this.F ? 1 : 0);
            pbEditorData.setContent(this.c);
            pbEditorData.setWriteImagesInfo(this.b);
            pbEditorData.setVoiceModel(this.e);
            PbEditorData.ThreadData threadData = new PbEditorData.ThreadData();
            ForumData forumData = this.j;
            if (forumData != null) {
                threadData.setForumId(forumData.getId());
                threadData.setForumName(this.j.getName());
                threadData.setFirstDir(this.j.getFirst_class());
                threadData.setSecondDir(this.j.getSecond_class());
            }
            threadData.setAuthorId(this.q);
            threadData.setAuthorName(this.o);
            threadData.setAuthorNameShow(this.p);
            threadData.setPostId(this.G);
            threadData.setThreadId(this.l);
            threadData.isBJH = this.t;
            pbEditorData.setThreadData(threadData);
            pbEditorData.setDisableVoiceMessage(this.n);
            pbEditorData.setOpenVoiceRecordButton(z);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbFullScreenEditorActivityConfig(this.m.getPageActivity(), 25035, pbEditorData, postWriteCallBackData)));
        }
    }

    @Override // com.baidu.tieba.dk5
    public void x() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            String str2 = this.c;
            ForumData forumData = this.j;
            if (forumData != null) {
                str = String.valueOf(forumData.getId());
            } else {
                str = "";
            }
            di5.e(str2, str);
        }
    }
}
