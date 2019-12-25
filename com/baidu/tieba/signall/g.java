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
/* loaded from: classes8.dex */
public class g extends BaseAdapter implements AbsListView.OnScrollListener, SignSingleModel.a {
    private boolean isDestory;
    private c jTG;
    private SignAllForumActivity jUa;
    private ArrayList<d> fMN = new ArrayList<>();
    private HashMap<String, SignSingleModel> jUb = new HashMap<>();
    private boolean fYF = true;

    public g(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.jUa = signAllForumActivity;
    }

    public void c(c cVar) {
        if (cVar != null) {
            this.jTG = cVar;
            this.fMN = cVar.cFL();
            if (this.fMN.size() == 0) {
                this.fYF = false;
            } else {
                this.fYF = true;
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
        if (this.fYF) {
            return this.fMN.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.fMN.size() > i) {
            return this.fMN.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View BW(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.jUa.getPageContext().getPageActivity()).inflate(R.layout.signallforum_item, (ViewGroup) null);
            b bVar = new b();
            bVar.jUh = (BarImageView) inflate.findViewById(R.id.signallforum_item_avatar);
            bVar.jUh.setIsRound(false);
            bVar.jUh.setGifIconSupport(false);
            bVar.jUj = (TextView) inflate.findViewById(R.id.signallforum_item_name);
            bVar.jUk = (ImageView) inflate.findViewById(R.id.signallforum_item_level);
            bVar.jUl = (TextView) inflate.findViewById(R.id.signallforum_item_exp);
            bVar.jUm = (FrameLayout) inflate.findViewById(R.id.signallforum_item_res_container);
            bVar.jUn = (TextView) inflate.findViewById(R.id.signallforum_item_days);
            bVar.jUo = (RelativeLayout) inflate.findViewById(R.id.signallforum_item_resign_container);
            bVar.jUp = (ImageView) inflate.findViewById(R.id.signallforum_item_resign_icon);
            bVar.jUq = (ProgressBar) inflate.findViewById(R.id.signallforum_item_resign_progress);
            bVar.jUr = (TextView) inflate.findViewById(R.id.signallforum_item_resign_text);
            bVar.jUs = (TextView) inflate.findViewById(R.id.signallforum_item_error);
            bVar.jUi = (LinearLayout) inflate.findViewById(R.id.signallforum_item_level_container);
            bVar.jUt = (TextView) inflate.findViewById(R.id.signallforum_item_increaseexp);
            inflate.setTag(bVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.jUa.getPageContext().getPageActivity()).inflate(R.layout.signallforum_header, (ViewGroup) null);
        a aVar = new a();
        aVar.jUf = (TextView) inflate2.findViewById(R.id.signallforum_head_title);
        aVar.jUg = (TextView) inflate2.findViewById(R.id.signallforum_head_res);
        inflate2.setTag(aVar);
        return inflate2;
    }

    private void a(View view, View view2, int i) {
        String str;
        this.jUa.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.jUa.getLayoutMode().onModeChanged(view);
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
            bVar.jUj.setText(str);
            am.setImageResource(bVar.jUk, BitmapHelper.getSmallGradeResourceIdNew(dVar.cFY()));
            bVar.jUl.setText(dVar.cFZ() + "/" + dVar.cGa());
            bVar.jUt.clearAnimation();
            if (dVar.bau()) {
                bVar.jUi.setVisibility(0);
                bVar.jUs.setVisibility(8);
                bVar.jUn.setVisibility(0);
                bVar.jUo.setVisibility(8);
                bVar.jUn.setText(String.format(this.jUa.getPageContext().getString(R.string.signallforum_days), Integer.valueOf(dVar.cFX())));
                if (dVar.cGe()) {
                    bVar.jUl.setText(this.jUa.getPageContext().getString(R.string.signallforum_uplevel));
                    bVar.jUt.setVisibility(8);
                } else {
                    bVar.jUl.setText(dVar.cFZ() + "/" + dVar.cGa());
                    bVar.jUt.setVisibility(0);
                }
                int cGd = dVar.cGd();
                if (cGd > 0) {
                    bVar.jUt.setVisibility(0);
                    bVar.jUt.setText("+" + cGd);
                } else {
                    bVar.jUt.setVisibility(8);
                }
            } else if (dVar.cGb()) {
                bVar.jUi.setVisibility(0);
                bVar.jUs.setVisibility(8);
                bVar.jUt.setVisibility(8);
                bVar.jUn.setVisibility(8);
                bVar.jUo.setVisibility(0);
                if (dVar.cGc()) {
                    bVar.jUp.setVisibility(4);
                    bVar.jUq.setVisibility(0);
                    bVar.jUr.setText(R.string.signallforum_resigning);
                } else {
                    bVar.jUp.setVisibility(0);
                    bVar.jUq.setVisibility(4);
                    bVar.jUr.setText(R.string.signallforum_resign);
                }
                bVar.jUo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.signall.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        if (!dVar.cGc()) {
                            bVar.jUp.setVisibility(4);
                            bVar.jUq.setVisibility(0);
                            bVar.jUr.setText(R.string.signallforum_resigning);
                            dVar.sl(true);
                            SignSingleModel signSingleModel = new SignSingleModel(g.this.jUa);
                            signSingleModel.a(g.this);
                            String str2 = dVar.getForumId() + "";
                            synchronized (g.this) {
                                g.this.jUb.put(str2, signSingleModel);
                            }
                            signSingleModel.em(dVar.getForumName(), str2);
                            TiebaStatic.log("signall_resign_click");
                        }
                    }
                });
            } else {
                bVar.jUn.setVisibility(8);
                bVar.jUo.setVisibility(8);
                bVar.jUt.setVisibility(8);
                bVar.jUi.setVisibility(0);
                bVar.jUs.setVisibility(8);
            }
            String avatar = dVar.getAvatar();
            bVar.jUh.setTag(avatar);
            bVar.jUh.startLoad(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (!this.fYF) {
            return byo();
        }
        int itemViewType = getItemViewType(i);
        View BW = view == null ? BW(itemViewType) : view;
        if (itemViewType == 1) {
            if (BW.getTag() != null && (BW.getTag() instanceof a)) {
                view2 = BW;
                aVar = (a) BW.getTag();
            } else {
                View BW2 = BW(itemViewType);
                view2 = BW2;
                aVar = (a) BW2.getTag();
            }
            this.jUa.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.jUa.getLayoutMode().onModeChanged(view2.findViewById(R.id.sign_all_forum_tip));
            aVar.jUf.setText(((com.baidu.tieba.signall.b) getItem(i)).getTitle());
            h(aVar.jUg, i);
            return view2;
        }
        if (BW.getTag() == null || !(BW.getTag() instanceof b)) {
            BW = BW(itemViewType);
        }
        a(BW, viewGroup, i);
        return BW;
    }

    private void h(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.jTG == null ? 7 : this.jTG.getLevel();
        if (this.fMN == null || this.fMN.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<d> it = this.fMN.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                d next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.cFY() >= level) {
                        if (next.bau()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.bau()) {
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
            format = String.format(this.jUa.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.jUa.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View byo() {
        View inflate = LayoutInflater.from(this.jUa.getPageContext().getPageActivity()).inflate(R.layout.sign_all_forum_nodata_item, (ViewGroup) null);
        NoDataView a2 = NoDataViewFactory.a(this.jUa.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(R.id.sign_all_forum_no_data_view), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.FINDBAR, this.jUa.getResources().getDimensionPixelSize(R.dimen.tbds90)), NoDataViewFactory.d.cr(null, this.jUa.getResources().getString(R.string.no_bar_attentioned)), null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.jUa.getLayoutMode().setNightMode(skinType == 1);
        this.jUa.getLayoutMode().onModeChanged(inflate);
        a2.onChangeSkinType(this.jUa.getPageContext(), skinType);
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
    /* loaded from: classes8.dex */
    public class b {
        public BarImageView jUh;
        public LinearLayout jUi;
        public TextView jUj;
        public ImageView jUk;
        public TextView jUl;
        public FrameLayout jUm;
        public TextView jUn;
        public RelativeLayout jUo;
        public ImageView jUp;
        public ProgressBar jUq;
        public TextView jUr;
        public TextView jUs;
        public TextView jUt;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public class a {
        public TextView jUf;
        public TextView jUg;

        a() {
        }
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void c(SignData signData) {
        String str = signData.forumId;
        synchronized (this) {
            this.jUb.remove(str);
        }
        a(str, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void el(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            l.showToast(this.jUa.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.jUb.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.fMN.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.fMN.get(i);
            if ((dVar.getForumId() + "").equals(str)) {
                dVar.sj(z);
                dVar.sk(!z);
                dVar.sl(false);
                if (z) {
                    dVar.BT(signData.count_sign_num);
                    dVar.BV(signData.sign_bonus_point);
                    dVar.BS(1);
                    TbadkApplication.getInst().addSignedForum(dVar.getForumName(), signData.sign_bonus_point, -1);
                    ArrayList<d> cFO = this.jTG.cFO();
                    if (cFO.contains(dVar)) {
                        cFO.remove(dVar);
                        this.jTG.cFN().add(dVar);
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

    public void cGk() {
        this.isDestory = true;
        synchronized (this) {
            try {
                for (Map.Entry<String, SignSingleModel> entry : this.jUb.entrySet()) {
                    entry.getValue().cGD();
                }
                this.jUb.clear();
            }
        }
    }
}
