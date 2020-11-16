package com.baidu.tieba.pb.pb.main.a;

import android.content.res.Configuration;
import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
import com.baidu.tieba.pb.video.g;
import com.baidu.tieba.pb.video.h;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes21.dex */
public class e {
    private h lFa;
    private g lFb;
    private boolean lFc = false;
    private PbFragment lpX;

    public e(PbFragment pbFragment) {
        this.lpX = pbFragment;
    }

    public void a(f fVar, PostData postData, BdTypeListView bdTypeListView, d dVar, FrameLayout frameLayout, com.baidu.tieba.pb.pb.main.view.c cVar, String str, long j) {
        if (fVar != null && fVar.dih()) {
            if (this.lFa == null) {
                this.lFa = new h(this.lpX, cVar, fVar.dhH().blU(), j);
                this.lFa.a(fVar.dhH().blU(), fVar.dhH(), fVar.getForumId());
                this.lFa.startPlay();
            } else if (this.lFc) {
                this.lFa.a(fVar.dhH().blU(), fVar.dhH(), fVar.getForumId());
                this.lFa.startPlay();
            } else {
                this.lFa.PE(fVar.getForumId());
            }
            com.baidu.tieba.pb.c.a.a(this.lpX.getUniqueId(), fVar, postData, 1, 1);
            if (fVar.dhI() != null && fVar.dhI().size() >= 1) {
                bx bxVar = fVar.dhI().get(0);
                this.lFa.aO(bxVar);
                this.lFa.PF(bxVar.getTitle());
            }
            this.lFa.b(postData, fVar.dhH(), fVar.dig());
            this.lFc = false;
            bdTypeListView.removeHeaderView(this.lFa.dqb());
            bdTypeListView.addHeaderView(this.lFa.dqb(), 0);
            if (this.lFa.bOH() != null && this.lFa.bOH().getParent() == null) {
                frameLayout.addView(this.lFa.bOH());
            }
            if (this.lFb == null) {
                this.lFb = new g(this.lpX.getBaseFragmentActivity());
            }
            this.lFb.b(fVar, str);
            bdTypeListView.removeHeaderView(this.lFb.dpU());
            bdTypeListView.addHeaderView(this.lFb.dpU(), 1);
            dVar.c(bdTypeListView);
            dVar.a(bdTypeListView, 2);
            if (this.lFa != null) {
                cVar.vi(false);
                this.lFa.GJ(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            if (this.lFa != null) {
                bdTypeListView.removeHeaderView(this.lFa.dqb());
            }
            if (this.lFb != null) {
                this.lFb.e(bdTypeListView);
            }
        }
    }

    public void uY(boolean z) {
        this.lFc = z;
    }

    public void V(View.OnClickListener onClickListener) {
        if (this.lFa != null) {
            this.lFa.V(onClickListener);
        }
    }

    public void d(BdTypeListView bdTypeListView) {
        if (this.lFa != null) {
            TiebaStatic.log(new ar("c11997").ak("obj_type", 1));
            this.lFa.dop();
            bdTypeListView.smoothScrollToPosition(0);
        }
    }

    public boolean GI(int i) {
        if (this.lFa != null) {
            return this.lFa.zK(i);
        }
        return false;
    }

    public void a(PbLandscapeListView pbLandscapeListView, TextView textView, int i) {
        if (pbLandscapeListView != null) {
            if (this.lFa != null && this.lFa.bOH() != null) {
                if (textView != null) {
                    pbLandscapeListView.removeHeaderView(textView);
                    pbLandscapeListView.setTextViewAdded(false);
                }
                if (i != 1) {
                    pbLandscapeListView.removeHeaderView(this.lFa.dqb());
                    pbLandscapeListView.addHeaderView(this.lFa.dqb(), 0);
                    return;
                }
                return;
            }
            if (this.lFa != null) {
                pbLandscapeListView.removeHeaderView(this.lFa.dqb());
            }
            if (textView != null) {
                pbLandscapeListView.removeHeaderView(textView);
                pbLandscapeListView.addHeaderView(textView, 0);
            }
        }
    }

    public boolean dnT() {
        return this.lFa != null && this.lFa.dnT();
    }

    public void dnU() {
        if (this.lFa != null) {
            this.lFa.onPause();
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.lFa != null) {
            this.lFa.c(absListView, i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.lFa != null) {
            this.lFa.onScrollStateChanged(absListView, i);
        }
    }

    public void uW(boolean z) {
        if (this.lFa != null) {
            this.lFa.uW(z);
        }
    }

    public void dop() {
        if (this.lFa != null) {
            this.lFa.dop();
        }
    }

    public void destroy() {
        if (this.lFa != null) {
            this.lFa.destroy();
        }
    }

    public void onPause() {
        if (this.lFa != null) {
            this.lFa.onPause();
        }
    }

    public void onResume() {
        if (this.lFa != null) {
            this.lFa.onResume();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.lFa != null) {
            this.lFa.onConfigurationChanged(configuration);
        }
    }

    public void GJ(int i) {
        if (this.lFa != null) {
            this.lFa.GJ(i);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.lFb != null) {
            this.lFb.onChangeSkinType(i);
        }
    }

    public View bOH() {
        if (this.lFa != null) {
            return this.lFa.bOH();
        }
        return null;
    }

    public int doq() {
        View bOH = bOH();
        if (bOH != null) {
            return bOH.getHeight();
        }
        return 0;
    }

    public int dor() {
        if (this.lFa != null) {
            return this.lFa.dor();
        }
        return 0;
    }

    public boolean bWv() {
        if (this.lFa != null) {
            return this.lFa.bWv();
        }
        return false;
    }
}
