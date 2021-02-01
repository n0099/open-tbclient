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
    private int caN;
    private int caO;
    private View.OnClickListener fhT;
    private SortSwitchButton.a lOe;
    private SortSwitchButton lYf;
    private o lYr;
    private View mRootView;
    private TextView mne;
    private TextView mnf;
    private int lYp = 0;
    private int mng = 0;
    private SortSwitchButton.a lSB = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.videopb.videoView.b.1
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean zp(int i) {
            if (b.this.lOe != null) {
                return b.this.lOe.zp(i);
            }
            return true;
        }
    };
    private View.OnClickListener lYu = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.videoView.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.fhT != null) {
                b.this.fhT.onClick(view);
            }
            if (j.isNetWorkAvailable()) {
                if (view == null || !(view.getTag() instanceof Boolean) || ((Boolean) view.getTag()).booleanValue()) {
                    if (view != b.this.mne) {
                        if (view == b.this.mnf) {
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
    private View.OnClickListener lYv = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.videoView.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.fhT != null) {
                b.this.fhT.onClick(view);
            }
        }
    };

    public void setSelection(int i) {
        this.mng = i;
        if (i == 0) {
            this.mne.setTypeface(Typeface.defaultFromStyle(1));
            this.mnf.setTypeface(Typeface.defaultFromStyle(0));
            this.mne.setTextColor(this.caN);
            this.mnf.setTextColor(this.caO);
        } else if (i == 1) {
            this.mne.setTypeface(Typeface.defaultFromStyle(0));
            this.mnf.setTypeface(Typeface.defaultFromStyle(1));
            this.mne.setTextColor(this.caO);
            this.mnf.setTextColor(this.caN);
        }
    }

    public b(View view) {
        if (view != null) {
            this.mRootView = view;
            this.mne = (TextView) this.mRootView.findViewById(R.id.all_reply);
            this.mne.setOnClickListener(this.lYu);
            this.mnf = (TextView) this.mRootView.findViewById(R.id.owner_reply);
            this.mnf.setOnClickListener(this.lYu);
            this.lYf = (SortSwitchButton) this.mRootView.findViewById(R.id.video_pb_sort_switch_btn);
            this.lYf.setOnSwitchChangeListener(this.lSB);
            this.lYf.iF(2);
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
        this.caN = ap.getColor(R.color.CAM_X0105);
        this.caO = ap.getColor(R.color.CAM_X0107);
        setSelection(this.mng);
        this.lYf.onChangeSkinType();
    }

    public void a(o oVar) {
        this.lYr = oVar;
        if (oVar != null) {
            if (oVar.Wm == o.lLq) {
                this.mne.setClickable(true);
                this.mne.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.mnf.setVisibility(0);
                vw(oVar.lLv);
            }
            if (oVar.isDynamic) {
                this.mnf.setVisibility(8);
                this.lYf.setVisibility(8);
            } else {
                this.mnf.setVisibility(0);
                if (oVar.lLw != null) {
                    this.lYf.setVisibility(0);
                    int i = 0;
                    while (true) {
                        if (i >= oVar.lLw.size()) {
                            i = 0;
                            break;
                        } else if (oVar.lLw.get(i) != null && oVar.sortType == oVar.lLw.get(i).sort_type.intValue()) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    p(oVar.lLw, i);
                }
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void p(List<PbSortType> list, int i) {
        if (y.isEmpty(list)) {
            this.lYf.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (PbSortType pbSortType : list) {
            r rVar = new r();
            rVar.JF(pbSortType.sort_type.intValue());
            rVar.Tf(pbSortType.sort_name);
            arrayList.add(rVar);
        }
        this.lYf.setVisibility(0);
        this.lYf.setData(arrayList, i);
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.lOe = aVar;
    }

    public void Z(View.OnClickListener onClickListener) {
        this.fhT = onClickListener;
    }
}
