package com.baidu.tieba.pb.videopb.videoView;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.n;
import com.baidu.tieba.tbadkCore.data.p;
import com.baidu.tieba.view.SortSwitchButton;
import java.util.ArrayList;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes16.dex */
public class b {
    private int aXj;
    private int aXk;
    private View.OnClickListener erH;
    private SortSwitchButton.a kAy;
    private SortSwitchButton kKh;
    private n kKt;
    private TextView kYI;
    private TextView kYJ;
    private View mRootView;
    private int kKr = 0;
    private int kYK = 0;
    private SortSwitchButton.a kEE = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.videopb.videoView.b.1
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean xL(int i) {
            if (b.this.kAy != null) {
                return b.this.kAy.xL(i);
            }
            return true;
        }
    };
    private View.OnClickListener kKw = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.videoView.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.erH != null) {
                b.this.erH.onClick(view);
            }
            if (j.isNetWorkAvailable()) {
                if (view == null || !(view.getTag() instanceof Boolean) || ((Boolean) view.getTag()).booleanValue()) {
                    if (view != b.this.kYI) {
                        if (view == b.this.kYJ) {
                            b.this.setSelection(1);
                            return;
                        }
                        return;
                    }
                    b.this.setSelection(0);
                }
            }
        }
    };
    private View.OnClickListener kKx = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.videoView.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.erH != null) {
                b.this.erH.onClick(view);
            }
        }
    };

    public void setSelection(int i) {
        this.kYK = i;
        if (i == 0) {
            this.kYI.setTypeface(Typeface.defaultFromStyle(1));
            this.kYJ.setTypeface(Typeface.defaultFromStyle(0));
            this.kYI.setTextColor(this.aXj);
            this.kYJ.setTextColor(this.aXk);
        } else if (i == 1) {
            this.kYI.setTypeface(Typeface.defaultFromStyle(0));
            this.kYJ.setTypeface(Typeface.defaultFromStyle(1));
            this.kYI.setTextColor(this.aXk);
            this.kYJ.setTextColor(this.aXj);
        }
    }

    public b(View view) {
        if (view != null) {
            this.mRootView = view;
            this.kYI = (TextView) this.mRootView.findViewById(R.id.all_reply);
            this.kYI.setOnClickListener(this.kKw);
            this.kYJ = (TextView) this.mRootView.findViewById(R.id.owner_reply);
            this.kYJ.setOnClickListener(this.kKw);
            this.kKh = (SortSwitchButton) this.mRootView.findViewById(R.id.video_pb_sort_switch_btn);
            this.kKh.setOnSwitchChangeListener(this.kEE);
            this.kKh.changeState(2);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void tr(boolean z) {
        if (z) {
            setSelection(1);
        } else {
            setSelection(0);
        }
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
        this.aXj = ap.getColor(R.color.cp_cont_b);
        this.aXk = ap.getColor(R.color.cp_cont_j);
        setSelection(this.kYK);
        this.kKh.onChangeSkinType();
    }

    public void a(n nVar) {
        this.kKt = nVar;
        if (nVar != null) {
            if (nVar.UM == n.kyf) {
                this.kYI.setClickable(true);
                this.kYI.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.kYJ.setVisibility(0);
                tr(nVar.kyk);
            }
            if (nVar.isDynamic) {
                this.kYJ.setVisibility(8);
                this.kKh.setVisibility(8);
            } else {
                this.kYJ.setVisibility(0);
                if (nVar.kyl != null) {
                    this.kKh.setVisibility(0);
                    int i = 0;
                    while (true) {
                        if (i >= nVar.kyl.size()) {
                            i = 0;
                            break;
                        } else if (nVar.kyl.get(i) != null && nVar.sortType == nVar.kyl.get(i).sort_type.intValue()) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    p(nVar.kyl, i);
                }
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void p(List<PbSortType> list, int i) {
        if (y.isEmpty(list)) {
            this.kKh.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (PbSortType pbSortType : list) {
            p pVar = new p();
            pVar.HQ(pbSortType.sort_type.intValue());
            pVar.QO(pbSortType.sort_name);
            arrayList.add(pVar);
        }
        this.kKh.setVisibility(0);
        this.kKh.setData(arrayList, i);
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.kAy = aVar;
    }

    public void X(View.OnClickListener onClickListener) {
        this.erH = onClickListener;
    }
}
