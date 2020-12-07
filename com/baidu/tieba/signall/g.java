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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
import com.baidu.tieba.signall.SignSingleModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes24.dex */
public class g extends BaseAdapter implements AbsListView.OnScrollListener, SignSingleModel.a {
    private c ncK;
    private boolean ncX;
    private SignAllForumActivity ndi;
    private ArrayList<d> isD = new ArrayList<>();
    private HashMap<String, SignSingleModel> ndj = new HashMap<>();
    private boolean iIs = true;

    public g(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.ndi = signAllForumActivity;
    }

    public void c(c cVar) {
        if (cVar != null) {
            this.ncK = cVar;
            this.isD = cVar.dMj();
            if (this.isD.size() == 0) {
                this.iIs = false;
            } else {
                this.iIs = true;
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
        if (this.iIs) {
            return this.isD.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.isD.size() > i) {
            return this.isD.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View KE(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.ndi.getPageContext().getPageActivity()).inflate(R.layout.signallforum_item, (ViewGroup) null);
            b bVar = new b();
            bVar.ndp = (BarImageView) inflate.findViewById(R.id.signallforum_item_avatar);
            bVar.ndp.setIsRound(false);
            bVar.ndp.setGifIconSupport(false);
            bVar.ndr = (TextView) inflate.findViewById(R.id.signallforum_item_name);
            bVar.gaW = (ImageView) inflate.findViewById(R.id.signallforum_item_level);
            bVar.nds = (TextView) inflate.findViewById(R.id.signallforum_item_exp);
            bVar.ndt = (FrameLayout) inflate.findViewById(R.id.signallforum_item_res_container);
            bVar.ndu = (TextView) inflate.findViewById(R.id.signallforum_item_days);
            bVar.ndv = (RelativeLayout) inflate.findViewById(R.id.signallforum_item_resign_container);
            bVar.ndw = (ImageView) inflate.findViewById(R.id.signallforum_item_resign_icon);
            bVar.ndx = (ProgressBar) inflate.findViewById(R.id.signallforum_item_resign_progress);
            bVar.ndy = (TextView) inflate.findViewById(R.id.signallforum_item_resign_text);
            bVar.ndz = (TextView) inflate.findViewById(R.id.signallforum_item_error);
            bVar.ndq = (LinearLayout) inflate.findViewById(R.id.signallforum_item_level_container);
            bVar.ndA = (TextView) inflate.findViewById(R.id.signallforum_item_increaseexp);
            inflate.setTag(bVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.ndi.getPageContext().getPageActivity()).inflate(R.layout.signallforum_header, (ViewGroup) null);
        a aVar = new a();
        aVar.ndn = (TextView) inflate2.findViewById(R.id.signallforum_head_title);
        aVar.ndo = (TextView) inflate2.findViewById(R.id.signallforum_head_res);
        inflate2.setTag(aVar);
        return inflate2;
    }

    private void a(View view, View view2, int i) {
        String str;
        this.ndi.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.ndi.getLayoutMode().onModeChanged(view);
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
            bVar.ndr.setText(str);
            ap.setImageResource(bVar.gaW, BitmapHelper.getSmallGradeResourceIdNew(dVar.bLB()));
            bVar.nds.setText(dVar.dMw() + "/" + dVar.dMx());
            bVar.ndA.clearAnimation();
            if (dVar.bSP()) {
                bVar.ndq.setVisibility(0);
                bVar.ndz.setVisibility(8);
                bVar.ndu.setVisibility(0);
                bVar.ndv.setVisibility(8);
                bVar.ndu.setText(String.format(this.ndi.getPageContext().getString(R.string.signallforum_days), Integer.valueOf(dVar.dMv())));
                if (dVar.dMB()) {
                    bVar.nds.setText(this.ndi.getPageContext().getString(R.string.signallforum_uplevel));
                    bVar.ndA.setVisibility(8);
                } else {
                    bVar.nds.setText(dVar.dMw() + "/" + dVar.dMx());
                    bVar.ndA.setVisibility(0);
                }
                int dMA = dVar.dMA();
                if (dMA > 0) {
                    bVar.ndA.setVisibility(0);
                    bVar.ndA.setText("+" + dMA);
                } else {
                    bVar.ndA.setVisibility(8);
                }
            } else if (dVar.dMy()) {
                bVar.ndq.setVisibility(0);
                bVar.ndz.setVisibility(8);
                bVar.ndA.setVisibility(8);
                bVar.ndu.setVisibility(8);
                bVar.ndv.setVisibility(0);
                if (dVar.dMz()) {
                    bVar.ndw.setVisibility(4);
                    bVar.ndx.setVisibility(0);
                    bVar.ndy.setText(R.string.signallforum_resigning);
                } else {
                    bVar.ndw.setVisibility(0);
                    bVar.ndx.setVisibility(4);
                    bVar.ndy.setText(R.string.signallforum_resign);
                }
                bVar.ndv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.signall.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        if (!dVar.dMz()) {
                            bVar.ndw.setVisibility(4);
                            bVar.ndx.setVisibility(0);
                            bVar.ndy.setText(R.string.signallforum_resigning);
                            dVar.xN(true);
                            SignSingleModel signSingleModel = new SignSingleModel(g.this.ndi);
                            signSingleModel.a(g.this);
                            String str2 = dVar.getForumId() + "";
                            synchronized (g.this) {
                                g.this.ndj.put(str2, signSingleModel);
                            }
                            signSingleModel.gp(dVar.getForumName(), str2);
                            TiebaStatic.log("signall_resign_click");
                        }
                    }
                });
            } else {
                bVar.ndu.setVisibility(8);
                bVar.ndv.setVisibility(8);
                bVar.ndA.setVisibility(8);
                bVar.ndq.setVisibility(0);
                bVar.ndz.setVisibility(8);
            }
            String avatar = dVar.getAvatar();
            bVar.ndp.setTag(avatar);
            bVar.ndp.setPlaceHolder(1);
            bVar.ndp.startLoad(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (!this.iIs) {
            return cyV();
        }
        int itemViewType = getItemViewType(i);
        View KE = view == null ? KE(itemViewType) : view;
        if (itemViewType == 1) {
            if (KE.getTag() != null && (KE.getTag() instanceof a)) {
                view2 = KE;
                aVar = (a) KE.getTag();
            } else {
                View KE2 = KE(itemViewType);
                view2 = KE2;
                aVar = (a) KE2.getTag();
            }
            this.ndi.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.ndi.getLayoutMode().onModeChanged(view2.findViewById(R.id.sign_all_forum_tip));
            aVar.ndn.setText(((com.baidu.tieba.signall.b) getItem(i)).getTitle());
            j(aVar.ndo, i);
            return view2;
        }
        if (KE.getTag() == null || !(KE.getTag() instanceof b)) {
            KE = KE(itemViewType);
        }
        a(KE, viewGroup, i);
        return KE;
    }

    private void j(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.ncK == null ? 7 : this.ncK.getLevel();
        if (this.isD == null || this.isD.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<d> it = this.isD.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                d next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.bLB() >= level) {
                        if (next.bSP()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.bSP()) {
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
            format = String.format(this.ndi.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.ndi.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View cyV() {
        View inflate = LayoutInflater.from(this.ndi.getPageContext().getPageActivity()).inflate(R.layout.sign_all_forum_nodata_item, (ViewGroup) null);
        NoDataView a2 = NoDataViewFactory.a(this.ndi.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(R.id.sign_all_forum_no_data_view), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.FINDBAR, this.ndi.getResources().getDimensionPixelSize(R.dimen.tbds90)), NoDataViewFactory.d.dZ(null, this.ndi.getResources().getString(R.string.no_bar_attentioned)), null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.ndi.getLayoutMode().setNightMode(skinType == 1);
        this.ndi.getLayoutMode().onModeChanged(inflate);
        a2.onChangeSkinType(this.ndi.getPageContext(), skinType);
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
    /* loaded from: classes24.dex */
    public class b {
        public ImageView gaW;
        public TextView ndA;
        public BarImageView ndp;
        public LinearLayout ndq;
        public TextView ndr;
        public TextView nds;
        public FrameLayout ndt;
        public TextView ndu;
        public RelativeLayout ndv;
        public ImageView ndw;
        public ProgressBar ndx;
        public TextView ndy;
        public TextView ndz;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes24.dex */
    public class a {
        public TextView ndn;
        public TextView ndo;

        a() {
        }
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void c(SignData signData) {
        String str = signData.forumId;
        synchronized (this) {
            this.ndj.remove(str);
        }
        a(str, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void go(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            l.showToast(this.ndi.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.ndj.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.isD.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.isD.get(i);
            if ((dVar.getForumId() + "").equals(str)) {
                dVar.xL(z);
                dVar.xM(!z);
                dVar.xN(false);
                if (z) {
                    dVar.KC(signData.count_sign_num);
                    dVar.KD(signData.sign_bonus_point);
                    dVar.KB(1);
                    TbadkApplication.getInst().addSignedForum(dVar.getForumName(), signData.sign_bonus_point, -1);
                    ArrayList<d> dMm = this.ncK.dMm();
                    if (dMm.contains(dVar)) {
                        dMm.remove(dVar);
                        this.ncK.dMl().add(dVar);
                    }
                } else {
                    dVar.setErrorMsg(str2);
                }
                if (!this.ncX) {
                    notifyDataSetChanged();
                    return;
                }
                return;
            }
        }
    }

    public void dMH() {
        this.ncX = true;
        synchronized (this) {
            try {
                for (Map.Entry<String, SignSingleModel> entry : this.ndj.entrySet()) {
                    entry.getValue().dNa();
                }
                this.ndj.clear();
            }
        }
    }
}
