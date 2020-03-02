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
    private SignAllForumActivity jYI;
    private c jYo;
    private ArrayList<d> fSt = new ArrayList<>();
    private HashMap<String, SignSingleModel> jYJ = new HashMap<>();
    private boolean gdR = true;

    public g(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.jYI = signAllForumActivity;
    }

    public void c(c cVar) {
        if (cVar != null) {
            this.jYo = cVar;
            this.fSt = cVar.cIx();
            if (this.fSt.size() == 0) {
                this.gdR = false;
            } else {
                this.gdR = true;
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
        if (this.gdR) {
            return this.fSt.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.fSt.size() > i) {
            return this.fSt.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View Ci(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.jYI.getPageContext().getPageActivity()).inflate(R.layout.signallforum_item, (ViewGroup) null);
            b bVar = new b();
            bVar.jYP = (BarImageView) inflate.findViewById(R.id.signallforum_item_avatar);
            bVar.jYP.setIsRound(false);
            bVar.jYP.setGifIconSupport(false);
            bVar.jYR = (TextView) inflate.findViewById(R.id.signallforum_item_name);
            bVar.jYS = (ImageView) inflate.findViewById(R.id.signallforum_item_level);
            bVar.jYT = (TextView) inflate.findViewById(R.id.signallforum_item_exp);
            bVar.jYU = (FrameLayout) inflate.findViewById(R.id.signallforum_item_res_container);
            bVar.jYV = (TextView) inflate.findViewById(R.id.signallforum_item_days);
            bVar.jYW = (RelativeLayout) inflate.findViewById(R.id.signallforum_item_resign_container);
            bVar.jYX = (ImageView) inflate.findViewById(R.id.signallforum_item_resign_icon);
            bVar.jYY = (ProgressBar) inflate.findViewById(R.id.signallforum_item_resign_progress);
            bVar.jYZ = (TextView) inflate.findViewById(R.id.signallforum_item_resign_text);
            bVar.jZa = (TextView) inflate.findViewById(R.id.signallforum_item_error);
            bVar.jYQ = (LinearLayout) inflate.findViewById(R.id.signallforum_item_level_container);
            bVar.jZb = (TextView) inflate.findViewById(R.id.signallforum_item_increaseexp);
            inflate.setTag(bVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.jYI.getPageContext().getPageActivity()).inflate(R.layout.signallforum_header, (ViewGroup) null);
        a aVar = new a();
        aVar.jYN = (TextView) inflate2.findViewById(R.id.signallforum_head_title);
        aVar.jYO = (TextView) inflate2.findViewById(R.id.signallforum_head_res);
        inflate2.setTag(aVar);
        return inflate2;
    }

    private void a(View view, View view2, int i) {
        String str;
        this.jYI.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.jYI.getLayoutMode().onModeChanged(view);
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
            bVar.jYR.setText(str);
            am.setImageResource(bVar.jYS, BitmapHelper.getSmallGradeResourceIdNew(dVar.cIK()));
            bVar.jYT.setText(dVar.cIL() + "/" + dVar.cIM());
            bVar.jZb.clearAnimation();
            if (dVar.bdg()) {
                bVar.jYQ.setVisibility(0);
                bVar.jZa.setVisibility(8);
                bVar.jYV.setVisibility(0);
                bVar.jYW.setVisibility(8);
                bVar.jYV.setText(String.format(this.jYI.getPageContext().getString(R.string.signallforum_days), Integer.valueOf(dVar.cIJ())));
                if (dVar.cIQ()) {
                    bVar.jYT.setText(this.jYI.getPageContext().getString(R.string.signallforum_uplevel));
                    bVar.jZb.setVisibility(8);
                } else {
                    bVar.jYT.setText(dVar.cIL() + "/" + dVar.cIM());
                    bVar.jZb.setVisibility(0);
                }
                int cIP = dVar.cIP();
                if (cIP > 0) {
                    bVar.jZb.setVisibility(0);
                    bVar.jZb.setText("+" + cIP);
                } else {
                    bVar.jZb.setVisibility(8);
                }
            } else if (dVar.cIN()) {
                bVar.jYQ.setVisibility(0);
                bVar.jZa.setVisibility(8);
                bVar.jZb.setVisibility(8);
                bVar.jYV.setVisibility(8);
                bVar.jYW.setVisibility(0);
                if (dVar.cIO()) {
                    bVar.jYX.setVisibility(4);
                    bVar.jYY.setVisibility(0);
                    bVar.jYZ.setText(R.string.signallforum_resigning);
                } else {
                    bVar.jYX.setVisibility(0);
                    bVar.jYY.setVisibility(4);
                    bVar.jYZ.setText(R.string.signallforum_resign);
                }
                bVar.jYW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.signall.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        if (!dVar.cIO()) {
                            bVar.jYX.setVisibility(4);
                            bVar.jYY.setVisibility(0);
                            bVar.jYZ.setText(R.string.signallforum_resigning);
                            dVar.sB(true);
                            SignSingleModel signSingleModel = new SignSingleModel(g.this.jYI);
                            signSingleModel.a(g.this);
                            String str2 = dVar.getForumId() + "";
                            synchronized (g.this) {
                                g.this.jYJ.put(str2, signSingleModel);
                            }
                            signSingleModel.ex(dVar.getForumName(), str2);
                            TiebaStatic.log("signall_resign_click");
                        }
                    }
                });
            } else {
                bVar.jYV.setVisibility(8);
                bVar.jYW.setVisibility(8);
                bVar.jZb.setVisibility(8);
                bVar.jYQ.setVisibility(0);
                bVar.jZa.setVisibility(8);
            }
            String avatar = dVar.getAvatar();
            bVar.jYP.setTag(avatar);
            bVar.jYP.setPlaceHolder(1);
            bVar.jYP.startLoad(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (!this.gdR) {
            return bAU();
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
            this.jYI.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.jYI.getLayoutMode().onModeChanged(view2.findViewById(R.id.sign_all_forum_tip));
            aVar.jYN.setText(((com.baidu.tieba.signall.b) getItem(i)).getTitle());
            h(aVar.jYO, i);
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
        int level = this.jYo == null ? 7 : this.jYo.getLevel();
        if (this.fSt == null || this.fSt.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<d> it = this.fSt.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                d next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.cIK() >= level) {
                        if (next.bdg()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.bdg()) {
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
            format = String.format(this.jYI.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.jYI.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View bAU() {
        View inflate = LayoutInflater.from(this.jYI.getPageContext().getPageActivity()).inflate(R.layout.sign_all_forum_nodata_item, (ViewGroup) null);
        NoDataView a2 = NoDataViewFactory.a(this.jYI.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(R.id.sign_all_forum_no_data_view), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.FINDBAR, this.jYI.getResources().getDimensionPixelSize(R.dimen.tbds90)), NoDataViewFactory.d.cA(null, this.jYI.getResources().getString(R.string.no_bar_attentioned)), null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.jYI.getLayoutMode().setNightMode(skinType == 1);
        this.jYI.getLayoutMode().onModeChanged(inflate);
        a2.onChangeSkinType(this.jYI.getPageContext(), skinType);
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
        public BarImageView jYP;
        public LinearLayout jYQ;
        public TextView jYR;
        public ImageView jYS;
        public TextView jYT;
        public FrameLayout jYU;
        public TextView jYV;
        public RelativeLayout jYW;
        public ImageView jYX;
        public ProgressBar jYY;
        public TextView jYZ;
        public TextView jZa;
        public TextView jZb;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a {
        public TextView jYN;
        public TextView jYO;

        a() {
        }
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void c(SignData signData) {
        String str = signData.forumId;
        synchronized (this) {
            this.jYJ.remove(str);
        }
        a(str, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void ew(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            l.showToast(this.jYI.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.jYJ.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.fSt.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.fSt.get(i);
            if ((dVar.getForumId() + "").equals(str)) {
                dVar.sz(z);
                dVar.sA(!z);
                dVar.sB(false);
                if (z) {
                    dVar.Cf(signData.count_sign_num);
                    dVar.Ch(signData.sign_bonus_point);
                    dVar.Ce(1);
                    TbadkApplication.getInst().addSignedForum(dVar.getForumName(), signData.sign_bonus_point, -1);
                    ArrayList<d> cIA = this.jYo.cIA();
                    if (cIA.contains(dVar)) {
                        cIA.remove(dVar);
                        this.jYo.cIz().add(dVar);
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

    public void cIW() {
        this.isDestory = true;
        synchronized (this) {
            try {
                for (Map.Entry<String, SignSingleModel> entry : this.jYJ.entrySet()) {
                    entry.getValue().cJp();
                }
                this.jYJ.clear();
            }
        }
    }
}
