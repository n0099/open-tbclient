package com.baidu.tieba.pb.pb.main.a;

import android.content.res.Configuration;
import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
import com.baidu.tieba.pb.video.g;
import com.baidu.tieba.pb.video.h;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes9.dex */
public class e {
    private PbFragment jHL;
    private h jVS;
    private g jVT;
    private boolean jVU = false;

    public e(PbFragment pbFragment) {
        this.jHL = pbFragment;
    }

    public void a(com.baidu.tieba.pb.data.e eVar, PostData postData, BdTypeListView bdTypeListView, d dVar, FrameLayout frameLayout, com.baidu.tieba.pb.pb.main.view.c cVar, String str, long j) {
        if (eVar != null && eVar.aWj()) {
            if (this.jVS == null) {
                this.jVS = new h(this.jHL, cVar, eVar.cCy().aQQ(), j);
                this.jVS.a(eVar.cCy().aQQ(), eVar.cCy(), eVar.getForumId());
                this.jVS.startPlay();
            } else if (this.jVU) {
                this.jVS.a(eVar.cCy().aQQ(), eVar.cCy(), eVar.getForumId());
                this.jVS.startPlay();
            } else {
                this.jVS.JT(eVar.getForumId());
            }
            com.baidu.tieba.pb.c.a.a(this.jHL.getUniqueId(), eVar, postData, 1, 1);
            if (eVar.cCz() != null && eVar.cCz().size() >= 1) {
                bk bkVar = eVar.cCz().get(0);
                this.jVS.aM(bkVar);
                this.jVS.JU(bkVar.getTitle());
            }
            this.jVS.b(postData, eVar.cCy(), eVar.cCW());
            this.jVU = false;
            bdTypeListView.removeHeaderView(this.jVS.cKG());
            bdTypeListView.addHeaderView(this.jVS.cKG(), 0);
            if (this.jVS.bre() != null && this.jVS.bre().getParent() == null) {
                frameLayout.addView(this.jVS.bre());
            }
            if (this.jVT == null) {
                this.jVT = new g(this.jHL.getBaseFragmentActivity());
            }
            this.jVT.b(eVar, str);
            bdTypeListView.removeHeaderView(this.jVT.cKz());
            bdTypeListView.addHeaderView(this.jVT.cKz(), 1);
            dVar.c(bdTypeListView);
            dVar.a(bdTypeListView, 2);
            if (this.jVS != null) {
                cVar.sm(false);
                this.jVS.AD(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            if (this.jVS != null) {
                bdTypeListView.removeHeaderView(this.jVS.cKG());
            }
            if (this.jVT != null) {
                this.jVT.e(bdTypeListView);
            }
        }
    }

    public void sd(boolean z) {
        this.jVU = z;
    }

    public void S(View.OnClickListener onClickListener) {
        if (this.jVS != null) {
            this.jVS.S(onClickListener);
        }
    }

    public void d(BdTypeListView bdTypeListView) {
        if (this.jVS != null) {
            TiebaStatic.log(new an("c11997").ag("obj_type", 1));
            this.jVS.cIX();
            bdTypeListView.smoothScrollToPosition(0);
        }
    }

    public boolean AC(int i) {
        if (this.jVS != null) {
            return this.jVS.um(i);
        }
        return false;
    }

    public void a(PbLandscapeListView pbLandscapeListView, TextView textView, int i) {
        if (pbLandscapeListView != null) {
            if (this.jVS != null && this.jVS.bre() != null) {
                if (textView != null) {
                    pbLandscapeListView.removeHeaderView(textView);
                    pbLandscapeListView.setTextViewAdded(false);
                }
                if (i != 1) {
                    pbLandscapeListView.removeHeaderView(this.jVS.cKG());
                    pbLandscapeListView.addHeaderView(this.jVS.cKG(), 0);
                    return;
                }
                return;
            }
            if (this.jVS != null) {
                pbLandscapeListView.removeHeaderView(this.jVS.cKG());
            }
            if (textView != null) {
                pbLandscapeListView.removeHeaderView(textView);
                pbLandscapeListView.addHeaderView(textView, 0);
            }
        }
    }

    public boolean cID() {
        return this.jVS != null && this.jVS.cID();
    }

    public void cIE() {
        if (this.jVS != null) {
            this.jVS.onPause();
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.jVS != null) {
            this.jVS.c(absListView, i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.jVS != null) {
            this.jVS.onScrollStateChanged(absListView, i);
        }
    }

    public void sb(boolean z) {
        if (this.jVS != null) {
            this.jVS.sb(z);
        }
    }

    public void cIX() {
        if (this.jVS != null) {
            this.jVS.cIX();
        }
    }

    public void destroy() {
        if (this.jVS != null) {
            this.jVS.destroy();
        }
    }

    public void onPause() {
        if (this.jVS != null) {
            this.jVS.onPause();
        }
    }

    public void onResume() {
        if (this.jVS != null) {
            this.jVS.onResume();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.jVS != null) {
            this.jVS.onConfigurationChanged(configuration);
        }
    }

    public void AD(int i) {
        if (this.jVS != null) {
            this.jVS.AD(i);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jVT != null) {
            this.jVT.onChangeSkinType(i);
        }
    }

    public View bre() {
        if (this.jVS != null) {
            return this.jVS.bre();
        }
        return null;
    }

    public int cIY() {
        View bre = bre();
        if (bre != null) {
            return bre.getHeight();
        }
        return 0;
    }

    public int cIZ() {
        if (this.jVS != null) {
            return this.jVS.cIZ();
        }
        return 0;
    }

    public boolean bxE() {
        if (this.jVS != null) {
            return this.jVS.bxE();
        }
        return false;
    }
}
