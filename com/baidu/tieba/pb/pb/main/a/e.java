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
    private PbFragment iDY;
    private h iRn;
    private g iRo;
    private boolean iRp = false;

    public e(PbFragment pbFragment) {
        this.iDY = pbFragment;
    }

    public void a(com.baidu.tieba.pb.data.e eVar, PostData postData, BdTypeListView bdTypeListView, d dVar, FrameLayout frameLayout, com.baidu.tieba.pb.pb.main.view.c cVar, String str, long j) {
        if (eVar != null && eVar.aHK()) {
            if (this.iRn == null) {
                this.iRn = new h(this.iDY, cVar, eVar.cku().aCF(), j);
                this.iRn.a(eVar.cku().aCF(), eVar.cku(), eVar.getForumId());
                this.iRn.startPlay();
            } else if (this.iRp) {
                this.iRn.a(eVar.cku().aCF(), eVar.cku(), eVar.getForumId());
                this.iRn.startPlay();
            } else {
                this.iRn.Gv(eVar.getForumId());
            }
            com.baidu.tieba.pb.c.a.a(this.iDY.getUniqueId(), eVar, postData, 1, 1);
            if (eVar.ckv() != null && eVar.ckv().size() >= 1) {
                bj bjVar = eVar.ckv().get(0);
                this.iRn.aK(bjVar);
                this.iRn.Gw(bjVar.getTitle());
            }
            this.iRn.b(postData, eVar.cku(), eVar.ckP());
            this.iRp = false;
            bdTypeListView.removeHeaderView(this.iRn.css());
            bdTypeListView.addHeaderView(this.iRn.css(), 0);
            if (this.iRn.bcK() != null && this.iRn.bcK().getParent() == null) {
                frameLayout.addView(this.iRn.bcK());
            }
            if (this.iRo == null) {
                this.iRo = new g(this.iDY.getBaseFragmentActivity());
            }
            this.iRo.b(eVar, str);
            bdTypeListView.removeHeaderView(this.iRo.csl());
            bdTypeListView.addHeaderView(this.iRo.csl(), 1);
            dVar.c(bdTypeListView);
            dVar.a(bdTypeListView, 2);
            if (this.iRn != null) {
                cVar.qD(false);
                this.iRn.zh(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            if (this.iRn != null) {
                bdTypeListView.removeHeaderView(this.iRn.css());
            }
            if (this.iRo != null) {
                this.iRo.e(bdTypeListView);
            }
        }
    }

    public void qu(boolean z) {
        this.iRp = z;
    }

    public void R(View.OnClickListener onClickListener) {
        if (this.iRn != null) {
            this.iRn.R(onClickListener);
        }
    }

    public void d(BdTypeListView bdTypeListView) {
        if (this.iRn != null) {
            TiebaStatic.log(new an("c11997").X("obj_type", 1));
            this.iRn.cqK();
            bdTypeListView.smoothScrollToPosition(0);
        }
    }

    public boolean zg(int i) {
        if (this.iRn != null) {
            return this.iRn.tf(i);
        }
        return false;
    }

    public void a(PbLandscapeListView pbLandscapeListView, TextView textView, int i) {
        if (pbLandscapeListView != null) {
            if (this.iRn != null && this.iRn.bcK() != null) {
                if (textView != null) {
                    pbLandscapeListView.removeHeaderView(textView);
                    pbLandscapeListView.setTextViewAdded(false);
                }
                if (i != 1) {
                    pbLandscapeListView.removeHeaderView(this.iRn.css());
                    pbLandscapeListView.addHeaderView(this.iRn.css(), 0);
                    return;
                }
                return;
            }
            if (this.iRn != null) {
                pbLandscapeListView.removeHeaderView(this.iRn.css());
            }
            if (textView != null) {
                pbLandscapeListView.removeHeaderView(textView);
                pbLandscapeListView.addHeaderView(textView, 0);
            }
        }
    }

    public boolean cqr() {
        return this.iRn != null && this.iRn.cqr();
    }

    public void cqs() {
        if (this.iRn != null) {
            this.iRn.onPause();
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.iRn != null) {
            this.iRn.c(absListView, i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.iRn != null) {
            this.iRn.onScrollStateChanged(absListView, i);
        }
    }

    public void qs(boolean z) {
        if (this.iRn != null) {
            this.iRn.qs(z);
        }
    }

    public void cqK() {
        if (this.iRn != null) {
            this.iRn.cqK();
        }
    }

    public void destroy() {
        if (this.iRn != null) {
            this.iRn.destroy();
        }
    }

    public void onPause() {
        if (this.iRn != null) {
            this.iRn.onPause();
        }
    }

    public void onResume() {
        if (this.iRn != null) {
            this.iRn.onResume();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.iRn != null) {
            this.iRn.onConfigurationChanged(configuration);
        }
    }

    public void zh(int i) {
        if (this.iRn != null) {
            this.iRn.zh(i);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iRo != null) {
            this.iRo.onChangeSkinType(i);
        }
    }

    public View bcK() {
        if (this.iRn != null) {
            return this.iRn.bcK();
        }
        return null;
    }

    public int cqL() {
        View bcK = bcK();
        if (bcK != null) {
            return bcK.getHeight();
        }
        return 0;
    }

    public int cqM() {
        if (this.iRn != null) {
            return this.iRn.cqM();
        }
        return 0;
    }

    public boolean bim() {
        if (this.iRn != null) {
            return this.iRn.bim();
        }
        return false;
    }
}
