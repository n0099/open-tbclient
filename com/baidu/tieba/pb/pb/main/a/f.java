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
    private PbFragment lNm;
    private com.baidu.tieba.pb.video.g mcT;
    private com.baidu.tieba.pb.video.f mcU;
    private boolean mcV = false;

    public f(PbFragment pbFragment) {
        this.lNm = pbFragment;
    }

    public void a(com.baidu.tieba.pb.data.f fVar, PostData postData, BdTypeListView bdTypeListView, e eVar, FrameLayout frameLayout, com.baidu.tieba.pb.pb.main.view.c cVar, String str, long j) {
        if (fVar != null && fVar.dlG()) {
            if (this.mcT == null) {
                this.mcT = new com.baidu.tieba.pb.video.g(this.lNm, cVar, fVar.dlg().boh(), j);
                this.mcT.a(fVar.dlg().boh(), fVar.dlg(), fVar.getForumId());
                this.mcT.startPlay();
            } else if (this.mcV) {
                this.mcT.a(fVar.dlg().boh(), fVar.dlg(), fVar.getForumId());
                this.mcT.startPlay();
            } else {
                this.mcT.Qd(fVar.getForumId());
            }
            com.baidu.tieba.pb.c.a.a(this.lNm.getUniqueId(), fVar, postData, 1, 1);
            if (fVar.dlh() != null && fVar.dlh().size() >= 1) {
                cb cbVar = fVar.dlh().get(0);
                this.mcT.aQ(cbVar);
                this.mcT.Qe(cbVar.getTitle());
            }
            this.mcT.b(postData, fVar.dlg(), fVar.dlF());
            this.mcV = false;
            bdTypeListView.removeHeaderView(this.mcT.dtO());
            bdTypeListView.addHeaderView(this.mcT.dtO(), 0);
            if (this.mcT.getContainerView() != null && this.mcT.getContainerView().getParent() == null) {
                frameLayout.addView(this.mcT.getContainerView());
            }
            if (this.mcU == null) {
                this.mcU = new com.baidu.tieba.pb.video.f(this.lNm.getBaseFragmentActivity());
            }
            this.mcU.b(fVar, str);
            bdTypeListView.removeHeaderView(this.mcU.dtH());
            bdTypeListView.addHeaderView(this.mcU.dtH(), 1);
            eVar.c(bdTypeListView);
            eVar.a(bdTypeListView, 2);
            if (this.mcT != null) {
                cVar.vY(false);
                this.mcT.Gf(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            if (this.mcT != null) {
                bdTypeListView.removeHeaderView(this.mcT.dtO());
            }
            if (this.mcU != null) {
                this.mcU.e(bdTypeListView);
            }
        }
    }

    public void vN(boolean z) {
        this.mcV = z;
    }

    public void X(View.OnClickListener onClickListener) {
        if (this.mcT != null) {
            this.mcT.X(onClickListener);
        }
    }

    public void d(BdTypeListView bdTypeListView) {
        if (this.mcT != null) {
            TiebaStatic.log(new ar("c11997").ap("obj_type", 1));
            this.mcT.dsa();
            bdTypeListView.smoothScrollToPosition(0);
        }
    }

    public boolean Ge(int i) {
        if (this.mcT != null) {
            return this.mcT.zf(i);
        }
        return false;
    }

    public void a(PbLandscapeListView pbLandscapeListView, TextView textView, int i) {
        if (pbLandscapeListView != null) {
            if (this.mcT != null && this.mcT.getContainerView() != null) {
                if (textView != null) {
                    pbLandscapeListView.removeHeaderView(textView);
                    pbLandscapeListView.setTextViewAdded(false);
                }
                if (i != 1) {
                    pbLandscapeListView.removeHeaderView(this.mcT.dtO());
                    pbLandscapeListView.addHeaderView(this.mcT.dtO(), 0);
                    return;
                }
                return;
            }
            if (this.mcT != null) {
                pbLandscapeListView.removeHeaderView(this.mcT.dtO());
            }
            if (textView != null) {
                pbLandscapeListView.removeHeaderView(textView);
                pbLandscapeListView.addHeaderView(textView, 0);
            }
        }
    }

    public boolean drC() {
        return this.mcT != null && this.mcT.drC();
    }

    public void drD() {
        if (this.mcT != null) {
            this.mcT.onPause();
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.mcT != null) {
            this.mcT.c(absListView, i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.mcT != null) {
            this.mcT.onScrollStateChanged(absListView, i);
        }
    }

    public void vL(boolean z) {
        if (this.mcT != null) {
            this.mcT.vL(z);
        }
    }

    public void dsa() {
        if (this.mcT != null) {
            this.mcT.dsa();
        }
    }

    public void destroy() {
        if (this.mcT != null) {
            this.mcT.destroy();
        }
    }

    public void onPause() {
        if (this.mcT != null) {
            this.mcT.onPause();
        }
    }

    public void onResume() {
        if (this.mcT != null) {
            this.mcT.onResume();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.mcT != null) {
            this.mcT.onConfigurationChanged(configuration);
        }
    }

    public void Gf(int i) {
        if (this.mcT != null) {
            this.mcT.Gf(i);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mcU != null) {
            this.mcU.onChangeSkinType(i);
        }
    }

    public View getContainerView() {
        if (this.mcT != null) {
            return this.mcT.getContainerView();
        }
        return null;
    }

    public int dsb() {
        View containerView = getContainerView();
        if (containerView != null) {
            return containerView.getHeight();
        }
        return 0;
    }

    public int dsc() {
        if (this.mcT != null) {
            return this.mcT.dsc();
        }
        return 0;
    }

    public boolean isVertical() {
        if (this.mcT != null) {
            return this.mcT.isVertical();
        }
        return false;
    }
}
