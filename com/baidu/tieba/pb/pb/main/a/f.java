package com.baidu.tieba.pb.pb.main.a;

import android.content.res.Configuration;
import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes2.dex */
public class f {
    private PbFragment lMX;
    private com.baidu.tieba.pb.video.g mcE;
    private com.baidu.tieba.pb.video.f mcF;
    private boolean mcG = false;

    public f(PbFragment pbFragment) {
        this.lMX = pbFragment;
    }

    public void a(com.baidu.tieba.pb.data.f fVar, PostData postData, BdTypeListView bdTypeListView, e eVar, FrameLayout frameLayout, com.baidu.tieba.pb.pb.main.view.c cVar, String str, long j) {
        if (fVar != null && fVar.dlz()) {
            if (this.mcE == null) {
                this.mcE = new com.baidu.tieba.pb.video.g(this.lMX, cVar, fVar.dkZ().boh(), j);
                this.mcE.a(fVar.dkZ().boh(), fVar.dkZ(), fVar.getForumId());
                this.mcE.startPlay();
            } else if (this.mcG) {
                this.mcE.a(fVar.dkZ().boh(), fVar.dkZ(), fVar.getForumId());
                this.mcE.startPlay();
            } else {
                this.mcE.Qc(fVar.getForumId());
            }
            com.baidu.tieba.pb.c.a.a(this.lMX.getUniqueId(), fVar, postData, 1, 1);
            if (fVar.dla() != null && fVar.dla().size() >= 1) {
                cb cbVar = fVar.dla().get(0);
                this.mcE.aQ(cbVar);
                this.mcE.Qd(cbVar.getTitle());
            }
            this.mcE.b(postData, fVar.dkZ(), fVar.dly());
            this.mcG = false;
            bdTypeListView.removeHeaderView(this.mcE.dtH());
            bdTypeListView.addHeaderView(this.mcE.dtH(), 0);
            if (this.mcE.getContainerView() != null && this.mcE.getContainerView().getParent() == null) {
                frameLayout.addView(this.mcE.getContainerView());
            }
            if (this.mcF == null) {
                this.mcF = new com.baidu.tieba.pb.video.f(this.lMX.getBaseFragmentActivity());
            }
            this.mcF.b(fVar, str);
            bdTypeListView.removeHeaderView(this.mcF.dtA());
            bdTypeListView.addHeaderView(this.mcF.dtA(), 1);
            eVar.c(bdTypeListView);
            eVar.a(bdTypeListView, 2);
            if (this.mcE != null) {
                cVar.vY(false);
                this.mcE.Gf(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            if (this.mcE != null) {
                bdTypeListView.removeHeaderView(this.mcE.dtH());
            }
            if (this.mcF != null) {
                this.mcF.e(bdTypeListView);
            }
        }
    }

    public void vN(boolean z) {
        this.mcG = z;
    }

    public void X(View.OnClickListener onClickListener) {
        if (this.mcE != null) {
            this.mcE.X(onClickListener);
        }
    }

    public void d(BdTypeListView bdTypeListView) {
        if (this.mcE != null) {
            TiebaStatic.log(new ar("c11997").ap("obj_type", 1));
            this.mcE.drT();
            bdTypeListView.smoothScrollToPosition(0);
        }
    }

    public boolean Ge(int i) {
        if (this.mcE != null) {
            return this.mcE.zf(i);
        }
        return false;
    }

    public void a(PbLandscapeListView pbLandscapeListView, TextView textView, int i) {
        if (pbLandscapeListView != null) {
            if (this.mcE != null && this.mcE.getContainerView() != null) {
                if (textView != null) {
                    pbLandscapeListView.removeHeaderView(textView);
                    pbLandscapeListView.setTextViewAdded(false);
                }
                if (i != 1) {
                    pbLandscapeListView.removeHeaderView(this.mcE.dtH());
                    pbLandscapeListView.addHeaderView(this.mcE.dtH(), 0);
                    return;
                }
                return;
            }
            if (this.mcE != null) {
                pbLandscapeListView.removeHeaderView(this.mcE.dtH());
            }
            if (textView != null) {
                pbLandscapeListView.removeHeaderView(textView);
                pbLandscapeListView.addHeaderView(textView, 0);
            }
        }
    }

    public boolean drv() {
        return this.mcE != null && this.mcE.drv();
    }

    public void drw() {
        if (this.mcE != null) {
            this.mcE.onPause();
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.mcE != null) {
            this.mcE.c(absListView, i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.mcE != null) {
            this.mcE.onScrollStateChanged(absListView, i);
        }
    }

    public void vL(boolean z) {
        if (this.mcE != null) {
            this.mcE.vL(z);
        }
    }

    public void drT() {
        if (this.mcE != null) {
            this.mcE.drT();
        }
    }

    public void destroy() {
        if (this.mcE != null) {
            this.mcE.destroy();
        }
    }

    public void onPause() {
        if (this.mcE != null) {
            this.mcE.onPause();
        }
    }

    public void onResume() {
        if (this.mcE != null) {
            this.mcE.onResume();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.mcE != null) {
            this.mcE.onConfigurationChanged(configuration);
        }
    }

    public void Gf(int i) {
        if (this.mcE != null) {
            this.mcE.Gf(i);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mcF != null) {
            this.mcF.onChangeSkinType(i);
        }
    }

    public View getContainerView() {
        if (this.mcE != null) {
            return this.mcE.getContainerView();
        }
        return null;
    }

    public int drU() {
        View containerView = getContainerView();
        if (containerView != null) {
            return containerView.getHeight();
        }
        return 0;
    }

    public int drV() {
        if (this.mcE != null) {
            return this.mcE.drV();
        }
        return 0;
    }

    public boolean isVertical() {
        if (this.mcE != null) {
            return this.mcE.isVertical();
        }
        return false;
    }
}
