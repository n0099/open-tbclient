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
    private h jDj;
    private g jDk;
    private boolean jDl = false;
    private PbFragment jpS;

    public e(PbFragment pbFragment) {
        this.jpS = pbFragment;
    }

    public void a(com.baidu.tieba.pb.data.e eVar, PostData postData, BdTypeListView bdTypeListView, d dVar, FrameLayout frameLayout, com.baidu.tieba.pb.pb.main.view.c cVar, String str, long j) {
        if (eVar != null && eVar.aQh()) {
            if (this.jDj == null) {
                this.jDj = new h(this.jpS, cVar, eVar.cvu().aKV(), j);
                this.jDj.a(eVar.cvu().aKV(), eVar.cvu(), eVar.getForumId());
                this.jDj.startPlay();
            } else if (this.jDl) {
                this.jDj.a(eVar.cvu().aKV(), eVar.cvu(), eVar.getForumId());
                this.jDj.startPlay();
            } else {
                this.jDj.Id(eVar.getForumId());
            }
            com.baidu.tieba.pb.c.a.a(this.jpS.getUniqueId(), eVar, postData, 1, 1);
            if (eVar.cvv() != null && eVar.cvv().size() >= 1) {
                bj bjVar = eVar.cvv().get(0);
                this.jDj.aM(bjVar);
                this.jDj.Ie(bjVar.getTitle());
            }
            this.jDj.b(postData, eVar.cvu(), eVar.cvP());
            this.jDl = false;
            bdTypeListView.removeHeaderView(this.jDj.cDu());
            bdTypeListView.addHeaderView(this.jDj.cDu(), 0);
            if (this.jDj.blG() != null && this.jDj.blG().getParent() == null) {
                frameLayout.addView(this.jDj.blG());
            }
            if (this.jDk == null) {
                this.jDk = new g(this.jpS.getBaseFragmentActivity());
            }
            this.jDk.b(eVar, str);
            bdTypeListView.removeHeaderView(this.jDk.cDn());
            bdTypeListView.addHeaderView(this.jDk.cDn(), 1);
            dVar.c(bdTypeListView);
            dVar.a(bdTypeListView, 2);
            if (this.jDj != null) {
                cVar.rN(false);
                this.jDj.zQ(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            if (this.jDj != null) {
                bdTypeListView.removeHeaderView(this.jDj.cDu());
            }
            if (this.jDk != null) {
                this.jDk.e(bdTypeListView);
            }
        }
    }

    public void rE(boolean z) {
        this.jDl = z;
    }

    public void S(View.OnClickListener onClickListener) {
        if (this.jDj != null) {
            this.jDj.S(onClickListener);
        }
    }

    public void d(BdTypeListView bdTypeListView) {
        if (this.jDj != null) {
            TiebaStatic.log(new an("c11997").af("obj_type", 1));
            this.jDj.cBM();
            bdTypeListView.smoothScrollToPosition(0);
        }
    }

    public boolean zP(int i) {
        if (this.jDj != null) {
            return this.jDj.tF(i);
        }
        return false;
    }

    public void a(PbLandscapeListView pbLandscapeListView, TextView textView, int i) {
        if (pbLandscapeListView != null) {
            if (this.jDj != null && this.jDj.blG() != null) {
                if (textView != null) {
                    pbLandscapeListView.removeHeaderView(textView);
                    pbLandscapeListView.setTextViewAdded(false);
                }
                if (i != 1) {
                    pbLandscapeListView.removeHeaderView(this.jDj.cDu());
                    pbLandscapeListView.addHeaderView(this.jDj.cDu(), 0);
                    return;
                }
                return;
            }
            if (this.jDj != null) {
                pbLandscapeListView.removeHeaderView(this.jDj.cDu());
            }
            if (textView != null) {
                pbLandscapeListView.removeHeaderView(textView);
                pbLandscapeListView.addHeaderView(textView, 0);
            }
        }
    }

    public boolean cBt() {
        return this.jDj != null && this.jDj.cBt();
    }

    public void cBu() {
        if (this.jDj != null) {
            this.jDj.onPause();
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.jDj != null) {
            this.jDj.c(absListView, i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.jDj != null) {
            this.jDj.onScrollStateChanged(absListView, i);
        }
    }

    public void rC(boolean z) {
        if (this.jDj != null) {
            this.jDj.rC(z);
        }
    }

    public void cBM() {
        if (this.jDj != null) {
            this.jDj.cBM();
        }
    }

    public void destroy() {
        if (this.jDj != null) {
            this.jDj.destroy();
        }
    }

    public void onPause() {
        if (this.jDj != null) {
            this.jDj.onPause();
        }
    }

    public void onResume() {
        if (this.jDj != null) {
            this.jDj.onResume();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.jDj != null) {
            this.jDj.onConfigurationChanged(configuration);
        }
    }

    public void zQ(int i) {
        if (this.jDj != null) {
            this.jDj.zQ(i);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jDk != null) {
            this.jDk.onChangeSkinType(i);
        }
    }

    public View blG() {
        if (this.jDj != null) {
            return this.jDj.blG();
        }
        return null;
    }

    public int cBN() {
        View blG = blG();
        if (blG != null) {
            return blG.getHeight();
        }
        return 0;
    }

    public int cBO() {
        if (this.jDj != null) {
            return this.jDj.cBO();
        }
        return 0;
    }

    public boolean brK() {
        if (this.jDj != null) {
            return this.jDj.brK();
        }
        return false;
    }
}
