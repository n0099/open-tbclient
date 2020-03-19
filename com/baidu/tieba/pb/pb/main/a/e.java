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
    private PbFragment iFL;
    private h iTa;
    private g iTb;
    private boolean iTc = false;

    public e(PbFragment pbFragment) {
        this.iFL = pbFragment;
    }

    public void a(com.baidu.tieba.pb.data.e eVar, PostData postData, BdTypeListView bdTypeListView, d dVar, FrameLayout frameLayout, com.baidu.tieba.pb.pb.main.view.c cVar, String str, long j) {
        if (eVar != null && eVar.aHP()) {
            if (this.iTa == null) {
                this.iTa = new h(this.iFL, cVar, eVar.ckP().aCI(), j);
                this.iTa.a(eVar.ckP().aCI(), eVar.ckP(), eVar.getForumId());
                this.iTa.startPlay();
            } else if (this.iTc) {
                this.iTa.a(eVar.ckP().aCI(), eVar.ckP(), eVar.getForumId());
                this.iTa.startPlay();
            } else {
                this.iTa.Gw(eVar.getForumId());
            }
            com.baidu.tieba.pb.c.a.a(this.iFL.getUniqueId(), eVar, postData, 1, 1);
            if (eVar.ckQ() != null && eVar.ckQ().size() >= 1) {
                bj bjVar = eVar.ckQ().get(0);
                this.iTa.aL(bjVar);
                this.iTa.Gx(bjVar.getTitle());
            }
            this.iTa.b(postData, eVar.ckP(), eVar.clk());
            this.iTc = false;
            bdTypeListView.removeHeaderView(this.iTa.csO());
            bdTypeListView.addHeaderView(this.iTa.csO(), 0);
            if (this.iTa.bcP() != null && this.iTa.bcP().getParent() == null) {
                frameLayout.addView(this.iTa.bcP());
            }
            if (this.iTb == null) {
                this.iTb = new g(this.iFL.getBaseFragmentActivity());
            }
            this.iTb.b(eVar, str);
            bdTypeListView.removeHeaderView(this.iTb.csH());
            bdTypeListView.addHeaderView(this.iTb.csH(), 1);
            dVar.c(bdTypeListView);
            dVar.a(bdTypeListView, 2);
            if (this.iTa != null) {
                cVar.qJ(false);
                this.iTa.zp(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            if (this.iTa != null) {
                bdTypeListView.removeHeaderView(this.iTa.csO());
            }
            if (this.iTb != null) {
                this.iTb.e(bdTypeListView);
            }
        }
    }

    public void qA(boolean z) {
        this.iTc = z;
    }

    public void R(View.OnClickListener onClickListener) {
        if (this.iTa != null) {
            this.iTa.R(onClickListener);
        }
    }

    public void d(BdTypeListView bdTypeListView) {
        if (this.iTa != null) {
            TiebaStatic.log(new an("c11997").X("obj_type", 1));
            this.iTa.crg();
            bdTypeListView.smoothScrollToPosition(0);
        }
    }

    public boolean zo(int i) {
        if (this.iTa != null) {
            return this.iTa.th(i);
        }
        return false;
    }

    public void a(PbLandscapeListView pbLandscapeListView, TextView textView, int i) {
        if (pbLandscapeListView != null) {
            if (this.iTa != null && this.iTa.bcP() != null) {
                if (textView != null) {
                    pbLandscapeListView.removeHeaderView(textView);
                    pbLandscapeListView.setTextViewAdded(false);
                }
                if (i != 1) {
                    pbLandscapeListView.removeHeaderView(this.iTa.csO());
                    pbLandscapeListView.addHeaderView(this.iTa.csO(), 0);
                    return;
                }
                return;
            }
            if (this.iTa != null) {
                pbLandscapeListView.removeHeaderView(this.iTa.csO());
            }
            if (textView != null) {
                pbLandscapeListView.removeHeaderView(textView);
                pbLandscapeListView.addHeaderView(textView, 0);
            }
        }
    }

    public boolean cqN() {
        return this.iTa != null && this.iTa.cqN();
    }

    public void cqO() {
        if (this.iTa != null) {
            this.iTa.onPause();
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.iTa != null) {
            this.iTa.c(absListView, i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.iTa != null) {
            this.iTa.onScrollStateChanged(absListView, i);
        }
    }

    public void qy(boolean z) {
        if (this.iTa != null) {
            this.iTa.qy(z);
        }
    }

    public void crg() {
        if (this.iTa != null) {
            this.iTa.crg();
        }
    }

    public void destroy() {
        if (this.iTa != null) {
            this.iTa.destroy();
        }
    }

    public void onPause() {
        if (this.iTa != null) {
            this.iTa.onPause();
        }
    }

    public void onResume() {
        if (this.iTa != null) {
            this.iTa.onResume();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.iTa != null) {
            this.iTa.onConfigurationChanged(configuration);
        }
    }

    public void zp(int i) {
        if (this.iTa != null) {
            this.iTa.zp(i);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iTb != null) {
            this.iTb.onChangeSkinType(i);
        }
    }

    public View bcP() {
        if (this.iTa != null) {
            return this.iTa.bcP();
        }
        return null;
    }

    public int crh() {
        View bcP = bcP();
        if (bcP != null) {
            return bcP.getHeight();
        }
        return 0;
    }

    public int cri() {
        if (this.iTa != null) {
            return this.iTa.cri();
        }
        return 0;
    }

    public boolean bis() {
        if (this.iTa != null) {
            return this.iTa.bis();
        }
        return false;
    }
}
