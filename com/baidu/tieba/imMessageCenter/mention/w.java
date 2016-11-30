package com.baidu.tieba.imMessageCenter.mention;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.view.z;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public abstract class w extends com.baidu.adp.base.f<bf> implements z.b, com.baidu.tbadk.mvc.f.a.a {
    protected View aBq;
    protected View aha;
    protected BdListView bgv;
    private com.baidu.tbadk.mvc.h.a bgx;
    protected bf dzh;
    private boolean dzv;
    private boolean dzw;
    protected int dzx;
    protected com.baidu.tbadk.core.view.ac mPullView;
    private int mSkinType;

    public w(bf bfVar) {
        super(com.baidu.adp.base.l.C(bfVar.getPageContext().getPageActivity()));
        this.dzv = true;
        this.dzw = false;
        this.dzh = bfVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.bgx != null) {
                if (aVar.Fp()) {
                    this.bgx.lz();
                    if (aVar.Fn()) {
                        this.bgx.eZ(r.j.loading);
                    } else if (aVar.Fo()) {
                        this.bgx.eZ(r.j.loading);
                    } else {
                        this.bgx.fa(r.j.no_more_msg);
                    }
                } else {
                    this.bgx.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                aBn();
            } else {
                aBo();
            }
        }
    }

    public void aBn() {
        if (this.mPullView != null) {
            this.mPullView.a((z.b) null);
        }
        if (this.bgv != null) {
            this.bgv.kv();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this);
        }
    }

    public void aBo() {
        if (this.bgv != null) {
            this.bgv.l(2000L);
        }
    }

    @Override // com.baidu.tbadk.core.view.z.b
    public void aL(boolean z) {
        if (this instanceof k) {
            this.dzh.aBI().cA(z);
        } else if (this instanceof j) {
            this.dzh.aBH().cA(z);
        } else {
            this.dzh.aBG().cA(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        aBo();
        if (this.bgx != null) {
            this.bgx.fa(r.j.no_more_msg);
        }
    }

    protected View me() {
        this.aBq = this.dzh.getActivity().getLayoutInflater().inflate(r.h.mvc_template_list, (ViewGroup) null);
        this.bgv = (BdListView) this.dzh.getActivity().findViewById(r.g.view_list);
        return this.aBq;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void lT() {
        this.mPullView = new com.baidu.tbadk.core.view.ac(this.dzh.getPageContext());
        this.mPullView.setTag(this.dzh.getUniqueId());
        this.mPullView.a(this);
        this.bgx = new com.baidu.tbadk.mvc.h.a(this.dzh.getBaseFragmentActivity());
        this.bgx.kk();
        if (this.bgv != null) {
            this.bgv.setDividerHeight(0);
            this.bgv.setExOnSrollToBottomListener(new x(this));
            this.bgv.setPullRefresh(this.mPullView);
            this.bgv.setNextPage(this.bgx);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aBp() {
        if (this.bgv != null) {
            this.aha = BdListViewHelper.a(this.dzh.getActivity(), this.bgv, BdListViewHelper.HeadType.HASTAB);
            if (this.dzx > 0) {
                mA(this.dzx);
            }
        }
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        com.baidu.tbadk.i.a.a(tbPageContext, getView());
        if (this.bgx != null) {
            this.bgx.a(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.di(i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(Bundle bundle) {
    }

    public void onPrimary() {
        if (this.dzv || this.dzw) {
            this.dzv = false;
            this.dzw = false;
            if (this instanceof k) {
                this.dzh.aBI().cA(false);
            } else if (this instanceof j) {
                this.dzh.aBH().lV();
            } else {
                this.dzh.aBG().lV();
            }
        }
    }

    public void bS(boolean z) {
        if (z && this.bgv != null && this.bgv.getWrappedAdapter() != null && this.bgv.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.h.h.eG().post(new y(this));
        }
    }

    public void Fs() {
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public void Ft() {
    }

    public void gR(boolean z) {
        this.dzw = z;
    }

    public void gS(boolean z) {
        this.dzv = z;
    }

    public View getView() {
        return this.aBq;
    }

    public void mA(int i) {
        ViewGroup.LayoutParams layoutParams;
        this.dzx = i;
        if (this.aha != null && (layoutParams = this.aha.getLayoutParams()) != null && layoutParams.height != i) {
            layoutParams.height = i;
            this.aha.setLayoutParams(layoutParams);
        }
    }
}
