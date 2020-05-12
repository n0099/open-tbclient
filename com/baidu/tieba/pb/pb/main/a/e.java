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
    private h jDn;
    private g jDo;
    private boolean jDp = false;
    private PbFragment jpW;

    public e(PbFragment pbFragment) {
        this.jpW = pbFragment;
    }

    public void a(com.baidu.tieba.pb.data.e eVar, PostData postData, BdTypeListView bdTypeListView, d dVar, FrameLayout frameLayout, com.baidu.tieba.pb.pb.main.view.c cVar, String str, long j) {
        if (eVar != null && eVar.aQe()) {
            if (this.jDn == null) {
                this.jDn = new h(this.jpW, cVar, eVar.cvs().aKT(), j);
                this.jDn.a(eVar.cvs().aKT(), eVar.cvs(), eVar.getForumId());
                this.jDn.startPlay();
            } else if (this.jDp) {
                this.jDn.a(eVar.cvs().aKT(), eVar.cvs(), eVar.getForumId());
                this.jDn.startPlay();
            } else {
                this.jDn.Ig(eVar.getForumId());
            }
            com.baidu.tieba.pb.c.a.a(this.jpW.getUniqueId(), eVar, postData, 1, 1);
            if (eVar.cvt() != null && eVar.cvt().size() >= 1) {
                bj bjVar = eVar.cvt().get(0);
                this.jDn.aM(bjVar);
                this.jDn.Ih(bjVar.getTitle());
            }
            this.jDn.b(postData, eVar.cvs(), eVar.cvN());
            this.jDp = false;
            bdTypeListView.removeHeaderView(this.jDn.cDs());
            bdTypeListView.addHeaderView(this.jDn.cDs(), 0);
            if (this.jDn.blE() != null && this.jDn.blE().getParent() == null) {
                frameLayout.addView(this.jDn.blE());
            }
            if (this.jDo == null) {
                this.jDo = new g(this.jpW.getBaseFragmentActivity());
            }
            this.jDo.b(eVar, str);
            bdTypeListView.removeHeaderView(this.jDo.cDl());
            bdTypeListView.addHeaderView(this.jDo.cDl(), 1);
            dVar.c(bdTypeListView);
            dVar.a(bdTypeListView, 2);
            if (this.jDn != null) {
                cVar.rN(false);
                this.jDn.zQ(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            if (this.jDn != null) {
                bdTypeListView.removeHeaderView(this.jDn.cDs());
            }
            if (this.jDo != null) {
                this.jDo.e(bdTypeListView);
            }
        }
    }

    public void rE(boolean z) {
        this.jDp = z;
    }

    public void S(View.OnClickListener onClickListener) {
        if (this.jDn != null) {
            this.jDn.S(onClickListener);
        }
    }

    public void d(BdTypeListView bdTypeListView) {
        if (this.jDn != null) {
            TiebaStatic.log(new an("c11997").af("obj_type", 1));
            this.jDn.cBK();
            bdTypeListView.smoothScrollToPosition(0);
        }
    }

    public boolean zP(int i) {
        if (this.jDn != null) {
            return this.jDn.tF(i);
        }
        return false;
    }

    public void a(PbLandscapeListView pbLandscapeListView, TextView textView, int i) {
        if (pbLandscapeListView != null) {
            if (this.jDn != null && this.jDn.blE() != null) {
                if (textView != null) {
                    pbLandscapeListView.removeHeaderView(textView);
                    pbLandscapeListView.setTextViewAdded(false);
                }
                if (i != 1) {
                    pbLandscapeListView.removeHeaderView(this.jDn.cDs());
                    pbLandscapeListView.addHeaderView(this.jDn.cDs(), 0);
                    return;
                }
                return;
            }
            if (this.jDn != null) {
                pbLandscapeListView.removeHeaderView(this.jDn.cDs());
            }
            if (textView != null) {
                pbLandscapeListView.removeHeaderView(textView);
                pbLandscapeListView.addHeaderView(textView, 0);
            }
        }
    }

    public boolean cBr() {
        return this.jDn != null && this.jDn.cBr();
    }

    public void cBs() {
        if (this.jDn != null) {
            this.jDn.onPause();
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.jDn != null) {
            this.jDn.c(absListView, i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.jDn != null) {
            this.jDn.onScrollStateChanged(absListView, i);
        }
    }

    public void rC(boolean z) {
        if (this.jDn != null) {
            this.jDn.rC(z);
        }
    }

    public void cBK() {
        if (this.jDn != null) {
            this.jDn.cBK();
        }
    }

    public void destroy() {
        if (this.jDn != null) {
            this.jDn.destroy();
        }
    }

    public void onPause() {
        if (this.jDn != null) {
            this.jDn.onPause();
        }
    }

    public void onResume() {
        if (this.jDn != null) {
            this.jDn.onResume();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.jDn != null) {
            this.jDn.onConfigurationChanged(configuration);
        }
    }

    public void zQ(int i) {
        if (this.jDn != null) {
            this.jDn.zQ(i);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jDo != null) {
            this.jDo.onChangeSkinType(i);
        }
    }

    public View blE() {
        if (this.jDn != null) {
            return this.jDn.blE();
        }
        return null;
    }

    public int cBL() {
        View blE = blE();
        if (blE != null) {
            return blE.getHeight();
        }
        return 0;
    }

    public int cBM() {
        if (this.jDn != null) {
            return this.jDn.cBM();
        }
        return 0;
    }

    public boolean brI() {
        if (this.jDn != null) {
            return this.jDn.brI();
        }
        return false;
    }
}
