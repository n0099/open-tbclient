package com.baidu.tieba.yuyinala.person.view;

import android.graphics.Bitmap;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.ap;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.view.b;
import com.baidu.live.view.c;
import com.baidu.tieba.yuyinala.person.PersonCardActivity;
import com.baidu.webkit.internal.ETAG;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private static final int hvY = "   ".length();
    private ap hgN;
    private TextView hwa;
    private TextView hwb;
    private TextView hwc;
    private View hwd;
    private List<AlaLiveMarkData> hwe;
    private List<AlaLiveMarkData> hwf;
    private List<AlaLiveMarkData> hwg;
    private int hwh = 0;
    private long lastClickTime = 0;
    private View mContentView;
    private View mRootView;
    private PersonCardActivity nZT;

    public a(PersonCardActivity personCardActivity, View view, View view2) {
        this.nZT = personCardActivity;
        this.mContentView = view;
        this.mRootView = view2;
        initView();
    }

    private void initView() {
        if (this.mContentView != null) {
            this.hwa = (TextView) this.mContentView.findViewById(a.g.user_mark_normal);
            this.hwb = (TextView) this.mContentView.findViewById(a.g.user_mark_extra);
            this.hwc = (TextView) this.mRootView.findViewById(a.g.user_name);
            this.hwb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.person.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cgQ();
                }
            });
            this.hwd = this.mContentView.findViewById(a.g.user_mark_divider);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v7, resolved type: com.baidu.tieba.yuyinala.person.PersonCardActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void cgQ() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastClickTime >= 500) {
            this.lastClickTime = currentTimeMillis;
            if (this.hgN != null && com.baidu.live.z.a.Pq().bsy.aOJ != null) {
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(this.hgN.user_id)) {
                    String str = com.baidu.live.z.a.Pq().bsy.aOJ.aOv;
                    if (!TextUtils.isEmpty(str)) {
                        UrlManager.getInstance().dealOneLink(this.nZT.getPageContext(), new String[]{str});
                    }
                } else {
                    String str2 = com.baidu.live.z.a.Pq().bsy.aOJ.aOw;
                    if (str2 != null && this.hgN != null) {
                        if (str2.endsWith("/")) {
                            str2 = str2.substring(0, str2.length() - 1);
                        }
                        String str3 = this.hgN.user_id;
                        String str4 = this.hgN.portrait;
                        String str5 = this.hgN.user_nickname;
                        StringBuilder sb = new StringBuilder();
                        sb.append("id=");
                        sb.append(ExtraParamsManager.getEncryptionUserId(str3));
                        sb.append(ETAG.ITEM_SEPARATOR);
                        sb.append("portrait=");
                        try {
                            sb.append(URLEncoder.encode(str4, "UTF-8"));
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                        sb.append(ETAG.ITEM_SEPARATOR);
                        sb.append("nickname=");
                        try {
                            sb.append(URLEncoder.encode(str5, "UTF-8"));
                        } catch (UnsupportedEncodingException e2) {
                            e2.printStackTrace();
                        }
                        if (!str2.contains("?")) {
                            sb.insert(0, "?");
                        } else {
                            sb.insert(0, ETAG.ITEM_SEPARATOR);
                        }
                        sb.insert(0, str2);
                        String sb2 = sb.toString();
                        this.nZT.finish();
                        if (!TextUtils.isEmpty(sb2)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913132, sb2));
                        }
                    } else {
                        return;
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913054));
            }
        }
    }

    public void setData(ap apVar) {
        if (apVar != null) {
            this.hgN = apVar;
            if (this.hwe == null) {
                this.hwe = new ArrayList();
            }
            this.hwe.clear();
            if (this.hwf == null) {
                this.hwf = new ArrayList();
            }
            this.hwf.clear();
            if (this.hwg == null) {
                this.hwg = new ArrayList();
            }
            this.hwg.clear();
            boolean cv = cv(apVar.live_mark_info_new);
            if (!ListUtils.isEmpty(this.hwe)) {
                a("", "", this.hwa, this.hwe);
            }
            if (!ListUtils.isEmpty(this.hwf) || cv) {
                int i = apVar.aNd;
                if (i <= 0) {
                    i = this.hwh;
                }
                a("  ", i + this.nZT.getResources().getString(a.i.ala_count_mei), this.hwb, this.hwf);
                this.hwb.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.f.sdk_person_card_more, 0);
                this.hwd.setVisibility(0);
            } else {
                this.hwb.setText("");
                this.hwb.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                this.hwd.setVisibility(8);
            }
            if (!ListUtils.isEmpty(this.hwg)) {
                a(cgR() + " ", "", this.hwc, this.hwg);
            }
        }
    }

    private String cgR() {
        String nameShow = this.hgN.getNameShow();
        if (nameShow != null) {
            if (TextHelper.getTextLengthWithEmoji(nameShow) > 20) {
                return TextHelper.subStringWithEmoji(nameShow, 20) + StringHelper.STRING_MORE;
            }
            return nameShow;
        }
        return "";
    }

    private void a(String str, String str2, final TextView textView, List<AlaLiveMarkData> list) {
        if (str == null) {
            str = "";
        }
        int length = str.length();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                str = str + "   ";
            }
        }
        String str3 = str + str2;
        if (list == null || list.isEmpty()) {
            textView.setText(str3);
            return;
        }
        final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str3);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < list.size()) {
                AlaLiveMarkData alaLiveMarkData = list.get(i3);
                if (alaLiveMarkData != null) {
                    final int i4 = length + (hvY * i3);
                    final int i5 = i4 + 1;
                    if (1 == alaLiveMarkData.type) {
                        new b(this.nZT, alaLiveMarkData, this.hgN.level_id, true, new c.a() { // from class: com.baidu.tieba.yuyinala.person.view.a.2
                            @Override // com.baidu.live.view.c.a
                            public void d(Bitmap bitmap) {
                            }

                            @Override // com.baidu.live.view.c.a
                            public void a(c cVar, Bitmap bitmap) {
                                spannableStringBuilder.setSpan(cVar, i4, i5, 17);
                                textView.setText(spannableStringBuilder);
                            }
                        });
                    } else {
                        new c(this.nZT, alaLiveMarkData, true, new c.a() { // from class: com.baidu.tieba.yuyinala.person.view.a.3
                            @Override // com.baidu.live.view.c.a
                            public void d(Bitmap bitmap) {
                            }

                            @Override // com.baidu.live.view.c.a
                            public void a(c cVar, Bitmap bitmap) {
                                spannableStringBuilder.setSpan(cVar, i4, i5, 17);
                                textView.setText(spannableStringBuilder);
                            }
                        });
                    }
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    private boolean cv(List<AlaLiveMarkData> list) {
        if (ListUtils.isEmpty(list)) {
            return false;
        }
        LinkedList<AlaLiveMarkData> linkedList = new LinkedList();
        for (AlaLiveMarkData alaLiveMarkData : list) {
            if (alaLiveMarkData != null && !TextUtils.isEmpty(alaLiveMarkData.mark_pic) && 3 != alaLiveMarkData.type && 4 != alaLiveMarkData.type) {
                if (StringUtils.isNull(alaLiveMarkData.anchor_user_id) || "0".equals(alaLiveMarkData.anchor_user_id)) {
                    linkedList.add(alaLiveMarkData);
                } else if (alaLiveMarkData.anchor_user_id.equals(this.nZT.cgy())) {
                    linkedList.add(alaLiveMarkData);
                }
            }
        }
        if (ListUtils.isEmpty(linkedList)) {
            return false;
        }
        boolean z = false;
        for (AlaLiveMarkData alaLiveMarkData2 : linkedList) {
            if (alaLiveMarkData2.type == 103 || alaLiveMarkData2.type == 104) {
                this.hwf.add(alaLiveMarkData2);
            } else if (alaLiveMarkData2.type == 2) {
                this.hwg.add(alaLiveMarkData2);
            } else {
                this.hwe.add(alaLiveMarkData2);
            }
            z = alaLiveMarkData2.type == 105 ? true : z;
        }
        this.hwh = this.hwf.size();
        if (this.hwh > 2) {
            this.hwf = this.hwf.subList(0, 2);
        }
        if (this.hwe.size() > 3) {
            this.hwe = this.hwe.subList(0, 3);
        }
        return z;
    }
}
