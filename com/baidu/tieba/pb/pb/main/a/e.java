package com.baidu.tieba.pb.pb.main.a;

import android.content.res.Configuration;
import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
import com.baidu.tieba.pb.video.g;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes2.dex */
public class e {
    private PbFragment lIO;
    private g lYf;
    private com.baidu.tieba.pb.video.f lYg;
    private boolean lYh = false;

    public e(PbFragment pbFragment) {
        this.lIO = pbFragment;
    }

    public void a(com.baidu.tieba.pb.data.f fVar, PostData postData, BdTypeListView bdTypeListView, d dVar, FrameLayout frameLayout, com.baidu.tieba.pb.pb.main.view.c cVar, String str, long j) {
        if (fVar != null && fVar.dne()) {
            if (this.lYf == null) {
                this.lYf = new g(this.lIO, cVar, fVar.dmE().brH(), j);
                this.lYf.a(fVar.dmE().brH(), fVar.dmE(), fVar.getForumId());
                this.lYf.startPlay();
            } else if (this.lYh) {
                this.lYf.a(fVar.dmE().brH(), fVar.dmE(), fVar.getForumId());
                this.lYf.startPlay();
            } else {
                this.lYf.Qt(fVar.getForumId());
            }
            com.baidu.tieba.pb.c.a.a(this.lIO.getUniqueId(), fVar, postData, 1, 1);
            if (fVar.dmF() != null && fVar.dmF().size() >= 1) {
                bz bzVar = fVar.dmF().get(0);
                this.lYf.aP(bzVar);
                this.lYf.Qu(bzVar.getTitle());
            }
            this.lYf.b(postData, fVar.dmE(), fVar.dnd());
            this.lYh = false;
            bdTypeListView.removeHeaderView(this.lYf.dvk());
            bdTypeListView.addHeaderView(this.lYf.dvk(), 0);
            if (this.lYf.bUV() != null && this.lYf.bUV().getParent() == null) {
                frameLayout.addView(this.lYf.bUV());
            }
            if (this.lYg == null) {
                this.lYg = new com.baidu.tieba.pb.video.f(this.lIO.getBaseFragmentActivity());
            }
            this.lYg.b(fVar, str);
            bdTypeListView.removeHeaderView(this.lYg.dvd());
            bdTypeListView.addHeaderView(this.lYg.dvd(), 1);
            dVar.c(bdTypeListView);
            dVar.a(bdTypeListView, 2);
            if (this.lYf != null) {
                cVar.vM(false);
                this.lYf.Hs(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            if (this.lYf != null) {
                bdTypeListView.removeHeaderView(this.lYf.dvk());
            }
            if (this.lYg != null) {
                this.lYg.e(bdTypeListView);
            }
        }
    }

    public void vC(boolean z) {
        this.lYh = z;
    }

    public void X(View.OnClickListener onClickListener) {
        if (this.lYf != null) {
            this.lYf.X(onClickListener);
        }
    }

    public void d(BdTypeListView bdTypeListView) {
        if (this.lYf != null) {
            TiebaStatic.log(new aq("c11997").an("obj_type", 1));
            this.lYf.dtw();
            bdTypeListView.smoothScrollToPosition(0);
        }
    }

    public boolean Hr(int i) {
        if (this.lYf != null) {
            return this.lYf.AB(i);
        }
        return false;
    }

    public void a(PbLandscapeListView pbLandscapeListView, TextView textView, int i) {
        if (pbLandscapeListView != null) {
            if (this.lYf != null && this.lYf.bUV() != null) {
                if (textView != null) {
                    pbLandscapeListView.removeHeaderView(textView);
                    pbLandscapeListView.setTextViewAdded(false);
                }
                if (i != 1) {
                    pbLandscapeListView.removeHeaderView(this.lYf.dvk());
                    pbLandscapeListView.addHeaderView(this.lYf.dvk(), 0);
                    return;
                }
                return;
            }
            if (this.lYf != null) {
                pbLandscapeListView.removeHeaderView(this.lYf.dvk());
            }
            if (textView != null) {
                pbLandscapeListView.removeHeaderView(textView);
                pbLandscapeListView.addHeaderView(textView, 0);
            }
        }
    }

    public boolean dsY() {
        return this.lYf != null && this.lYf.dsY();
    }

    public void dsZ() {
        if (this.lYf != null) {
            this.lYf.onPause();
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.lYf != null) {
            this.lYf.c(absListView, i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.lYf != null) {
            this.lYf.onScrollStateChanged(absListView, i);
        }
    }

    public void vA(boolean z) {
        if (this.lYf != null) {
            this.lYf.vA(z);
        }
    }

    public void dtw() {
        if (this.lYf != null) {
            this.lYf.dtw();
        }
    }

    public void destroy() {
        if (this.lYf != null) {
            this.lYf.destroy();
        }
    }

    public void onPause() {
        if (this.lYf != null) {
            this.lYf.onPause();
        }
    }

    public void onResume() {
        if (this.lYf != null) {
            this.lYf.onResume();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.lYf != null) {
            this.lYf.onConfigurationChanged(configuration);
        }
    }

    public void Hs(int i) {
        if (this.lYf != null) {
            this.lYf.Hs(i);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.lYg != null) {
            this.lYg.onChangeSkinType(i);
        }
    }

    public View bUV() {
        if (this.lYf != null) {
            return this.lYf.bUV();
        }
        return null;
    }

    public int dtx() {
        View bUV = bUV();
        if (bUV != null) {
            return bUV.getHeight();
        }
        return 0;
    }

    public int dty() {
        if (this.lYf != null) {
            return this.lYf.dty();
        }
        return 0;
    }

    public boolean isVertical() {
        if (this.lYf != null) {
            return this.lYf.isVertical();
        }
        return false;
    }
}
