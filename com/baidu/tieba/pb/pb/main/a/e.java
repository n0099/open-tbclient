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
    private h kOn;
    private g kOo;
    private boolean kOp = false;
    private PbFragment kzt;

    public e(PbFragment pbFragment) {
        this.kzt = pbFragment;
    }

    public void a(f fVar, PostData postData, BdTypeListView bdTypeListView, d dVar, FrameLayout frameLayout, com.baidu.tieba.pb.pb.main.view.c cVar, String str, long j) {
        if (fVar != null && fVar.cVL()) {
            if (this.kOn == null) {
                this.kOn = new h(this.kzt, cVar, fVar.cVl().beW(), j);
                this.kOn.a(fVar.cVl().beW(), fVar.cVl(), fVar.getForumId());
                this.kOn.startPlay();
            } else if (this.kOp) {
                this.kOn.a(fVar.cVl().beW(), fVar.cVl(), fVar.getForumId());
                this.kOn.startPlay();
            } else {
                this.kOn.Oc(fVar.getForumId());
            }
            com.baidu.tieba.pb.c.a.a(this.kzt.getUniqueId(), fVar, postData, 1, 1);
            if (fVar.cVm() != null && fVar.cVm().size() >= 1) {
                bw bwVar = fVar.cVm().get(0);
                this.kOn.aL(bwVar);
                this.kOn.Od(bwVar.getTitle());
            }
            this.kOn.b(postData, fVar.cVl(), fVar.cVK());
            this.kOp = false;
            bdTypeListView.removeHeaderView(this.kOn.ddD());
            bdTypeListView.addHeaderView(this.kOn.ddD(), 0);
            if (this.kOn.bGj() != null && this.kOn.bGj().getParent() == null) {
                frameLayout.addView(this.kOn.bGj());
            }
            if (this.kOo == null) {
                this.kOo = new g(this.kzt.getBaseFragmentActivity());
            }
            this.kOo.b(fVar, str);
            bdTypeListView.removeHeaderView(this.kOo.ddw());
            bdTypeListView.addHeaderView(this.kOo.ddw(), 1);
            dVar.c(bdTypeListView);
            dVar.a(bdTypeListView, 2);
            if (this.kOn != null) {
                cVar.tP(false);
                this.kOn.Ey(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            if (this.kOn != null) {
                bdTypeListView.removeHeaderView(this.kOn.ddD());
            }
            if (this.kOo != null) {
                this.kOo.e(bdTypeListView);
            }
        }
    }

    public void tF(boolean z) {
        this.kOp = z;
    }

    public void V(View.OnClickListener onClickListener) {
        if (this.kOn != null) {
            this.kOn.V(onClickListener);
        }
    }

    public void d(BdTypeListView bdTypeListView) {
        if (this.kOn != null) {
            TiebaStatic.log(new aq("c11997").ai("obj_type", 1));
            this.kOn.dbS();
            bdTypeListView.smoothScrollToPosition(0);
        }
    }

    public boolean Ex(int i) {
        if (this.kOn != null) {
            return this.kOn.xB(i);
        }
        return false;
    }

    public void a(PbLandscapeListView pbLandscapeListView, TextView textView, int i) {
        if (pbLandscapeListView != null) {
            if (this.kOn != null && this.kOn.bGj() != null) {
                if (textView != null) {
                    pbLandscapeListView.removeHeaderView(textView);
                    pbLandscapeListView.setTextViewAdded(false);
                }
                if (i != 1) {
                    pbLandscapeListView.removeHeaderView(this.kOn.ddD());
                    pbLandscapeListView.addHeaderView(this.kOn.ddD(), 0);
                    return;
                }
                return;
            }
            if (this.kOn != null) {
                pbLandscapeListView.removeHeaderView(this.kOn.ddD());
            }
            if (textView != null) {
                pbLandscapeListView.removeHeaderView(textView);
                pbLandscapeListView.addHeaderView(textView, 0);
            }
        }
    }

    public boolean dbx() {
        return this.kOn != null && this.kOn.dbx();
    }

    public void dby() {
        if (this.kOn != null) {
            this.kOn.onPause();
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.kOn != null) {
            this.kOn.c(absListView, i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.kOn != null) {
            this.kOn.onScrollStateChanged(absListView, i);
        }
    }

    public void tD(boolean z) {
        if (this.kOn != null) {
            this.kOn.tD(z);
        }
    }

    public void dbS() {
        if (this.kOn != null) {
            this.kOn.dbS();
        }
    }

    public void destroy() {
        if (this.kOn != null) {
            this.kOn.destroy();
        }
    }

    public void onPause() {
        if (this.kOn != null) {
            this.kOn.onPause();
        }
    }

    public void onResume() {
        if (this.kOn != null) {
            this.kOn.onResume();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.kOn != null) {
            this.kOn.onConfigurationChanged(configuration);
        }
    }

    public void Ey(int i) {
        if (this.kOn != null) {
            this.kOn.Ey(i);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kOo != null) {
            this.kOo.onChangeSkinType(i);
        }
    }

    public View bGj() {
        if (this.kOn != null) {
            return this.kOn.bGj();
        }
        return null;
    }

    public int dbT() {
        View bGj = bGj();
        if (bGj != null) {
            return bGj.getHeight();
        }
        return 0;
    }

    public int dbU() {
        if (this.kOn != null) {
            return this.kOn.dbU();
        }
        return 0;
    }

    public boolean bNe() {
        if (this.kOn != null) {
            return this.kOn.bNe();
        }
        return false;
    }
}
