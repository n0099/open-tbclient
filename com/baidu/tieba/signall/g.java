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
    private c lbJ;
    private SignAllForumActivity lcg;
    private ArrayList<d> gMN = new ArrayList<>();
    private HashMap<String, SignSingleModel> lch = new HashMap<>();
    private boolean hcN = true;

    public g(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.lcg = signAllForumActivity;
    }

    public void c(c cVar) {
        if (cVar != null) {
            this.lbJ = cVar;
            this.gMN = cVar.dax();
            if (this.gMN.size() == 0) {
                this.hcN = false;
            } else {
                this.hcN = true;
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
        if (this.hcN) {
            return this.gMN.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.gMN.size() > i) {
            return this.gMN.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View DA(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.lcg.getPageContext().getPageActivity()).inflate(R.layout.signallforum_item, (ViewGroup) null);
            b bVar = new b();
            bVar.lcn = (BarImageView) inflate.findViewById(R.id.signallforum_item_avatar);
            bVar.lcn.setIsRound(false);
            bVar.lcn.setGifIconSupport(false);
            bVar.lcp = (TextView) inflate.findViewById(R.id.signallforum_item_name);
            bVar.lcq = (ImageView) inflate.findViewById(R.id.signallforum_item_level);
            bVar.lcr = (TextView) inflate.findViewById(R.id.signallforum_item_exp);
            bVar.lcs = (FrameLayout) inflate.findViewById(R.id.signallforum_item_res_container);
            bVar.lct = (TextView) inflate.findViewById(R.id.signallforum_item_days);
            bVar.lcu = (RelativeLayout) inflate.findViewById(R.id.signallforum_item_resign_container);
            bVar.lcv = (ImageView) inflate.findViewById(R.id.signallforum_item_resign_icon);
            bVar.lcw = (ProgressBar) inflate.findViewById(R.id.signallforum_item_resign_progress);
            bVar.lcx = (TextView) inflate.findViewById(R.id.signallforum_item_resign_text);
            bVar.lcy = (TextView) inflate.findViewById(R.id.signallforum_item_error);
            bVar.lco = (LinearLayout) inflate.findViewById(R.id.signallforum_item_level_container);
            bVar.lcz = (TextView) inflate.findViewById(R.id.signallforum_item_increaseexp);
            inflate.setTag(bVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.lcg.getPageContext().getPageActivity()).inflate(R.layout.signallforum_header, (ViewGroup) null);
        a aVar = new a();
        aVar.lcl = (TextView) inflate2.findViewById(R.id.signallforum_head_title);
        aVar.lcm = (TextView) inflate2.findViewById(R.id.signallforum_head_res);
        inflate2.setTag(aVar);
        return inflate2;
    }

    private void a(View view, View view2, int i) {
        String str;
        this.lcg.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.lcg.getLayoutMode().onModeChanged(view);
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
            bVar.lcp.setText(str);
            am.setImageResource(bVar.lcq, BitmapHelper.getSmallGradeResourceIdNew(dVar.daK()));
            bVar.lcr.setText(dVar.daL() + "/" + dVar.daM());
            bVar.lcz.clearAnimation();
            if (dVar.brz()) {
                bVar.lco.setVisibility(0);
                bVar.lcy.setVisibility(8);
                bVar.lct.setVisibility(0);
                bVar.lcu.setVisibility(8);
                bVar.lct.setText(String.format(this.lcg.getPageContext().getString(R.string.signallforum_days), Integer.valueOf(dVar.daJ())));
                if (dVar.daQ()) {
                    bVar.lcr.setText(this.lcg.getPageContext().getString(R.string.signallforum_uplevel));
                    bVar.lcz.setVisibility(8);
                } else {
                    bVar.lcr.setText(dVar.daL() + "/" + dVar.daM());
                    bVar.lcz.setVisibility(0);
                }
                int daP = dVar.daP();
                if (daP > 0) {
                    bVar.lcz.setVisibility(0);
                    bVar.lcz.setText("+" + daP);
                } else {
                    bVar.lcz.setVisibility(8);
                }
            } else if (dVar.daN()) {
                bVar.lco.setVisibility(0);
                bVar.lcy.setVisibility(8);
                bVar.lcz.setVisibility(8);
                bVar.lct.setVisibility(8);
                bVar.lcu.setVisibility(0);
                if (dVar.daO()) {
                    bVar.lcv.setVisibility(4);
                    bVar.lcw.setVisibility(0);
                    bVar.lcx.setText(R.string.signallforum_resigning);
                } else {
                    bVar.lcv.setVisibility(0);
                    bVar.lcw.setVisibility(4);
                    bVar.lcx.setText(R.string.signallforum_resign);
                }
                bVar.lcu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.signall.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        if (!dVar.daO()) {
                            bVar.lcv.setVisibility(4);
                            bVar.lcw.setVisibility(0);
                            bVar.lcx.setText(R.string.signallforum_resigning);
                            dVar.ug(true);
                            SignSingleModel signSingleModel = new SignSingleModel(g.this.lcg);
                            signSingleModel.a(g.this);
                            String str2 = dVar.getForumId() + "";
                            synchronized (g.this) {
                                g.this.lch.put(str2, signSingleModel);
                            }
                            signSingleModel.fl(dVar.getForumName(), str2);
                            TiebaStatic.log("signall_resign_click");
                        }
                    }
                });
            } else {
                bVar.lct.setVisibility(8);
                bVar.lcu.setVisibility(8);
                bVar.lcz.setVisibility(8);
                bVar.lco.setVisibility(0);
                bVar.lcy.setVisibility(8);
            }
            String avatar = dVar.getAvatar();
            bVar.lcn.setTag(avatar);
            bVar.lcn.setPlaceHolder(1);
            bVar.lcn.startLoad(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (!this.hcN) {
            return bRV();
        }
        int itemViewType = getItemViewType(i);
        View DA = view == null ? DA(itemViewType) : view;
        if (itemViewType == 1) {
            if (DA.getTag() != null && (DA.getTag() instanceof a)) {
                view2 = DA;
                aVar = (a) DA.getTag();
            } else {
                View DA2 = DA(itemViewType);
                view2 = DA2;
                aVar = (a) DA2.getTag();
            }
            this.lcg.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.lcg.getLayoutMode().onModeChanged(view2.findViewById(R.id.sign_all_forum_tip));
            aVar.lcl.setText(((com.baidu.tieba.signall.b) getItem(i)).getTitle());
            i(aVar.lcm, i);
            return view2;
        }
        if (DA.getTag() == null || !(DA.getTag() instanceof b)) {
            DA = DA(itemViewType);
        }
        a(DA, viewGroup, i);
        return DA;
    }

    private void i(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.lbJ == null ? 7 : this.lbJ.getLevel();
        if (this.gMN == null || this.gMN.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<d> it = this.gMN.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                d next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.daK() >= level) {
                        if (next.brz()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.brz()) {
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
            format = String.format(this.lcg.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.lcg.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View bRV() {
        View inflate = LayoutInflater.from(this.lcg.getPageContext().getPageActivity()).inflate(R.layout.sign_all_forum_nodata_item, (ViewGroup) null);
        NoDataView a2 = NoDataViewFactory.a(this.lcg.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(R.id.sign_all_forum_no_data_view), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.FINDBAR, this.lcg.getResources().getDimensionPixelSize(R.dimen.tbds90)), NoDataViewFactory.d.dj(null, this.lcg.getResources().getString(R.string.no_bar_attentioned)), null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.lcg.getLayoutMode().setNightMode(skinType == 1);
        this.lcg.getLayoutMode().onModeChanged(inflate);
        a2.onChangeSkinType(this.lcg.getPageContext(), skinType);
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
        public BarImageView lcn;
        public LinearLayout lco;
        public TextView lcp;
        public ImageView lcq;
        public TextView lcr;
        public FrameLayout lcs;
        public TextView lct;
        public RelativeLayout lcu;
        public ImageView lcv;
        public ProgressBar lcw;
        public TextView lcx;
        public TextView lcy;
        public TextView lcz;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a {
        public TextView lcl;
        public TextView lcm;

        a() {
        }
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void c(SignData signData) {
        String str = signData.forumId;
        synchronized (this) {
            this.lch.remove(str);
        }
        a(str, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void fk(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            l.showToast(this.lcg.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.lch.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.gMN.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.gMN.get(i);
            if ((dVar.getForumId() + "").equals(str)) {
                dVar.ue(z);
                dVar.uf(!z);
                dVar.ug(false);
                if (z) {
                    dVar.Dx(signData.count_sign_num);
                    dVar.Dz(signData.sign_bonus_point);
                    dVar.Dw(1);
                    TbadkApplication.getInst().addSignedForum(dVar.getForumName(), signData.sign_bonus_point, -1);
                    ArrayList<d> daA = this.lbJ.daA();
                    if (daA.contains(dVar)) {
                        daA.remove(dVar);
                        this.lbJ.daz().add(dVar);
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

    public void daX() {
        this.isDestory = true;
        synchronized (this) {
            try {
                for (Map.Entry<String, SignSingleModel> entry : this.lch.entrySet()) {
                    entry.getValue().dbq();
                }
                this.lch.clear();
            }
        }
    }
}
