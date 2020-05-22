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
    private PbFragment jGF;
    private h jUM;
    private g jUN;
    private boolean jUO = false;

    public e(PbFragment pbFragment) {
        this.jGF = pbFragment;
    }

    public void a(com.baidu.tieba.pb.data.e eVar, PostData postData, BdTypeListView bdTypeListView, d dVar, FrameLayout frameLayout, com.baidu.tieba.pb.pb.main.view.c cVar, String str, long j) {
        if (eVar != null && eVar.aWi()) {
            if (this.jUM == null) {
                this.jUM = new h(this.jGF, cVar, eVar.cCi().aQQ(), j);
                this.jUM.a(eVar.cCi().aQQ(), eVar.cCi(), eVar.getForumId());
                this.jUM.startPlay();
            } else if (this.jUO) {
                this.jUM.a(eVar.cCi().aQQ(), eVar.cCi(), eVar.getForumId());
                this.jUM.startPlay();
            } else {
                this.jUM.JS(eVar.getForumId());
            }
            com.baidu.tieba.pb.c.a.a(this.jGF.getUniqueId(), eVar, postData, 1, 1);
            if (eVar.cCj() != null && eVar.cCj().size() >= 1) {
                bk bkVar = eVar.cCj().get(0);
                this.jUM.aM(bkVar);
                this.jUM.JT(bkVar.getTitle());
            }
            this.jUM.b(postData, eVar.cCi(), eVar.cCG());
            this.jUO = false;
            bdTypeListView.removeHeaderView(this.jUM.cKq());
            bdTypeListView.addHeaderView(this.jUM.cKq(), 0);
            if (this.jUM.brc() != null && this.jUM.brc().getParent() == null) {
                frameLayout.addView(this.jUM.brc());
            }
            if (this.jUN == null) {
                this.jUN = new g(this.jGF.getBaseFragmentActivity());
            }
            this.jUN.b(eVar, str);
            bdTypeListView.removeHeaderView(this.jUN.cKj());
            bdTypeListView.addHeaderView(this.jUN.cKj(), 1);
            dVar.c(bdTypeListView);
            dVar.a(bdTypeListView, 2);
            if (this.jUM != null) {
                cVar.sm(false);
                this.jUM.AB(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            if (this.jUM != null) {
                bdTypeListView.removeHeaderView(this.jUM.cKq());
            }
            if (this.jUN != null) {
                this.jUN.e(bdTypeListView);
            }
        }
    }

    public void sd(boolean z) {
        this.jUO = z;
    }

    public void S(View.OnClickListener onClickListener) {
        if (this.jUM != null) {
            this.jUM.S(onClickListener);
        }
    }

    public void d(BdTypeListView bdTypeListView) {
        if (this.jUM != null) {
            TiebaStatic.log(new an("c11997").ag("obj_type", 1));
            this.jUM.cIH();
            bdTypeListView.smoothScrollToPosition(0);
        }
    }

    public boolean AA(int i) {
        if (this.jUM != null) {
            return this.jUM.uk(i);
        }
        return false;
    }

    public void a(PbLandscapeListView pbLandscapeListView, TextView textView, int i) {
        if (pbLandscapeListView != null) {
            if (this.jUM != null && this.jUM.brc() != null) {
                if (textView != null) {
                    pbLandscapeListView.removeHeaderView(textView);
                    pbLandscapeListView.setTextViewAdded(false);
                }
                if (i != 1) {
                    pbLandscapeListView.removeHeaderView(this.jUM.cKq());
                    pbLandscapeListView.addHeaderView(this.jUM.cKq(), 0);
                    return;
                }
                return;
            }
            if (this.jUM != null) {
                pbLandscapeListView.removeHeaderView(this.jUM.cKq());
            }
            if (textView != null) {
                pbLandscapeListView.removeHeaderView(textView);
                pbLandscapeListView.addHeaderView(textView, 0);
            }
        }
    }

    public boolean cIn() {
        return this.jUM != null && this.jUM.cIn();
    }

    public void cIo() {
        if (this.jUM != null) {
            this.jUM.onPause();
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.jUM != null) {
            this.jUM.c(absListView, i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.jUM != null) {
            this.jUM.onScrollStateChanged(absListView, i);
        }
    }

    public void sb(boolean z) {
        if (this.jUM != null) {
            this.jUM.sb(z);
        }
    }

    public void cIH() {
        if (this.jUM != null) {
            this.jUM.cIH();
        }
    }

    public void destroy() {
        if (this.jUM != null) {
            this.jUM.destroy();
        }
    }

    public void onPause() {
        if (this.jUM != null) {
            this.jUM.onPause();
        }
    }

    public void onResume() {
        if (this.jUM != null) {
            this.jUM.onResume();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.jUM != null) {
            this.jUM.onConfigurationChanged(configuration);
        }
    }

    public void AB(int i) {
        if (this.jUM != null) {
            this.jUM.AB(i);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jUN != null) {
            this.jUN.onChangeSkinType(i);
        }
    }

    public View brc() {
        if (this.jUM != null) {
            return this.jUM.brc();
        }
        return null;
    }

    public int cII() {
        View brc = brc();
        if (brc != null) {
            return brc.getHeight();
        }
        return 0;
    }

    public int cIJ() {
        if (this.jUM != null) {
            return this.jUM.cIJ();
        }
        return 0;
    }

    public boolean bxC() {
        if (this.jUM != null) {
            return this.jUM.bxC();
        }
        return false;
    }
}
