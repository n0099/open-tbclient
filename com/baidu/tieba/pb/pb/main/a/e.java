package com.baidu.tieba.pb.pb.main.a;

import android.content.res.Configuration;
import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
import com.baidu.tieba.pb.video.g;
import com.baidu.tieba.pb.video.h;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes16.dex */
public class e {
    private PbFragment kkb;
    private h kyI;
    private g kyJ;
    private boolean kyK = false;

    public e(PbFragment pbFragment) {
        this.kkb = pbFragment;
    }

    public void a(f fVar, PostData postData, BdTypeListView bdTypeListView, d dVar, FrameLayout frameLayout, com.baidu.tieba.pb.pb.main.view.c cVar, String str, long j) {
        if (fVar != null && fVar.cKX()) {
            if (this.kyI == null) {
                this.kyI = new h(this.kkb, cVar, fVar.cKx().aWD(), j);
                this.kyI.a(fVar.cKx().aWD(), fVar.cKx(), fVar.getForumId());
                this.kyI.startPlay();
            } else if (this.kyK) {
                this.kyI.a(fVar.cKx().aWD(), fVar.cKx(), fVar.getForumId());
                this.kyI.startPlay();
            } else {
                this.kyI.Lj(fVar.getForumId());
            }
            com.baidu.tieba.pb.c.a.a(this.kkb.getUniqueId(), fVar, postData, 1, 1);
            if (fVar.cKy() != null && fVar.cKy().size() >= 1) {
                bv bvVar = fVar.cKy().get(0);
                this.kyI.aK(bvVar);
                this.kyI.Lk(bvVar.getTitle());
            }
            this.kyI.b(postData, fVar.cKx(), fVar.cKW());
            this.kyK = false;
            bdTypeListView.removeHeaderView(this.kyI.cSL());
            bdTypeListView.addHeaderView(this.kyI.cSL(), 0);
            if (this.kyI.bxk() != null && this.kyI.bxk().getParent() == null) {
                frameLayout.addView(this.kyI.bxk());
            }
            if (this.kyJ == null) {
                this.kyJ = new g(this.kkb.getBaseFragmentActivity());
            }
            this.kyJ.b(fVar, str);
            bdTypeListView.removeHeaderView(this.kyJ.cSE());
            bdTypeListView.addHeaderView(this.kyJ.cSE(), 1);
            dVar.c(bdTypeListView);
            dVar.a(bdTypeListView, 2);
            if (this.kyI != null) {
                cVar.tg(false);
                this.kyI.Ce(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            if (this.kyI != null) {
                bdTypeListView.removeHeaderView(this.kyI.cSL());
            }
            if (this.kyJ != null) {
                this.kyJ.e(bdTypeListView);
            }
        }
    }

    public void sW(boolean z) {
        this.kyK = z;
    }

    public void U(View.OnClickListener onClickListener) {
        if (this.kyI != null) {
            this.kyI.U(onClickListener);
        }
    }

    public void d(BdTypeListView bdTypeListView) {
        if (this.kyI != null) {
            TiebaStatic.log(new ap("c11997").ah("obj_type", 1));
            this.kyI.cRc();
            bdTypeListView.smoothScrollToPosition(0);
        }
    }

    public boolean Cd(int i) {
        if (this.kyI != null) {
            return this.kyI.vj(i);
        }
        return false;
    }

    public void a(PbLandscapeListView pbLandscapeListView, TextView textView, int i) {
        if (pbLandscapeListView != null) {
            if (this.kyI != null && this.kyI.bxk() != null) {
                if (textView != null) {
                    pbLandscapeListView.removeHeaderView(textView);
                    pbLandscapeListView.setTextViewAdded(false);
                }
                if (i != 1) {
                    pbLandscapeListView.removeHeaderView(this.kyI.cSL());
                    pbLandscapeListView.addHeaderView(this.kyI.cSL(), 0);
                    return;
                }
                return;
            }
            if (this.kyI != null) {
                pbLandscapeListView.removeHeaderView(this.kyI.cSL());
            }
            if (textView != null) {
                pbLandscapeListView.removeHeaderView(textView);
                pbLandscapeListView.addHeaderView(textView, 0);
            }
        }
    }

    public boolean cQH() {
        return this.kyI != null && this.kyI.cQH();
    }

    public void cQI() {
        if (this.kyI != null) {
            this.kyI.onPause();
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.kyI != null) {
            this.kyI.c(absListView, i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.kyI != null) {
            this.kyI.onScrollStateChanged(absListView, i);
        }
    }

    public void sU(boolean z) {
        if (this.kyI != null) {
            this.kyI.sU(z);
        }
    }

    public void cRc() {
        if (this.kyI != null) {
            this.kyI.cRc();
        }
    }

    public void destroy() {
        if (this.kyI != null) {
            this.kyI.destroy();
        }
    }

    public void onPause() {
        if (this.kyI != null) {
            this.kyI.onPause();
        }
    }

    public void onResume() {
        if (this.kyI != null) {
            this.kyI.onResume();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.kyI != null) {
            this.kyI.onConfigurationChanged(configuration);
        }
    }

    public void Ce(int i) {
        if (this.kyI != null) {
            this.kyI.Ce(i);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kyJ != null) {
            this.kyJ.onChangeSkinType(i);
        }
    }

    public View bxk() {
        if (this.kyI != null) {
            return this.kyI.bxk();
        }
        return null;
    }

    public int cRd() {
        View bxk = bxk();
        if (bxk != null) {
            return bxk.getHeight();
        }
        return 0;
    }

    public int cRe() {
        if (this.kyI != null) {
            return this.kyI.cRe();
        }
        return 0;
    }

    public boolean bDD() {
        if (this.kyI != null) {
            return this.kyI.bDD();
        }
        return false;
    }
}
