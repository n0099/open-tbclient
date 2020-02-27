package com.baidu.tieba.signall;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
import com.baidu.tieba.signall.SignSingleModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes11.dex */
public class g extends BaseAdapter implements AbsListView.OnScrollListener, SignSingleModel.a {
    private boolean isDestory;
    private SignAllForumActivity jYG;
    private c jYm;
    private ArrayList<d> fSr = new ArrayList<>();
    private HashMap<String, SignSingleModel> jYH = new HashMap<>();
    private boolean gdP = true;

    public g(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.jYG = signAllForumActivity;
    }

    public void c(c cVar) {
        if (cVar != null) {
            this.jYm = cVar;
            this.fSr = cVar.cIv();
            if (this.fSr.size() == 0) {
                this.gdP = false;
            } else {
                this.gdP = true;
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i) instanceof com.baidu.tieba.signall.b ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gdP) {
            return this.fSr.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.fSr.size() > i) {
            return this.fSr.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View Ci(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.jYG.getPageContext().getPageActivity()).inflate(R.layout.signallforum_item, (ViewGroup) null);
            b bVar = new b();
            bVar.jYN = (BarImageView) inflate.findViewById(R.id.signallforum_item_avatar);
            bVar.jYN.setIsRound(false);
            bVar.jYN.setGifIconSupport(false);
            bVar.jYP = (TextView) inflate.findViewById(R.id.signallforum_item_name);
            bVar.jYQ = (ImageView) inflate.findViewById(R.id.signallforum_item_level);
            bVar.jYR = (TextView) inflate.findViewById(R.id.signallforum_item_exp);
            bVar.jYS = (FrameLayout) inflate.findViewById(R.id.signallforum_item_res_container);
            bVar.jYT = (TextView) inflate.findViewById(R.id.signallforum_item_days);
            bVar.jYU = (RelativeLayout) inflate.findViewById(R.id.signallforum_item_resign_container);
            bVar.jYV = (ImageView) inflate.findViewById(R.id.signallforum_item_resign_icon);
            bVar.jYW = (ProgressBar) inflate.findViewById(R.id.signallforum_item_resign_progress);
            bVar.jYX = (TextView) inflate.findViewById(R.id.signallforum_item_resign_text);
            bVar.jYY = (TextView) inflate.findViewById(R.id.signallforum_item_error);
            bVar.jYO = (LinearLayout) inflate.findViewById(R.id.signallforum_item_level_container);
            bVar.jYZ = (TextView) inflate.findViewById(R.id.signallforum_item_increaseexp);
            inflate.setTag(bVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.jYG.getPageContext().getPageActivity()).inflate(R.layout.signallforum_header, (ViewGroup) null);
        a aVar = new a();
        aVar.jYL = (TextView) inflate2.findViewById(R.id.signallforum_head_title);
        aVar.jYM = (TextView) inflate2.findViewById(R.id.signallforum_head_res);
        inflate2.setTag(aVar);
        return inflate2;
    }

    private void a(View view, View view2, int i) {
        String str;
        this.jYG.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.jYG.getLayoutMode().onModeChanged(view);
        final b bVar = (b) view.getTag();
        final d dVar = (d) getItem(i);
        if (dVar != null) {
            String forumName = dVar.getForumName();
            if (forumName != null && forumName.length() > 8) {
                char[] charArray = forumName.toCharArray();
                int i2 = 0;
                for (int i3 = 0; i3 < charArray.length; i3++) {
                    if (StringUtils.isChinese(charArray[i3])) {
                        i2 += 2;
                    } else {
                        i2++;
                    }
                    if (i2 > 16) {
                        str = forumName.substring(0, i3) + StringHelper.STRING_MORE;
                        break;
                    }
                }
            }
            str = forumName;
            bVar.jYP.setText(str);
            am.setImageResource(bVar.jYQ, BitmapHelper.getSmallGradeResourceIdNew(dVar.cII()));
            bVar.jYR.setText(dVar.cIJ() + "/" + dVar.cIK());
            bVar.jYZ.clearAnimation();
            if (dVar.bde()) {
                bVar.jYO.setVisibility(0);
                bVar.jYY.setVisibility(8);
                bVar.jYT.setVisibility(0);
                bVar.jYU.setVisibility(8);
                bVar.jYT.setText(String.format(this.jYG.getPageContext().getString(R.string.signallforum_days), Integer.valueOf(dVar.cIH())));
                if (dVar.cIO()) {
                    bVar.jYR.setText(this.jYG.getPageContext().getString(R.string.signallforum_uplevel));
                    bVar.jYZ.setVisibility(8);
                } else {
                    bVar.jYR.setText(dVar.cIJ() + "/" + dVar.cIK());
                    bVar.jYZ.setVisibility(0);
                }
                int cIN = dVar.cIN();
                if (cIN > 0) {
                    bVar.jYZ.setVisibility(0);
                    bVar.jYZ.setText("+" + cIN);
                } else {
                    bVar.jYZ.setVisibility(8);
                }
            } else if (dVar.cIL()) {
                bVar.jYO.setVisibility(0);
                bVar.jYY.setVisibility(8);
                bVar.jYZ.setVisibility(8);
                bVar.jYT.setVisibility(8);
                bVar.jYU.setVisibility(0);
                if (dVar.cIM()) {
                    bVar.jYV.setVisibility(4);
                    bVar.jYW.setVisibility(0);
                    bVar.jYX.setText(R.string.signallforum_resigning);
                } else {
                    bVar.jYV.setVisibility(0);
                    bVar.jYW.setVisibility(4);
                    bVar.jYX.setText(R.string.signallforum_resign);
                }
                bVar.jYU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.signall.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        if (!dVar.cIM()) {
                            bVar.jYV.setVisibility(4);
                            bVar.jYW.setVisibility(0);
                            bVar.jYX.setText(R.string.signallforum_resigning);
                            dVar.sB(true);
                            SignSingleModel signSingleModel = new SignSingleModel(g.this.jYG);
                            signSingleModel.a(g.this);
                            String str2 = dVar.getForumId() + "";
                            synchronized (g.this) {
                                g.this.jYH.put(str2, signSingleModel);
                            }
                            signSingleModel.ex(dVar.getForumName(), str2);
                            TiebaStatic.log("signall_resign_click");
                        }
                    }
                });
            } else {
                bVar.jYT.setVisibility(8);
                bVar.jYU.setVisibility(8);
                bVar.jYZ.setVisibility(8);
                bVar.jYO.setVisibility(0);
                bVar.jYY.setVisibility(8);
            }
            String avatar = dVar.getAvatar();
            bVar.jYN.setTag(avatar);
            bVar.jYN.setPlaceHolder(1);
            bVar.jYN.startLoad(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (!this.gdP) {
            return bAS();
        }
        int itemViewType = getItemViewType(i);
        View Ci = view == null ? Ci(itemViewType) : view;
        if (itemViewType == 1) {
            if (Ci.getTag() != null && (Ci.getTag() instanceof a)) {
                view2 = Ci;
                aVar = (a) Ci.getTag();
            } else {
                View Ci2 = Ci(itemViewType);
                view2 = Ci2;
                aVar = (a) Ci2.getTag();
            }
            this.jYG.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.jYG.getLayoutMode().onModeChanged(view2.findViewById(R.id.sign_all_forum_tip));
            aVar.jYL.setText(((com.baidu.tieba.signall.b) getItem(i)).getTitle());
            h(aVar.jYM, i);
            return view2;
        }
        if (Ci.getTag() == null || !(Ci.getTag() instanceof b)) {
            Ci = Ci(itemViewType);
        }
        a(Ci, viewGroup, i);
        return Ci;
    }

    private void h(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.jYm == null ? 7 : this.jYm.getLevel();
        if (this.fSr == null || this.fSr.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<d> it = this.fSr.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                d next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.cII() >= level) {
                        if (next.bde()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.bde()) {
                        i3++;
                    } else {
                        i2++;
                    }
                    i5 = i5;
                    i4 = i4;
                    i3 = i3;
                    i2 = i2;
                }
            }
        }
        if (i == 0 && i5 + i4 > 0) {
            format = String.format(this.jYG.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.jYG.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View bAS() {
        View inflate = LayoutInflater.from(this.jYG.getPageContext().getPageActivity()).inflate(R.layout.sign_all_forum_nodata_item, (ViewGroup) null);
        NoDataView a2 = NoDataViewFactory.a(this.jYG.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(R.id.sign_all_forum_no_data_view), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.FINDBAR, this.jYG.getResources().getDimensionPixelSize(R.dimen.tbds90)), NoDataViewFactory.d.cA(null, this.jYG.getResources().getString(R.string.no_bar_attentioned)), null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.jYG.getLayoutMode().setNightMode(skinType == 1);
        this.jYG.getLayoutMode().onModeChanged(inflate);
        a2.onChangeSkinType(this.jYG.getPageContext(), skinType);
        a2.setVisibility(0);
        a2.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        return inflate;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class b {
        public BarImageView jYN;
        public LinearLayout jYO;
        public TextView jYP;
        public ImageView jYQ;
        public TextView jYR;
        public FrameLayout jYS;
        public TextView jYT;
        public RelativeLayout jYU;
        public ImageView jYV;
        public ProgressBar jYW;
        public TextView jYX;
        public TextView jYY;
        public TextView jYZ;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a {
        public TextView jYL;
        public TextView jYM;

        a() {
        }
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void c(SignData signData) {
        String str = signData.forumId;
        synchronized (this) {
            this.jYH.remove(str);
        }
        a(str, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void ew(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            l.showToast(this.jYG.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.jYH.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.fSr.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.fSr.get(i);
            if ((dVar.getForumId() + "").equals(str)) {
                dVar.sz(z);
                dVar.sA(!z);
                dVar.sB(false);
                if (z) {
                    dVar.Cf(signData.count_sign_num);
                    dVar.Ch(signData.sign_bonus_point);
                    dVar.Ce(1);
                    TbadkApplication.getInst().addSignedForum(dVar.getForumName(), signData.sign_bonus_point, -1);
                    ArrayList<d> cIy = this.jYm.cIy();
                    if (cIy.contains(dVar)) {
                        cIy.remove(dVar);
                        this.jYm.cIx().add(dVar);
                    }
                } else {
                    dVar.setErrorMsg(str2);
                }
                if (!this.isDestory) {
                    notifyDataSetChanged();
                    return;
                }
                return;
            }
        }
    }

    public void cIU() {
        this.isDestory = true;
        synchronized (this) {
            try {
                for (Map.Entry<String, SignSingleModel> entry : this.jYH.entrySet()) {
                    entry.getValue().cJn();
                }
                this.jYH.clear();
            }
        }
    }
}
