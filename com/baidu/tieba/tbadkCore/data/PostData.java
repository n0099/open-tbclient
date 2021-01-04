package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.ClipboardManager;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.c;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ag;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextEvaluateItemInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.R;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.ActPost;
import tbclient.HeadItem;
import tbclient.Item;
import tbclient.PbContent;
import tbclient.Post;
import tbclient.SignatureContent;
import tbclient.SkinInfo;
import tbclient.SubPost;
import tbclient.SubPostList;
import tbclient.TPointPost;
/* loaded from: classes.dex */
public class PostData implements com.baidu.adp.widget.ListView.n, ag {
    @Deprecated
    private String authorId;
    private String bimg_url;
    private List<HeadItem> eQZ;
    private SkinInfo eUV;
    private String eUY;
    private OriginalThreadInfo eVB;
    private Item eWt;
    private TbRichTextVoiceInfo fnv;
    private String lGv;
    public int locate;
    private SmallTailInfo mdu;
    private String nrD;
    private ArrayList<PostData> nrH;
    private com.baidu.tbadk.data.c nrO;
    private com.baidu.tbadk.data.g nrP;
    private i nrS;
    private bv nrT;
    public boolean nrV;
    private com.baidu.tbadk.widget.richText.i nrW;
    private String nrX;
    private String nrY;
    private TPointPost nrZ;
    public int nsc;
    public boolean nsf;
    public AlaLiveInfoCoreData nsi;
    private boolean nsm;
    public aq nsq;
    public List<PbContent> nst;
    private long tid;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId nru = BdUniqueId.gen();
    public static final BdUniqueId nrv = BdUniqueId.gen();
    public static final BdUniqueId eUW = BdUniqueId.gen();
    public static final BdUniqueId eTd = BdUniqueId.gen();
    public static final BdUniqueId eTj = BdUniqueId.gen();
    public static final BdUniqueId nrw = BdUniqueId.gen();
    public static final BdUniqueId nrx = BdUniqueId.gen();
    public static final BdUniqueId nry = BdUniqueId.gen();
    public static final BdUniqueId nrz = BdUniqueId.gen();
    public static final BdUniqueId nrA = BdUniqueId.gen();
    public static boolean nrB = false;
    private int nrC = 0;
    private boolean nrI = false;
    private ArrayList<PostData> nrJ = null;
    private TbRichText nrK = null;
    private boolean nrN = false;
    private boolean nrQ = false;
    private boolean nrR = false;
    public boolean nrU = false;
    public int eUv = 0;
    private boolean nsa = false;
    public boolean jog = false;
    public boolean nsb = false;
    public boolean nsd = false;
    public boolean nse = true;
    public boolean nsg = false;
    public boolean nsh = false;
    private boolean nsj = false;
    private int nsk = 0;
    private boolean nsl = true;
    public boolean nsn = false;
    public boolean nso = false;
    public boolean nsp = false;
    public boolean nsr = false;
    public boolean nss = false;
    int nsu = com.baidu.tbadk.a.d.bmP();
    private b nsv = new b() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1
        @Override // com.baidu.tieba.tbadkCore.data.PostData.b
        public void onClick() {
            if (PostData.this.nsq != null) {
                aq bwm = PostData.this.nsq.bwm();
                bwm.delete("obj_locate");
                bwm.an("obj_locate", 7);
                TiebaStatic.log(bwm);
            }
        }
    };
    private String id = null;
    private String title = null;
    private int floor_num = 0;
    private long time = 0;
    private String date = null;
    private MetaData eTY = new MetaData();
    private ArrayList<l> nrE = new ArrayList<>();
    private ArrayList<l> nrF = new ArrayList<>();
    private int nrG = 0;
    private int eUG = 0;
    private PraiseData eUj = new PraiseData();
    private az nrL = new az();
    private c nrM = new c();
    private ArrayList<com.baidu.tbadk.data.c> eUS = new ArrayList<>();
    private AgreeData agreeData = new AgreeData();

    /* loaded from: classes.dex */
    private interface b {
        void onClick();
    }

    public PostData() {
        this.nrH = null;
        this.nsc = 0;
        this.nrH = new ArrayList<>();
        this.nsc = 0;
    }

    public void yd(boolean z) {
        this.nsm = z;
    }

    public boolean dOV() {
        return this.nsm;
    }

    public ArrayList<PostData> dOW() {
        return this.nrJ;
    }

    public void dOX() {
        this.nrJ.clear();
        this.nrJ = null;
        this.nrI = false;
    }

    public void y(PostData postData) {
        if (postData != null) {
            if (this.nrJ == null) {
                this.nrJ = new ArrayList<>();
                if (x.getCount(this.nrH) > this.nsu) {
                    this.nrJ.addAll(x.subList(this.nrH, 0, this.nsu));
                } else {
                    this.nrJ.addAll(this.nrH);
                }
            }
            this.nrJ.add(postData);
        }
    }

    public void z(PostData postData) {
        if (postData != null && this.nrH != null) {
            this.nrH.add(postData);
            dPb();
        }
    }

    public void Tp(String str) {
        if (this.nrJ != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.nrJ.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.nrJ.remove(next);
                    return;
                }
            }
        }
    }

    public void ye(boolean z) {
        this.nsl = z;
    }

    public boolean dOY() {
        return this.nsl;
    }

    public void yf(boolean z) {
        this.nrI = z;
    }

    public boolean dOZ() {
        return this.nrI;
    }

    public ArrayList<PostData> dPa() {
        return this.nrH;
    }

    public void dPb() {
        this.nrG++;
    }

    public void dPc() {
        this.nrG--;
    }

    public void KQ(int i) {
        this.nrG = i;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
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

    public long getTid() {
        return this.tid;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int dPd() {
        return this.floor_num;
    }

    public void KR(int i) {
        this.floor_num = i;
    }

    public boolean dPe() {
        return this.nrR;
    }

    public void yg(boolean z) {
        this.nrR = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = at.getFormatTime(j);
    }

    public MetaData brq() {
        return this.eTY;
    }

    public void a(MetaData metaData) {
        this.eTY = metaData;
    }

    public void a(PraiseData praiseData) {
        this.eUj = praiseData;
    }

    public TbRichText dPf() {
        return this.nrK;
    }

    public void c(TbRichText tbRichText) {
        this.nrK = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo duO() {
        return this.mdu;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.mdu = smallTailInfo;
    }

    public com.baidu.tbadk.data.g dPg() {
        return this.nrP;
    }

    public SkinInfo brL() {
        return this.eUV;
    }

    public void yh(boolean z) {
        this.nsj = z;
    }

    public void a(TbPageContext tbPageContext, boolean z) {
        String str;
        SpannableString spannableString;
        String str2;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.nrK != null && this.nrK.bKW() != null) {
            final BdUniqueId uniqueId = tbPageContext.getUniqueId();
            String str3 = null;
            if (z) {
                str = " 楼主";
            } else {
                if (this.eTY != null && this.eTY.getIs_bawu() == 1) {
                    if (this.nsm) {
                        str = " 品牌官";
                    } else if (Config.BAWU_TYPE_MANAGER.equals(this.eTY.getBawu_type())) {
                        str = " 吧主";
                    } else if (Config.BAWU_TYPE_ASSIST.equals(this.eTY.getBawu_type())) {
                        str = " 小吧主";
                    } else if ("pri_content_assist".equals(this.eTY.getBawu_type())) {
                        str = " 内容吧务";
                    } else if ("pri_manage_assist".equals(this.eTY.getBawu_type())) {
                        str = " 管理吧务";
                    }
                }
                str = "";
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<IconData> tShowInfoNew = brq().getTShowInfoNew();
            if (tShowInfoNew != null) {
                Iterator<IconData> it = tShowInfoNew.iterator();
                while (it.hasNext()) {
                    final IconData next = it.next();
                    com.baidu.adp.widget.c cVar = new com.baidu.adp.widget.c(new c.a() { // from class: com.baidu.tieba.tbadkCore.data.PostData.2
                        @Override // com.baidu.adp.widget.c.a
                        public Drawable a(final com.baidu.adp.widget.c cVar2) {
                            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.e.d.mx().loadResourceFromMemery(next.getIcon(), 21, new Object[0]);
                            if (aVar == null) {
                                com.baidu.adp.lib.e.d.mx().a(next.getIcon(), 21, new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadkCore.data.PostData.2.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX INFO: Access modifiers changed from: protected */
                                    @Override // com.baidu.adp.lib.e.c
                                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar2, String str4, int i) {
                                        super.onLoaded((AnonymousClass1) aVar2, str4, i);
                                        if (aVar2 != null && aVar2.isValidNow()) {
                                            cVar2.setDrawable(PostData.this.h(aVar2));
                                            PostData.this.nrK.isChanged = true;
                                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD));
                                        }
                                    }
                                }, uniqueId);
                            }
                            return PostData.this.h(aVar);
                        }
                    }, 0, 1);
                    cVar.setEmptyBounds(0, 0, TbConfig.getContentSizeOfLzl(), TbConfig.getContentSizeOfLzl());
                    arrayList.add(cVar);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(i);
            }
            if (!StringUtils.isNull(this.eTY.getSealPrefix())) {
                sb.append(" ");
                sb.append(this.eTY.getSealPrefix());
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            String sb2 = sb.toString();
            if (this.eTY != null) {
                spannableString = new SpannableString(sb2 + this.eTY.getName_show() + str + "：");
                String userName = this.eTY.getUserName();
                str2 = this.eTY.getUserId();
                str3 = userName;
            } else {
                spannableString = new SpannableString(sb2 + str + "：");
                str2 = null;
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            if (!StringUtils.isNull(this.eTY.getSealPrefix())) {
                Bitmap bitmap = ao.getBitmap(R.drawable.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                if (bitmap != null) {
                    bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                }
                com.baidu.tbadk.core.view.i iVar = new com.baidu.tbadk.core.view.i(bitmapDrawable);
                iVar.setOffset(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds2));
                int size = arrayList.size() + this.eTY.getSealPrefix().length() + 1;
                spannableString.setSpan(iVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str3, str2, this.nsv), 0, spannableString.length(), 18);
            if (!StringUtils.isNull(str) && (z || (this.eTY != null && this.eTY.getIs_bawu() == 1))) {
                com.baidu.tbadk.core.view.b i3 = i(z, this.eTY != null && this.eTY.getIs_bawu() == 1, str);
                if (i3 != null) {
                    if (this.eTY != null) {
                        int i4 = 0;
                        if (this.eTY.getName_show() != null) {
                            i4 = this.eTY.getName_show().length();
                        }
                        spannableString.setSpan(i3, sb2.length() + i4 + 1, i4 + sb2.length() + str.length(), 17);
                    } else {
                        spannableString.setSpan(i3, sb2.length(), str.length() + sb2.length(), 17);
                    }
                }
            }
            ArrayList<TbRichTextData> bKW = this.nrK.bKW();
            if (bKW != null && bKW.size() > 0) {
                TbRichTextData tbRichTextData2 = bKW.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.bLd() != null) {
                    if (this.nsj) {
                        int indexOf = tbRichTextData2.bLd().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.bLd().delete(0, indexOf + 1);
                        }
                        this.nsj = false;
                    }
                    tbRichTextData2.tL(sb.length());
                    tbRichTextData2.bLd().insert(0, (CharSequence) spannableString);
                } else {
                    int i5 = 0;
                    while (true) {
                        int i6 = i5;
                        if (i6 >= bKW.size()) {
                            tbRichTextVoiceInfo = null;
                            break;
                        } else if (bKW.get(i6) == null || bKW.get(i6).getType() != 512) {
                            i5 = i6 + 1;
                        } else {
                            TbRichTextVoiceInfo bLe = bKW.get(i6).bLe();
                            bKW.remove(i6);
                            tbRichTextVoiceInfo = bLe;
                            break;
                        }
                    }
                    if (tbRichTextVoiceInfo != null) {
                        tbRichTextData = new TbRichTextData(768);
                        tbRichTextData.a(tbRichTextVoiceInfo);
                    } else {
                        tbRichTextData = new TbRichTextData(1);
                    }
                    tbRichTextData.tL(sb.length());
                    tbRichTextData.q(spannableString);
                    bKW.add(0, tbRichTextData);
                }
            }
            this.nsn = true;
        }
    }

    private com.baidu.tbadk.core.view.b i(boolean z, boolean z2, String str) {
        if (z || z2) {
            Context context = TbadkCoreApplication.getInst().getContext();
            int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.L_X01);
            int dimens2 = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10);
            int dimens3 = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds26);
            int dimens4 = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds12);
            int dimens5 = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds40);
            if (" 楼主".equals(str)) {
                com.baidu.tbadk.core.view.b bVar = new com.baidu.tbadk.core.view.b(dimens, -1, R.color.CAM_X0302, dimens3, R.color.CAM_X0302, dimens4, dimens5);
                bVar.qN(dimens2);
                bVar.jX(false);
                bVar.Ct(str);
                return bVar;
            } else if (" 吧主".equals(str) || " 小吧主".equals(str) || " 品牌官".equals(str)) {
                com.baidu.tbadk.core.view.b bVar2 = new com.baidu.tbadk.core.view.b(dimens, -1, R.color.CAM_X0302, dimens3, R.color.CAM_X0101, dimens4, dimens5);
                bVar2.qN(dimens2);
                bVar2.jX(true);
                bVar2.Ct(str);
                return bVar2;
            } else {
                return null;
            }
        }
        return null;
    }

    protected Drawable h(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap rawBitmap;
        if (aVar == null || (rawBitmap = aVar.getRawBitmap()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(rawBitmap);
        bitmapDrawable.setBounds(0, 0, TbConfig.getContentSizeOfLzl(), TbConfig.getContentSizeOfLzl());
        return bitmapDrawable;
    }

    public int dPh() {
        return this.nrG;
    }

    public void gU(Context context) {
        int type;
        int i;
        if (this.nrE != null) {
            int i2 = -1;
            int size = this.nrF.size();
            if (size > 0) {
                try {
                    i2 = this.nrF.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i3 = 0;
            int i4 = i2;
            while (i3 < this.nrE.size()) {
                l lVar = this.nrE.get(i3);
                if (l.dv(i4, lVar.getType())) {
                    this.nrF.get(size - 1).b(lVar.gT(context));
                    i = size;
                    type = i4;
                } else {
                    if (lVar.getType() == 3 || lVar.getType() == 2 || lVar.getType() == 11) {
                        this.nrF.add(lVar);
                        type = lVar.getType();
                    } else {
                        l lVar2 = new l();
                        lVar2.setType(0);
                        lVar2.b(lVar.gT(context));
                        this.nrF.add(lVar2);
                        type = 0;
                    }
                    i = size + 1;
                }
                i3++;
                size = i;
                i4 = type;
            }
        }
    }

    public void gV(Context context) {
        try {
            if (this.nrK != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.nrK.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.nrF == null || this.nrF.size() == 0) {
                gU(context);
            }
            ArrayList<l> arrayList = this.nrF;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<l> it = arrayList.iterator();
                while (it.hasNext()) {
                    l next = it.next();
                    if (next.getType() == 0) {
                        if (next.dOK() != null) {
                            sb.append((CharSequence) next.dOK());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(R.string.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(R.string.voice_str));
                    } else if (next.getType() == 2) {
                        String DJ = TbFaceManager.bGo().DJ(next.getText());
                        if (DJ != null) {
                            sb.append("[");
                            sb.append(DJ);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !at.isEmpty(next.dOJ())) {
                        sb.append("[").append(next.dOJ()).append("]");
                    }
                }
                ClipboardManager clipboardManager2 = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager2.setText(sb.toString());
                if (clipboardManager2.getText() != null) {
                }
            }
        } catch (Exception e) {
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
                this.floor_num = subPostList.floor.intValue();
                this.time = subPostList.time.intValue() * 1000;
                this.date = at.getFormatTime(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.nrQ = subPostList.is_giftpost.intValue() == 1;
                this.agreeData.postId = this.id;
                this.agreeData.parseProtobuf(subPostList.agree);
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.eTY = metaData;
                }
                if (this.eTY.getUserId() == null || this.eTY.getUserId().length() <= 0 || this.eTY.getUserId().equals("0")) {
                    this.eTY = metaData2;
                }
                this.nrK = TbRichTextView.a(context, subPostList.content, z);
                if (this.nrK != null) {
                    this.nrK.setPostId(com.baidu.adp.lib.f.b.toLong(this.id, -1L));
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void a(Post post, Context context) {
        TbRichTextData tbRichTextData;
        int i;
        MetaData metaData;
        if (post != null) {
            try {
                this.id = String.valueOf(post.id);
                this.tid = post.tid.longValue();
                this.title = post.title;
                this.floor_num = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.date = at.getFormatTime(this.time);
                this.nrD = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.eTY = metaData;
                }
                this.jog = post.need_log.intValue() == 1;
                this.nsb = post.img_num_abtest.intValue() == 1;
                this.nrT = new bv();
                this.nrT.parserProtobuf(post.from_forum);
                if (this.eTY.getUserId() == null || this.eTY.getUserId().length() <= 0 || this.eTY.getUserId().equals("0")) {
                    this.eTY.parserProtobuf(post.author);
                }
                if (this.eTY != null && context != null) {
                    this.nrX = this.eTY.getUserName() + context.getResources().getString(R.string.somebodys_portrait);
                    this.nrY = String.format(TbadkCoreApplication.getInst().getString(R.string.degree_in_forum), Integer.valueOf(this.eTY.getLevel_id()));
                }
                this.nrN = post.is_ntitle.intValue() == 1;
                this.nrG = post.sub_post_number.intValue();
                this.nrS = new i(post.tpoint_post);
                List<PbContent> list = post.content;
                this.nst = post.content;
                this.nsr = post.is_wonderful_post.intValue() == 1;
                this.nso = post.is_top_agree_post.intValue() == 1;
                this.eQZ = post.item_star;
                if (post.item != null && post.item.item_id.longValue() != 0) {
                    this.eWt = post.item;
                }
                this.nrK = TbRichTextView.a(context, list, true);
                if (this.nrK != null) {
                    this.nrK.setPostId(com.baidu.adp.lib.f.b.toLong(this.id, -1L));
                    this.nrK.tK(this.floor_num);
                    if (this.eTY != null) {
                        this.nrK.setAuthorId(this.eTY.getUserId());
                    }
                    int count = x.getCount(this.eQZ);
                    if (this.floor_num == 1 && count != 0 && this.eQZ != null) {
                        ArrayList<TbRichTextData> bKW = this.nrK.bKW();
                        if (count == 1) {
                            TbRichTextData tbRichTextData2 = (TbRichTextData) x.getItem(bKW, 0);
                            if (tbRichTextData2 == null || tbRichTextData2.getType() != 1) {
                                TbRichTextData tbRichTextData3 = new TbRichTextData(1);
                                x.add(bKW, 0, tbRichTextData3);
                                tbRichTextData = tbRichTextData3;
                            } else {
                                tbRichTextData = tbRichTextData2;
                            }
                            HeadItem headItem = (HeadItem) x.getItem(this.eQZ, 0);
                            if (headItem != null) {
                                try {
                                    i = Integer.parseInt(headItem.content);
                                } catch (NumberFormatException e) {
                                    i = 0;
                                }
                                tbRichTextData.r(com.baidu.tbadk.widget.richText.e.I(i, false));
                            }
                        } else {
                            for (int size = this.eQZ.size() - 1; size >= 0; size--) {
                                HeadItem headItem2 = this.eQZ.get(size);
                                if (headItem2 != null) {
                                    a(bKW, headItem2);
                                }
                            }
                        }
                    }
                    if (this.floor_num == 1 && this.eWt != null) {
                        TbRichTextData tbRichTextData4 = new TbRichTextData(1281);
                        tbRichTextData4.a(new TbRichTextEvaluateItemInfo(this.eWt));
                        x.add(this.nrK.bKW(), tbRichTextData4);
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list2 = subPost.sub_post_list;
                    if (list2.size() > 0) {
                        for (int i2 = 0; i2 < list2.size(); i2++) {
                            SubPostList subPostList = list2.get(i2);
                            PostData postData = new PostData();
                            postData.nrQ = subPostList.is_giftpost.intValue() == 1;
                            postData.agreeData.parseProtobuf(subPostList.agree);
                            postData.setUserMap(this.userMap);
                            postData.yd(this.nsm);
                            postData.a(subPostList, context);
                            this.nrH.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.nrM.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.nrO = new com.baidu.tbadk.data.c();
                    this.nrO.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.nrP = new com.baidu.tbadk.data.g();
                    this.nrP.a(post.lbs_info);
                }
                this.eUG = post.storecount.intValue();
                this.nrL.a(post.present);
                this.eUj.setUserMap(this.userMap);
                this.eUj.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.mdu = new SmallTailInfo();
                    this.mdu.id = post.signature.signature_id.intValue();
                    this.mdu.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.mdu.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list3 = this.mdu.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list3.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.mdu.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i3 = 0; i3 != post.ext_tails.size(); i3++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(post.ext_tails.get(i3));
                        this.eUS.add(cVar);
                    }
                }
                this.eUV = post.skin_info;
                this.eUY = post.lego_card;
                this.nrZ = post.tpoint_post;
                if (post.agree != null) {
                    this.nsa = true;
                    this.agreeData.postId = this.id;
                    this.agreeData.parseProtobuf(post.agree);
                } else {
                    this.nsa = false;
                }
                this.nsh = post.is_post_visible.intValue() == 1;
                if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                    this.eVB = new OriginalThreadInfo();
                    this.eVB.a(post.origin_thread_info);
                } else {
                    this.eVB = null;
                }
                this.nsk = post.is_fold.intValue();
                this.lGv = post.fold_tip;
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    private void a(List<TbRichTextData> list, HeadItem headItem) {
        int i;
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(new SpannableString(headItem.name + ": " + (headItem.type.intValue() == 1 ? headItem.content : " ")));
        if (headItem.type.intValue() == 2) {
            try {
                i = Integer.parseInt(headItem.content);
            } catch (NumberFormatException e) {
                i = 0;
            }
            spannableStringBuilder.append((CharSequence) com.baidu.tbadk.widget.richText.e.I(i, true));
        }
        tbRichTextData.q(spannableStringBuilder);
        x.add(list, 0, tbRichTextData);
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int mColorId;

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ao.getColor(this.mColorId));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private String mId;
        private String mName;
        private SoftReference<Context> nsB;
        private b nsC;

        public a(Context context, String str, String str2, b bVar) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.nsB = new SoftReference<>(context);
            this.nsC = bVar;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ao.getColor(R.color.CAM_X0108));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(true);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.nsB != null && this.nsB.get() != null) {
                if (this.nsC != null) {
                    this.nsC.onClick();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.nsB.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String gW(Context context) {
        ArrayList<TbRichTextData> bKW;
        if (this.nrK == null || (bKW = this.nrK.bKW()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = bKW.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.bLd().toString());
            } else if (next.getType() == 17) {
                String str = next.bLh().mGifInfo.mSharpText;
                if (str != null && str.startsWith("#(") && str.endsWith(")")) {
                    stringBuffer.append("[" + str.substring(2, str.length() - 1) + "]");
                }
            } else if (next.getType() == 8) {
                stringBuffer.append("[" + context.getString(R.string.editor_image) + "]");
            } else if (next.getType() == 512) {
                stringBuffer.append("[" + context.getString(R.string.msglist_voice) + "]");
            } else if (next.getType() == 32) {
                stringBuffer.append("[" + context.getString(R.string.video_title_str) + "]");
            }
        }
        return stringBuffer.toString();
    }

    public String dPi() {
        ArrayList<TbRichTextData> bKW;
        String str;
        if (this.nrK == null || (bKW = this.nrK.bKW()) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<TbRichTextData> it = bKW.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                if (next.getType() == 1) {
                    sb.append(next.bLd().toString());
                } else if (next.getType() == 17) {
                    if (next.bLh() != null && next.bLh().mGifInfo != null && (str = next.bLh().mGifInfo.mSharpText) != null && str.startsWith("#(") && str.endsWith(")")) {
                        sb.append("[" + str.substring(2, str.length() - 1) + "]");
                    }
                } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(' ');
                }
            }
        }
        return sb.toString();
    }

    public PreLoadImageInfo dPj() {
        ArrayList<TbRichTextData> bKW;
        if (this.nrK != null && (bKW = this.nrK.bKW()) != null) {
            Iterator<TbRichTextData> it = bKW.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.bLc().getWidth();
                    preLoadImageInfo.height = next.bLc().getHeight();
                    preLoadImageInfo.imgUrl = next.bLc().bLp();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 20) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.bLi().memeInfo.width.intValue();
                    preLoadImageInfo2.height = next.bLi().memeInfo.height.intValue();
                    preLoadImageInfo2.imgUrl = next.bLi().memeInfo.pic_url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return null;
    }

    public String dPk() {
        k dOH;
        PreLoadImageInfo dPj = dPj();
        if (dPj != null && !StringUtils.isNull(dPj.imgUrl)) {
            return dPj.imgUrl;
        }
        if (this.nrS != null && (dOH = this.nrS.dOH()) != null && !StringUtils.isNull(dOH.dOI())) {
            return dOH.dOI();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ag
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> bKW;
        if (this.nrK == null || (bKW = this.nrK.bKW()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = bKW.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.bLc().getWidth();
                preLoadImageInfo.height = next.bLc().getHeight();
                if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.bLc().bLu()) {
                    preLoadImageInfo.imgUrl = next.bLc().bLq();
                    preLoadImageInfo.procType = 38;
                } else {
                    preLoadImageInfo.imgUrl = next.bLc().bLp();
                    preLoadImageInfo.procType = 17;
                }
                arrayList.add(preLoadImageInfo);
            } else if (next.bLh() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.bLh().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.bLh().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.bLh();
                preLoadImageInfo2.procType = 20;
                arrayList.add(preLoadImageInfo2);
            }
        }
        if (!TextUtils.isEmpty(this.bimg_url)) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.bimg_url;
            preLoadImageInfo3.width = 105;
            preLoadImageInfo3.width = 105;
            preLoadImageInfo3.procType = 19;
            arrayList.add(preLoadImageInfo3);
        }
        if (this.eTY == null) {
            return arrayList;
        }
        PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
        preLoadImageInfo4.imgUrl = this.eTY.getPortrait();
        preLoadImageInfo4.procType = 12;
        arrayList.add(preLoadImageInfo4);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        if (this.nrC == 52) {
            return nry;
        }
        if (this.nrC == 1) {
            return eUW;
        }
        if (this.nrC == 36) {
            return eTd;
        }
        if (this.nrC == 40 || this.nrC == 50) {
            return eTj;
        }
        if (this.nrC == 41) {
            return nrw;
        }
        if (this.nrC == 53) {
            return nrz;
        }
        if (dPd() == 1) {
            return nru;
        }
        return nrv;
    }

    public void setPostType(int i) {
        this.nrC = i;
    }

    public az dPl() {
        return this.nrL;
    }

    public void a(az azVar) {
        this.nrL = azVar;
    }

    public i dPm() {
        return this.nrS;
    }

    public com.baidu.tbadk.widget.richText.i bLg() {
        if (this.nrW != null) {
            return this.nrW;
        }
        if (this.nrK != null && x.getCount(this.nrK.bKW()) > 0) {
            Iterator<TbRichTextData> it = this.nrK.bKW().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.nrW = next.bLg();
                    return this.nrW;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo bLe() {
        if (this.fnv != null) {
            return this.fnv;
        }
        if (this.nrK != null && x.getCount(this.nrK.bKW()) > 0) {
            Iterator<TbRichTextData> it = this.nrK.bKW().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.fnv = next.bLe();
                    return this.fnv;
                }
            }
        }
        return null;
    }

    public String dPn() {
        return this.nrX;
    }

    public String bsC() {
        return this.eUY;
    }

    public void bsE() {
        if (this.eUv == 0) {
            this.eUv = 1;
        }
    }

    public long bsS() {
        return this.agreeData.disAgreeNum;
    }

    public int bsU() {
        return this.agreeData.agreeType;
    }

    public AgreeData btk() {
        return this.agreeData;
    }

    public OriginalThreadInfo dPo() {
        return this.eVB;
    }

    public void h(OriginalThreadInfo originalThreadInfo) {
        this.eVB = originalThreadInfo;
    }

    public int dPp() {
        return this.nsk;
    }

    public String dmP() {
        return this.lGv;
    }

    public Item btx() {
        return this.eWt;
    }

    public List<HeadItem> bty() {
        return this.eQZ;
    }
}
