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
    private List<HeadItem> eMo;
    private OriginalThreadInfo eQQ;
    private SkinInfo eQk;
    private String eQn;
    private Item eRI;
    private TbRichTextVoiceInfo fiM;
    private String lBP;
    private SmallTailInfo lYM;
    public int locate;
    private String nmV;
    private ArrayList<PostData> nmZ;
    public AlaLiveInfoCoreData nnA;
    private boolean nnE;
    public aq nnI;
    public List<PbContent> nnL;
    private com.baidu.tbadk.data.c nng;
    private com.baidu.tbadk.data.g nnh;
    private i nnk;
    private bv nnl;
    public boolean nnn;
    private com.baidu.tbadk.widget.richText.i nno;
    private String nnp;
    private String nnq;
    private TPointPost nnr;
    public int nnu;
    public boolean nnx;
    private long tid;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId nmM = BdUniqueId.gen();
    public static final BdUniqueId nmN = BdUniqueId.gen();
    public static final BdUniqueId eQl = BdUniqueId.gen();
    public static final BdUniqueId eOs = BdUniqueId.gen();
    public static final BdUniqueId eOy = BdUniqueId.gen();
    public static final BdUniqueId nmO = BdUniqueId.gen();
    public static final BdUniqueId nmP = BdUniqueId.gen();
    public static final BdUniqueId nmQ = BdUniqueId.gen();
    public static final BdUniqueId nmR = BdUniqueId.gen();
    public static final BdUniqueId nmS = BdUniqueId.gen();
    public static boolean nmT = false;
    private int nmU = 0;
    private boolean nna = false;
    private ArrayList<PostData> nnb = null;
    private TbRichText nnc = null;
    private boolean nnf = false;
    private boolean nni = false;
    private boolean nnj = false;
    public boolean nnm = false;
    public int ePK = 0;
    private boolean nns = false;
    public boolean jjz = false;
    public boolean nnt = false;
    public boolean nnv = false;
    public boolean nnw = true;
    public boolean nny = false;
    public boolean nnz = false;
    private boolean nnB = false;
    private int nnC = 0;
    private boolean nnD = true;
    public boolean nnF = false;
    public boolean nnG = false;
    public boolean nnH = false;
    public boolean nnJ = false;
    public boolean nnK = false;
    int nnM = com.baidu.tbadk.a.d.biW();
    private b nnN = new b() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1
        @Override // com.baidu.tieba.tbadkCore.data.PostData.b
        public void onClick() {
            if (PostData.this.nnI != null) {
                aq bst = PostData.this.nnI.bst();
                bst.delete("obj_locate");
                bst.an("obj_locate", 7);
                TiebaStatic.log(bst);
            }
        }
    };
    private String id = null;
    private String title = null;
    private int floor_num = 0;
    private long time = 0;
    private String date = null;
    private MetaData ePn = new MetaData();
    private ArrayList<l> nmW = new ArrayList<>();
    private ArrayList<l> nmX = new ArrayList<>();
    private int nmY = 0;
    private int ePV = 0;
    private PraiseData ePy = new PraiseData();
    private az nnd = new az();
    private c nne = new c();
    private ArrayList<com.baidu.tbadk.data.c> eQh = new ArrayList<>();
    private AgreeData agreeData = new AgreeData();

    /* loaded from: classes.dex */
    private interface b {
        void onClick();
    }

    public PostData() {
        this.nmZ = null;
        this.nnu = 0;
        this.nmZ = new ArrayList<>();
        this.nnu = 0;
    }

    public void xZ(boolean z) {
        this.nnE = z;
    }

    public boolean dLe() {
        return this.nnE;
    }

    public ArrayList<PostData> dLf() {
        return this.nnb;
    }

    public void dLg() {
        this.nnb.clear();
        this.nnb = null;
        this.nna = false;
    }

    public void y(PostData postData) {
        if (postData != null) {
            if (this.nnb == null) {
                this.nnb = new ArrayList<>();
                if (x.getCount(this.nmZ) > this.nnM) {
                    this.nnb.addAll(x.subList(this.nmZ, 0, this.nnM));
                } else {
                    this.nnb.addAll(this.nmZ);
                }
            }
            this.nnb.add(postData);
        }
    }

    public void z(PostData postData) {
        if (postData != null && this.nmZ != null) {
            this.nmZ.add(postData);
            dLk();
        }
    }

    public void Sg(String str) {
        if (this.nnb != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.nnb.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.nnb.remove(next);
                    return;
                }
            }
        }
    }

    public void ya(boolean z) {
        this.nnD = z;
    }

    public boolean dLh() {
        return this.nnD;
    }

    public void yb(boolean z) {
        this.nna = z;
    }

    public boolean dLi() {
        return this.nna;
    }

    public ArrayList<PostData> dLj() {
        return this.nmZ;
    }

    public void dLk() {
        this.nmY++;
    }

    public void dLl() {
        this.nmY--;
    }

    public void Jj(int i) {
        this.nmY = i;
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

    public int dLm() {
        return this.floor_num;
    }

    public void Jk(int i) {
        this.floor_num = i;
    }

    public boolean dLn() {
        return this.nnj;
    }

    public void yc(boolean z) {
        this.nnj = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = at.getFormatTime(j);
    }

    public MetaData bnx() {
        return this.ePn;
    }

    public void a(MetaData metaData) {
        this.ePn = metaData;
    }

    public void a(PraiseData praiseData) {
        this.ePy = praiseData;
    }

    public TbRichText dLo() {
        return this.nnc;
    }

    public void c(TbRichText tbRichText) {
        this.nnc = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo dqX() {
        return this.lYM;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.lYM = smallTailInfo;
    }

    public com.baidu.tbadk.data.g dLp() {
        return this.nnh;
    }

    public SkinInfo bnS() {
        return this.eQk;
    }

    public void yd(boolean z) {
        this.nnB = z;
    }

    public void a(TbPageContext tbPageContext, boolean z) {
        String str;
        SpannableString spannableString;
        String str2;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.nnc != null && this.nnc.bHf() != null) {
            final BdUniqueId uniqueId = tbPageContext.getUniqueId();
            String str3 = null;
            if (z) {
                str = " 楼主";
            } else {
                if (this.ePn != null && this.ePn.getIs_bawu() == 1) {
                    if (this.nnE) {
                        str = " 品牌官";
                    } else if (Config.BAWU_TYPE_MANAGER.equals(this.ePn.getBawu_type())) {
                        str = " 吧主";
                    } else if (Config.BAWU_TYPE_ASSIST.equals(this.ePn.getBawu_type())) {
                        str = " 小吧主";
                    } else if ("pri_content_assist".equals(this.ePn.getBawu_type())) {
                        str = " 内容吧务";
                    } else if ("pri_manage_assist".equals(this.ePn.getBawu_type())) {
                        str = " 管理吧务";
                    }
                }
                str = "";
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<IconData> tShowInfoNew = bnx().getTShowInfoNew();
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
                                            PostData.this.nnc.isChanged = true;
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
            if (!StringUtils.isNull(this.ePn.getSealPrefix())) {
                sb.append(" ");
                sb.append(this.ePn.getSealPrefix());
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            String sb2 = sb.toString();
            if (this.ePn != null) {
                spannableString = new SpannableString(sb2 + this.ePn.getName_show() + str + "：");
                String userName = this.ePn.getUserName();
                str2 = this.ePn.getUserId();
                str3 = userName;
            } else {
                spannableString = new SpannableString(sb2 + str + "：");
                str2 = null;
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            if (!StringUtils.isNull(this.ePn.getSealPrefix())) {
                Bitmap bitmap = ao.getBitmap(R.drawable.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                if (bitmap != null) {
                    bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                }
                com.baidu.tbadk.core.view.i iVar = new com.baidu.tbadk.core.view.i(bitmapDrawable);
                iVar.setOffset(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds2));
                int size = arrayList.size() + this.ePn.getSealPrefix().length() + 1;
                spannableString.setSpan(iVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str3, str2, this.nnN), 0, spannableString.length(), 18);
            if (!StringUtils.isNull(str) && (z || (this.ePn != null && this.ePn.getIs_bawu() == 1))) {
                com.baidu.tbadk.core.view.b i3 = i(z, this.ePn != null && this.ePn.getIs_bawu() == 1, str);
                if (i3 != null) {
                    if (this.ePn != null) {
                        int i4 = 0;
                        if (this.ePn.getName_show() != null) {
                            i4 = this.ePn.getName_show().length();
                        }
                        spannableString.setSpan(i3, sb2.length() + i4 + 1, i4 + sb2.length() + str.length(), 17);
                    } else {
                        spannableString.setSpan(i3, sb2.length(), str.length() + sb2.length(), 17);
                    }
                }
            }
            ArrayList<TbRichTextData> bHf = this.nnc.bHf();
            if (bHf != null && bHf.size() > 0) {
                TbRichTextData tbRichTextData2 = bHf.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.bHm() != null) {
                    if (this.nnB) {
                        int indexOf = tbRichTextData2.bHm().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.bHm().delete(0, indexOf + 1);
                        }
                        this.nnB = false;
                    }
                    tbRichTextData2.sf(sb.length());
                    tbRichTextData2.bHm().insert(0, (CharSequence) spannableString);
                } else {
                    int i5 = 0;
                    while (true) {
                        int i6 = i5;
                        if (i6 >= bHf.size()) {
                            tbRichTextVoiceInfo = null;
                            break;
                        } else if (bHf.get(i6) == null || bHf.get(i6).getType() != 512) {
                            i5 = i6 + 1;
                        } else {
                            TbRichTextVoiceInfo bHn = bHf.get(i6).bHn();
                            bHf.remove(i6);
                            tbRichTextVoiceInfo = bHn;
                            break;
                        }
                    }
                    if (tbRichTextVoiceInfo != null) {
                        tbRichTextData = new TbRichTextData(768);
                        tbRichTextData.a(tbRichTextVoiceInfo);
                    } else {
                        tbRichTextData = new TbRichTextData(1);
                    }
                    tbRichTextData.sf(sb.length());
                    tbRichTextData.q(spannableString);
                    bHf.add(0, tbRichTextData);
                }
            }
            this.nnF = true;
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
                bVar.pg(dimens2);
                bVar.jT(false);
                bVar.Bh(str);
                return bVar;
            } else if (" 吧主".equals(str) || " 小吧主".equals(str) || " 品牌官".equals(str)) {
                com.baidu.tbadk.core.view.b bVar2 = new com.baidu.tbadk.core.view.b(dimens, -1, R.color.CAM_X0302, dimens3, R.color.CAM_X0101, dimens4, dimens5);
                bVar2.pg(dimens2);
                bVar2.jT(true);
                bVar2.Bh(str);
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

    public int dLq() {
        return this.nmY;
    }

    public void gS(Context context) {
        int type;
        int i;
        if (this.nmW != null) {
            int i2 = -1;
            int size = this.nmX.size();
            if (size > 0) {
                try {
                    i2 = this.nmX.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i3 = 0;
            int i4 = i2;
            while (i3 < this.nmW.size()) {
                l lVar = this.nmW.get(i3);
                if (l.dv(i4, lVar.getType())) {
                    this.nmX.get(size - 1).b(lVar.gR(context));
                    i = size;
                    type = i4;
                } else {
                    if (lVar.getType() == 3 || lVar.getType() == 2 || lVar.getType() == 11) {
                        this.nmX.add(lVar);
                        type = lVar.getType();
                    } else {
                        l lVar2 = new l();
                        lVar2.setType(0);
                        lVar2.b(lVar.gR(context));
                        this.nmX.add(lVar2);
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

    public void gT(Context context) {
        try {
            if (this.nnc != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.nnc.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.nmX == null || this.nmX.size() == 0) {
                gS(context);
            }
            ArrayList<l> arrayList = this.nmX;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<l> it = arrayList.iterator();
                while (it.hasNext()) {
                    l next = it.next();
                    if (next.getType() == 0) {
                        if (next.dKT() != null) {
                            sb.append((CharSequence) next.dKT());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(R.string.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(R.string.voice_str));
                    } else if (next.getType() == 2) {
                        String Cx = TbFaceManager.bCw().Cx(next.getText());
                        if (Cx != null) {
                            sb.append("[");
                            sb.append(Cx);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !at.isEmpty(next.dKS())) {
                        sb.append("[").append(next.dKS()).append("]");
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
                this.nni = subPostList.is_giftpost.intValue() == 1;
                this.agreeData.postId = this.id;
                this.agreeData.parseProtobuf(subPostList.agree);
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.ePn = metaData;
                }
                if (this.ePn.getUserId() == null || this.ePn.getUserId().length() <= 0 || this.ePn.getUserId().equals("0")) {
                    this.ePn = metaData2;
                }
                this.nnc = TbRichTextView.a(context, subPostList.content, z);
                if (this.nnc != null) {
                    this.nnc.setPostId(com.baidu.adp.lib.f.b.toLong(this.id, -1L));
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
                this.nmV = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.ePn = metaData;
                }
                this.jjz = post.need_log.intValue() == 1;
                this.nnt = post.img_num_abtest.intValue() == 1;
                this.nnl = new bv();
                this.nnl.parserProtobuf(post.from_forum);
                if (this.ePn.getUserId() == null || this.ePn.getUserId().length() <= 0 || this.ePn.getUserId().equals("0")) {
                    this.ePn.parserProtobuf(post.author);
                }
                if (this.ePn != null && context != null) {
                    this.nnp = this.ePn.getUserName() + context.getResources().getString(R.string.somebodys_portrait);
                    this.nnq = String.format(TbadkCoreApplication.getInst().getString(R.string.degree_in_forum), Integer.valueOf(this.ePn.getLevel_id()));
                }
                this.nnf = post.is_ntitle.intValue() == 1;
                this.nmY = post.sub_post_number.intValue();
                this.nnk = new i(post.tpoint_post);
                List<PbContent> list = post.content;
                this.nnL = post.content;
                this.nnJ = post.is_wonderful_post.intValue() == 1;
                this.nnG = post.is_top_agree_post.intValue() == 1;
                this.eMo = post.item_star;
                if (post.item != null && post.item.item_id.longValue() != 0) {
                    this.eRI = post.item;
                }
                this.nnc = TbRichTextView.a(context, list, true);
                if (this.nnc != null) {
                    this.nnc.setPostId(com.baidu.adp.lib.f.b.toLong(this.id, -1L));
                    this.nnc.se(this.floor_num);
                    if (this.ePn != null) {
                        this.nnc.setAuthorId(this.ePn.getUserId());
                    }
                    int count = x.getCount(this.eMo);
                    if (this.floor_num == 1 && count != 0 && this.eMo != null) {
                        ArrayList<TbRichTextData> bHf = this.nnc.bHf();
                        if (count == 1) {
                            TbRichTextData tbRichTextData2 = (TbRichTextData) x.getItem(bHf, 0);
                            if (tbRichTextData2 == null || tbRichTextData2.getType() != 1) {
                                TbRichTextData tbRichTextData3 = new TbRichTextData(1);
                                x.add(bHf, 0, tbRichTextData3);
                                tbRichTextData = tbRichTextData3;
                            } else {
                                tbRichTextData = tbRichTextData2;
                            }
                            HeadItem headItem = (HeadItem) x.getItem(this.eMo, 0);
                            if (headItem != null) {
                                try {
                                    i = Integer.parseInt(headItem.content);
                                } catch (NumberFormatException e) {
                                    i = 0;
                                }
                                tbRichTextData.r(com.baidu.tbadk.widget.richText.e.I(i, false));
                            }
                        } else {
                            for (int size = this.eMo.size() - 1; size >= 0; size--) {
                                HeadItem headItem2 = this.eMo.get(size);
                                if (headItem2 != null) {
                                    a(bHf, headItem2);
                                }
                            }
                        }
                    }
                    if (this.floor_num == 1 && this.eRI != null) {
                        TbRichTextData tbRichTextData4 = new TbRichTextData(1281);
                        tbRichTextData4.a(new TbRichTextEvaluateItemInfo(this.eRI));
                        x.add(this.nnc.bHf(), tbRichTextData4);
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list2 = subPost.sub_post_list;
                    if (list2.size() > 0) {
                        for (int i2 = 0; i2 < list2.size(); i2++) {
                            SubPostList subPostList = list2.get(i2);
                            PostData postData = new PostData();
                            postData.nni = subPostList.is_giftpost.intValue() == 1;
                            postData.agreeData.parseProtobuf(subPostList.agree);
                            postData.setUserMap(this.userMap);
                            postData.xZ(this.nnE);
                            postData.a(subPostList, context);
                            this.nmZ.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.nne.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.nng = new com.baidu.tbadk.data.c();
                    this.nng.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.nnh = new com.baidu.tbadk.data.g();
                    this.nnh.a(post.lbs_info);
                }
                this.ePV = post.storecount.intValue();
                this.nnd.a(post.present);
                this.ePy.setUserMap(this.userMap);
                this.ePy.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.lYM = new SmallTailInfo();
                    this.lYM.id = post.signature.signature_id.intValue();
                    this.lYM.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.lYM.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list3 = this.lYM.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list3.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.lYM.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i3 = 0; i3 != post.ext_tails.size(); i3++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(post.ext_tails.get(i3));
                        this.eQh.add(cVar);
                    }
                }
                this.eQk = post.skin_info;
                this.eQn = post.lego_card;
                this.nnr = post.tpoint_post;
                if (post.agree != null) {
                    this.nns = true;
                    this.agreeData.postId = this.id;
                    this.agreeData.parseProtobuf(post.agree);
                } else {
                    this.nns = false;
                }
                this.nnz = post.is_post_visible.intValue() == 1;
                if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                    this.eQQ = new OriginalThreadInfo();
                    this.eQQ.a(post.origin_thread_info);
                } else {
                    this.eQQ = null;
                }
                this.nnC = post.is_fold.intValue();
                this.lBP = post.fold_tip;
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
        private SoftReference<Context> nnT;
        private b nnU;

        public a(Context context, String str, String str2, b bVar) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.nnT = new SoftReference<>(context);
            this.nnU = bVar;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ao.getColor(R.color.CAM_X0108));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(true);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.nnT != null && this.nnT.get() != null) {
                if (this.nnU != null) {
                    this.nnU.onClick();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.nnT.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String gU(Context context) {
        ArrayList<TbRichTextData> bHf;
        if (this.nnc == null || (bHf = this.nnc.bHf()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = bHf.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.bHm().toString());
            } else if (next.getType() == 17) {
                String str = next.bHq().mGifInfo.mSharpText;
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

    public String dLr() {
        ArrayList<TbRichTextData> bHf;
        String str;
        if (this.nnc == null || (bHf = this.nnc.bHf()) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<TbRichTextData> it = bHf.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                if (next.getType() == 1) {
                    sb.append(next.bHm().toString());
                } else if (next.getType() == 17) {
                    if (next.bHq() != null && next.bHq().mGifInfo != null && (str = next.bHq().mGifInfo.mSharpText) != null && str.startsWith("#(") && str.endsWith(")")) {
                        sb.append("[" + str.substring(2, str.length() - 1) + "]");
                    }
                } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(' ');
                }
            }
        }
        return sb.toString();
    }

    public PreLoadImageInfo dLs() {
        ArrayList<TbRichTextData> bHf;
        if (this.nnc != null && (bHf = this.nnc.bHf()) != null) {
            Iterator<TbRichTextData> it = bHf.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.bHl().getWidth();
                    preLoadImageInfo.height = next.bHl().getHeight();
                    preLoadImageInfo.imgUrl = next.bHl().bHy();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 20) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.bHr().memeInfo.width.intValue();
                    preLoadImageInfo2.height = next.bHr().memeInfo.height.intValue();
                    preLoadImageInfo2.imgUrl = next.bHr().memeInfo.pic_url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return null;
    }

    public String dLt() {
        k dKQ;
        PreLoadImageInfo dLs = dLs();
        if (dLs != null && !StringUtils.isNull(dLs.imgUrl)) {
            return dLs.imgUrl;
        }
        if (this.nnk != null && (dKQ = this.nnk.dKQ()) != null && !StringUtils.isNull(dKQ.dKR())) {
            return dKQ.dKR();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ag
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> bHf;
        if (this.nnc == null || (bHf = this.nnc.bHf()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = bHf.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.bHl().getWidth();
                preLoadImageInfo.height = next.bHl().getHeight();
                if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.bHl().bHD()) {
                    preLoadImageInfo.imgUrl = next.bHl().bHz();
                    preLoadImageInfo.procType = 38;
                } else {
                    preLoadImageInfo.imgUrl = next.bHl().bHy();
                    preLoadImageInfo.procType = 17;
                }
                arrayList.add(preLoadImageInfo);
            } else if (next.bHq() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.bHq().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.bHq().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.bHq();
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
        if (this.ePn == null) {
            return arrayList;
        }
        PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
        preLoadImageInfo4.imgUrl = this.ePn.getPortrait();
        preLoadImageInfo4.procType = 12;
        arrayList.add(preLoadImageInfo4);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        if (this.nmU == 52) {
            return nmQ;
        }
        if (this.nmU == 1) {
            return eQl;
        }
        if (this.nmU == 36) {
            return eOs;
        }
        if (this.nmU == 40 || this.nmU == 50) {
            return eOy;
        }
        if (this.nmU == 41) {
            return nmO;
        }
        if (this.nmU == 53) {
            return nmR;
        }
        if (dLm() == 1) {
            return nmM;
        }
        return nmN;
    }

    public void setPostType(int i) {
        this.nmU = i;
    }

    public az dLu() {
        return this.nnd;
    }

    public void a(az azVar) {
        this.nnd = azVar;
    }

    public i dLv() {
        return this.nnk;
    }

    public com.baidu.tbadk.widget.richText.i bHp() {
        if (this.nno != null) {
            return this.nno;
        }
        if (this.nnc != null && x.getCount(this.nnc.bHf()) > 0) {
            Iterator<TbRichTextData> it = this.nnc.bHf().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.nno = next.bHp();
                    return this.nno;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo bHn() {
        if (this.fiM != null) {
            return this.fiM;
        }
        if (this.nnc != null && x.getCount(this.nnc.bHf()) > 0) {
            Iterator<TbRichTextData> it = this.nnc.bHf().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.fiM = next.bHn();
                    return this.fiM;
                }
            }
        }
        return null;
    }

    public String dLw() {
        return this.nnp;
    }

    public String boJ() {
        return this.eQn;
    }

    public void boL() {
        if (this.ePK == 0) {
            this.ePK = 1;
        }
    }

    public long boZ() {
        return this.agreeData.disAgreeNum;
    }

    public int bpb() {
        return this.agreeData.agreeType;
    }

    public AgreeData bpr() {
        return this.agreeData;
    }

    public OriginalThreadInfo dLx() {
        return this.eQQ;
    }

    public void h(OriginalThreadInfo originalThreadInfo) {
        this.eQQ = originalThreadInfo;
    }

    public int dLy() {
        return this.nnC;
    }

    public String diY() {
        return this.lBP;
    }

    public Item bpE() {
        return this.eRI;
    }

    public List<HeadItem> bpF() {
        return this.eMo;
    }
}
