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
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.aq;
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
public class i implements u, ad {
    public static final BdUniqueId cRf = BdUniqueId.gen();
    private String authorId;
    private String bimg_url;
    private String cRh;
    private ArrayList<i> cRj;
    private ArrayList<i> cRm;
    private int cRo;
    private com.baidu.tbadk.data.a cRp;
    private com.baidu.tbadk.data.d cRq;
    private SmallTailInfo chS;
    private HashMap<String, MetaData> userMap;
    private boolean cRk = false;
    private com.baidu.tbadk.widget.richText.a cRn = null;
    private boolean cRr = false;
    private String id = null;
    private String title = null;
    private int cRg = 0;
    private long time = 0;
    private MetaData author = new MetaData();
    private ArrayList<b> bLD = new ArrayList<>();
    private ArrayList<b> bMk = new ArrayList<>();
    private int cRi = 0;
    private int cRl = 0;
    private int Wd = 0;
    private PraiseData praise = new PraiseData();

    public i() {
        this.cRj = null;
        this.cRm = null;
        this.cRj = new ArrayList<>();
        this.cRm = new ArrayList<>();
    }

    public ArrayList<i> auf() {
        return this.cRj;
    }

    public void aug() {
        this.cRi++;
    }

    public void auh() {
        this.cRi--;
    }

    public void ks(int i) {
        this.cRi = i;
    }

    public ArrayList<i> aui() {
        return this.cRm;
    }

    public boolean isGiftPost() {
        return this.cRr;
    }

    public void setIsGiftPost(boolean z) {
        this.cRr = z;
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

    public int auj() {
        return this.cRg;
    }

    public void kt(int i) {
        this.cRg = i;
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

    public com.baidu.tbadk.widget.richText.a auk() {
        return this.cRn;
    }

    public void a(com.baidu.tbadk.widget.richText.a aVar) {
        this.cRn = aVar;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public com.baidu.tbadk.data.a aul() {
        return this.cRp;
    }

    public SmallTailInfo afQ() {
        return this.chS;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.chS = smallTailInfo;
    }

    public com.baidu.tbadk.data.d aum() {
        return this.cRq;
    }

    public void a(BdUniqueId bdUniqueId, boolean z) {
        String str;
        SpannableString spannableString;
        String str2;
        r rVar;
        com.baidu.tbadk.widget.richText.c cVar;
        Bitmap cu;
        if (this.cRn != null && this.cRn.Fg() != null) {
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
                    com.baidu.adp.widget.e eVar = new com.baidu.adp.widget.e(new j(this, it.next(), bdUniqueId), 0, 1);
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
            if (z && (cu = al.cu(i.e.icon_floorhost)) != null) {
                int width = (cu.getWidth() * dimensionPixelSize) / cu.getHeight();
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cu);
                bitmapDrawable.setBounds(0, 0, width, dimensionPixelSize);
                com.baidu.tbadk.widget.i iVar = new com.baidu.tbadk.widget.i(bitmapDrawable);
                if (this.author != null) {
                    spannableString.setSpan(iVar, sb2.length() + this.author.getName_show().length() + 1, str3.length() + sb2.length() + this.author.getName_show().length(), 17);
                } else {
                    spannableString.setSpan(iVar, sb2.length(), str3.length() + sb2.length(), 17);
                }
            }
            spannableString.setSpan(aVar, 0, length, 18);
            ArrayList<com.baidu.tbadk.widget.richText.c> Fg = this.cRn.Fg();
            if (Fg != null && Fg.size() > 0) {
                com.baidu.tbadk.widget.richText.c cVar2 = Fg.get(0);
                if (cVar2.Fm() != null) {
                    cVar2.eG(sb.length());
                    cVar2.Fm().insert(0, (CharSequence) spannableString);
                    return;
                }
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= Fg.size()) {
                        rVar = null;
                        break;
                    } else if (Fg.get(i4) == null || Fg.get(i4).getType() != 512) {
                        i3 = i4 + 1;
                    } else {
                        r Fn = Fg.get(i4).Fn();
                        Fg.remove(i4);
                        rVar = Fn;
                        break;
                    }
                }
                if (rVar != null) {
                    cVar = new com.baidu.tbadk.widget.richText.c(768);
                    cVar.a(rVar);
                } else {
                    cVar = new com.baidu.tbadk.widget.richText.c(1);
                }
                cVar.eG(sb.length());
                cVar.append(spannableString);
                Fg.add(0, cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Drawable f(com.baidu.adp.widget.a.a aVar) {
        Bitmap mZ;
        if (aVar == null || (mZ = aVar.mZ()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(mZ);
        bitmapDrawable.setBounds(0, 0, TbadkCoreApplication.m411getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(i.d.small_icon_width), TbadkCoreApplication.m411getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(i.d.small_icon_height));
        return bitmapDrawable;
    }

    public int aun() {
        return this.cRi;
    }

    public int auo() {
        return this.cRl;
    }

    public void aS(Context context) {
        int type;
        int i;
        int i2;
        if (this.bLD != null) {
            int i3 = -1;
            int size = this.bMk.size();
            if (size > 0) {
                try {
                    i3 = this.bMk.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.bLD.size()) {
                b bVar = this.bLD.get(i4);
                if (b.aG(i5, bVar.getType())) {
                    this.bMk.get(size - 1).b(bVar.aR(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (bVar.getType() == 3 || bVar.getType() == 2 || bVar.getType() == 11) {
                        this.bMk.add(bVar);
                        type = bVar.getType();
                    } else {
                        b bVar2 = new b();
                        bVar2.setType(0);
                        bVar2.b(bVar.aR(context));
                        this.bMk.add(bVar2);
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

    public void aT(Context context) {
        try {
            if (this.cRn != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.cRn.toString());
                clipboardManager.getText();
                return;
            }
            if (this.bMk == null || this.bMk.size() == 0) {
                aS(context);
            }
            ArrayList<b> arrayList = this.bMk;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<b> it = arrayList.iterator();
                while (it.hasNext()) {
                    b next = it.next();
                    if (next.getType() == 0) {
                        if (next.atR() != null) {
                            sb.append((CharSequence) next.atR());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(i.h.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(i.h.voice_str));
                    } else if (next.getType() == 2) {
                        String eJ = TbFaceManager.Cr().eJ(next.getText());
                        if (eJ != null) {
                            sb.append("[");
                            sb.append(eJ);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !aq.isEmpty(next.atQ())) {
                        sb.append("[").append(next.atQ()).append("]");
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
                this.cRg = subPostList.floor.intValue();
                this.time = subPostList.time.intValue() * 1000;
                this.authorId = String.valueOf(subPostList.author_id);
                this.cRr = subPostList.is_giftpost.intValue() == 1;
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                if ((this.author.getUserId() == null || this.author.getUserId().length() <= 0 || this.author.getUserId().equals("0")) && metaData2 != null) {
                    this.author = metaData2;
                }
                this.cRn = TbRichTextView.b(context, subPostList.content, z);
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
                this.cRg = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.cRh = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0")) {
                    MetaData metaData = this.userMap.get(this.authorId);
                    if (metaData != null) {
                        this.author = metaData;
                    }
                } else {
                    this.author.parserProtobuf(post.author);
                }
                this.cRi = post.sub_post_number.intValue();
                this.cRl = post.add_post_number.intValue();
                this.cRn = TbRichTextView.b(context, post.content, true);
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            i iVar = new i();
                            iVar.cRr = subPostList.is_giftpost.intValue() == 1;
                            iVar.setUserMap(this.userMap);
                            iVar.a(subPostList, context);
                            this.cRj.add(iVar);
                        }
                    }
                }
                AddPostList addPostList = post.add_post_list;
                if (addPostList != null) {
                    List<SubPostList> list2 = addPostList.add_post_list;
                    if (list2.size() > 0) {
                        for (SubPostList subPostList2 : list2) {
                            i iVar2 = new i();
                            iVar2.setUserMap(this.userMap);
                            iVar2.a(subPostList2, context);
                            this.cRm.add(iVar2);
                        }
                    }
                }
                this.bimg_url = post.bimg_url;
                if (this.cRm.size() >= 5) {
                    this.cRo = 5;
                } else {
                    this.cRo = this.cRm.size();
                }
                if (post.tail_info != null) {
                    this.cRp = new com.baidu.tbadk.data.a();
                    this.cRp.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.cRq = new com.baidu.tbadk.data.d();
                    this.cRq.a(post.lbs_info);
                }
                this.Wd = post.storecount.intValue();
                this.praise.setUserMap(this.userMap);
                this.praise.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.chS = new SmallTailInfo();
                    this.chS.id = post.signature.signature_id.intValue();
                    this.chS.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.chS.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list3 = this.chS.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list3.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.chS.updateShowInfo();
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    private class a extends ClickableSpan {
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
                textPaint.setColor(al.getColor(i.c.cp_link_tip_c));
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

    public String aU(Context context) {
        ArrayList<com.baidu.tbadk.widget.richText.c> Fg;
        if (this.cRn == null || (Fg = this.cRn.Fg()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<com.baidu.tbadk.widget.richText.c> it = Fg.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.Fm().toString());
            } else if (next.getType() == 17) {
                String str = next.Fq().avh.auI;
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

    public int aup() {
        return this.cRo;
    }

    public void ku(int i) {
        this.cRo = i;
    }

    public ac auq() {
        ArrayList<com.baidu.tbadk.widget.richText.c> Fg;
        if (this.cRn != null && (Fg = this.cRn.Fg()) != null) {
            Iterator<com.baidu.tbadk.widget.richText.c> it = Fg.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.widget.richText.c next = it.next();
                if (next.getType() == 8) {
                    ac acVar = new ac();
                    acVar.width = next.Fl().getWidth();
                    acVar.height = next.Fl().getHeight();
                    acVar.Wg = next.Fl().Fu();
                    acVar.aaD = 17;
                    return acVar;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ad
    public ArrayList<ac> getImages() {
        ArrayList<com.baidu.tbadk.widget.richText.c> Fg;
        if (this.cRn == null || (Fg = this.cRn.Fg()) == null) {
            return null;
        }
        ArrayList<ac> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.widget.richText.c> it = Fg.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next.getType() == 8) {
                ac acVar = new ac();
                acVar.width = next.Fl().getWidth();
                acVar.height = next.Fl().getHeight();
                acVar.Wg = next.Fl().Fu();
                acVar.aaD = 17;
                arrayList.add(acVar);
            } else if (next.Fq() != null) {
                ac acVar2 = new ac();
                acVar2.width = next.Fq().avh.auL;
                acVar2.height = next.Fq().avh.auM;
                acVar2.aaE = next.Fq();
                acVar2.aaD = 20;
                arrayList.add(acVar2);
            }
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.cRo) {
                break;
            }
            arrayList.addAll(this.cRm.get(i2).getImages());
            i = i2 + 1;
        }
        if (!TextUtils.isEmpty(this.bimg_url)) {
            ac acVar3 = new ac();
            acVar3.Wg = this.bimg_url;
            acVar3.width = 105;
            acVar3.width = 105;
            acVar3.aaD = 19;
            arrayList.add(acVar3);
        }
        if (this.author == null) {
            return arrayList;
        }
        ac acVar4 = new ac();
        acVar4.Wg = this.author.getPortrait();
        acVar4.aaD = 12;
        arrayList.add(acVar4);
        if (this.cRm != null) {
            Iterator<i> it2 = this.cRm.iterator();
            while (it2.hasNext()) {
                arrayList.addAll(it2.next().getImages());
            }
        }
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return cRf;
    }

    public boolean aur() {
        return this.cRk;
    }

    public void gj(boolean z) {
        this.cRk = z;
    }
}
