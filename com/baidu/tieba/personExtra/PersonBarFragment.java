package com.baidu.tieba.personExtra;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.ResponseGetLivableForumList;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.RequestGetLivableForumList;
import d.a.m0.r.f0.f;
import d.a.m0.z0.f0;
import d.a.m0.z0.h0;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class PersonBarFragment extends BaseFragment implements AdapterView.OnItemClickListener, View.OnClickListener {
    public PersonBarModel l;
    public String v;
    public TextView x;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBarShadowView f19798e = null;

    /* renamed from: f  reason: collision with root package name */
    public NavigationBarShadowView f19799f = null;

    /* renamed from: g  reason: collision with root package name */
    public BdListView f19800g = null;

    /* renamed from: h  reason: collision with root package name */
    public m f19801h = null;

    /* renamed from: i  reason: collision with root package name */
    public d.a.n0.i2.c f19802i = null;
    public int j = -1;
    public String k = null;
    public View m = null;
    public NoDataView n = null;
    public d.a.m0.r.f0.g o = null;
    public TextView p = null;
    public int q = 0;
    public int r = 50;
    public boolean s = false;
    public ForumData t = null;
    public boolean u = false;
    public View w = null;
    public boolean y = false;
    public int z = 0;
    public boolean A = true;
    public boolean B = false;
    public boolean C = false;
    public boolean D = false;
    public ArrayList<ForumData> E = new ArrayList<>();
    public int F = R.color.navi_op_text;
    public AbsListView.OnScrollListener G = new d();
    public final d.a.c.c.g.c H = new l(107129);
    public final CustomMessageListener I = new a(2001183);
    public HttpMessageListener J = new b(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
    public HttpMessageListener K = new c(CmdConfigHttp.PIC_LIKE_BAR_CMD);

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001183 && PersonBarFragment.this.A) {
                d.a.n0.i2.b personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                if (PersonBarFragment.this.l1() != null) {
                    if (personBarData != null) {
                        PersonBarFragment.this.B = true;
                    }
                    if (PersonBarFragment.this.l1().getRequestCode() != 23011) {
                        PersonBarFragment.this.w.setVisibility(8);
                    } else {
                        if (!PersonBarFragment.this.D) {
                            PersonBarFragment.this.D = true;
                            PersonBarFragment personBarFragment = PersonBarFragment.this;
                            personBarFragment.f19800g.addHeaderView(personBarFragment.w);
                        }
                        PersonBarFragment.this.w.setVisibility(0);
                    }
                    PersonBarFragment.this.q1(personBarData, true);
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
            PersonBarFragment.this.u = false;
            if (httpResponsedMessage.getError() == 0) {
                ArrayList<ForumData> i2 = PersonBarFragment.this.l.w().i();
                int k = PersonBarFragment.this.l.w().k();
                if (PersonBarFragment.this.j < k) {
                    PersonBarFragment.this.l.w().t(k - 1);
                }
                if (i2 != null && PersonBarFragment.this.j >= 0 && PersonBarFragment.this.j < i2.size()) {
                    i2.remove(PersonBarFragment.this.j);
                    TbadkCoreApplication.getInst().delLikeForum(PersonBarFragment.this.k);
                    if (PersonBarFragment.this.f19802i != null) {
                        PersonBarFragment.this.i1(true);
                        PersonBarFragment.this.f19802i.g(i2);
                        PersonBarFragment.this.f19802i.notifyDataSetChanged();
                    }
                }
                PersonBarFragment.this.showToast(R.string.success);
                if (PersonBarFragment.this.t == null || TextUtils.isEmpty(PersonBarFragment.this.t.getId())) {
                    return;
                }
                PersonBarFragment personBarFragment = PersonBarFragment.this;
                personBarFragment.sendMessage(new CustomMessage(2003004, personBarFragment.t.getId()));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(d.a.c.e.m.b.f(PersonBarFragment.this.t.getId(), 0L))));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, PersonBarFragment.this.t.getName()));
                return;
            }
            PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
        }
    }

    /* loaded from: classes5.dex */
    public class c extends HttpMessageListener {

        /* loaded from: classes5.dex */
        public class a extends f0<Object> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PersonBarModel f19806a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f19807b;

            public a(c cVar, PersonBarModel personBarModel, String str) {
                this.f19806a = personBarModel;
                this.f19807b = str;
            }

            @Override // d.a.m0.z0.f0
            public Object doInBackground() {
                PersonBarModel personBarModel = this.f19806a;
                if (personBarModel != null) {
                    personBarModel.A(this.f19807b);
                    return null;
                }
                return null;
            }
        }

        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PersonBarFragment personBarFragment;
            m mVar;
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1002002) {
                return;
            }
            if (PersonBarFragment.this.l1() != null) {
                m mVar2 = PersonBarFragment.this.f19801h;
                if (mVar2 != null && mVar2.b() != null) {
                    PersonBarFragment.this.f19801h.b().setVisibility(0);
                }
                PersonBarFragment.this.f19800g.A(0L);
                PersonBarFragment.this.y = false;
                if (httpResponsedMessage.getOrginalMessage().getTag() == PersonBarFragment.this.l1().getUniqueId()) {
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                        PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                        if (personBarResponseMessage.getErrCode() == 0) {
                            d.a.n0.i2.b personBarData = personBarResponseMessage.getPersonBarData();
                            PersonBarFragment.this.l.B(PersonBarFragment.this.q);
                            h0.b(new a(this, PersonBarFragment.this.l, personBarResponseMessage.getResultString()), null);
                            PersonBarFragment.this.q1(personBarData, false);
                            if (1 != PersonBarFragment.this.l1().getCurrentPageType() || (mVar = (personBarFragment = PersonBarFragment.this).f19801h) == null) {
                                return;
                            }
                            mVar.f(personBarFragment.v);
                            return;
                        }
                        PersonBarFragment.this.showToast(httpResponsedMessage.getErrorString());
                        PersonBarFragment personBarFragment2 = PersonBarFragment.this;
                        m mVar3 = personBarFragment2.f19801h;
                        if (mVar3 != null) {
                            mVar3.f(personBarFragment2.v);
                            return;
                        }
                        return;
                    }
                    PersonBarFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonBarFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
                    if (PersonBarFragment.this.B) {
                        PersonBarFragment personBarFragment3 = PersonBarFragment.this;
                        m mVar4 = personBarFragment3.f19801h;
                        if (mVar4 != null) {
                            mVar4.f(personBarFragment3.v);
                            return;
                        }
                        return;
                    }
                    m mVar5 = PersonBarFragment.this.f19801h;
                    if (mVar5 != null) {
                        mVar5.f("");
                        return;
                    }
                    return;
                }
                return;
            }
            PersonBarFragment personBarFragment4 = PersonBarFragment.this;
            m mVar6 = personBarFragment4.f19801h;
            if (mVar6 != null) {
                mVar6.f(personBarFragment4.v);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements AbsListView.OnScrollListener {
        public d() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            View childAt;
            if (i2 == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                if (PersonBarFragment.this.A) {
                    PersonBarFragment.this.f19798e.a();
                } else {
                    PersonBarFragment.this.f19799f.a();
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            if (i2 == 1) {
                if (PersonBarFragment.this.A) {
                    PersonBarFragment.this.f19798e.c();
                } else {
                    PersonBarFragment.this.f19799f.c();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SkinManager.setNavbarTitleColor(PersonBarFragment.this.p, R.color.CAM_X0106, R.color.navi_op_text_skin);
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonBarFragment.this.f19802i != null) {
                if (!PersonBarFragment.this.f19802i.c()) {
                    PersonBarFragment.this.f19802i.f(true);
                    PersonBarFragment.this.p.setText(R.string.done);
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        PersonBarFragment.this.F = R.color.navi_op_text_skin;
                    } else {
                        PersonBarFragment.this.F = R.color.CAM_X0302;
                    }
                    SkinManager.setViewTextColor(PersonBarFragment.this.p, PersonBarFragment.this.F, 1);
                    PersonBarFragment.this.f19802i.notifyDataSetChanged();
                    return;
                }
                PersonBarFragment.this.f19802i.f(false);
                PersonBarFragment.this.p.setText(R.string.edit);
                if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                    PersonBarFragment.this.F = R.color.navi_op_text_skin;
                } else {
                    PersonBarFragment.this.F = R.color.CAM_X0106;
                }
                SkinManager.setViewTextColor(PersonBarFragment.this.p, PersonBarFragment.this.F, 1);
                PersonBarFragment.this.f19802i.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PersonBarFragment.this.j = ((Integer) view.getTag()).intValue();
            if (PersonBarFragment.this.j < 0 || PersonBarFragment.this.j >= PersonBarFragment.this.f19802i.getCount() || PersonBarFragment.this.u) {
                return;
            }
            PersonBarFragment personBarFragment = PersonBarFragment.this;
            personBarFragment.t = (ForumData) personBarFragment.f19802i.getItem(PersonBarFragment.this.j);
            if (PersonBarFragment.this.t == null || PersonBarFragment.this.t.getId() == null || PersonBarFragment.this.t.getName() == null) {
                return;
            }
            PersonBarFragment personBarFragment2 = PersonBarFragment.this;
            personBarFragment2.k = personBarFragment2.t.getName();
            PersonBarFragment.this.u = true;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
            httpMessage.addParam("fid", PersonBarFragment.this.t.getId());
            httpMessage.addParam(TiebaStatic.Params.H5_FORUM_NAME, PersonBarFragment.this.k);
            httpMessage.addParam("favo_type", String.valueOf(PersonBarFragment.this.t.getFavo_type()));
            httpMessage.addParam(HttpRequest.TBS, TbadkCoreApplication.getInst().getTbs());
            PersonBarFragment.this.sendMessage(httpMessage);
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (intValue < 0 || intValue >= PersonBarFragment.this.f19802i.getCount()) {
                return;
            }
            ForumData forumData = (ForumData) PersonBarFragment.this.f19802i.getItem(intValue);
            if (PersonBarFragment.this.l1() != null) {
                PersonBarFragment.this.sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(PersonBarFragment.this.l1().getPageContext().getPageActivity(), d.a.c.e.m.b.f(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements AdapterView.OnItemClickListener {
        public i() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            if (PersonBarFragment.this.f19802i.getItem(i2) == null || PersonBarFragment.this.u) {
                return;
            }
            PersonBarFragment.this.j = i2;
            ForumData forumData = (ForumData) PersonBarFragment.this.f19802i.getItem(i2);
            if (forumData == null || PersonBarFragment.this.l1() == null) {
                return;
            }
            if (PersonBarFragment.this.C) {
                Intent intent = new Intent();
                intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                PersonBarActivity l1 = PersonBarFragment.this.l1();
                PersonBarFragment.this.l1();
                l1.setResult(-1, intent);
                PersonBarFragment.this.l1().finish();
                return;
            }
            FrsActivityConfig createNormalCfg = new FrsActivityConfig(PersonBarFragment.this.l1().getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba");
            if (PersonBarFragment.this.A) {
                createNormalCfg.setCallFrom(7);
            } else {
                createNormalCfg.setCallFrom(9);
            }
            PersonBarFragment.this.sendMessage(new CustomMessage(2003000, createNormalCfg));
        }
    }

    /* loaded from: classes5.dex */
    public class j implements f.g {
        public j() {
        }

        @Override // d.a.m0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (PersonBarFragment.this.l1() != null) {
                PersonBarFragment personBarFragment = PersonBarFragment.this;
                personBarFragment.q = 1;
                if (personBarFragment.l1() == null || PersonBarFragment.this.l1().getRequestCode() != 23011) {
                    PersonBarFragment.this.n1();
                    return;
                }
                RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                requestGetLivableForumList.setGetLikeForum(1);
                requestGetLivableForumList.setPageNo(PersonBarFragment.this.q);
                requestGetLivableForumList.setPageSize(PersonBarFragment.this.r);
                requestGetLivableForumList.setUserId(d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L));
                PersonBarFragment.this.sendMessage(requestGetLivableForumList);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements BdListView.p {
        public k() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            PersonBarFragment personBarFragment = PersonBarFragment.this;
            if (personBarFragment.s) {
                if (personBarFragment.y) {
                    return;
                }
                PersonBarFragment.this.y = true;
                PersonBarFragment.this.f19801h.e();
                if (PersonBarFragment.this.l1().getRequestCode() == 23011) {
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(PersonBarFragment.this.q);
                    requestGetLivableForumList.setPageSize(PersonBarFragment.this.r);
                    requestGetLivableForumList.setUserId(d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L));
                    PersonBarFragment.this.sendMessage(requestGetLivableForumList);
                    return;
                }
                PersonBarFragment personBarFragment2 = PersonBarFragment.this;
                personBarFragment2.o1(personBarFragment2.q);
                return;
            }
            personBarFragment.f19801h.f(personBarFragment.v);
        }
    }

    /* loaded from: classes5.dex */
    public class l extends d.a.c.c.g.c {
        public l(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonBarFragment.this.f19800g.A(0L);
            if (socketResponsedMessage == null) {
                PersonBarFragment personBarFragment = PersonBarFragment.this;
                personBarFragment.showToast(personBarFragment.getPageContext().getString(R.string.neterror));
            } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
                ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
                if (responseGetLivableForumList.getError() == 0) {
                    if (PersonBarFragment.this.l1() == null || PersonBarFragment.this.l1().getRequestCode() == 23011) {
                        if (!PersonBarFragment.this.D) {
                            PersonBarFragment.this.D = true;
                            PersonBarFragment personBarFragment2 = PersonBarFragment.this;
                            personBarFragment2.f19800g.addHeaderView(personBarFragment2.w);
                            int miniLevel = responseGetLivableForumList.getMiniLevel();
                            if (miniLevel <= 0) {
                                miniLevel = 0;
                            }
                            PersonBarFragment.this.x.setText(PersonBarFragment.this.getResources().getString(R.string.level_above_six_tip, Integer.valueOf(miniLevel)));
                            SkinManager.setViewTextColor(PersonBarFragment.this.x, R.color.CAM_X0108, 1);
                            SkinManager.setBackgroundColor(PersonBarFragment.this.x, R.color.common_color_10238);
                        }
                        PersonBarFragment.this.w.setVisibility(0);
                    } else {
                        PersonBarFragment.this.w.setVisibility(8);
                    }
                    if (PersonBarFragment.this.f19802i != null) {
                        PersonBarFragment.this.E.addAll(responseGetLivableForumList.getData());
                        PersonBarFragment.this.p1();
                        PersonBarFragment.this.f19802i.g(PersonBarFragment.this.E);
                        PersonBarFragment.this.s = responseGetLivableForumList.hasMore();
                        PersonBarFragment.this.i1(true);
                        PersonBarFragment.this.f19802i.notifyDataSetChanged();
                        PersonBarFragment.this.q++;
                        return;
                    }
                    return;
                }
                PersonBarFragment.this.showToast(responseGetLivableForumList.getErrorString());
                PersonBarFragment personBarFragment3 = PersonBarFragment.this;
                personBarFragment3.f19801h.f(personBarFragment3.v);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class m extends d.a.c.k.e.b {

        /* renamed from: g  reason: collision with root package name */
        public BaseFragmentActivity f19818g;
        public View l;

        /* renamed from: f  reason: collision with root package name */
        public int f19817f = R.color.CAM_X0201;

        /* renamed from: h  reason: collision with root package name */
        public TextView f19819h = null;

        /* renamed from: i  reason: collision with root package name */
        public ProgressBar f19820i = null;
        public View.OnClickListener j = null;
        public View k = null;

        public m(BaseFragmentActivity baseFragmentActivity) {
            this.f19818g = null;
            this.f19818g = baseFragmentActivity;
        }

        @Override // d.a.c.k.e.b
        public View a() {
            View inflate = LayoutInflater.from(this.f19818g.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.k = inflate;
            inflate.setPadding(0, this.f19818g.getResources().getDimensionPixelSize(R.dimen.ds16), 0, this.f19818g.getResources().getDimensionPixelSize(R.dimen.ds16));
            this.f19819h = (TextView) this.k.findViewById(R.id.pb_more_text);
            this.l = this.k.findViewById(R.id.pb_more_view);
            SkinManager.setBackgroundColor(this.k, this.f19817f);
            SkinManager.setBackgroundColor(this.l, this.f19817f);
            this.l.setVisibility(8);
            this.f19820i = (ProgressBar) this.k.findViewById(R.id.progress);
            h(TbadkCoreApplication.getInst().getSkinType());
            this.l.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.k;
        }

        @Override // d.a.c.k.e.b
        public void c() {
            View.OnClickListener onClickListener = this.j;
            if (onClickListener != null) {
                onClickListener.onClick(this.k);
            }
        }

        @SuppressLint({"ResourceAsColor"})
        public void d(int i2) {
            SkinManager.setBackgroundColor(this.k, this.f19817f, i2);
            SkinManager.setBackgroundColor(this.l, this.f19817f, i2);
        }

        public void e() {
            this.f19820i.setVisibility(0);
            this.f19819h.setText(this.f19818g.getPageContext().getPageActivity().getText(R.string.loading));
            this.l.setVisibility(0);
        }

        public void f(String str) {
            g(false, str);
        }

        public void g(boolean z, String str) {
            ProgressBar progressBar = this.f19820i;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            if (this.f19819h != null) {
                if (!z) {
                    this.l.setVisibility(0);
                    this.f19819h.setText(str);
                    return;
                }
                this.l.setVisibility(8);
            }
        }

        public void h(int i2) {
            this.f19818g.getLayoutMode().j(this.l);
        }
    }

    static {
        d.a.n0.e3.d0.a.b(2001183, d.a.n0.i2.f.class);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD, TbConfig.SERVER_ADDRESS + TbConfig.UNFAVOLIKE_ADDRESS);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void i1(boolean z) {
        TextView textView;
        d.a.n0.i2.c cVar = this.f19802i;
        if (cVar == null) {
            return;
        }
        cVar.b();
        if (!this.f19802i.d()) {
            j1(false);
            this.f19800g.setVisibility(0);
            TextView textView2 = this.p;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            if (l1() == null || l1().getRequestCode() != 23011 || (textView = this.p) == null) {
                return;
            }
            textView.setVisibility(8);
        } else if (z) {
            this.f19802i.f(false);
            j1(true);
            this.f19800g.setVisibility(0);
            TextView textView3 = this.p;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            m mVar = this.f19801h;
            if (mVar == null || mVar.b() == null) {
                return;
            }
            this.f19801h.b().setVisibility(8);
        }
    }

    public final void j1(boolean z) {
        if (z) {
            if (this.f19800g != null) {
                NoDataView noDataView = this.n;
                if (noDataView != null) {
                    noDataView.setVisibility(0);
                }
                this.f19800g.removeHeaderView(this.n);
                this.f19800g.addHeaderView(this.n);
            }
        } else if (this.f19800g != null) {
            NoDataView noDataView2 = this.n;
            if (noDataView2 != null) {
                noDataView2.setVisibility(8);
            }
            this.f19800g.removeHeaderView(this.n);
        }
    }

    public d.a.n0.i2.c k1() {
        return this.f19802i;
    }

    public final PersonBarActivity l1() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        if (baseFragmentActivity instanceof PersonBarActivity) {
            return (PersonBarActivity) baseFragmentActivity;
        }
        return null;
    }

    public void m1() {
        PersonBarModel personBarModel = this.l;
        if (personBarModel != null) {
            personBarModel.y();
        }
    }

    public final void n1() {
        PersonBarModel personBarModel = this.l;
        if (personBarModel != null) {
            personBarModel.z(this.A, personBarModel.getId(), this.q, this.r);
        }
    }

    public void o1(int i2) {
        PersonBarModel personBarModel = this.l;
        if (personBarModel != null) {
            personBarModel.z(this.A, personBarModel.getId(), i2, this.r);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.K);
        registerListener(this.J);
        registerListener(this.I);
        registerListener(this.H);
        this.H.setSelfListener(true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        if (isAdded()) {
            if (this.m != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().k(i2 == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().j(this.m);
            }
            if (this.n != null && getBaseFragmentActivity() != null) {
                SkinManager.setBackgroundResource(this.n, R.color.CAM_X0201);
                this.n.f(getBaseFragmentActivity().getPageContext(), i2);
            }
            if (l1() != null) {
                l1().getNavigationBar().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i2);
            }
            d.a.m0.r.f0.g gVar = this.o;
            if (gVar != null) {
                gVar.I(i2);
            }
            d.a.n0.i2.c cVar = this.f19802i;
            if (cVar != null) {
                cVar.notifyDataSetChanged();
            }
            m mVar = this.f19801h;
            if (mVar != null) {
                mVar.d(i2);
            }
            SkinManager.setNavbarTitleColor(this.p, this.F, R.color.navi_op_text_skin);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.z = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        View inflate2 = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.friend_fragment_header, (ViewGroup) null);
        this.w = inflate2;
        this.x = (TextView) inflate2.findViewById(R.id.header_text_describe);
        if (l1() == null) {
            return inflate;
        }
        this.v = getString(R.string.person_bar_no_more);
        this.l = l1().getModel();
        this.A = l1().getIsHost();
        this.C = l1().ismIsChooseBarMode();
        this.m = inflate.findViewById(R.id.friend_fragment_parent);
        if (this.A && !this.C) {
            TextView textView = (TextView) l1().getNavigationBar().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, l1()).findViewById(R.id.right_textview);
            this.p = textView;
            textView.postDelayed(new e(), 100L);
            this.p.setText(R.string.edit);
            this.p.setOnClickListener(new f());
            this.p.setVisibility(0);
        }
        d.a.n0.i2.c cVar = new d.a.n0.i2.c(l1(), this.l.w(), this.A, this.C);
        this.f19802i = cVar;
        cVar.h(l1().getSelectedBarId());
        this.f19802i.e(new g());
        this.f19802i.i(new h());
        this.f19798e = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_host_concern_bar);
        this.f19799f = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_ta_concern_bar);
        BdListView bdListView = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.f19800g = bdListView;
        bdListView.setAdapter((ListAdapter) this.f19802i);
        this.f19800g.setOnItemClickListener(new i());
        this.f19800g.setOnScrollListener(this.G);
        d.a.m0.r.f0.g gVar = new d.a.m0.r.f0.g(l1().getPageContext());
        this.o = gVar;
        gVar.a(new j());
        m mVar = new m(getBaseFragmentActivity());
        this.f19801h = mVar;
        this.f19800g.setNextPage(mVar);
        this.f19800g.setOnSrollToBottomListener(new k());
        this.f19800g.setPullRefresh(this.o);
        if (this.A) {
            BdListViewHelper.d(getActivity(), this.f19800g, BdListViewHelper.HeadType.DEFAULT);
            dimension = d.a.c.e.p.l.g(getActivity(), R.dimen.ds220);
            string = getString(R.string.person_bar_no_personal_info);
        } else {
            BdListViewHelper.d(getActivity(), this.f19800g, BdListViewHelper.HeadType.HASTAB);
            dimension = (int) getResources().getDimension(R.dimen.ds102);
            if (this.z == 0) {
                string = getString(R.string.person_bar_no_personal_info);
            } else {
                string = getString(R.string.no_data_common_txt);
            }
        }
        if (this.C) {
            this.n = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.e.d(string, getString(R.string.share_choose_bar_nothing_tip)), null);
        } else {
            this.n = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.FINDBAR, dimension), NoDataViewFactory.e.d(null, string), null);
        }
        if (this.A && l1() != null && l1().getRequestCode() != 23011) {
            m1();
        }
        if (this.z == l1().getCurrentPageType()) {
            this.f19800g.F();
        }
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        if (this.f19802i != null) {
            this.f19802i = null;
        }
        MessageManager.getInstance().unRegisterListener(this.J);
        MessageManager.getInstance().unRegisterListener(this.K);
        MessageManager.getInstance().unRegisterListener(this.I);
        MessageManager.getInstance().unRegisterListener(this.H);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        NoDataView noDataView = this.n;
        if (noDataView != null) {
            noDataView.d(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        NoDataView noDataView = this.n;
        if (noDataView != null) {
            noDataView.e();
        }
    }

    public final void p1() {
        HashSet hashSet = new HashSet();
        Iterator<ForumData> it = this.E.iterator();
        while (it.hasNext()) {
            if (!hashSet.add(it.next().getId())) {
                it.remove();
            }
        }
    }

    public void q1(d.a.n0.i2.b bVar, boolean z) {
        if (bVar == null) {
            return;
        }
        this.s = bVar.m();
        if (!z) {
            this.f19800g.A(0L);
        }
        int likeBarCount = l1().getLikeBarCount();
        if (this.l == null || this.f19802i == null) {
            return;
        }
        if (this.z == l1().getCurrentPageType()) {
            if (z) {
                this.q = 1;
                this.l.w().r(bVar.l(), bVar.j());
                this.l.w().p(bVar.h(), bVar.f());
                this.l.w().t(bVar.k());
                this.l.w().q(bVar.g());
            } else if (this.q == 1) {
                this.l.w().r(bVar.l(), bVar.j());
                this.l.w().p(bVar.h(), bVar.f());
                this.l.w().t(bVar.k());
                this.l.w().q(bVar.g());
                this.q++;
            } else {
                this.l.w().c(bVar.l(), bVar.j());
                this.l.w().a(bVar.h(), bVar.f());
                this.l.w().d(bVar.k());
                this.l.w().b(bVar.g());
                this.q++;
            }
        }
        if (this.z == 0) {
            this.f19802i.g(this.l.w().i());
        } else {
            this.f19802i.g(this.l.w().e());
        }
        int size = bVar.e() != null ? this.l.w().e().size() : 0;
        if (l1() != null) {
            l1().updateTabTitle(likeBarCount, size);
        }
        i1(true);
        this.f19802i.notifyDataSetChanged();
    }
}
