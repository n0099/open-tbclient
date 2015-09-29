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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ar;
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
    public static final BdUniqueId cYF = BdUniqueId.gen();
    public static final BdUniqueId cYG = BdUniqueId.gen();
    public static final BdUniqueId cYH = BdUniqueId.gen();
    public static final BdUniqueId cYI = BdUniqueId.gen();
    private String authorId;
    private String bimg_url;
    private String cYL;
    private ArrayList<k> cYN;
    private ArrayList<k> cYQ;
    private int cYS;
    private com.baidu.tbadk.data.a cYT;
    private com.baidu.tbadk.data.d cYU;
    private SmallTailInfo cnp;
    private HashMap<String, MetaData> userMap;
    private int cYJ = 0;
    private boolean cYO = false;
    private com.baidu.tbadk.widget.richText.a cYR = null;
    private boolean cYV = false;
    private String id = null;
    private String title = null;
    private int cYK = 0;
    private long time = 0;
    private MetaData author = new MetaData();
    private ArrayList<d> bOZ = new ArrayList<>();
    private ArrayList<d> bPM = new ArrayList<>();
    private int cYM = 0;
    private int cYP = 0;
    private int VT = 0;
    private PraiseData praise = new PraiseData();

    public k() {
        this.cYN = null;
        this.cYQ = null;
        this.cYN = new ArrayList<>();
        this.cYQ = new ArrayList<>();
    }

    public ArrayList<k> awu() {
        return this.cYN;
    }

    public void awv() {
        this.cYM++;
    }

    public void aww() {
        this.cYM--;
    }

    public void kT(int i) {
        this.cYM = i;
    }

    public ArrayList<k> awx() {
        return this.cYQ;
    }

    public boolean isGiftPost() {
        return this.cYV;
    }

    public void setIsGiftPost(boolean z) {
        this.cYV = z;
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

    public int awy() {
        return this.cYK;
    }

    public void kU(int i) {
        this.cYK = i;
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

    public com.baidu.tbadk.widget.richText.a awz() {
        return this.cYR;
    }

    public void a(com.baidu.tbadk.widget.richText.a aVar) {
        this.cYR = aVar;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public com.baidu.tbadk.data.a awA() {
        return this.cYT;
    }

    public SmallTailInfo ahO() {
        return this.cnp;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.cnp = smallTailInfo;
    }

    public com.baidu.tbadk.data.d awB() {
        return this.cYU;
    }

    public void a(BdUniqueId bdUniqueId, boolean z) {
        String str;
        SpannableString spannableString;
        String str2;
        r rVar;
        com.baidu.tbadk.widget.richText.c cVar;
        Bitmap cw;
        if (this.cYR != null && this.cYR.ET() != null) {
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
            if (z && (cw = am.cw(i.e.icon_floorhost)) != null) {
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
            ArrayList<com.baidu.tbadk.widget.richText.c> ET = this.cYR.ET();
            if (ET != null && ET.size() > 0) {
                com.baidu.tbadk.widget.richText.c cVar2 = ET.get(0);
                if (cVar2.EZ() != null) {
                    cVar2.eJ(sb.length());
                    cVar2.EZ().insert(0, (CharSequence) spannableString);
                    return;
                }
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= ET.size()) {
                        rVar = null;
                        break;
                    } else if (ET.get(i4) == null || ET.get(i4).getType() != 512) {
                        i3 = i4 + 1;
                    } else {
                        r Fa = ET.get(i4).Fa();
                        ET.remove(i4);
                        rVar = Fa;
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
                ET.add(0, cVar);
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

    public int awC() {
        return this.cYM;
    }

    public int awD() {
        return this.cYP;
    }

    public void aR(Context context) {
        int type;
        int i;
        int i2;
        if (this.bOZ != null) {
            int i3 = -1;
            int size = this.bPM.size();
            if (size > 0) {
                try {
                    i3 = this.bPM.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.bOZ.size()) {
                d dVar = this.bOZ.get(i4);
                if (d.aF(i5, dVar.getType())) {
                    this.bPM.get(size - 1).b(dVar.aQ(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (dVar.getType() == 3 || dVar.getType() == 2 || dVar.getType() == 11) {
                        this.bPM.add(dVar);
                        type = dVar.getType();
                    } else {
                        d dVar2 = new d();
                        dVar2.setType(0);
                        dVar2.b(dVar.aQ(context));
                        this.bPM.add(dVar2);
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
            if (this.cYR != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.cYR.toString());
                clipboardManager.getText();
                return;
            }
            if (this.bPM == null || this.bPM.size() == 0) {
                aR(context);
            }
            ArrayList<d> arrayList = this.bPM;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<d> it = arrayList.iterator();
                while (it.hasNext()) {
                    d next = it.next();
                    if (next.getType() == 0) {
                        if (next.awg() != null) {
                            sb.append((CharSequence) next.awg());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(i.h.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(i.h.voice_str));
                    } else if (next.getType() == 2) {
                        String eO = TbFaceManager.Ce().eO(next.getText());
                        if (eO != null) {
                            sb.append("[");
                            sb.append(eO);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !ar.isEmpty(next.awf())) {
                        sb.append("[").append(next.awf()).append("]");
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
                this.cYK = subPostList.floor.intValue();
                this.time = subPostList.time.intValue() * 1000;
                this.authorId = String.valueOf(subPostList.author_id);
                this.cYV = subPostList.is_giftpost.intValue() == 1;
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                if ((this.author.getUserId() == null || this.author.getUserId().length() <= 0 || this.author.getUserId().equals("0")) && metaData2 != null) {
                    this.author = metaData2;
                }
                this.cYR = TbRichTextView.b(context, subPostList.content, z);
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
                this.cYK = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.cYL = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0")) {
                    MetaData metaData = this.userMap.get(this.authorId);
                    if (metaData != null) {
                        this.author = metaData;
                    }
                } else {
                    this.author.parserProtobuf(post.author);
                }
                this.cYM = post.sub_post_number.intValue();
                this.cYP = post.add_post_number.intValue();
                this.cYR = TbRichTextView.b(context, post.content, true);
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            k kVar = new k();
                            kVar.cYV = subPostList.is_giftpost.intValue() == 1;
                            kVar.setUserMap(this.userMap);
                            kVar.a(subPostList, context);
                            this.cYN.add(kVar);
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
                            this.cYQ.add(kVar2);
                        }
                    }
                }
                this.bimg_url = post.bimg_url;
                if (this.cYQ.size() >= 5) {
                    this.cYS = 5;
                } else {
                    this.cYS = this.cYQ.size();
                }
                if (post.tail_info != null) {
                    this.cYT = new com.baidu.tbadk.data.a();
                    this.cYT.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.cYU = new com.baidu.tbadk.data.d();
                    this.cYU.a(post.lbs_info);
                }
                this.VT = post.storecount.intValue();
                this.praise.setUserMap(this.userMap);
                this.praise.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.cnp = new SmallTailInfo();
                    this.cnp.id = post.signature.signature_id.intValue();
                    this.cnp.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.cnp.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list3 = this.cnp.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list3.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.cnp.updateShowInfo();
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
                textPaint.setColor(am.getColor(i.c.cp_link_tip_c));
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
        ArrayList<com.baidu.tbadk.widget.richText.c> ET;
        if (this.cYR == null || (ET = this.cYR.ET()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<com.baidu.tbadk.widget.richText.c> it = ET.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.EZ().toString());
            } else if (next.getType() == 17) {
                String str = next.Fd().atE.atf;
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

    public int awE() {
        return this.cYS;
    }

    public void kV(int i) {
        this.cYS = i;
    }

    public ad awF() {
        ArrayList<com.baidu.tbadk.widget.richText.c> ET;
        if (this.cYR != null && (ET = this.cYR.ET()) != null) {
            Iterator<com.baidu.tbadk.widget.richText.c> it = ET.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.widget.richText.c next = it.next();
                if (next.getType() == 8) {
                    ad adVar = new ad();
                    adVar.width = next.EY().getWidth();
                    adVar.height = next.EY().getHeight();
                    adVar.VY = next.EY().Fh();
                    adVar.aax = 17;
                    return adVar;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<ad> getImages() {
        ArrayList<com.baidu.tbadk.widget.richText.c> ET;
        if (this.cYR == null || (ET = this.cYR.ET()) == null) {
            return null;
        }
        ArrayList<ad> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.widget.richText.c> it = ET.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next.getType() == 8) {
                ad adVar = new ad();
                adVar.width = next.EY().getWidth();
                adVar.height = next.EY().getHeight();
                adVar.VY = next.EY().Fh();
                adVar.aax = 17;
                arrayList.add(adVar);
            } else if (next.Fd() != null) {
                ad adVar2 = new ad();
                adVar2.width = next.Fd().atE.ati;
                adVar2.height = next.Fd().atE.atj;
                adVar2.aay = next.Fd();
                adVar2.aax = 20;
                arrayList.add(adVar2);
            }
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.cYS) {
                break;
            }
            arrayList.addAll(this.cYQ.get(i2).getImages());
            i = i2 + 1;
        }
        if (!TextUtils.isEmpty(this.bimg_url)) {
            ad adVar3 = new ad();
            adVar3.VY = this.bimg_url;
            adVar3.width = 105;
            adVar3.width = 105;
            adVar3.aax = 19;
            arrayList.add(adVar3);
        }
        if (this.author == null) {
            return arrayList;
        }
        ad adVar4 = new ad();
        adVar4.VY = this.author.getPortrait();
        adVar4.aax = 12;
        arrayList.add(adVar4);
        if (this.cYQ != null) {
            Iterator<k> it2 = this.cYQ.iterator();
            while (it2.hasNext()) {
                arrayList.addAll(it2.next().getImages());
            }
        }
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        if (this.cYJ == 2) {
            return cYG;
        }
        if (this.cYJ == 1) {
            return cYH;
        }
        if (this.cYJ == 36) {
            return cYI;
        }
        return cYF;
    }

    public boolean awG() {
        return this.cYO;
    }

    public void gt(boolean z) {
        this.cYO = z;
    }

    public void setPostType(int i) {
        this.cYJ = i;
    }
}
