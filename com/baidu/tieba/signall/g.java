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
/* loaded from: classes6.dex */
public class g extends BaseAdapter implements AbsListView.OnScrollListener, SignSingleModel.a {
    private boolean isDestory;
    private SignAllForumActivity jaD;
    private c jaj;
    private ArrayList<d> eWk = new ArrayList<>();
    private HashMap<String, SignSingleModel> jaE = new HashMap<>();
    private boolean fik = true;

    public g(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.jaD = signAllForumActivity;
    }

    public void c(c cVar) {
        if (cVar != null) {
            this.jaj = cVar;
            this.eWk = cVar.cnN();
            if (this.eWk.size() == 0) {
                this.fik = false;
            } else {
                this.fik = true;
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
        if (this.fik) {
            return this.eWk.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eWk.size() > i) {
            return this.eWk.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View AT(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.jaD.getPageContext().getPageActivity()).inflate(R.layout.signallforum_item, (ViewGroup) null);
            b bVar = new b();
            bVar.jaK = (BarImageView) inflate.findViewById(R.id.signallforum_item_avatar);
            bVar.jaK.setIsRound(false);
            bVar.jaK.setGifIconSupport(false);
            bVar.jaM = (TextView) inflate.findViewById(R.id.signallforum_item_name);
            bVar.jaN = (ImageView) inflate.findViewById(R.id.signallforum_item_level);
            bVar.jaO = (TextView) inflate.findViewById(R.id.signallforum_item_exp);
            bVar.jaP = (FrameLayout) inflate.findViewById(R.id.signallforum_item_res_container);
            bVar.jaQ = (TextView) inflate.findViewById(R.id.signallforum_item_days);
            bVar.jaR = (RelativeLayout) inflate.findViewById(R.id.signallforum_item_resign_container);
            bVar.jaS = (ImageView) inflate.findViewById(R.id.signallforum_item_resign_icon);
            bVar.jaT = (ProgressBar) inflate.findViewById(R.id.signallforum_item_resign_progress);
            bVar.jaU = (TextView) inflate.findViewById(R.id.signallforum_item_resign_text);
            bVar.jaV = (TextView) inflate.findViewById(R.id.signallforum_item_error);
            bVar.jaL = (LinearLayout) inflate.findViewById(R.id.signallforum_item_level_container);
            bVar.jaW = (TextView) inflate.findViewById(R.id.signallforum_item_increaseexp);
            inflate.setTag(bVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.jaD.getPageContext().getPageActivity()).inflate(R.layout.signallforum_header, (ViewGroup) null);
        a aVar = new a();
        aVar.jaI = (TextView) inflate2.findViewById(R.id.signallforum_head_title);
        aVar.jaJ = (TextView) inflate2.findViewById(R.id.signallforum_head_res);
        inflate2.setTag(aVar);
        return inflate2;
    }

    private void a(View view, View view2, int i) {
        String str;
        this.jaD.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.jaD.getLayoutMode().onModeChanged(view);
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
                        str = forumName.substring(0, i3) + "...";
                        break;
                    }
                }
            }
            str = forumName;
            bVar.jaM.setText(str);
            am.c(bVar.jaN, BitmapHelper.getSmallGradeResourceIdNew(dVar.coa()));
            bVar.jaO.setText(dVar.cob() + "/" + dVar.coc());
            bVar.jaW.clearAnimation();
            if (dVar.aKD()) {
                bVar.jaL.setVisibility(0);
                bVar.jaV.setVisibility(8);
                bVar.jaQ.setVisibility(0);
                bVar.jaR.setVisibility(8);
                bVar.jaQ.setText(String.format(this.jaD.getPageContext().getString(R.string.signallforum_days), Integer.valueOf(dVar.cnZ())));
                if (dVar.cog()) {
                    bVar.jaO.setText(this.jaD.getPageContext().getString(R.string.signallforum_uplevel));
                    bVar.jaW.setVisibility(8);
                } else {
                    bVar.jaO.setText(dVar.cob() + "/" + dVar.coc());
                    bVar.jaW.setVisibility(0);
                }
                int cof = dVar.cof();
                if (cof > 0) {
                    bVar.jaW.setVisibility(0);
                    bVar.jaW.setText("+" + cof);
                } else {
                    bVar.jaW.setVisibility(8);
                }
            } else if (dVar.cod()) {
                bVar.jaL.setVisibility(0);
                bVar.jaV.setVisibility(8);
                bVar.jaW.setVisibility(8);
                bVar.jaQ.setVisibility(8);
                bVar.jaR.setVisibility(0);
                if (dVar.coe()) {
                    bVar.jaS.setVisibility(4);
                    bVar.jaT.setVisibility(0);
                    bVar.jaU.setText(R.string.signallforum_resigning);
                } else {
                    bVar.jaS.setVisibility(0);
                    bVar.jaT.setVisibility(4);
                    bVar.jaU.setText(R.string.signallforum_resign);
                }
                bVar.jaR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.signall.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        if (!dVar.coe()) {
                            bVar.jaS.setVisibility(4);
                            bVar.jaT.setVisibility(0);
                            bVar.jaU.setText(R.string.signallforum_resigning);
                            dVar.qU(true);
                            SignSingleModel signSingleModel = new SignSingleModel(g.this.jaD);
                            signSingleModel.a(g.this);
                            String str2 = dVar.getForumId() + "";
                            synchronized (g.this) {
                                g.this.jaE.put(str2, signSingleModel);
                            }
                            signSingleModel.eh(dVar.getForumName(), str2);
                            TiebaStatic.log("signall_resign_click");
                        }
                    }
                });
            } else {
                bVar.jaQ.setVisibility(8);
                bVar.jaR.setVisibility(8);
                bVar.jaW.setVisibility(8);
                bVar.jaL.setVisibility(0);
                bVar.jaV.setVisibility(8);
            }
            String avatar = dVar.getAvatar();
            bVar.jaK.setTag(avatar);
            bVar.jaK.startLoad(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (!this.fik) {
            return bjd();
        }
        int itemViewType = getItemViewType(i);
        View AT = view == null ? AT(itemViewType) : view;
        if (itemViewType == 1) {
            if (AT.getTag() != null && (AT.getTag() instanceof a)) {
                view2 = AT;
                aVar = (a) AT.getTag();
            } else {
                View AT2 = AT(itemViewType);
                view2 = AT2;
                aVar = (a) AT2.getTag();
            }
            this.jaD.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.jaD.getLayoutMode().onModeChanged(view2.findViewById(R.id.sign_all_forum_tip));
            aVar.jaI.setText(((com.baidu.tieba.signall.b) getItem(i)).getTitle());
            n(aVar.jaJ, i);
            return view2;
        }
        if (AT.getTag() == null || !(AT.getTag() instanceof b)) {
            AT = AT(itemViewType);
        }
        a(AT, viewGroup, i);
        return AT;
    }

    private void n(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.jaj == null ? 7 : this.jaj.getLevel();
        if (this.eWk == null || this.eWk.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<d> it = this.eWk.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                d next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.coa() >= level) {
                        if (next.aKD()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.aKD()) {
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
            format = String.format(this.jaD.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.jaD.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View bjd() {
        View inflate = LayoutInflater.from(this.jaD.getPageContext().getPageActivity()).inflate(R.layout.sign_all_forum_nodata_item, (ViewGroup) null);
        NoDataView a2 = NoDataViewFactory.a(this.jaD.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(R.id.sign_all_forum_no_data_view), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, 0), NoDataViewFactory.d.ag(R.string.sign_all_forum_nodata_tip, R.string.sign_all_forum_nodata_guide), null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.jaD.getLayoutMode().setNightMode(skinType == 1);
        this.jaD.getLayoutMode().onModeChanged(inflate);
        a2.onChangeSkinType(this.jaD.getPageContext(), skinType);
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
    /* loaded from: classes6.dex */
    public class b {
        public BarImageView jaK;
        public LinearLayout jaL;
        public TextView jaM;
        public ImageView jaN;
        public TextView jaO;
        public FrameLayout jaP;
        public TextView jaQ;
        public RelativeLayout jaR;
        public ImageView jaS;
        public ProgressBar jaT;
        public TextView jaU;
        public TextView jaV;
        public TextView jaW;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a {
        public TextView jaI;
        public TextView jaJ;

        a() {
        }
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void b(SignData signData) {
        String str = signData.forumId;
        synchronized (this) {
            this.jaE.remove(str);
        }
        a(str, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void eg(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            l.showToast(this.jaD.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.jaE.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.eWk.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.eWk.get(i);
            if ((dVar.getForumId() + "").equals(str)) {
                dVar.qS(z);
                dVar.qT(!z);
                dVar.qU(false);
                if (z) {
                    dVar.AQ(signData.count_sign_num);
                    dVar.AS(signData.sign_bonus_point);
                    dVar.AP(1);
                    TbadkApplication.getInst().addSignedForum(dVar.getForumName(), signData.sign_bonus_point, -1);
                    ArrayList<d> cnQ = this.jaj.cnQ();
                    if (cnQ.contains(dVar)) {
                        cnQ.remove(dVar);
                        this.jaj.cnP().add(dVar);
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

    public void com() {
        this.isDestory = true;
        synchronized (this) {
            try {
                for (Map.Entry<String, SignSingleModel> entry : this.jaE.entrySet()) {
                    entry.getValue().coF();
                }
                this.jaE.clear();
            }
        }
    }
}
