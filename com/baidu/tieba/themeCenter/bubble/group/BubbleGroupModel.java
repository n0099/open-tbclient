package com.baidu.tieba.themeCenter.bubble.group;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.tieba.themeCenter.bubble.all.BubbleSetResponseMessage;
import d.a.o0.k3.h.e;
import java.util.List;
/* loaded from: classes5.dex */
public class BubbleGroupModel extends BdBaseModel<BubbleGroupActivity> {

    /* renamed from: e  reason: collision with root package name */
    public BubbleGroupActivity f21264e;

    /* renamed from: f  reason: collision with root package name */
    public e f21265f;

    /* renamed from: g  reason: collision with root package name */
    public List<d.a.o0.k3.f.b.b> f21266g;

    /* renamed from: h  reason: collision with root package name */
    public c f21267h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f21268i;
    public d.a.c.c.g.a j;
    public final HttpMessageListener k;

    /* loaded from: classes5.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof BubbleGroupHttpResponseMessage;
            if (z || (responsedMessage instanceof BubbleGroupSocketResponseMessage)) {
                if (responsedMessage.getError() != 0) {
                    if (BubbleGroupModel.this.f21267h != null) {
                        BubbleGroupModel.this.f21267h.a(responsedMessage.getError(), responsedMessage.getErrorString(), BubbleGroupModel.this.f21265f, BubbleGroupModel.this.f21266g);
                        return;
                    }
                    return;
                }
                if (z) {
                    BubbleGroupHttpResponseMessage bubbleGroupHttpResponseMessage = (BubbleGroupHttpResponseMessage) responsedMessage;
                    BubbleGroupModel.this.f21265f = bubbleGroupHttpResponseMessage.getRecommand();
                    BubbleGroupModel.this.f21266g = bubbleGroupHttpResponseMessage.getGroupList();
                } else if (responsedMessage instanceof BubbleGroupSocketResponseMessage) {
                    BubbleGroupSocketResponseMessage bubbleGroupSocketResponseMessage = (BubbleGroupSocketResponseMessage) responsedMessage;
                    BubbleGroupModel.this.f21265f = bubbleGroupSocketResponseMessage.getRecommand();
                    BubbleGroupModel.this.f21266g = bubbleGroupSocketResponseMessage.getGroupList();
                }
                if (BubbleGroupModel.this.f21267h != null) {
                    BubbleGroupModel.this.f21267h.a(responsedMessage.getError(), responsedMessage.getErrorString(), BubbleGroupModel.this.f21265f, BubbleGroupModel.this.f21266g);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends HttpMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1003056) {
                return;
            }
            BubbleSetResponseMessage bubbleSetResponseMessage = (BubbleSetResponseMessage) httpResponsedMessage;
            if (bubbleSetResponseMessage.getError() != 0) {
                BubbleGroupModel.this.f21264e.showToast(bubbleSetResponseMessage.getErrorString());
                return;
            }
            BubbleGroupModel.this.H(((Integer) ((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getExtra()).intValue());
            BubbleGroupModel.this.f21267h.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), BubbleGroupModel.this.f21265f, BubbleGroupModel.this.f21266g);
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(int i2, String str, e eVar, List<d.a.o0.k3.f.b.b> list);
    }

    public BubbleGroupModel(BubbleGroupActivity bubbleGroupActivity) {
        super(bubbleGroupActivity.getPageContext());
        this.j = new a(CmdConfigHttp.CMD_BUBBLE_CATEGORY, 309030);
        this.k = new b(CmdConfigHttp.CMD_BUBBLE_SET);
        this.f21264e = bubbleGroupActivity;
        this.f21268i = bubbleGroupActivity.getIntent().getBooleanExtra(IntentConfig.MEMBER_BUY_SHOW, false);
        E();
        registerListener(this.j);
        F();
        registerListener(this.k);
    }

    public boolean D() {
        return this.f21268i;
    }

    public final void E() {
        d.a.o0.e3.d0.a.h(309030, BubbleGroupSocketResponseMessage.class, false, false);
        d.a.o0.e3.d0.a.c(309030, CmdConfigHttp.CMD_BUBBLE_CATEGORY, TbConfig.BUBBLE_GROUP_PAGE, BubbleGroupHttpResponseMessage.class, false, false, false, false);
    }

    public final void F() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_BUBBLE_SET, TbConfig.SERVER_ADDRESS + TbConfig.BUBBLE_SET);
        tbHttpMessageTask.setResponsedClass(BubbleSetResponseMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public void G(c cVar) {
        this.f21267h = cVar;
    }

    public final void H(int i2) {
        List<d.a.o0.k3.f.b.b> list = this.f21266g;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (d.a.o0.k3.f.b.b bVar : this.f21266g) {
            if (bVar != null && bVar.a() != null) {
                for (DressItemData dressItemData : bVar.a()) {
                    if (dressItemData != null) {
                        if (dressItemData.getPropsId() == i2) {
                            dressItemData.setInUse(true);
                        } else {
                            dressItemData.setInUse(false);
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        sendMessage(new BubbleGroupRequestMessage());
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
