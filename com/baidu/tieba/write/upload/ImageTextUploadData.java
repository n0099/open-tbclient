package com.baidu.tieba.write.upload;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ImageTextUploadData extends BaseUploadData implements Serializable {
    public ArrayList<String> imagePaths;

    public ImageTextUploadData() {
        this.publishType = "0";
    }
}
