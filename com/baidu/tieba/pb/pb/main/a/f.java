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
    private PbFragment lPo;
    private com.baidu.tieba.pb.video.g meW;
    private com.baidu.tieba.pb.video.f meX;
    private boolean meY = false;

    public f(PbFragment pbFragment) {
        this.lPo = pbFragment;
    }

    public void a(com.baidu.tieba.pb.data.f fVar, PostData postData, BdTypeListView bdTypeListView, e eVar, FrameLayout frameLayout, com.baidu.tieba.pb.pb.main.view.c cVar, String str, long j) {
        if (fVar != null && fVar.dlP()) {
            if (this.meW == null) {
                this.meW = new com.baidu.tieba.pb.video.g(this.lPo, cVar, fVar.dlp().boj(), j);
                this.meW.a(fVar.dlp().boj(), fVar.dlp(), fVar.getForumId());
                this.meW.startPlay();
            } else if (this.meY) {
                this.meW.a(fVar.dlp().boj(), fVar.dlp(), fVar.getForumId());
                this.meW.startPlay();
            } else {
                this.meW.Qj(fVar.getForumId());
            }
            com.baidu.tieba.pb.c.a.a(this.lPo.getUniqueId(), fVar, postData, 1, 1);
            if (fVar.dlq() != null && fVar.dlq().size() >= 1) {
                cb cbVar = fVar.dlq().get(0);
                this.meW.aQ(cbVar);
                this.meW.Qk(cbVar.getTitle());
            }
            this.meW.b(postData, fVar.dlp(), fVar.dlO());
            this.meY = false;
            bdTypeListView.removeHeaderView(this.meW.dtX());
            bdTypeListView.addHeaderView(this.meW.dtX(), 0);
            if (this.meW.getContainerView() != null && this.meW.getContainerView().getParent() == null) {
                frameLayout.addView(this.meW.getContainerView());
            }
            if (this.meX == null) {
                this.meX = new com.baidu.tieba.pb.video.f(this.lPo.getBaseFragmentActivity());
            }
            this.meX.b(fVar, str);
            bdTypeListView.removeHeaderView(this.meX.dtQ());
            bdTypeListView.addHeaderView(this.meX.dtQ(), 1);
            eVar.c(bdTypeListView);
            eVar.a(bdTypeListView, 2);
            if (this.meW != null) {
                cVar.vY(false);
                this.meW.Gi(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            if (this.meW != null) {
                bdTypeListView.removeHeaderView(this.meW.dtX());
            }
            if (this.meX != null) {
                this.meX.e(bdTypeListView);
            }
        }
    }

    public void vN(boolean z) {
        this.meY = z;
    }

    public void Y(View.OnClickListener onClickListener) {
        if (this.meW != null) {
            this.meW.Y(onClickListener);
        }
    }

    public void d(BdTypeListView bdTypeListView) {
        if (this.meW != null) {
            TiebaStatic.log(new ar("c11997").aq("obj_type", 1));
            this.meW.dsj();
            bdTypeListView.smoothScrollToPosition(0);
        }
    }

    public boolean Gh(int i) {
        if (this.meW != null) {
            return this.meW.zg(i);
        }
        return false;
    }

    public void a(PbLandscapeListView pbLandscapeListView, TextView textView, int i) {
        if (pbLandscapeListView != null) {
            if (this.meW != null && this.meW.getContainerView() != null) {
                if (textView != null) {
                    pbLandscapeListView.removeHeaderView(textView);
                    pbLandscapeListView.setTextViewAdded(false);
                }
                if (i != 1) {
                    pbLandscapeListView.removeHeaderView(this.meW.dtX());
                    pbLandscapeListView.addHeaderView(this.meW.dtX(), 0);
                    return;
                }
                return;
            }
            if (this.meW != null) {
                pbLandscapeListView.removeHeaderView(this.meW.dtX());
            }
            if (textView != null) {
                pbLandscapeListView.removeHeaderView(textView);
                pbLandscapeListView.addHeaderView(textView, 0);
            }
        }
    }

    public boolean drL() {
        return this.meW != null && this.meW.drL();
    }

    public void drM() {
        if (this.meW != null) {
            this.meW.onPause();
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.meW != null) {
            this.meW.c(absListView, i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.meW != null) {
            this.meW.onScrollStateChanged(absListView, i);
        }
    }

    public void vL(boolean z) {
        if (this.meW != null) {
            this.meW.vL(z);
        }
    }

    public void dsj() {
        if (this.meW != null) {
            this.meW.dsj();
        }
    }

    public void destroy() {
        if (this.meW != null) {
            this.meW.destroy();
        }
    }

    public void onPause() {
        if (this.meW != null) {
            this.meW.onPause();
        }
    }

    public void onResume() {
        if (this.meW != null) {
            this.meW.onResume();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.meW != null) {
            this.meW.onConfigurationChanged(configuration);
        }
    }

    public void Gi(int i) {
        if (this.meW != null) {
            this.meW.Gi(i);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.meX != null) {
            this.meX.onChangeSkinType(i);
        }
    }

    public View getContainerView() {
        if (this.meW != null) {
            return this.meW.getContainerView();
        }
        return null;
    }

    public int dsk() {
        View containerView = getContainerView();
        if (containerView != null) {
            return containerView.getHeight();
        }
        return 0;
    }

    public int dsl() {
        if (this.meW != null) {
            return this.meW.dsl();
        }
        return 0;
    }

    public boolean isVertical() {
        if (this.meW != null) {
            return this.meW.isVertical();
        }
        return false;
    }
}
