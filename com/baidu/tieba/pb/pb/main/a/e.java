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
/* loaded from: classes16.dex */
public class e {
    private h kOu;
    private g kOv;
    private boolean kOw = false;
    private PbFragment kzA;

    public e(PbFragment pbFragment) {
        this.kzA = pbFragment;
    }

    public void a(f fVar, PostData postData, BdTypeListView bdTypeListView, d dVar, FrameLayout frameLayout, com.baidu.tieba.pb.pb.main.view.c cVar, String str, long j) {
        if (fVar != null && fVar.cVM()) {
            if (this.kOu == null) {
                this.kOu = new h(this.kzA, cVar, fVar.cVm().beW(), j);
                this.kOu.a(fVar.cVm().beW(), fVar.cVm(), fVar.getForumId());
                this.kOu.startPlay();
            } else if (this.kOw) {
                this.kOu.a(fVar.cVm().beW(), fVar.cVm(), fVar.getForumId());
                this.kOu.startPlay();
            } else {
                this.kOu.Od(fVar.getForumId());
            }
            com.baidu.tieba.pb.c.a.a(this.kzA.getUniqueId(), fVar, postData, 1, 1);
            if (fVar.cVn() != null && fVar.cVn().size() >= 1) {
                bw bwVar = fVar.cVn().get(0);
                this.kOu.aL(bwVar);
                this.kOu.Oe(bwVar.getTitle());
            }
            this.kOu.b(postData, fVar.cVm(), fVar.cVL());
            this.kOw = false;
            bdTypeListView.removeHeaderView(this.kOu.ddE());
            bdTypeListView.addHeaderView(this.kOu.ddE(), 0);
            if (this.kOu.bGk() != null && this.kOu.bGk().getParent() == null) {
                frameLayout.addView(this.kOu.bGk());
            }
            if (this.kOv == null) {
                this.kOv = new g(this.kzA.getBaseFragmentActivity());
            }
            this.kOv.b(fVar, str);
            bdTypeListView.removeHeaderView(this.kOv.ddx());
            bdTypeListView.addHeaderView(this.kOv.ddx(), 1);
            dVar.c(bdTypeListView);
            dVar.a(bdTypeListView, 2);
            if (this.kOu != null) {
                cVar.tR(false);
                this.kOu.Ey(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            if (this.kOu != null) {
                bdTypeListView.removeHeaderView(this.kOu.ddE());
            }
            if (this.kOv != null) {
                this.kOv.e(bdTypeListView);
            }
        }
    }

    public void tH(boolean z) {
        this.kOw = z;
    }

    public void V(View.OnClickListener onClickListener) {
        if (this.kOu != null) {
            this.kOu.V(onClickListener);
        }
    }

    public void d(BdTypeListView bdTypeListView) {
        if (this.kOu != null) {
            TiebaStatic.log(new aq("c11997").ai("obj_type", 1));
            this.kOu.dbT();
            bdTypeListView.smoothScrollToPosition(0);
        }
    }

    public boolean Ex(int i) {
        if (this.kOu != null) {
            return this.kOu.xB(i);
        }
        return false;
    }

    public void a(PbLandscapeListView pbLandscapeListView, TextView textView, int i) {
        if (pbLandscapeListView != null) {
            if (this.kOu != null && this.kOu.bGk() != null) {
                if (textView != null) {
                    pbLandscapeListView.removeHeaderView(textView);
                    pbLandscapeListView.setTextViewAdded(false);
                }
                if (i != 1) {
                    pbLandscapeListView.removeHeaderView(this.kOu.ddE());
                    pbLandscapeListView.addHeaderView(this.kOu.ddE(), 0);
                    return;
                }
                return;
            }
            if (this.kOu != null) {
                pbLandscapeListView.removeHeaderView(this.kOu.ddE());
            }
            if (textView != null) {
                pbLandscapeListView.removeHeaderView(textView);
                pbLandscapeListView.addHeaderView(textView, 0);
            }
        }
    }

    public boolean dby() {
        return this.kOu != null && this.kOu.dby();
    }

    public void dbz() {
        if (this.kOu != null) {
            this.kOu.onPause();
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.kOu != null) {
            this.kOu.c(absListView, i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.kOu != null) {
            this.kOu.onScrollStateChanged(absListView, i);
        }
    }

    public void tF(boolean z) {
        if (this.kOu != null) {
            this.kOu.tF(z);
        }
    }

    public void dbT() {
        if (this.kOu != null) {
            this.kOu.dbT();
        }
    }

    public void destroy() {
        if (this.kOu != null) {
            this.kOu.destroy();
        }
    }

    public void onPause() {
        if (this.kOu != null) {
            this.kOu.onPause();
        }
    }

    public void onResume() {
        if (this.kOu != null) {
            this.kOu.onResume();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.kOu != null) {
            this.kOu.onConfigurationChanged(configuration);
        }
    }

    public void Ey(int i) {
        if (this.kOu != null) {
            this.kOu.Ey(i);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kOv != null) {
            this.kOv.onChangeSkinType(i);
        }
    }

    public View bGk() {
        if (this.kOu != null) {
            return this.kOu.bGk();
        }
        return null;
    }

    public int dbU() {
        View bGk = bGk();
        if (bGk != null) {
            return bGk.getHeight();
        }
        return 0;
    }

    public int dbV() {
        if (this.kOu != null) {
            return this.kOu.dbV();
        }
        return 0;
    }

    public boolean bNf() {
        if (this.kOu != null) {
            return this.kOu.bNf();
        }
        return false;
    }
}
