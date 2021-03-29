package com.baidu.tieba.imMessageCenter.mention;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class ReplyMeModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f18334e;

    /* renamed from: f  reason: collision with root package name */
    public b f18335f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.b.c.g.a f18336g;

    /* loaded from: classes3.dex */
    public class a extends d.b.b.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        /* JADX WARN: Removed duplicated region for block: B:35:0x00cc  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00de  */
        @Override // d.b.b.c.g.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            long forumId;
            long postState;
            long quoteId;
            long repostId;
            String forumName;
            long j;
            long tid;
            if (responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof CheckPostResponseMessage;
            if (!z && !(responsedMessage instanceof CheckPostHttpResponseMessage)) {
                ReplyMeModel.this.f18334e.showToast(R.string.neterror);
            } else if (responsedMessage.hasError()) {
                if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                    ReplyMeModel.this.f18334e.showToast(responsedMessage.getErrorString());
                } else {
                    ReplyMeModel.this.f18334e.showToast(R.string.neterror);
                }
            } else {
                if (z) {
                    CheckPostResponseMessage checkPostResponseMessage = (CheckPostResponseMessage) responsedMessage;
                    forumId = checkPostResponseMessage.getForumId();
                    postState = checkPostResponseMessage.getPostState();
                    quoteId = checkPostResponseMessage.getQuoteId();
                    repostId = checkPostResponseMessage.getRepostId();
                    forumName = checkPostResponseMessage.getForumName();
                    tid = (responsedMessage.getOrginalMessage() == null || !(checkPostResponseMessage.getOrginalMessage().getExtra() instanceof CheckPostRequestMessage)) ? 0L : ((CheckPostRequestMessage) checkPostResponseMessage.getOrginalMessage().getExtra()).getTid();
                } else {
                    CheckPostHttpResponseMessage checkPostHttpResponseMessage = (CheckPostHttpResponseMessage) responsedMessage;
                    forumId = checkPostHttpResponseMessage.getForumId();
                    postState = checkPostHttpResponseMessage.getPostState();
                    quoteId = checkPostHttpResponseMessage.getQuoteId();
                    repostId = checkPostHttpResponseMessage.getRepostId();
                    forumName = checkPostHttpResponseMessage.getForumName();
                    if (responsedMessage.getOrginalMessage() == null || !(checkPostHttpResponseMessage.getOrginalMessage().getExtra() instanceof CheckPostRequestMessage)) {
                        j = 0;
                        long j2 = forumId;
                        long j3 = quoteId;
                        long j4 = repostId;
                        String str = forumName;
                        if (postState != 1) {
                            if (ReplyMeModel.this.f18335f != null) {
                                ReplyMeModel.this.f18335f.a(j2, j3, j4, str, j);
                                return;
                            }
                            return;
                        } else if (postState == 0) {
                            ReplyMeModel.this.f18334e.showToast(R.string.thread_delete_tip);
                            return;
                        } else if (postState == -1) {
                            ReplyMeModel.this.f18334e.showToast(R.string.thread_shield_tip);
                            return;
                        } else {
                            return;
                        }
                    }
                    tid = ((CheckPostRequestMessage) checkPostHttpResponseMessage.getOrginalMessage().getExtra()).getTid();
                }
                j = tid;
                long j22 = forumId;
                long j32 = quoteId;
                long j42 = repostId;
                String str2 = forumName;
                if (postState != 1) {
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(long j, long j2, long j3, String str, long j4);
    }

    static {
        d.b.i0.c3.d0.a.f(303010, CheckPostResponseMessage.class, false);
        d.b.i0.c3.d0.a.c(303010, CmdConfigHttp.CMD_CHECK_POST, "c/f/check/checkpost", CheckPostHttpResponseMessage.class, true, true, false, false);
    }

    public ReplyMeModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.f18334e = tbPageContext;
        u();
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void onDestroy() {
        if (this.f18336g != null) {
            MessageManager.getInstance().unRegisterListener(this.f18336g);
        }
    }

    public void u() {
        a aVar = new a(CmdConfigHttp.CMD_CHECK_POST, 303010);
        this.f18336g = aVar;
        aVar.setTag(this.f18334e.getUniqueId());
        this.f18336g.getHttpMessageListener().setSelfListener(true);
        this.f18336g.getSocketMessageListener().setSelfListener(true);
        this.f18334e.registerListener(this.f18336g);
    }

    public void v(long j, int i, String str, String str2, BaijiahaoData baijiahaoData) {
        CheckPostRequestMessage checkPostRequestMessage = new CheckPostRequestMessage();
        checkPostRequestMessage.setPid(j);
        checkPostRequestMessage.setPostType(i);
        checkPostRequestMessage.setForumName(str);
        checkPostRequestMessage.setTid(d.b.b.e.m.b.f(str2, 0L));
        checkPostRequestMessage.setTag(this.f18334e.getUniqueId());
        if (baijiahaoData != null) {
            checkPostRequestMessage.ori_ugc_type = baijiahaoData.oriUgcType;
            checkPostRequestMessage.ori_ugc_tid = baijiahaoData.oriUgcTid;
            checkPostRequestMessage.ori_ugc_nid = baijiahaoData.oriUgcNid;
            checkPostRequestMessage.ori_ugc_vid = baijiahaoData.oriUgcVid;
        }
        sendMessage(checkPostRequestMessage);
    }

    public void w(b bVar) {
        this.f18335f = bVar;
    }
}
