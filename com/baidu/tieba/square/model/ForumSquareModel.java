package com.baidu.tieba.square.model;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.square.message.ForumSquareHttpResponsedMessage;
import com.baidu.tieba.square.message.ForumSquareRequestMessage;
import com.baidu.tieba.square.message.ForumSquareSocketResponsedMessage;
import d.b.b.j.e.n;
import d.b.i0.c3.q0.e;
import d.b.i0.z2.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class ForumSquareModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public d f21233e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f21234f;

    /* renamed from: g  reason: collision with root package name */
    public final HashMap<String, d.b.i0.z2.f.c> f21235g;

    /* renamed from: h  reason: collision with root package name */
    public final List<String> f21236h;
    public CustomMessageListener i;
    public CustomMessageListener j;
    public d.b.b.c.g.a k;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof e)) {
                return;
            }
            e eVar = (e) customResponsedMessage.getData();
            if (eVar.f53595b) {
                ForumSquareModel.this.L(eVar.f53594a, true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof e)) {
                return;
            }
            e eVar = (e) customResponsedMessage.getData();
            if (eVar.f53595b) {
                ForumSquareModel.this.L(eVar.f53594a, false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends d.b.b.c.g.a {
        public c(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String str;
            d.b.i0.z2.f.d data;
            ForumSquareModel.this.f21234f = false;
            if (responsedMessage == null) {
                return;
            }
            ForumSquareModel.this.mErrorCode = responsedMessage.getError();
            ForumSquareModel.this.mErrorString = responsedMessage.getErrorString();
            if (!StringUtils.isNull(ForumSquareModel.this.mErrorString)) {
                str = ForumSquareModel.this.mErrorString;
            } else {
                str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(ForumSquareModel.this.mErrorCode);
            errorData.setError_msg(str);
            if (responsedMessage instanceof ForumSquareHttpResponsedMessage) {
                data = ((ForumSquareHttpResponsedMessage) responsedMessage).getData();
            } else {
                data = responsedMessage instanceof ForumSquareSocketResponsedMessage ? ((ForumSquareSocketResponsedMessage) responsedMessage).getData() : null;
            }
            Object extra = responsedMessage.getOrginalMessage().getExtra();
            String str2 = extra instanceof ForumSquareRequestMessage ? ((ForumSquareRequestMessage) extra).className : null;
            ForumSquareModel.this.I(data);
            if (ListUtils.isEmpty(ForumSquareModel.this.f21236h)) {
                if (ForumSquareModel.this.f21233e != null) {
                    ForumSquareModel.this.f21233e.c(errorData);
                }
            } else if (ForumSquareModel.this.mErrorCode != 0 || data == null) {
                if (ForumSquareModel.this.f21233e != null) {
                    ForumSquareModel.this.f21233e.b(str2, errorData);
                }
            } else {
                ForumSquareModel.this.J(data);
            }
        }
    }

    public ForumSquareModel(Context context, d dVar) {
        super(UtilHelper.getTbPageContext(context));
        this.f21234f = false;
        this.f21235g = new HashMap<>();
        this.f21236h = new ArrayList();
        this.i = new a(2001437);
        this.j = new b(2001438);
        c cVar = new c(CmdConfigHttp.CMD_FORUM_SQUARE, 309653);
        this.k = cVar;
        this.f21233e = dVar;
        cVar.getHttpMessageListener().setSelfListener(true);
        this.k.getSocketMessageListener().setSelfListener(true);
        registerListener(this.k);
        registerListener(this.i);
        registerListener(this.j);
    }

    public d.b.i0.z2.f.c E(String str) {
        if (str == null) {
            return null;
        }
        return this.f21235g.get(str);
    }

    public boolean F(String str) {
        d.b.i0.z2.f.c cVar;
        if (TextUtils.isEmpty(str) || (cVar = this.f21235g.get(str)) == null) {
            return false;
        }
        return cVar.f63482d;
    }

    public boolean G() {
        return this.f21234f;
    }

    public void H(String str) {
        d.b.i0.z2.f.c cVar;
        ForumSquareRequestMessage forumSquareRequestMessage = new ForumSquareRequestMessage();
        forumSquareRequestMessage.className = str;
        if (TextUtils.isEmpty(str)) {
            cVar = new d.b.i0.z2.f.c();
        } else {
            d.b.i0.z2.f.c cVar2 = this.f21235g.get(str);
            if (cVar2 == null) {
                cVar2 = new d.b.i0.z2.f.c();
                this.f21235g.put(str, cVar2);
            }
            cVar = cVar2;
        }
        forumSquareRequestMessage.pn = cVar.f63483e + 1;
        this.f21234f = true;
        sendMessage(forumSquareRequestMessage);
    }

    public final void I(d.b.i0.z2.f.d dVar) {
        if (!ListUtils.isEmpty(this.f21236h) || dVar == null || ListUtils.isEmpty(dVar.f63487b)) {
            return;
        }
        for (String str : dVar.f63487b) {
            if (!TextUtils.isEmpty(str) && !this.f21236h.contains(str)) {
                this.f21236h.add(str);
            }
        }
    }

    public final void J(d.b.i0.z2.f.d dVar) {
        String str = dVar.f63489d;
        if (TextUtils.isEmpty(str)) {
            str = (String) ListUtils.getItem(this.f21236h, 0);
            dVar.f63489d = str;
        }
        d.b.i0.z2.f.c cVar = this.f21235g.get(str);
        if (cVar == null) {
            cVar = new d.b.i0.z2.f.c();
            this.f21235g.put(str, cVar);
        }
        cVar.b(dVar);
        d dVar2 = this.f21233e;
        if (dVar2 != null) {
            dVar2.a(str, this.f21236h, cVar.a());
        }
    }

    public int K(List<n> list, int i) {
        int count = ListUtils.getCount(list);
        if (count <= i) {
            return 0;
        }
        int max = Math.max(count - 300, 30);
        int i2 = (count - max) / 2;
        int i3 = i2 + max;
        if (i2 <= 20 || i3 >= count - 20) {
            return 0;
        }
        ListUtils.removeSubList(list, i2, i3);
        return max;
    }

    public final void L(long j, boolean z) {
        for (Map.Entry<String, d.b.i0.z2.f.c> entry : this.f21235g.entrySet()) {
            d.b.i0.z2.f.c value = entry.getValue();
            if (value != null && !ListUtils.isEmpty(value.a())) {
                for (n nVar : value.a()) {
                    if (nVar instanceof d.b.i0.z2.f.b) {
                        d.b.i0.z2.f.b bVar = (d.b.i0.z2.f.b) nVar;
                        if (bVar.f63475e == j) {
                            bVar.f63478h = z;
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        super.cancelMessage();
        this.f21234f = false;
    }
}
