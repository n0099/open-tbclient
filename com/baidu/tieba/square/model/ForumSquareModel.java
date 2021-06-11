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
import d.a.c.k.e.n;
import d.a.n0.b3.d;
import d.a.n0.e3.q0.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class ForumSquareModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public d f20736e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f20737f;

    /* renamed from: g  reason: collision with root package name */
    public final HashMap<String, d.a.n0.b3.f.c> f20738g;

    /* renamed from: h  reason: collision with root package name */
    public final List<String> f20739h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f20740i;
    public CustomMessageListener j;
    public d.a.c.c.g.a k;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof e)) {
                return;
            }
            e eVar = (e) customResponsedMessage.getData();
            if (eVar.f57913b) {
                ForumSquareModel.this.P(eVar.f57912a, true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof e)) {
                return;
            }
            e eVar = (e) customResponsedMessage.getData();
            if (eVar.f57913b) {
                ForumSquareModel.this.P(eVar.f57912a, false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends d.a.c.c.g.a {
        public c(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String str;
            d.a.n0.b3.f.d data;
            ForumSquareModel.this.f20737f = false;
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
            ForumSquareModel.this.M(data);
            if (ListUtils.isEmpty(ForumSquareModel.this.f20739h)) {
                if (ForumSquareModel.this.f20736e != null) {
                    ForumSquareModel.this.f20736e.b(errorData);
                }
            } else if (ForumSquareModel.this.mErrorCode != 0 || data == null) {
                if (ForumSquareModel.this.f20736e != null) {
                    ForumSquareModel.this.f20736e.c(str2, errorData);
                }
            } else {
                ForumSquareModel.this.N(data);
            }
        }
    }

    public ForumSquareModel(Context context, d dVar) {
        super(UtilHelper.getTbPageContext(context));
        this.f20737f = false;
        this.f20738g = new HashMap<>();
        this.f20739h = new ArrayList();
        this.f20740i = new a(2001437);
        this.j = new b(2001438);
        c cVar = new c(CmdConfigHttp.CMD_FORUM_SQUARE, 309653);
        this.k = cVar;
        this.f20736e = dVar;
        cVar.getHttpMessageListener().setSelfListener(true);
        this.k.getSocketMessageListener().setSelfListener(true);
        registerListener(this.k);
        registerListener(this.f20740i);
        registerListener(this.j);
    }

    public d.a.n0.b3.f.c I(String str) {
        if (str == null) {
            return null;
        }
        return this.f20738g.get(str);
    }

    public boolean J(String str) {
        d.a.n0.b3.f.c cVar;
        if (TextUtils.isEmpty(str) || (cVar = this.f20738g.get(str)) == null) {
            return false;
        }
        return cVar.f55810d;
    }

    public boolean K() {
        return this.f20737f;
    }

    public void L(String str) {
        d.a.n0.b3.f.c cVar;
        ForumSquareRequestMessage forumSquareRequestMessage = new ForumSquareRequestMessage();
        forumSquareRequestMessage.className = str;
        if (TextUtils.isEmpty(str)) {
            cVar = new d.a.n0.b3.f.c();
        } else {
            d.a.n0.b3.f.c cVar2 = this.f20738g.get(str);
            if (cVar2 == null) {
                cVar2 = new d.a.n0.b3.f.c();
                this.f20738g.put(str, cVar2);
            }
            cVar = cVar2;
        }
        forumSquareRequestMessage.pn = cVar.f55811e + 1;
        this.f20737f = true;
        sendMessage(forumSquareRequestMessage);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    public final void M(d.a.n0.b3.f.d dVar) {
        if (!ListUtils.isEmpty(this.f20739h) || dVar == null || ListUtils.isEmpty(dVar.f55815b)) {
            return;
        }
        for (String str : dVar.f55815b) {
            if (!TextUtils.isEmpty(str) && !this.f20739h.contains(str)) {
                this.f20739h.add(str);
            }
        }
    }

    public final void N(d.a.n0.b3.f.d dVar) {
        String str = dVar.f55817d;
        if (TextUtils.isEmpty(str)) {
            str = (String) ListUtils.getItem(this.f20739h, 0);
            dVar.f55817d = str;
        }
        d.a.n0.b3.f.c cVar = this.f20738g.get(str);
        if (cVar == null) {
            cVar = new d.a.n0.b3.f.c();
            this.f20738g.put(str, cVar);
        }
        cVar.b(dVar);
        d dVar2 = this.f20736e;
        if (dVar2 != null) {
            dVar2.a(str, this.f20739h, cVar.a());
        }
    }

    public int O(List<n> list, int i2) {
        int count = ListUtils.getCount(list);
        if (count <= i2) {
            return 0;
        }
        int max = Math.max(count - 300, 30);
        int i3 = (count - max) / 2;
        int i4 = i3 + max;
        if (i3 <= 20 || i4 >= count - 20) {
            return 0;
        }
        ListUtils.removeSubList(list, i3, i4);
        return max;
    }

    public final void P(long j, boolean z) {
        for (Map.Entry<String, d.a.n0.b3.f.c> entry : this.f20738g.entrySet()) {
            d.a.n0.b3.f.c value = entry.getValue();
            if (value != null && !ListUtils.isEmpty(value.a())) {
                for (n nVar : value.a()) {
                    if (nVar instanceof d.a.n0.b3.f.b) {
                        d.a.n0.b3.f.b bVar = (d.a.n0.b3.f.b) nVar;
                        if (bVar.f55802e == j) {
                            bVar.f55805h = z;
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        super.cancelMessage();
        this.f20737f = false;
    }
}
