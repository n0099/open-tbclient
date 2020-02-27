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
    private PbFragment iDW;
    private h iRl;
    private g iRm;
    private boolean iRn = false;

    public e(PbFragment pbFragment) {
        this.iDW = pbFragment;
    }

    public void a(com.baidu.tieba.pb.data.e eVar, PostData postData, BdTypeListView bdTypeListView, d dVar, FrameLayout frameLayout, com.baidu.tieba.pb.pb.main.view.c cVar, String str, long j) {
        if (eVar != null && eVar.aHI()) {
            if (this.iRl == null) {
                this.iRl = new h(this.iDW, cVar, eVar.cks().aCD(), j);
                this.iRl.a(eVar.cks().aCD(), eVar.cks(), eVar.getForumId());
                this.iRl.startPlay();
            } else if (this.iRn) {
                this.iRl.a(eVar.cks().aCD(), eVar.cks(), eVar.getForumId());
                this.iRl.startPlay();
            } else {
                this.iRl.Gv(eVar.getForumId());
            }
            com.baidu.tieba.pb.c.a.a(this.iDW.getUniqueId(), eVar, postData, 1, 1);
            if (eVar.ckt() != null && eVar.ckt().size() >= 1) {
                bj bjVar = eVar.ckt().get(0);
                this.iRl.aK(bjVar);
                this.iRl.Gw(bjVar.getTitle());
            }
            this.iRl.b(postData, eVar.cks(), eVar.ckN());
            this.iRn = false;
            bdTypeListView.removeHeaderView(this.iRl.csq());
            bdTypeListView.addHeaderView(this.iRl.csq(), 0);
            if (this.iRl.bcI() != null && this.iRl.bcI().getParent() == null) {
                frameLayout.addView(this.iRl.bcI());
            }
            if (this.iRm == null) {
                this.iRm = new g(this.iDW.getBaseFragmentActivity());
            }
            this.iRm.b(eVar, str);
            bdTypeListView.removeHeaderView(this.iRm.csj());
            bdTypeListView.addHeaderView(this.iRm.csj(), 1);
            dVar.c(bdTypeListView);
            dVar.a(bdTypeListView, 2);
            if (this.iRl != null) {
                cVar.qD(false);
                this.iRl.zh(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            if (this.iRl != null) {
                bdTypeListView.removeHeaderView(this.iRl.csq());
            }
            if (this.iRm != null) {
                this.iRm.e(bdTypeListView);
            }
        }
    }

    public void qu(boolean z) {
        this.iRn = z;
    }

    public void R(View.OnClickListener onClickListener) {
        if (this.iRl != null) {
            this.iRl.R(onClickListener);
        }
    }

    public void d(BdTypeListView bdTypeListView) {
        if (this.iRl != null) {
            TiebaStatic.log(new an("c11997").X("obj_type", 1));
            this.iRl.cqI();
            bdTypeListView.smoothScrollToPosition(0);
        }
    }

    public boolean zg(int i) {
        if (this.iRl != null) {
            return this.iRl.tf(i);
        }
        return false;
    }

    public void a(PbLandscapeListView pbLandscapeListView, TextView textView, int i) {
        if (pbLandscapeListView != null) {
            if (this.iRl != null && this.iRl.bcI() != null) {
                if (textView != null) {
                    pbLandscapeListView.removeHeaderView(textView);
                    pbLandscapeListView.setTextViewAdded(false);
                }
                if (i != 1) {
                    pbLandscapeListView.removeHeaderView(this.iRl.csq());
                    pbLandscapeListView.addHeaderView(this.iRl.csq(), 0);
                    return;
                }
                return;
            }
            if (this.iRl != null) {
                pbLandscapeListView.removeHeaderView(this.iRl.csq());
            }
            if (textView != null) {
                pbLandscapeListView.removeHeaderView(textView);
                pbLandscapeListView.addHeaderView(textView, 0);
            }
        }
    }

    public boolean cqp() {
        return this.iRl != null && this.iRl.cqp();
    }

    public void cqq() {
        if (this.iRl != null) {
            this.iRl.onPause();
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.iRl != null) {
            this.iRl.c(absListView, i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.iRl != null) {
            this.iRl.onScrollStateChanged(absListView, i);
        }
    }

    public void qs(boolean z) {
        if (this.iRl != null) {
            this.iRl.qs(z);
        }
    }

    public void cqI() {
        if (this.iRl != null) {
            this.iRl.cqI();
        }
    }

    public void destroy() {
        if (this.iRl != null) {
            this.iRl.destroy();
        }
    }

    public void onPause() {
        if (this.iRl != null) {
            this.iRl.onPause();
        }
    }

    public void onResume() {
        if (this.iRl != null) {
            this.iRl.onResume();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.iRl != null) {
            this.iRl.onConfigurationChanged(configuration);
        }
    }

    public void zh(int i) {
        if (this.iRl != null) {
            this.iRl.zh(i);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iRm != null) {
            this.iRm.onChangeSkinType(i);
        }
    }

    public View bcI() {
        if (this.iRl != null) {
            return this.iRl.bcI();
        }
        return null;
    }

    public int cqJ() {
        View bcI = bcI();
        if (bcI != null) {
            return bcI.getHeight();
        }
        return 0;
    }

    public int cqK() {
        if (this.iRl != null) {
            return this.iRl.cqK();
        }
        return 0;
    }

    public boolean bik() {
        if (this.iRl != null) {
            return this.iRl.bik();
        }
        return false;
    }
}
