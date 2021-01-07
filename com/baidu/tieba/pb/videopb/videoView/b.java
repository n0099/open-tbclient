package com.baidu.tieba.pb.videopb.videoView;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.n;
import com.baidu.tieba.tbadkCore.data.q;
import com.baidu.tieba.view.SortSwitchButton;
import java.util.ArrayList;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes2.dex */
public class b {
    private int cby;
    private int cbz;
    private View.OnClickListener fko;
    private SortSwitchButton.a lJS;
    private SortSwitchButton lTN;
    private n lTZ;
    private View mRootView;
    private TextView miI;
    private TextView miJ;
    private int lTX = 0;
    private int miK = 0;
    private SortSwitchButton.a lOi = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.videopb.videoView.b.1
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean AL(int i) {
            if (b.this.lJS != null) {
                return b.this.lJS.AL(i);
            }
            return true;
        }
    };
    private View.OnClickListener lUc = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.videoView.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.fko != null) {
                b.this.fko.onClick(view);
            }
            if (j.isNetWorkAvailable()) {
                if (view == null || !(view.getTag() instanceof Boolean) || ((Boolean) view.getTag()).booleanValue()) {
                    if (view != b.this.miI) {
                        if (view == b.this.miJ) {
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
    private View.OnClickListener lUd = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.videoView.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.fko != null) {
                b.this.fko.onClick(view);
            }
        }
    };

    public void setSelection(int i) {
        this.miK = i;
        if (i == 0) {
            this.miI.setTypeface(Typeface.defaultFromStyle(1));
            this.miJ.setTypeface(Typeface.defaultFromStyle(0));
            this.miI.setTextColor(this.cby);
            this.miJ.setTextColor(this.cbz);
        } else if (i == 1) {
            this.miI.setTypeface(Typeface.defaultFromStyle(0));
            this.miJ.setTypeface(Typeface.defaultFromStyle(1));
            this.miI.setTextColor(this.cbz);
            this.miJ.setTextColor(this.cby);
        }
    }

    public b(View view) {
        if (view != null) {
            this.mRootView = view;
            this.miI = (TextView) this.mRootView.findViewById(R.id.all_reply);
            this.miI.setOnClickListener(this.lUc);
            this.miJ = (TextView) this.mRootView.findViewById(R.id.owner_reply);
            this.miJ.setOnClickListener(this.lUc);
            this.lTN = (SortSwitchButton) this.mRootView.findViewById(R.id.video_pb_sort_switch_btn);
            this.lTN.setOnSwitchChangeListener(this.lOi);
            this.lTN.ki(2);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void vl(boolean z) {
        if (z) {
            setSelection(1);
        } else {
            setSelection(0);
        }
    }

    public void onChangeSkinType(int i) {
        ao.setBackgroundColor(this.mRootView, R.color.CAM_X0205);
        this.cby = ao.getColor(R.color.CAM_X0105);
        this.cbz = ao.getColor(R.color.CAM_X0107);
        setSelection(this.miK);
        this.lTN.onChangeSkinType();
    }

    public void a(n nVar) {
        this.lTZ = nVar;
        if (nVar != null) {
            if (nVar.Ws == n.lHh) {
                this.miI.setClickable(true);
                this.miI.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.miJ.setVisibility(0);
                vl(nVar.lHm);
            }
            if (nVar.isDynamic) {
                this.miJ.setVisibility(8);
                this.lTN.setVisibility(8);
            } else {
                this.miJ.setVisibility(0);
                if (nVar.lHn != null) {
                    this.lTN.setVisibility(0);
                    int i = 0;
                    while (true) {
                        if (i >= nVar.lHn.size()) {
                            i = 0;
                            break;
                        } else if (nVar.lHn.get(i) != null && nVar.sortType == nVar.lHn.get(i).sort_type.intValue()) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    p(nVar.lHn, i);
                }
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void p(List<PbSortType> list, int i) {
        if (x.isEmpty(list)) {
            this.lTN.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (PbSortType pbSortType : list) {
            q qVar = new q();
            qVar.KS(pbSortType.sort_type.intValue());
            qVar.Tp(pbSortType.sort_name);
            arrayList.add(qVar);
        }
        this.lTN.setVisibility(0);
        this.lTN.setData(arrayList, i);
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.lJS = aVar;
    }

    public void Z(View.OnClickListener onClickListener) {
        this.fko = onClickListener;
    }
}
