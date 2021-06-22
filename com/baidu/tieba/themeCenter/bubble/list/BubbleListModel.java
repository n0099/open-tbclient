package com.baidu.tieba.themeCenter.bubble.list;

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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class BubbleListModel extends BdBaseModel<BubbleListActivity> {

    /* renamed from: e  reason: collision with root package name */
    public BubbleListActivity f21274e;

    /* renamed from: f  reason: collision with root package name */
    public e f21275f;

    /* renamed from: g  reason: collision with root package name */
    public List<DressItemData> f21276g;

    /* renamed from: h  reason: collision with root package name */
    public List<DressItemData> f21277h;

    /* renamed from: i  reason: collision with root package name */
    public c f21278i;
    public int j;
    public boolean k;
    public boolean l;
    public boolean m;
    public d.a.c.c.g.a n;
    public final HttpMessageListener o;

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
            boolean z = responsedMessage instanceof BubbleListHttpResponseMessage;
            if (z || (responsedMessage instanceof BubbleListSocketResponseMessage)) {
                if (responsedMessage.getError() == 0) {
                    if (z) {
                        BubbleListHttpResponseMessage bubbleListHttpResponseMessage = (BubbleListHttpResponseMessage) responsedMessage;
                        BubbleListModel.this.f21275f = bubbleListHttpResponseMessage.getRecommand();
                        BubbleListModel.this.f21276g = bubbleListHttpResponseMessage.getBubbleList();
                        BubbleListModel.this.k = bubbleListHttpResponseMessage.hasMore();
                        BubbleListModel.this.l = bubbleListHttpResponseMessage.isDefault();
                    } else if (responsedMessage instanceof BubbleListSocketResponseMessage) {
                        BubbleListSocketResponseMessage bubbleListSocketResponseMessage = (BubbleListSocketResponseMessage) responsedMessage;
                        BubbleListModel.this.f21275f = bubbleListSocketResponseMessage.getRecommand();
                        BubbleListModel.this.f21276g = bubbleListSocketResponseMessage.getBubbleList();
                        BubbleListModel.this.k = bubbleListSocketResponseMessage.hasMore();
                        BubbleListModel.this.l = bubbleListSocketResponseMessage.isDefault();
                    }
                    if (BubbleListModel.this.f21277h == null) {
                        BubbleListModel.this.f21277h = new ArrayList();
                    }
                    if (BubbleListModel.this.j == 1) {
                        BubbleListModel.this.f21277h.clear();
                        DressItemData dressItemData = new DressItemData();
                        dressItemData.setPropsId(0);
                        dressItemData.setInUse(BubbleListModel.this.l);
                        BubbleListModel.this.f21277h.add(dressItemData);
                    }
                    if (BubbleListModel.this.f21276g != null) {
                        BubbleListModel.this.f21277h.addAll(BubbleListModel.this.f21276g);
                    }
                } else {
                    BubbleListModel.y(BubbleListModel.this);
                }
                if (BubbleListModel.this.f21278i != null) {
                    BubbleListModel.this.f21278i.a(responsedMessage.getError(), responsedMessage.getErrorString(), BubbleListModel.this.f21275f, BubbleListModel.this.f21277h);
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
                BubbleListModel.this.f21274e.showToast(bubbleSetResponseMessage.getErrorString());
                return;
            }
            BubbleListModel.this.O(((Integer) ((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getExtra()).intValue());
            BubbleListModel.this.f21278i.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), BubbleListModel.this.f21275f, BubbleListModel.this.f21277h);
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(int i2, String str, e eVar, List<DressItemData> list);
    }

    public BubbleListModel(BubbleListActivity bubbleListActivity) {
        super(bubbleListActivity.getPageContext());
        this.j = 0;
        this.k = true;
        this.l = false;
        this.n = new a(CmdConfigHttp.CMD_BUBBLE_LIST, 309031);
        this.o = new b(CmdConfigHttp.CMD_BUBBLE_SET);
        this.f21274e = bubbleListActivity;
        this.m = bubbleListActivity.getIntent().getBooleanExtra(IntentConfig.MEMBER_BUY_SHOW, false);
        registerTask();
        registerListener(this.n);
        M();
        registerListener(this.o);
    }

    public static /* synthetic */ int y(BubbleListModel bubbleListModel) {
        int i2 = bubbleListModel.j;
        bubbleListModel.j = i2 - 1;
        return i2;
    }

    public boolean L() {
        return this.m;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        BubbleListRequestMessage bubbleListRequestMessage = new BubbleListRequestMessage();
        this.j = 1;
        bubbleListRequestMessage.setPn(1);
        bubbleListRequestMessage.setRn(15);
        sendMessage(bubbleListRequestMessage);
        return false;
    }

    public final void M() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_BUBBLE_SET, TbConfig.SERVER_ADDRESS + TbConfig.BUBBLE_SET);
        tbHttpMessageTask.setResponsedClass(BubbleSetResponseMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public void N(c cVar) {
        this.f21278i = cVar;
    }

    public final void O(int i2) {
        List<DressItemData> list = this.f21277h;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (DressItemData dressItemData : this.f21277h) {
            if (dressItemData != null) {
                if (dressItemData.getPropsId() == i2) {
                    dressItemData.setInUse(true);
                } else {
                    dressItemData.setInUse(false);
                }
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public final void registerTask() {
        d.a.o0.e3.d0.a.h(309031, BubbleListSocketResponseMessage.class, false, false);
        d.a.o0.e3.d0.a.c(309031, CmdConfigHttp.CMD_BUBBLE_LIST, TbConfig.BUBBLE_LIST_PAGE, BubbleListHttpResponseMessage.class, false, false, false, false);
    }

    public void w() {
        if (this.k) {
            this.j++;
            BubbleListRequestMessage bubbleListRequestMessage = new BubbleListRequestMessage();
            bubbleListRequestMessage.setPn(this.j);
            bubbleListRequestMessage.setRn(16);
            sendMessage(bubbleListRequestMessage);
        }
    }
}
