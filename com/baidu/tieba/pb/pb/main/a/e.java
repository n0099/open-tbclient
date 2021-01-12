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
    private PbFragment lEi;
    private g lTA;
    private com.baidu.tieba.pb.video.f lTB;
    private boolean lTC = false;

    public e(PbFragment pbFragment) {
        this.lEi = pbFragment;
    }

    public void a(com.baidu.tieba.pb.data.f fVar, PostData postData, BdTypeListView bdTypeListView, d dVar, FrameLayout frameLayout, com.baidu.tieba.pb.pb.main.view.c cVar, String str, long j) {
        if (fVar != null && fVar.djn()) {
            if (this.lTA == null) {
                this.lTA = new g(this.lEi, cVar, fVar.diN().bnO(), j);
                this.lTA.a(fVar.diN().bnO(), fVar.diN(), fVar.getForumId());
                this.lTA.startPlay();
            } else if (this.lTC) {
                this.lTA.a(fVar.diN().bnO(), fVar.diN(), fVar.getForumId());
                this.lTA.startPlay();
            } else {
                this.lTA.Pk(fVar.getForumId());
            }
            com.baidu.tieba.pb.c.a.a(this.lEi.getUniqueId(), fVar, postData, 1, 1);
            if (fVar.diO() != null && fVar.diO().size() >= 1) {
                bz bzVar = fVar.diO().get(0);
                this.lTA.aP(bzVar);
                this.lTA.Pl(bzVar.getTitle());
            }
            this.lTA.b(postData, fVar.diN(), fVar.djm());
            this.lTC = false;
            bdTypeListView.removeHeaderView(this.lTA.drt());
            bdTypeListView.addHeaderView(this.lTA.drt(), 0);
            if (this.lTA.bRe() != null && this.lTA.bRe().getParent() == null) {
                frameLayout.addView(this.lTA.bRe());
            }
            if (this.lTB == null) {
                this.lTB = new com.baidu.tieba.pb.video.f(this.lEi.getBaseFragmentActivity());
            }
            this.lTB.b(fVar, str);
            bdTypeListView.removeHeaderView(this.lTB.drm());
            bdTypeListView.addHeaderView(this.lTB.drm(), 1);
            dVar.c(bdTypeListView);
            dVar.a(bdTypeListView, 2);
            if (this.lTA != null) {
                cVar.vI(false);
                this.lTA.FM(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            if (this.lTA != null) {
                bdTypeListView.removeHeaderView(this.lTA.drt());
            }
            if (this.lTB != null) {
                this.lTB.e(bdTypeListView);
            }
        }
    }

    public void vy(boolean z) {
        this.lTC = z;
    }

    public void X(View.OnClickListener onClickListener) {
        if (this.lTA != null) {
            this.lTA.X(onClickListener);
        }
    }

    public void d(BdTypeListView bdTypeListView) {
        if (this.lTA != null) {
            TiebaStatic.log(new aq("c11997").an("obj_type", 1));
            this.lTA.dpF();
            bdTypeListView.smoothScrollToPosition(0);
        }
    }

    public boolean FL(int i) {
        if (this.lTA != null) {
            return this.lTA.yV(i);
        }
        return false;
    }

    public void a(PbLandscapeListView pbLandscapeListView, TextView textView, int i) {
        if (pbLandscapeListView != null) {
            if (this.lTA != null && this.lTA.bRe() != null) {
                if (textView != null) {
                    pbLandscapeListView.removeHeaderView(textView);
                    pbLandscapeListView.setTextViewAdded(false);
                }
                if (i != 1) {
                    pbLandscapeListView.removeHeaderView(this.lTA.drt());
                    pbLandscapeListView.addHeaderView(this.lTA.drt(), 0);
                    return;
                }
                return;
            }
            if (this.lTA != null) {
                pbLandscapeListView.removeHeaderView(this.lTA.drt());
            }
            if (textView != null) {
                pbLandscapeListView.removeHeaderView(textView);
                pbLandscapeListView.addHeaderView(textView, 0);
            }
        }
    }

    public boolean dph() {
        return this.lTA != null && this.lTA.dph();
    }

    public void dpi() {
        if (this.lTA != null) {
            this.lTA.onPause();
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.lTA != null) {
            this.lTA.c(absListView, i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.lTA != null) {
            this.lTA.onScrollStateChanged(absListView, i);
        }
    }

    public void vw(boolean z) {
        if (this.lTA != null) {
            this.lTA.vw(z);
        }
    }

    public void dpF() {
        if (this.lTA != null) {
            this.lTA.dpF();
        }
    }

    public void destroy() {
        if (this.lTA != null) {
            this.lTA.destroy();
        }
    }

    public void onPause() {
        if (this.lTA != null) {
            this.lTA.onPause();
        }
    }

    public void onResume() {
        if (this.lTA != null) {
            this.lTA.onResume();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.lTA != null) {
            this.lTA.onConfigurationChanged(configuration);
        }
    }

    public void FM(int i) {
        if (this.lTA != null) {
            this.lTA.FM(i);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.lTB != null) {
            this.lTB.onChangeSkinType(i);
        }
    }

    public View bRe() {
        if (this.lTA != null) {
            return this.lTA.bRe();
        }
        return null;
    }

    public int dpG() {
        View bRe = bRe();
        if (bRe != null) {
            return bRe.getHeight();
        }
        return 0;
    }

    public int dpH() {
        if (this.lTA != null) {
            return this.lTA.dpH();
        }
        return 0;
    }

    public boolean isVertical() {
        if (this.lTA != null) {
            return this.lTA.isVertical();
        }
        return false;
    }
}
