package com.baidu.tieba.pb.pb.main.a;

import android.content.res.Configuration;
import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
import com.baidu.tieba.pb.video.g;
import com.baidu.tieba.pb.video.h;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes9.dex */
public class e {
    private PbFragment iEk;
    private g iRA;
    private boolean iRB = false;
    private h iRz;

    public e(PbFragment pbFragment) {
        this.iEk = pbFragment;
    }

    public void a(com.baidu.tieba.pb.data.e eVar, PostData postData, BdTypeListView bdTypeListView, d dVar, FrameLayout frameLayout, com.baidu.tieba.pb.pb.main.view.c cVar, String str, long j) {
        if (eVar != null && eVar.aHL()) {
            if (this.iRz == null) {
                this.iRz = new h(this.iEk, cVar, eVar.ckv().aCF(), j);
                this.iRz.a(eVar.ckv().aCF(), eVar.ckv(), eVar.getForumId());
                this.iRz.startPlay();
            } else if (this.iRB) {
                this.iRz.a(eVar.ckv().aCF(), eVar.ckv(), eVar.getForumId());
                this.iRz.startPlay();
            } else {
                this.iRz.Gw(eVar.getForumId());
            }
            com.baidu.tieba.pb.c.a.a(this.iEk.getUniqueId(), eVar, postData, 1, 1);
            if (eVar.ckw() != null && eVar.ckw().size() >= 1) {
                bj bjVar = eVar.ckw().get(0);
                this.iRz.aK(bjVar);
                this.iRz.Gx(bjVar.getTitle());
            }
            this.iRz.b(postData, eVar.ckv(), eVar.ckQ());
            this.iRB = false;
            bdTypeListView.removeHeaderView(this.iRz.cst());
            bdTypeListView.addHeaderView(this.iRz.cst(), 0);
            if (this.iRz.bcL() != null && this.iRz.bcL().getParent() == null) {
                frameLayout.addView(this.iRz.bcL());
            }
            if (this.iRA == null) {
                this.iRA = new g(this.iEk.getBaseFragmentActivity());
            }
            this.iRA.b(eVar, str);
            bdTypeListView.removeHeaderView(this.iRA.csm());
            bdTypeListView.addHeaderView(this.iRA.csm(), 1);
            dVar.c(bdTypeListView);
            dVar.a(bdTypeListView, 2);
            if (this.iRz != null) {
                cVar.qD(false);
                this.iRz.zh(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            if (this.iRz != null) {
                bdTypeListView.removeHeaderView(this.iRz.cst());
            }
            if (this.iRA != null) {
                this.iRA.e(bdTypeListView);
            }
        }
    }

    public void qu(boolean z) {
        this.iRB = z;
    }

    public void R(View.OnClickListener onClickListener) {
        if (this.iRz != null) {
            this.iRz.R(onClickListener);
        }
    }

    public void d(BdTypeListView bdTypeListView) {
        if (this.iRz != null) {
            TiebaStatic.log(new an("c11997").X("obj_type", 1));
            this.iRz.cqL();
            bdTypeListView.smoothScrollToPosition(0);
        }
    }

    public boolean zg(int i) {
        if (this.iRz != null) {
            return this.iRz.tf(i);
        }
        return false;
    }

    public void a(PbLandscapeListView pbLandscapeListView, TextView textView, int i) {
        if (pbLandscapeListView != null) {
            if (this.iRz != null && this.iRz.bcL() != null) {
                if (textView != null) {
                    pbLandscapeListView.removeHeaderView(textView);
                    pbLandscapeListView.setTextViewAdded(false);
                }
                if (i != 1) {
                    pbLandscapeListView.removeHeaderView(this.iRz.cst());
                    pbLandscapeListView.addHeaderView(this.iRz.cst(), 0);
                    return;
                }
                return;
            }
            if (this.iRz != null) {
                pbLandscapeListView.removeHeaderView(this.iRz.cst());
            }
            if (textView != null) {
                pbLandscapeListView.removeHeaderView(textView);
                pbLandscapeListView.addHeaderView(textView, 0);
            }
        }
    }

    public boolean cqs() {
        return this.iRz != null && this.iRz.cqs();
    }

    public void cqt() {
        if (this.iRz != null) {
            this.iRz.onPause();
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.iRz != null) {
            this.iRz.c(absListView, i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.iRz != null) {
            this.iRz.onScrollStateChanged(absListView, i);
        }
    }

    public void qs(boolean z) {
        if (this.iRz != null) {
            this.iRz.qs(z);
        }
    }

    public void cqL() {
        if (this.iRz != null) {
            this.iRz.cqL();
        }
    }

    public void destroy() {
        if (this.iRz != null) {
            this.iRz.destroy();
        }
    }

    public void onPause() {
        if (this.iRz != null) {
            this.iRz.onPause();
        }
    }

    public void onResume() {
        if (this.iRz != null) {
            this.iRz.onResume();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.iRz != null) {
            this.iRz.onConfigurationChanged(configuration);
        }
    }

    public void zh(int i) {
        if (this.iRz != null) {
            this.iRz.zh(i);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iRA != null) {
            this.iRA.onChangeSkinType(i);
        }
    }

    public View bcL() {
        if (this.iRz != null) {
            return this.iRz.bcL();
        }
        return null;
    }

    public int cqM() {
        View bcL = bcL();
        if (bcL != null) {
            return bcL.getHeight();
        }
        return 0;
    }

    public int cqN() {
        if (this.iRz != null) {
            return this.iRz.cqN();
        }
        return 0;
    }

    public boolean bin() {
        if (this.iRz != null) {
            return this.iRz.bin();
        }
        return false;
    }
}
