package com.baidu.tieba.pb.pb.main.a;

import android.content.res.Configuration;
import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
import com.baidu.tieba.pb.video.g;
import com.baidu.tieba.pb.video.h;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes22.dex */
public class e {
    private PbFragment kXi;
    private h lmj;
    private g lmk;
    private boolean lml = false;

    public e(PbFragment pbFragment) {
        this.kXi = pbFragment;
    }

    public void a(f fVar, PostData postData, BdTypeListView bdTypeListView, d dVar, FrameLayout frameLayout, com.baidu.tieba.pb.pb.main.view.c cVar, String str, long j) {
        if (fVar != null && fVar.dda()) {
            if (this.lmj == null) {
                this.lmj = new h(this.kXi, cVar, fVar.dcA().biz(), j);
                this.lmj.a(fVar.dcA().biz(), fVar.dcA(), fVar.getForumId());
                this.lmj.startPlay();
            } else if (this.lml) {
                this.lmj.a(fVar.dcA().biz(), fVar.dcA(), fVar.getForumId());
                this.lmj.startPlay();
            } else {
                this.lmj.Pt(fVar.getForumId());
            }
            com.baidu.tieba.pb.c.a.a(this.kXi.getUniqueId(), fVar, postData, 1, 1);
            if (fVar.dcB() != null && fVar.dcB().size() >= 1) {
                bw bwVar = fVar.dcB().get(0);
                this.lmj.aM(bwVar);
                this.lmj.Pu(bwVar.getTitle());
            }
            this.lmj.b(postData, fVar.dcA(), fVar.dcZ());
            this.lml = false;
            bdTypeListView.removeHeaderView(this.lmj.dkR());
            bdTypeListView.addHeaderView(this.lmj.dkR(), 0);
            if (this.lmj.bKm() != null && this.lmj.bKm().getParent() == null) {
                frameLayout.addView(this.lmj.bKm());
            }
            if (this.lmk == null) {
                this.lmk = new g(this.kXi.getBaseFragmentActivity());
            }
            this.lmk.b(fVar, str);
            bdTypeListView.removeHeaderView(this.lmk.dkK());
            bdTypeListView.addHeaderView(this.lmk.dkK(), 1);
            dVar.c(bdTypeListView);
            dVar.a(bdTypeListView, 2);
            if (this.lmj != null) {
                cVar.uF(false);
                this.lmj.FF(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            if (this.lmj != null) {
                bdTypeListView.removeHeaderView(this.lmj.dkR());
            }
            if (this.lmk != null) {
                this.lmk.e(bdTypeListView);
            }
        }
    }

    public void uv(boolean z) {
        this.lml = z;
    }

    public void V(View.OnClickListener onClickListener) {
        if (this.lmj != null) {
            this.lmj.V(onClickListener);
        }
    }

    public void d(BdTypeListView bdTypeListView) {
        if (this.lmj != null) {
            TiebaStatic.log(new aq("c11997").aj("obj_type", 1));
            this.lmj.djg();
            bdTypeListView.smoothScrollToPosition(0);
        }
    }

    public boolean FE(int i) {
        if (this.lmj != null) {
            return this.lmj.yG(i);
        }
        return false;
    }

    public void a(PbLandscapeListView pbLandscapeListView, TextView textView, int i) {
        if (pbLandscapeListView != null) {
            if (this.lmj != null && this.lmj.bKm() != null) {
                if (textView != null) {
                    pbLandscapeListView.removeHeaderView(textView);
                    pbLandscapeListView.setTextViewAdded(false);
                }
                if (i != 1) {
                    pbLandscapeListView.removeHeaderView(this.lmj.dkR());
                    pbLandscapeListView.addHeaderView(this.lmj.dkR(), 0);
                    return;
                }
                return;
            }
            if (this.lmj != null) {
                pbLandscapeListView.removeHeaderView(this.lmj.dkR());
            }
            if (textView != null) {
                pbLandscapeListView.removeHeaderView(textView);
                pbLandscapeListView.addHeaderView(textView, 0);
            }
        }
    }

    public boolean diK() {
        return this.lmj != null && this.lmj.diK();
    }

    public void diL() {
        if (this.lmj != null) {
            this.lmj.onPause();
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.lmj != null) {
            this.lmj.c(absListView, i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.lmj != null) {
            this.lmj.onScrollStateChanged(absListView, i);
        }
    }

    public void ut(boolean z) {
        if (this.lmj != null) {
            this.lmj.ut(z);
        }
    }

    public void djg() {
        if (this.lmj != null) {
            this.lmj.djg();
        }
    }

    public void destroy() {
        if (this.lmj != null) {
            this.lmj.destroy();
        }
    }

    public void onPause() {
        if (this.lmj != null) {
            this.lmj.onPause();
        }
    }

    public void onResume() {
        if (this.lmj != null) {
            this.lmj.onResume();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.lmj != null) {
            this.lmj.onConfigurationChanged(configuration);
        }
    }

    public void FF(int i) {
        if (this.lmj != null) {
            this.lmj.FF(i);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.lmk != null) {
            this.lmk.onChangeSkinType(i);
        }
    }

    public View bKm() {
        if (this.lmj != null) {
            return this.lmj.bKm();
        }
        return null;
    }

    public int djh() {
        View bKm = bKm();
        if (bKm != null) {
            return bKm.getHeight();
        }
        return 0;
    }

    public int dji() {
        if (this.lmj != null) {
            return this.lmj.dji();
        }
        return 0;
    }

    public boolean bRF() {
        if (this.lmj != null) {
            return this.lmj.bRF();
        }
        return false;
    }
}
