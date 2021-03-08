package com.baidu.tieba.pb.videopb.videoView;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.o;
import com.baidu.tieba.tbadkCore.data.r;
import com.baidu.tieba.view.SortSwitchButton;
import java.util.ArrayList;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes2.dex */
public class b {
    private int cco;
    private int ccp;
    private View.OnClickListener fjv;
    private SortSwitchButton.a lQv;
    private View mRootView;
    private o maL;
    private SortSwitchButton maz;
    private TextView mpw;
    private TextView mpx;
    private int maJ = 0;
    private int mpy = 0;
    private SortSwitchButton.a lUS = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.videopb.videoView.b.1
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean zq(int i) {
            if (b.this.lQv != null) {
                return b.this.lQv.zq(i);
            }
            return true;
        }
    };
    private View.OnClickListener maO = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.videoView.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.fjv != null) {
                b.this.fjv.onClick(view);
            }
            if (j.isNetWorkAvailable()) {
                if (view == null || !(view.getTag() instanceof Boolean) || ((Boolean) view.getTag()).booleanValue()) {
                    if (view != b.this.mpw) {
                        if (view == b.this.mpx) {
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
    private View.OnClickListener maP = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.videoView.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.fjv != null) {
                b.this.fjv.onClick(view);
            }
        }
    };

    public void setSelection(int i) {
        this.mpy = i;
        if (i == 0) {
            this.mpw.setTypeface(Typeface.defaultFromStyle(1));
            this.mpx.setTypeface(Typeface.defaultFromStyle(0));
            this.mpw.setTextColor(this.cco);
            this.mpx.setTextColor(this.ccp);
        } else if (i == 1) {
            this.mpw.setTypeface(Typeface.defaultFromStyle(0));
            this.mpx.setTypeface(Typeface.defaultFromStyle(1));
            this.mpw.setTextColor(this.ccp);
            this.mpx.setTextColor(this.cco);
        }
    }

    public b(View view) {
        if (view != null) {
            this.mRootView = view;
            this.mpw = (TextView) this.mRootView.findViewById(R.id.all_reply);
            this.mpw.setOnClickListener(this.maO);
            this.mpx = (TextView) this.mRootView.findViewById(R.id.owner_reply);
            this.mpx.setOnClickListener(this.maO);
            this.maz = (SortSwitchButton) this.mRootView.findViewById(R.id.video_pb_sort_switch_btn);
            this.maz.setOnSwitchChangeListener(this.lUS);
            this.maz.iG(2);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void vw(boolean z) {
        if (z) {
            setSelection(1);
        } else {
            setSelection(0);
        }
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0205);
        this.cco = ap.getColor(R.color.CAM_X0105);
        this.ccp = ap.getColor(R.color.CAM_X0107);
        setSelection(this.mpy);
        this.maz.onChangeSkinType();
    }

    public void a(o oVar) {
        this.maL = oVar;
        if (oVar != null) {
            if (oVar.XG == o.lNH) {
                this.mpw.setClickable(true);
                this.mpw.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.mpx.setVisibility(0);
                vw(oVar.lNM);
            }
            if (oVar.isDynamic) {
                this.mpx.setVisibility(8);
                this.maz.setVisibility(8);
            } else {
                this.mpx.setVisibility(0);
                if (oVar.lNN != null) {
                    this.maz.setVisibility(0);
                    int i = 0;
                    while (true) {
                        if (i >= oVar.lNN.size()) {
                            i = 0;
                            break;
                        } else if (oVar.lNN.get(i) != null && oVar.sortType == oVar.lNN.get(i).sort_type.intValue()) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    p(oVar.lNN, i);
                }
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void p(List<PbSortType> list, int i) {
        if (y.isEmpty(list)) {
            this.maz.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (PbSortType pbSortType : list) {
            r rVar = new r();
            rVar.JK(pbSortType.sort_type.intValue());
            rVar.Ty(pbSortType.sort_name);
            arrayList.add(rVar);
        }
        this.maz.setVisibility(0);
        this.maz.setData(arrayList, i);
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.lQv = aVar;
    }

    public void aa(View.OnClickListener onClickListener) {
        this.fjv = onClickListener;
    }
}
