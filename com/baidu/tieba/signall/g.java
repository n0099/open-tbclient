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
    private c lcS;
    private SignAllForumActivity ldp;
    private ArrayList<d> gMY = new ArrayList<>();
    private HashMap<String, SignSingleModel> ldq = new HashMap<>();
    private boolean hcY = true;

    public g(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.ldp = signAllForumActivity;
    }

    public void c(c cVar) {
        if (cVar != null) {
            this.lcS = cVar;
            this.gMY = cVar.daN();
            if (this.gMY.size() == 0) {
                this.hcY = false;
            } else {
                this.hcY = true;
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
        if (this.hcY) {
            return this.gMY.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.gMY.size() > i) {
            return this.gMY.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View DC(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.ldp.getPageContext().getPageActivity()).inflate(R.layout.signallforum_item, (ViewGroup) null);
            b bVar = new b();
            bVar.ldw = (BarImageView) inflate.findViewById(R.id.signallforum_item_avatar);
            bVar.ldw.setIsRound(false);
            bVar.ldw.setGifIconSupport(false);
            bVar.ldy = (TextView) inflate.findViewById(R.id.signallforum_item_name);
            bVar.ldz = (ImageView) inflate.findViewById(R.id.signallforum_item_level);
            bVar.ldA = (TextView) inflate.findViewById(R.id.signallforum_item_exp);
            bVar.ldB = (FrameLayout) inflate.findViewById(R.id.signallforum_item_res_container);
            bVar.ldC = (TextView) inflate.findViewById(R.id.signallforum_item_days);
            bVar.ldD = (RelativeLayout) inflate.findViewById(R.id.signallforum_item_resign_container);
            bVar.ldE = (ImageView) inflate.findViewById(R.id.signallforum_item_resign_icon);
            bVar.ldF = (ProgressBar) inflate.findViewById(R.id.signallforum_item_resign_progress);
            bVar.ldG = (TextView) inflate.findViewById(R.id.signallforum_item_resign_text);
            bVar.ldH = (TextView) inflate.findViewById(R.id.signallforum_item_error);
            bVar.ldx = (LinearLayout) inflate.findViewById(R.id.signallforum_item_level_container);
            bVar.ldI = (TextView) inflate.findViewById(R.id.signallforum_item_increaseexp);
            inflate.setTag(bVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.ldp.getPageContext().getPageActivity()).inflate(R.layout.signallforum_header, (ViewGroup) null);
        a aVar = new a();
        aVar.ldu = (TextView) inflate2.findViewById(R.id.signallforum_head_title);
        aVar.ldv = (TextView) inflate2.findViewById(R.id.signallforum_head_res);
        inflate2.setTag(aVar);
        return inflate2;
    }

    private void a(View view, View view2, int i) {
        String str;
        this.ldp.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.ldp.getLayoutMode().onModeChanged(view);
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
            bVar.ldy.setText(str);
            am.setImageResource(bVar.ldz, BitmapHelper.getSmallGradeResourceIdNew(dVar.dba()));
            bVar.ldA.setText(dVar.dbb() + "/" + dVar.dbc());
            bVar.ldI.clearAnimation();
            if (dVar.brB()) {
                bVar.ldx.setVisibility(0);
                bVar.ldH.setVisibility(8);
                bVar.ldC.setVisibility(0);
                bVar.ldD.setVisibility(8);
                bVar.ldC.setText(String.format(this.ldp.getPageContext().getString(R.string.signallforum_days), Integer.valueOf(dVar.daZ())));
                if (dVar.dbg()) {
                    bVar.ldA.setText(this.ldp.getPageContext().getString(R.string.signallforum_uplevel));
                    bVar.ldI.setVisibility(8);
                } else {
                    bVar.ldA.setText(dVar.dbb() + "/" + dVar.dbc());
                    bVar.ldI.setVisibility(0);
                }
                int dbf = dVar.dbf();
                if (dbf > 0) {
                    bVar.ldI.setVisibility(0);
                    bVar.ldI.setText("+" + dbf);
                } else {
                    bVar.ldI.setVisibility(8);
                }
            } else if (dVar.dbd()) {
                bVar.ldx.setVisibility(0);
                bVar.ldH.setVisibility(8);
                bVar.ldI.setVisibility(8);
                bVar.ldC.setVisibility(8);
                bVar.ldD.setVisibility(0);
                if (dVar.dbe()) {
                    bVar.ldE.setVisibility(4);
                    bVar.ldF.setVisibility(0);
                    bVar.ldG.setText(R.string.signallforum_resigning);
                } else {
                    bVar.ldE.setVisibility(0);
                    bVar.ldF.setVisibility(4);
                    bVar.ldG.setText(R.string.signallforum_resign);
                }
                bVar.ldD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.signall.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        if (!dVar.dbe()) {
                            bVar.ldE.setVisibility(4);
                            bVar.ldF.setVisibility(0);
                            bVar.ldG.setText(R.string.signallforum_resigning);
                            dVar.ug(true);
                            SignSingleModel signSingleModel = new SignSingleModel(g.this.ldp);
                            signSingleModel.a(g.this);
                            String str2 = dVar.getForumId() + "";
                            synchronized (g.this) {
                                g.this.ldq.put(str2, signSingleModel);
                            }
                            signSingleModel.fl(dVar.getForumName(), str2);
                            TiebaStatic.log("signall_resign_click");
                        }
                    }
                });
            } else {
                bVar.ldC.setVisibility(8);
                bVar.ldD.setVisibility(8);
                bVar.ldI.setVisibility(8);
                bVar.ldx.setVisibility(0);
                bVar.ldH.setVisibility(8);
            }
            String avatar = dVar.getAvatar();
            bVar.ldw.setTag(avatar);
            bVar.ldw.setPlaceHolder(1);
            bVar.ldw.startLoad(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (!this.hcY) {
            return bRX();
        }
        int itemViewType = getItemViewType(i);
        View DC = view == null ? DC(itemViewType) : view;
        if (itemViewType == 1) {
            if (DC.getTag() != null && (DC.getTag() instanceof a)) {
                view2 = DC;
                aVar = (a) DC.getTag();
            } else {
                View DC2 = DC(itemViewType);
                view2 = DC2;
                aVar = (a) DC2.getTag();
            }
            this.ldp.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.ldp.getLayoutMode().onModeChanged(view2.findViewById(R.id.sign_all_forum_tip));
            aVar.ldu.setText(((com.baidu.tieba.signall.b) getItem(i)).getTitle());
            i(aVar.ldv, i);
            return view2;
        }
        if (DC.getTag() == null || !(DC.getTag() instanceof b)) {
            DC = DC(itemViewType);
        }
        a(DC, viewGroup, i);
        return DC;
    }

    private void i(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.lcS == null ? 7 : this.lcS.getLevel();
        if (this.gMY == null || this.gMY.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<d> it = this.gMY.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                d next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.dba() >= level) {
                        if (next.brB()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.brB()) {
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
            format = String.format(this.ldp.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.ldp.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View bRX() {
        View inflate = LayoutInflater.from(this.ldp.getPageContext().getPageActivity()).inflate(R.layout.sign_all_forum_nodata_item, (ViewGroup) null);
        NoDataView a2 = NoDataViewFactory.a(this.ldp.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(R.id.sign_all_forum_no_data_view), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.FINDBAR, this.ldp.getResources().getDimensionPixelSize(R.dimen.tbds90)), NoDataViewFactory.d.dj(null, this.ldp.getResources().getString(R.string.no_bar_attentioned)), null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.ldp.getLayoutMode().setNightMode(skinType == 1);
        this.ldp.getLayoutMode().onModeChanged(inflate);
        a2.onChangeSkinType(this.ldp.getPageContext(), skinType);
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
        public TextView ldA;
        public FrameLayout ldB;
        public TextView ldC;
        public RelativeLayout ldD;
        public ImageView ldE;
        public ProgressBar ldF;
        public TextView ldG;
        public TextView ldH;
        public TextView ldI;
        public BarImageView ldw;
        public LinearLayout ldx;
        public TextView ldy;
        public ImageView ldz;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a {
        public TextView ldu;
        public TextView ldv;

        a() {
        }
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void c(SignData signData) {
        String str = signData.forumId;
        synchronized (this) {
            this.ldq.remove(str);
        }
        a(str, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void fk(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            l.showToast(this.ldp.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.ldq.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.gMY.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.gMY.get(i);
            if ((dVar.getForumId() + "").equals(str)) {
                dVar.ue(z);
                dVar.uf(!z);
                dVar.ug(false);
                if (z) {
                    dVar.Dz(signData.count_sign_num);
                    dVar.DB(signData.sign_bonus_point);
                    dVar.Dy(1);
                    TbadkApplication.getInst().addSignedForum(dVar.getForumName(), signData.sign_bonus_point, -1);
                    ArrayList<d> daQ = this.lcS.daQ();
                    if (daQ.contains(dVar)) {
                        daQ.remove(dVar);
                        this.lcS.daP().add(dVar);
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

    public void dbn() {
        this.isDestory = true;
        synchronized (this) {
            try {
                for (Map.Entry<String, SignSingleModel> entry : this.ldq.entrySet()) {
                    entry.getValue().dbG();
                }
                this.ldq.clear();
            }
        }
    }
}
