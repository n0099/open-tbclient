package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.ClipboardManager;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.r;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.AddPostList;
import tbclient.Post;
import tbclient.SignatureContent;
import tbclient.SubPost;
import tbclient.SubPostList;
/* loaded from: classes.dex */
public class k implements u, ae {
    public static final BdUniqueId cZf = BdUniqueId.gen();
    public static final BdUniqueId cZg = BdUniqueId.gen();
    public static final BdUniqueId cZh = BdUniqueId.gen();
    public static final BdUniqueId cZi = BdUniqueId.gen();
    private String authorId;
    private String bimg_url;
    private String cZl;
    private ArrayList<k> cZn;
    private ArrayList<k> cZq;
    private int cZs;
    private com.baidu.tbadk.data.a cZt;
    private com.baidu.tbadk.data.d cZu;
    private SmallTailInfo cnA;
    private HashMap<String, MetaData> userMap;
    private int cZj = 0;
    private boolean cZo = false;
    private com.baidu.tbadk.widget.richText.a cZr = null;
    private boolean cZv = false;
    private String id = null;
    private String title = null;
    private int cZk = 0;
    private long time = 0;
    private MetaData author = new MetaData();
    private ArrayList<d> bPk = new ArrayList<>();
    private ArrayList<d> bPX = new ArrayList<>();
    private int cZm = 0;
    private int cZp = 0;
    private int VV = 0;
    private PraiseData praise = new PraiseData();

    public k() {
        this.cZn = null;
        this.cZq = null;
        this.cZn = new ArrayList<>();
        this.cZq = new ArrayList<>();
    }

    public ArrayList<k> awA() {
        return this.cZn;
    }

    public void awB() {
        this.cZm++;
    }

    public void awC() {
        this.cZm--;
    }

    public void kV(int i) {
        this.cZm = i;
    }

    public ArrayList<k> awD() {
        return this.cZq;
    }

    public boolean isGiftPost() {
        return this.cZv;
    }

    public void setIsGiftPost(boolean z) {
        this.cZv = z;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int awE() {
        return this.cZk;
    }

    public void kW(int i) {
        this.cZk = i;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public MetaData getAuthor() {
        return this.author;
    }

    public void setAuthor(MetaData metaData) {
        this.author = metaData;
    }

    public com.baidu.tbadk.widget.richText.a awF() {
        return this.cZr;
    }

    public void a(com.baidu.tbadk.widget.richText.a aVar) {
        this.cZr = aVar;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public com.baidu.tbadk.data.a awG() {
        return this.cZt;
    }

    public SmallTailInfo ahK() {
        return this.cnA;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.cnA = smallTailInfo;
    }

    public com.baidu.tbadk.data.d awH() {
        return this.cZu;
    }

    public void a(BdUniqueId bdUniqueId, boolean z) {
        String str;
        SpannableString spannableString;
        String str2;
        r rVar;
        com.baidu.tbadk.widget.richText.c cVar;
        Bitmap cw;
        if (this.cZr != null && this.cZr.EP() != null) {
            ArrayList<IconData> tShowInfo = getAuthor().getTShowInfo();
            if (tShowInfo != null) {
                tShowInfo.size();
            }
            String str3 = z ? " [host]" : "";
            int dimensionPixelSize = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds36);
            ArrayList arrayList = new ArrayList();
            if (tShowInfo != null) {
                Iterator<IconData> it = tShowInfo.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.e eVar = new com.baidu.adp.widget.e(new l(this, it.next(), bdUniqueId), 0, 1);
                    eVar.c(0, 0, TbadkCoreApplication.m411getInst().getApp().getResources().getDimensionPixelSize(i.d.small_icon_width), TbadkCoreApplication.m411getInst().getApp().getResources().getDimensionPixelSize(i.d.small_icon_height));
                    arrayList.add(eVar);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(i);
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            String sb2 = sb.toString();
            if (this.author == null) {
                str = null;
                spannableString = new SpannableString(String.valueOf(sb2) + str3 + "：");
                str2 = null;
            } else {
                spannableString = new SpannableString(String.valueOf(sb2) + this.author.getName_show() + str3 + "：");
                str = this.author.getUserName();
                str2 = this.author.getUserId();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            int length = spannableString.length();
            a aVar = new a(TbadkCoreApplication.m411getInst().getApp(), str, str2);
            if (z && (cw = an.cw(i.e.icon_floorhost)) != null) {
                int width = (cw.getWidth() * dimensionPixelSize) / cw.getHeight();
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cw);
                bitmapDrawable.setBounds(0, 0, width, dimensionPixelSize);
                com.baidu.tbadk.widget.g gVar = new com.baidu.tbadk.widget.g(bitmapDrawable);
                if (this.author != null) {
                    spannableString.setSpan(gVar, sb2.length() + this.author.getName_show().length() + 1, str3.length() + sb2.length() + this.author.getName_show().length(), 17);
                } else {
                    spannableString.setSpan(gVar, sb2.length(), str3.length() + sb2.length(), 17);
                }
            }
            spannableString.setSpan(aVar, 0, length, 18);
            ArrayList<com.baidu.tbadk.widget.richText.c> EP = this.cZr.EP();
            if (EP != null && EP.size() > 0) {
                com.baidu.tbadk.widget.richText.c cVar2 = EP.get(0);
                if (cVar2.EV() != null) {
                    cVar2.eJ(sb.length());
                    cVar2.EV().insert(0, (CharSequence) spannableString);
                    return;
                }
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= EP.size()) {
                        rVar = null;
                        break;
                    } else if (EP.get(i4) == null || EP.get(i4).getType() != 512) {
                        i3 = i4 + 1;
                    } else {
                        r EW = EP.get(i4).EW();
                        EP.remove(i4);
                        rVar = EW;
                        break;
                    }
                }
                if (rVar != null) {
                    cVar = new com.baidu.tbadk.widget.richText.c(768);
                    cVar.a(rVar);
                } else {
                    cVar = new com.baidu.tbadk.widget.richText.c(1);
                }
                cVar.eJ(sb.length());
                cVar.append(spannableString);
                EP.add(0, cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Drawable g(com.baidu.adp.widget.a.a aVar) {
        Bitmap na;
        if (aVar == null || (na = aVar.na()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(na);
        bitmapDrawable.setBounds(0, 0, TbadkCoreApplication.m411getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(i.d.small_icon_width), TbadkCoreApplication.m411getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(i.d.small_icon_height));
        return bitmapDrawable;
    }

    public int awI() {
        return this.cZm;
    }

    public int awJ() {
        return this.cZp;
    }

    public void aR(Context context) {
        int type;
        int i;
        int i2;
        if (this.bPk != null) {
            int i3 = -1;
            int size = this.bPX.size();
            if (size > 0) {
                try {
                    i3 = this.bPX.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.bPk.size()) {
                d dVar = this.bPk.get(i4);
                if (d.aF(i5, dVar.getType())) {
                    this.bPX.get(size - 1).b(dVar.aQ(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (dVar.getType() == 3 || dVar.getType() == 2 || dVar.getType() == 11) {
                        this.bPX.add(dVar);
                        type = dVar.getType();
                    } else {
                        d dVar2 = new d();
                        dVar2.setType(0);
                        dVar2.b(dVar.aQ(context));
                        this.bPX.add(dVar2);
                        type = 0;
                    }
                    i = type;
                    i2 = size + 1;
                }
                i4++;
                i5 = i;
                size = i2;
            }
        }
    }

    public void aS(Context context) {
        try {
            if (this.cZr != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.cZr.toString());
                clipboardManager.getText();
                return;
            }
            if (this.bPX == null || this.bPX.size() == 0) {
                aR(context);
            }
            ArrayList<d> arrayList = this.bPX;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<d> it = arrayList.iterator();
                while (it.hasNext()) {
                    d next = it.next();
                    if (next.getType() == 0) {
                        if (next.awl() != null) {
                            sb.append((CharSequence) next.awl());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(i.h.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(i.h.voice_str));
                    } else if (next.getType() == 2) {
                        String eO = TbFaceManager.Cb().eO(next.getText());
                        if (eO != null) {
                            sb.append("[");
                            sb.append(eO);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !as.isEmpty(next.awk())) {
                        sb.append("[").append(next.awk()).append("]");
                    }
                }
                ClipboardManager clipboardManager2 = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager2.setText(sb.toString());
                clipboardManager2.getText();
            }
        } catch (NullPointerException e) {
            BdLog.detailException(e);
        }
    }

    public void a(SubPostList subPostList, Context context) {
        a(subPostList, context, false);
    }

    public void a(SubPostList subPostList, Context context, boolean z) {
        MetaData metaData;
        if (subPostList != null) {
            try {
                this.id = String.valueOf(subPostList.id);
                this.title = subPostList.title;
                this.cZk = subPostList.floor.intValue();
                this.time = subPostList.time.intValue() * 1000;
                this.authorId = String.valueOf(subPostList.author_id);
                this.cZv = subPostList.is_giftpost.intValue() == 1;
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                if ((this.author.getUserId() == null || this.author.getUserId().length() <= 0 || this.author.getUserId().equals("0")) && metaData2 != null) {
                    this.author = metaData2;
                }
                this.cZr = TbRichTextView.b(context, subPostList.content, z);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void a(Post post, Context context) {
        if (post != null) {
            try {
                this.id = String.valueOf(post.id);
                this.title = post.title;
                this.cZk = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.cZl = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0")) {
                    MetaData metaData = this.userMap.get(this.authorId);
                    if (metaData != null) {
                        this.author = metaData;
                    }
                } else {
                    this.author.parserProtobuf(post.author);
                }
                this.cZm = post.sub_post_number.intValue();
                this.cZp = post.add_post_number.intValue();
                this.cZr = TbRichTextView.b(context, post.content, true);
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            k kVar = new k();
                            kVar.cZv = subPostList.is_giftpost.intValue() == 1;
                            kVar.setUserMap(this.userMap);
                            kVar.a(subPostList, context);
                            this.cZn.add(kVar);
                        }
                    }
                }
                AddPostList addPostList = post.add_post_list;
                if (addPostList != null) {
                    List<SubPostList> list2 = addPostList.add_post_list;
                    if (list2.size() > 0) {
                        for (SubPostList subPostList2 : list2) {
                            k kVar2 = new k();
                            kVar2.setUserMap(this.userMap);
                            kVar2.a(subPostList2, context);
                            this.cZq.add(kVar2);
                        }
                    }
                }
                this.bimg_url = post.bimg_url;
                if (this.cZq.size() >= 5) {
                    this.cZs = 5;
                } else {
                    this.cZs = this.cZq.size();
                }
                if (post.tail_info != null) {
                    this.cZt = new com.baidu.tbadk.data.a();
                    this.cZt.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.cZu = new com.baidu.tbadk.data.d();
                    this.cZu.a(post.lbs_info);
                }
                this.VV = post.storecount.intValue();
                this.praise.setUserMap(this.userMap);
                this.praise.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.cnA = new SmallTailInfo();
                    this.cnA.id = post.signature.signature_id.intValue();
                    this.cnA.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.cnA.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list3 = this.cnA.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list3.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.cnA.updateShowInfo();
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private Context mContext;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2) {
            this.mName = null;
            this.mId = null;
            this.mContext = null;
            this.mName = str;
            this.mId = str2;
            this.mContext = context;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            if (this.mContext != null) {
                textPaint.setColor(an.getColor(i.c.cp_link_tip_c));
            }
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.mContext != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.mContext, this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String aT(Context context) {
        ArrayList<com.baidu.tbadk.widget.richText.c> EP;
        if (this.cZr == null || (EP = this.cZr.EP()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<com.baidu.tbadk.widget.richText.c> it = EP.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.EV().toString());
            } else if (next.getType() == 17) {
                String str = next.EZ().atF.atg;
                if (str != null && str.startsWith("#(") && str.endsWith(")")) {
                    stringBuffer.append("[" + str.substring(2, str.length() - 1) + "]");
                }
            } else if (next.getType() == 8) {
                stringBuffer.append("[" + context.getString(i.h.msglist_image) + "]");
            } else if (next.getType() == 512) {
                stringBuffer.append("[" + context.getString(i.h.msglist_voice) + "]");
            } else if (next.getType() == 32) {
                stringBuffer.append("[" + context.getString(i.h.msglist_video) + "]");
            }
        }
        return stringBuffer.toString();
    }

    public int awK() {
        return this.cZs;
    }

    public void kX(int i) {
        this.cZs = i;
    }

    public ad awL() {
        ArrayList<com.baidu.tbadk.widget.richText.c> EP;
        if (this.cZr != null && (EP = this.cZr.EP()) != null) {
            Iterator<com.baidu.tbadk.widget.richText.c> it = EP.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.widget.richText.c next = it.next();
                if (next.getType() == 8) {
                    ad adVar = new ad();
                    adVar.width = next.EU().getWidth();
                    adVar.height = next.EU().getHeight();
                    adVar.Wa = next.EU().Fd();
                    adVar.aaz = 17;
                    return adVar;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<ad> getImages() {
        ArrayList<com.baidu.tbadk.widget.richText.c> EP;
        if (this.cZr == null || (EP = this.cZr.EP()) == null) {
            return null;
        }
        ArrayList<ad> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.widget.richText.c> it = EP.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next.getType() == 8) {
                ad adVar = new ad();
                adVar.width = next.EU().getWidth();
                adVar.height = next.EU().getHeight();
                adVar.Wa = next.EU().Fd();
                adVar.aaz = 17;
                arrayList.add(adVar);
            } else if (next.EZ() != null) {
                ad adVar2 = new ad();
                adVar2.width = next.EZ().atF.atj;
                adVar2.height = next.EZ().atF.atk;
                adVar2.aaA = next.EZ();
                adVar2.aaz = 20;
                arrayList.add(adVar2);
            }
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.cZs) {
                break;
            }
            arrayList.addAll(this.cZq.get(i2).getImages());
            i = i2 + 1;
        }
        if (!TextUtils.isEmpty(this.bimg_url)) {
            ad adVar3 = new ad();
            adVar3.Wa = this.bimg_url;
            adVar3.width = 105;
            adVar3.width = 105;
            adVar3.aaz = 19;
            arrayList.add(adVar3);
        }
        if (this.author == null) {
            return arrayList;
        }
        ad adVar4 = new ad();
        adVar4.Wa = this.author.getPortrait();
        adVar4.aaz = 12;
        arrayList.add(adVar4);
        if (this.cZq != null) {
            Iterator<k> it2 = this.cZq.iterator();
            while (it2.hasNext()) {
                arrayList.addAll(it2.next().getImages());
            }
        }
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        if (this.cZj == 2) {
            return cZg;
        }
        if (this.cZj == 1) {
            return cZh;
        }
        if (this.cZj == 36) {
            return cZi;
        }
        return cZf;
    }

    public boolean awM() {
        return this.cZo;
    }

    public void gt(boolean z) {
        this.cZo = z;
    }

    public void setPostType(int i) {
        this.cZj = i;
    }
}
